package calculate;

import org.jgraph.graph.DefaultEdge;
import org.jgrapht.DirectedGraph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;

import java.util.Set;

public class MetricsCalculate {

    private final DirectedGraph<String, DefaultEdge> graph;
    private final Set<String> vertices;

    public MetricsCalculate(DirectedGraph<String, DefaultEdge> graph) {
        this.graph = graph;
        this.vertices = graph.vertexSet();
    }

    public double calculateThroughput() {
        var searchPathHelper = new DijkstraShortestPath<>(graph);
        String gateWay = vertices.stream().findFirst().orElse(null);

        double verticesPathWeightSum = vertices.stream()
                .filter(v -> !v.contains("'"))
                .mapToDouble(v -> searchPathHelper.getPathWeight(gateWay, v))
                .sum();
        double metricValue = verticesPathWeightSum / (graph.edgeSet().size() * vertices.size());

        return normalizeValueByFunction(metricValue);
    }

    public double calculateFaultTolerance() {
        int verticesDegreeSum = vertices.stream()
                .mapToInt(graph::inDegreeOf)
                .sum();
        double metricValue = (double) verticesDegreeSum / vertices.size();

        return normalizeValueByFunction(metricValue);
    }

    public double calculateServiceInteraction(int expectedRps) {
        int verticesPathCountSum = vertices.stream()
                .mapToInt(v -> graph.inDegreeOf(v) == 0 ? 1 : graph.inDegreeOf(v))
                .sum();
        double verticesPathCountAverage = (double) verticesPathCountSum / vertices.size();
        int defaultRps = 500;

        return (double) defaultRps / (expectedRps * verticesPathCountAverage);
    }

    private double normalizeValueByFunction(double x) {
        return 1 - x / (x+1);
    }
}

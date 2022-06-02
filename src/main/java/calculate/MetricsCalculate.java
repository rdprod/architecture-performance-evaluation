package calculate;

import org.jgraph.graph.DefaultEdge;
import org.jgrapht.DirectedGraph;

import java.util.List;

public class MetricsCalculate {

    public double getCommonEvaluation(List<Double> metrics) {
        return metrics
                .stream()
                .reduce(Double::sum).orElse(0.0)/3;
    }

    private double calculateThroughput(DirectedGraph<String, DefaultEdge> graph) {
        return 0.0;
    }

    private double calculateFaultTolerance(DirectedGraph<String, DefaultEdge> graph) {
        return 0.0;
    }

    private double calculateServiceInteraction(DirectedGraph<String, DefaultEdge> graph) {
        return 0.0;
    }

    private double normalizeValueByFunction(double x) {
        return 1 - x/(x+1);
    }
}

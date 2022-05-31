package graph;

import org.jgraph.graph.DefaultEdge;
import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultDirectedGraph;

import java.util.List;

public class GraphSource {
    public DirectedGraph<String, DefaultEdge> createGraph(List<String> vertices,
                                                          List<String> edges) {
        var graph = new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
        vertices.forEach(graph::addVertex);
        edges.forEach(e -> graph.addEdge
                (e.split(">")[0], e.split(">")[1]));

        return graph;
    }
}

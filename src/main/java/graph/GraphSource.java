package graph;

import org.jgraph.graph.DefaultEdge;
import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultDirectedGraph;

import java.util.List;

public class GraphSource {
    public DirectedGraph<String, DefaultEdge> createGraph(List<String> vertices,
                                                          List<String> edges,
                                                          List<String> replicas) {
        var graph = new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
        vertices.forEach(graph::addVertex);
        replicas.forEach(graph::addVertex);
        addEdgesInGraph(graph, replicas, edges);

        return graph;
    }

    private void addEdgesInGraph(DirectedGraph<String, DefaultEdge> graph,
                                 List<String> replicas,
                                 List<String> edges) {
        edges.forEach(e -> {
            String[] edgeVert = e.split(">");
            graph.addEdge(edgeVert[0], edgeVert[1]);
            replicas.forEach(replicaEnd -> {
                if (replicaEnd.contains(edgeVert[1])) {
                    graph.addEdge(edgeVert[0], replicaEnd);
                }
            });
            replicas.forEach(replicaStart -> {
                if (replicaStart.contains(edgeVert[0])) {
                    graph.addEdge(replicaStart, edgeVert[1]);
                    replicas.forEach(replicaEnd -> {
                        if (replicaEnd.contains(edgeVert[1])) {
                            graph.addEdge(replicaStart, replicaEnd);
                        }
                    });
                }
            });
        });
    }
}

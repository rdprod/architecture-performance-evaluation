package graph;

import org.jgraph.graph.DefaultEdge;
import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GraphSourceTest {

    private final GraphSource graphSource = new GraphSource();
    private DirectedGraph<String, DefaultEdge> expectedGraph;

    @Before
    public void init() {
        expectedGraph = new DefaultDirectedGraph<>(DefaultEdge.class);
        expectedGraph.addVertex("m1");
        expectedGraph.addVertex("m2");
        expectedGraph.addVertex("m1'");
        expectedGraph.addEdge("m1","m2");
        expectedGraph.addEdge("m1'", "m2");
    }

    @Test
    public void whenGetVerticesAndEdgesThenCreateGraph() {
        List<String> vertices = List.of("m1", "m2");
        List<String> replicas = List.of("m1'");
        List<String> edges = List.of("m1>m2");
        DirectedGraph<String, DefaultEdge> actualGraph =
                graphSource.createGraph(vertices, edges, replicas);

        assertEquals(expectedGraph.vertexSet(), actualGraph.vertexSet());
    }
}

package calculate;

import org.jgraph.graph.DefaultEdge;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MetricCalculateTest {
    private MetricsCalculate metricsCalculate;

    @Before
    public void init() {
        var graph = new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
        graph.addVertex("m1");
        metricsCalculate = new MetricsCalculate(graph);
    }

    @Test
    public void whenGetGraphCalculateThroughput() {
        double result = metricsCalculate.calculateFaultTolerance();

        assertEquals(Double.valueOf(1.0), Double.valueOf(result));
    }

    @Test
    public void whenGetGraphCalculateFaultTolerance() {
        double result = metricsCalculate.calculateFaultTolerance();

        assertEquals(Double.valueOf(1.0), Double.valueOf(result));
    }

    @Test
    public void whenGetGraphCalculateServiceInteraction() {
        double result = metricsCalculate.calculateServiceInteraction(250);

        assertEquals(Double.valueOf(1.0), Double.valueOf(result));
    }
}

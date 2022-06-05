import calculate.EvaluationCalculate;
import calculate.MetricsCalculate;
import client.ClientMessagesSender;
import graph.GraphImageSource;
import graph.GraphSource;
import org.jgraph.graph.DefaultEdge;
import org.jgrapht.DirectedGraph;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        var scanner = new Scanner(System.in);
        var clientMessagesSender = new ClientMessagesSender();
        var graphSource = new GraphSource();
        var graphImageSource = new GraphImageSource();
        var evaluationCalculate = new EvaluationCalculate();

        clientMessagesSender.printGreetings();

        clientMessagesSender.printIndicateServices();
        List<String> vertices = Arrays.asList(scanner.nextLine().split(","));

        clientMessagesSender.printIndicateServicesReplicas();
        String replicasString = scanner.nextLine();
        List<String> replicas = !replicasString.isBlank() ?
                Arrays.asList(replicasString.split(",")) : Collections.emptyList();

        clientMessagesSender.printIndicateEdges();
        List<String> edges = Arrays.asList(scanner.nextLine().split(","));

        clientMessagesSender.printIndicateExpectedRps();
        int appExpectedRps = scanner.nextInt();

        DirectedGraph<String, DefaultEdge> graph = graphSource.createGraph(vertices, edges, replicas);
        graphImageSource.createGraphImage(graph, args[0]);

        var metricsCalculate = new MetricsCalculate(graph);

        double throughputMetricValue = metricsCalculate.calculateThroughput();
        double faultToleranceMetricValue = metricsCalculate.calculateFaultTolerance();
        double serviceInteractionMetricValue = metricsCalculate.calculateServiceInteraction(appExpectedRps);

        double evaluation = evaluationCalculate.getCommonEvaluation
                (List.of(throughputMetricValue, faultToleranceMetricValue, serviceInteractionMetricValue));

        clientMessagesSender.printResult(evaluation);
    }
}

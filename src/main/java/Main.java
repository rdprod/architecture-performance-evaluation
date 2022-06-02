import calculate.MetricsCalculate;
import client.ClientInputProcessor;
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
        var clientInput = new ClientInputProcessor();
        var graphSource = new GraphSource();
        var graphImageSource = new GraphImageSource();
        var metricsCalculate = new MetricsCalculate();

        clientInput.printGreetings();

        clientInput.printIndicateServices();
        List<String> vertices = Arrays.asList(scanner.nextLine().split(","));

        clientInput.printIndicateServicesReplicas();
        String replicasString = scanner.nextLine();
        List<String> replicas = !replicasString.isBlank() ?
                Arrays.asList(scanner.nextLine().split(",")) : Collections.emptyList();

        clientInput.printIndicateEdges();
        List<String> edges = Arrays.asList(scanner.nextLine().split(","));

        System.out.println("Final architecture performance evaluation = "
                + metricsCalculate.getCommonEvaluation(Collections.emptyList()));

        DirectedGraph<String, DefaultEdge> graph = graphSource.createGraph(vertices, edges, replicas);
        graphImageSource.createGraphImage(graph);
    }
}

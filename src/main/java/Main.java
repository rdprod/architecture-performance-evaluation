import client.ClientInputProcessor;
import graph.GraphImageSource;
import graph.GraphSource;
import org.jgraph.graph.DefaultEdge;
import org.jgrapht.DirectedGraph;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ClientInputProcessor clientInput = new ClientInputProcessor();
        GraphSource graphSource = new GraphSource();
        GraphImageSource graphImageSource = new GraphImageSource();

        clientInput.printGreetings();

        clientInput.printIndicateServices();
        List<String> vertices = Arrays.asList(scanner.nextLine().split(","));

        clientInput.printIndicateServicesReplicas();
        List<String> replicas = Arrays.asList(scanner.nextLine().split(","));

        clientInput.printIndicateEdges();
        List<String> edges = Arrays.asList(scanner.nextLine().split(","));

        DirectedGraph<String, DefaultEdge> graph = graphSource.createGraph(vertices, edges, replicas);
        graphImageSource.createGraphImage(graph);
    }
}

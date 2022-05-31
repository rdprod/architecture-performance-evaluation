package client;

public class ClientInputProcessor {
    public void printGreetings() {
        System.out.println("""
                -----------------------------------
                Architecture Performance Evaluation
                -----------------------------------""");
    }

    public void printIndicateServices() {
        System.out.println("Enter your services (vertices), separated by commas (','):");
    }

    public void printIndicateEdges() {
        System.out.println("Enter edges by services using arrow ('>'), separated by commas (','):");
    }

    public void printIndicateServicesReplicas() {
        System.out.println("Enter service's replicas (if exists), separated by commas (','):");
    }
}

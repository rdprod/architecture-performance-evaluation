package client;

public class ClientMessagesSender {
    public void printGreetings() {
        System.out.println("""
                -----------------------------------
                Architecture Performance Evaluation
                -----------------------------------""");
    }

    public void printIndicateServices() {
        System.out.println("Enter your services (vertices), separated by commas (,):");
    }

    public void printIndicateEdges() {
        System.out.println("Enter edges by services using arrow (>), separated by commas (,):");
    }

    public void printIndicateServicesReplicas() {
        System.out.println("Enter service's replicas (if not exists press 'Enter') with (') iterating, " +
                "separated by commas (,):");
    }

    public void printIndicateExpectedRps() {
        System.out.println("Enter expected RPS value for your application:");
    }

    public void printResult(double value) {
        System.out.printf("""
                --------------------
                Result value =  %.2f
                --------------------
                """, value);
    }
}

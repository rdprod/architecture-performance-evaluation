package calculate;

import java.util.List;

public class EvaluationCalculate {

    public double getCommonEvaluation(List<Double> metrics) {
        return metrics
                .stream()
                .reduce(Double::sum).orElse(0.0) / 3;
    }
}

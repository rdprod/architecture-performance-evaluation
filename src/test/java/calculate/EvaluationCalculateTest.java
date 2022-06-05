package calculate;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EvaluationCalculateTest {

    private final EvaluationCalculate evaluationCalculate = new EvaluationCalculate();

    @Test
    public void whenAllMetricsMinThenReturnMin() {
        List<Double> listOfMin = List.of(0.0, 0.0, 0.0);
        double result = evaluationCalculate.getCommonEvaluation(listOfMin);

        assertEquals(Double.valueOf(0.0), Double.valueOf(result));
    }

    @Test
    public void whenAllMetricsMaxThenReturnMax() {
        List<Double> listOfMax = List.of(1.0, 1.0, 1.0);
        double result = evaluationCalculate.getCommonEvaluation(listOfMax);

        assertEquals(Double.valueOf(1.0), Double.valueOf(result));
    }
}

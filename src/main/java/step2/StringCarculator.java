package step2;

import java.util.Arrays;
import java.util.List;

public class StringCarculator {

    public int compute(String inputExpression) {
        inputExpressionInValidException(inputExpression);

        List<String> expressions = Arrays.asList(inputExpression.split(CommonConstant.DELIMITER));
        int resultValue = stringToInt(expressions.get(0));

        for (int i = 1; i < expressions.size(); i += 2) {
            String operator = expressions.get(i);
            int number = stringToInt(expressions.get(i + 1));
            resultValue = calculate(operator, resultValue, number);
        }
        return resultValue;
    }

    public static int calculate(String operator, int firstNumber, int secondNumber) {
        Operator operation = Operator.of(operator);
        return operation.calculate(firstNumber, secondNumber);
    }

    public static void inputExpressionInValidException(String inputExpression) {
        if (inputExpression == null || inputExpression.trim().isEmpty()) {
            throw new IllegalArgumentException(CommonConstant.INVALID_INPUT_EXPRESSION);
        }
    }

    private int stringToInt(String value) {
        return Integer.parseInt(value);
    }

}
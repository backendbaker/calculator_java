package program;
import calculator.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите математическое выражение: ");

        Scanner scanner = new Scanner(System.in);
        var exprString = scanner.nextLine();

        System.out.println("Результат: " + calc(exprString));
        System.exit(0);
    }
    public static String calc(String input) {
        CalcController controller = new CalcController();

        Expression expr = new Parser(input).getExpression();
        var operator = expr.getOperators().getFirst();

        for (Calculator.Operation op: Calculator.Operation.values()) {
            if (op.toString().contains(operator)) {
                var operands = expr.getOperands();
                var result = op.apply(Integer.parseInt(operands.getFirst()), Integer.parseInt(operands.getLast()));
                expr.setResult(String.valueOf(result));
                break;
            }
        }
        return expr.getResult();
    }
}
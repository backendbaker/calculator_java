package program;
import calculator.Calculator;
import calculator.Converter;
import calculator.Parser;
import calculator.Expression;
import jdk.jshell.spi.ExecutionControl;

import static jdk.jshell.spi.ExecutionControl.*;

class CalcController {
    private Converter converter;
    public CalcController() {
        converter = new Converter();
    }
    public String calculate(String exprString) throws NotImplementedException{
        var expression = new Parser(exprString).getExpression();
        switch (expression.getType()){
            case ROMAN -> {
                try {
                    handleRomanExpession(expression);
                }
                catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    System.exit(-1);
                }
            }
            case ARABIC -> {handleArabicExpession(expression);}
            default -> {throw new NotImplementedException("Для данного типа выражения нет алгоритма");}
        }

        return expression.getResult();
    }

    private void handleRomanExpession(Expression expression) {
        var firstOperand = converter.toArabic(expression.getOperands().getFirst());
        var secondOperand = converter.toArabic(expression.getOperands().getLast());
        if (firstOperand > 10 || secondOperand > 10) {
            throw new IllegalArgumentException("Введённые числа превышают 10");
        }
        var operator = expression.getOperators().getFirst();

        int numResult = 0;
        for (Calculator.Operation op: Calculator.Operation.values()) {
            if (op.toString().contains(operator)){
                numResult = op.apply(firstOperand, secondOperand);
            }
        }
        if (numResult <= 0 ) {
            throw new IllegalStateException("Результат отрицательный. В римской системе нет отрицательных чисел");
        }
        expression.setResult(converter.toRoman(numResult));
    }
    private void handleArabicExpession(Expression expression) {
        var firstOperand = Integer.parseInt(expression.getOperands().getFirst());
        var secondOperand = Integer.parseInt(expression.getOperands().getLast());
        var operator = expression.getOperators().getFirst();

        int numResult = 0;
        for (Calculator.Operation op: Calculator.Operation.values()) {
            if (op.toString().contains(operator)){
                try{
                    numResult = op.apply(firstOperand, secondOperand);
                }
                catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

        expression.setResult(String.valueOf(numResult));
    }
}

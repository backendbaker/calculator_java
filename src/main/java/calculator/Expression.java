package calculator;

import java.util.ArrayDeque;

public class Expression {
    private ArrayDeque<String> operators;
    private ArrayDeque<String> operands;
    private ExpressionType type;
    private final int MAX_COUNT_OPERANDS = 2;
    private final int MAX_COUNT_OPERATORS = 1;

    private String Result;

    public Expression(){
        this.operators = new ArrayDeque<String>();
        this.operands = new ArrayDeque<String>();
    }

    public ArrayDeque<String> getOperators() {
        return operators;
    }

    public void setOperators(String operator) {
        if (operators.size() == MAX_COUNT_OPERATORS) {return;}
        this.operators.add(operator);
    }

    public ArrayDeque<String> getOperands() {
        return operands;
    }

    public void setOperands(String operand) {
        if (operands.size() == MAX_COUNT_OPERANDS) {return;}
        this.operands.add(operand);
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public ExpressionType getType() {
        return type;
    }

    public void setType(ExpressionType type) {
        this.type = type;
    }
}

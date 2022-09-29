import java.util.Stack;

public class Expression {
    private String operator;
    private Stack<String> operands;

    private String Result;

    public Expression(){
        this.operator = null;
        this.operands = new Stack<String>();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Stack<String> getOperands() {
        return operands;
    }

    public void setOperands(String operand) {
        if (operands.size() == 2) {return;}
        this.operands.push(operand);
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }
}

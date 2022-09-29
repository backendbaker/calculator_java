package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private final String OPERATORS = "[-+/*]";
    private final String VALIDATION_STRING_EXPR = "^\\s?[0123456789IVX]+\\s*[-+/*]\\s*[[0123456789][IVX]]+\\z";
    private Expression expression;

    public Parser(String exprString) throws IllegalArgumentException {
        try {
            if (isValidExpression(exprString)) {
                expression = new Expression();
                parseExpression(exprString);
            }
            else {
                throw new IllegalArgumentException("Неверный формат выражения");
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.exit(-1);
        }
    }

    public Expression getExpression() throws NullPointerException{
        if (this.expression == null) {
            throw new NullPointerException("Неудалось преобразовать выражение");
        }
        return this.expression;
    }

    private boolean isValidExpression(String exprString) {
        Pattern validationExpr = Pattern.compile(VALIDATION_STRING_EXPR, Pattern.CASE_INSENSITIVE);
        Matcher matcher = validationExpr.matcher(exprString);
        if (!matcher.matches()) { return false; }
        return true;
    }

    private void parseExpression(String exprString) {
        String exprCleanStr = exprString.replace(" ", "");
        StringBuffer sb = new StringBuffer();
        Pattern operators = Pattern.compile(OPERATORS, Pattern.CASE_INSENSITIVE);

        for (int i = 0; i < exprCleanStr.length(); i++) {
            char c = exprCleanStr.charAt(i);
            if (operators.matcher(String.valueOf(c)).matches()) {
                expression.setOperator(String.valueOf(c));
                expression.setOperands(sb.toString());
                sb.delete(0, sb.length());
                continue;
            }
            sb.append(c);
            if (i == exprCleanStr.length() - 1) {
                expression.setOperands(sb.toString());
            }
        }
    }
}

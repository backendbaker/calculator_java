import org.junit.jupiter.api.Test;
import calculator.*;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    private calculator.Parser parser;
    @Test
    void parserMustReturnInstanceOfExpressionClass(){
        String exprString = "1+2";
        parser = new calculator.Parser(exprString);
        var expr = parser.getExpression();
        assertEquals(expr.getClass(), Expression.class);
    }

    @Test
    void parserMustSetTwoOperandsInExpression(){
        String exprString = "1+2";
        parser = new calculator.Parser(exprString);

        Expression expr = parser.getExpression();
        assertEquals(2, expr.getOperands().size());
    }

    @Test
    void parserMustSetValuesForOperandsInExpression() {
        String exprString = "1+2";
        parser = new calculator.Parser(exprString);

        Expression expr = parser.getExpression();
        assertFalse(expr.getOperands().isEmpty());
    }

    @Test
    void parserMustSetOperatorInExpression(){
        String exprString = "1+2";
        parser = new calculator.Parser(exprString);

        Expression expr = parser.getExpression();
        assertFalse(expr.getOperators().isEmpty());
    }

    @Test
    void parserMustSetOperatorCorrect(){
        String exprString = "1+2";
        parser = new calculator.Parser(exprString);

        Expression expr = parser.getExpression();
        assertEquals("+", expr.getOperators().getFirst());
    }

    @Test
    void parserMustSetFirstOperandCorrect(){
        String exprString = "I+V";
        parser = new calculator.Parser(exprString);

        Expression expr = parser.getExpression();
        assertEquals("I", expr.getOperands().getFirst());
    }

    @Test
    void parserMustSetSecondOperandCorrect(){
        String exprString = "I+V";
        parser = new calculator.Parser(exprString);

        Expression expr = parser.getExpression();
        assertEquals("V", expr.getOperands().getLast());
    }

}

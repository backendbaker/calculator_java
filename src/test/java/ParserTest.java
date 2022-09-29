import org.junit.jupiter.api.Test;

import javax.swing.text.html.parser.Parser;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    private Parser parser;
    @Test
    void parserMustReturnInstanceOfExpressionClass(){
        String exprString = "1+2";
        parser = new Parser(exprString);
        var expr = parser.getExpression();
        assertEquals(expr, Expression.class);
    }

    @Test
    void parserMustThrowExeptionIfStringIsNotExpression(){
        String exprString = "1+";
        parser = new Parser(exprString);
        Exception exception = assertThrows(RuntimeException.class, () -> {
            parser.getExpression();
        });

        String expectedMessage = "";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void parserMustSetTwoOperandsInExpression(){
        String exprString = "1+2";
        parser = new Parser(exprString);

        Expression expr = parser.getExpression();
        assertEquals(2, expr.getOperands().size());
    }

    @Test
    void parserMustSetValuesForOperandsInExpression() {
        String exprString = "1+2";
        parser = new Parser(exprString);

        Expression expr = parser.getExpression();
        assertFalse(expr.getOperands().isEmpty());
    }

    @Test
    void parserMustSetOperatorInExpression(){
        String exprString = "1+2";
        parser = new Parser(exprString);

        Expression expr = parser.getExpression();
        assertFalse(expr.getOperator().isEmpty());
    }

    @Test
    void parserMustSetOperatorCorrect(){
        String exprString = "1+2";
        parser = new Parser(exprString);

        Expression expr = parser.getExpression();
        assertEquals("+", expr.getOperator());
    }

    @Test
    void parserMustSetFirstOperandCorrect(){
        String exprString = "I+V";
        parser = new Parser(exprString);

        Expression expr = parser.getExpression();
        assertEquals("I", expr.getOperands().lastElement());
    }

    @Test
    void parserMustSetSecondOperandCorrect(){
        String exprString = "I+V";
        parser = new Parser(exprString);

        Expression expr = parser.getExpression();
        assertEquals("V", expr.getOperands().lastElement());
    }

}

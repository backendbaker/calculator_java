package calculator;

public enum ExpressionType {
    ARABIC("^[0123456789]+$"),
    ROMAN("^[IVX]+$");

    private final String regExpString;

    ExpressionType(String expr){
        this.regExpString = expr;
    }

    public String getRegExpString(){
        return this.regExpString;
    }
}

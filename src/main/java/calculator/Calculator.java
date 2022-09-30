package calculator;

public class Calculator {
    public enum Operation {

        PLUS("+") {
            public int apply(int x, int y) {
                return x + y;
            }
        },
        MINUS("-") {
            public int apply(int x, int y) {
                return x - y;
            }
        },
        MULTIPLY("*") {
            public int apply(int x, int y) {
                return x * y;
            }
        },
        DIVIDE("/") {
            public int apply(int x, int y) {

                if (y == 0) {
                    throw new ArithmeticException("Деление на ноль запрещено");
                }
                return x / y;
            }
        };

        private final String symbol;

        Operation(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return symbol;
        }

        public abstract int apply(int x, int y);
    }
}

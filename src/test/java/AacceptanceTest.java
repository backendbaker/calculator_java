import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import program.Main;

import java.security.spec.ECField;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AacceptanceTest {
    @ParameterizedTest
    @MethodSource("provideCorrectExprParameters")
    void calcMustReturnCorrectResult(String expr, String expect){
        var res = Main.calc(expr);
        assertEquals(res, expect);
    }

    private static Stream<Arguments> provideCorrectExprParameters() {
        return Stream.of(
                Arguments.of("1+2", "3"),
                Arguments.of("1-2", "-1"),
                Arguments.of("1 * 9", "9"),
                Arguments.of("10 * 10", "100"),
                Arguments.of("10 / 10", "1"),
                Arguments.of("I+I", "II"),
                Arguments.of("i * ii", "II"),
                Arguments.of("VI / III", "II"),
                Arguments.of("II - I", "I")
        );
    }

//    private static Stream<Arguments> provideIllegalExprParameters(){
//        return Stream.of(
//                Arguments.of("1+I", "Неверный формат выражения"),
//                Arguments.of("IV - X", "Результат отрицательный. В римской системе нет отрицательных чисел"),
//                Arguments.of("1+", "Неверный формат выражения"),
//                Arguments.of("1 + 2 + 3", "Неверный формат выражения"),
//                Arguments.of("5 / 0", "Деление на ноль запрещено"),
//                Arguments.of("V / 0", "Деление на ноль запрещено"),
//                Arguments.of("-1", "Неверный формат выражения"),
//                Arguments.of("-1 + 2", "Неверный формат выражения"),
//                Arguments.of("CX + CX", "Введённые числа превышают X")
//        );
//    }
}

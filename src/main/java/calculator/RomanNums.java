package calculator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum RomanNums {
    I(1), IV(4), V(5), IX(9), X(10),
    XL(40), L(50), XC(90), C(100),
    CD(400), D(500), CM(900), M(1000);

    private int value;

    public int getValue(){
        return value;
    }
    RomanNums(int num){
        this.value = num;
    }
    public static List<RomanNums> getValuesReversed() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((RomanNums e) -> e.value).reversed())
                .collect(Collectors.toList());
    }
}

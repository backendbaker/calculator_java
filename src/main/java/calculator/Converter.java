package calculator;

import java.util.List;
import java.util.Locale;

public class Converter {
    public Converter() {}
    private final int MAX_ROMAN_NUM = 3999;
    public int toArabic(String operand) throws IllegalArgumentException {
        String num = operand.toUpperCase(Locale.ENGLISH);
        int result = 0;

        var romanNums= RomanNums.getValuesReversed();

        int i = 0;

        while ((num.length() > 0) && (i < romanNums.size())) {
            RomanNums n = romanNums.get(i);
            if (num.startsWith(n.name())) {
                result += n.getValue();
                num = num.substring(n.name().length());
            } else {
                i++;
            }
        }

        if (num.length() > 0) {
            throw new IllegalArgumentException("Неверный аругмент конвертации");
        }

        return result;
    }

    public String toRoman(int operand) throws IllegalArgumentException {
        int num = 0;
        try {
            num = operand;
            if (num > MAX_ROMAN_NUM){
            throw new IllegalArgumentException("Неверный аругмент конвертации");
            }
        }
        catch (Exception ex) {
            throw new IllegalArgumentException("Неверный аругмент конвертации");
        }

        StringBuilder sb = new StringBuilder();
        var romanNums = RomanNums.getValuesReversed();
        for (int i = 0; num > 0 && i < romanNums.size();) {
            RomanNums currentNum = romanNums.get(i);
            if (currentNum.getValue() <= num) {
                sb.append(currentNum.name());
                num -= currentNum.getValue();
            } else {i++;}

        }
        return sb.toString();
    }

}

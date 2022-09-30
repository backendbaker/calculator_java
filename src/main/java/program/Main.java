package program;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите математическое выражение: ");

        Scanner scanner = new Scanner(System.in);
        var exprString = scanner.nextLine();

        System.out.println("Результат: " + calc(exprString));
        System.exit(0);
    }

    public static String calc(String input) {
        String result = new String();
        try{
            result = new CalcController().calculate(input);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            System.exit(-1);
        }
        return result;
    }
}
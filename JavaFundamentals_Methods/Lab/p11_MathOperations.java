package Lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class p11_MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNum = Double.parseDouble(scanner.nextLine());
        String operator = scanner.nextLine();
        double secondNum = Double.parseDouble(scanner.nextLine());

        DecimalFormat df = new DecimalFormat("0.##");
        System.out.println(df.format(executeOperations(firstNum, operator, secondNum)));
    }

    public static double executeOperations(double firstNum, String operator, double secondNum) {
        double result = 0;
        switch (operator) {
            case "+":
                result = firstNum + secondNum;
                break;
            case "-":
                result = firstNum - secondNum;
                break;
            case "*":
                result = firstNum * secondNum;
                break;
            case "/":
                result = firstNum / secondNum;
                break;
        }
        return result;
    }
}
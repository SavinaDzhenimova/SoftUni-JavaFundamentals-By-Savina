package Exercise;

import java.util.Scanner;

public class p08_FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long firstNum = Integer.parseInt(scanner.nextLine());
        long secondNum = Integer.parseInt(scanner.nextLine());

        double factorialFirstNum = calculateFactorial(firstNum);
        double factorialSecondNum = calculateFactorial(secondNum);
        System.out.printf("%.2f", factorialFirstNum / factorialSecondNum);
    }

    public static double calculateFactorial(long number) {
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
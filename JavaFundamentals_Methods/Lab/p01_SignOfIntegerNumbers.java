package Lab;

import java.util.Scanner;

public class p01_SignOfIntegerNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        printIntegerSign(number);
    }

    public static void printIntegerSign(int num) {
        String integerSign = "";
        if (num < 0) {
            integerSign = "negative";
        } else if (num > 0) {
            integerSign = "positive";
        } else {
            integerSign = "zero";
        }
        System.out.printf("The number %d is %s.", num, integerSign);
    }
}
package Exercise;

import java.util.Scanner;

public class p10_TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int currentNum = 1; currentNum <= number; currentNum++) {
            if (sumOfDigitsIsDivisibleByEight(currentNum) && haveAtLeastOneOddDigit(currentNum)) {
                System.out.println(currentNum);
            }
        }
    }

    public static boolean sumOfDigitsIsDivisibleByEight(int number) {
        int sumOfDigits = 0;
        while (number > 0) {
            int currentDigit = number % 10;
            sumOfDigits += currentDigit;
            number /= 10;
        }

        if (sumOfDigits % 8 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean haveAtLeastOneOddDigit(int number) {
        while (number > 0) {
            int currentDigit = number % 10;
            if (currentDigit % 2 != 0) {
                return true;
            }
            number /= 10;
        }
        return false;
    }
}
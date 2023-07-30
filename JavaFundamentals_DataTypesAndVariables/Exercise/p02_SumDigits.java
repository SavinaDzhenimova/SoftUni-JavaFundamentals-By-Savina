package Exercise;

import java.util.Scanner;

public class p02_SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int sumOfDigits = 0;

        while (num > 0) {
            int lastDigit = num % 10;
            sumOfDigits += lastDigit;
            num /= 10;
        }

        System.out.println(sumOfDigits);
    }
}
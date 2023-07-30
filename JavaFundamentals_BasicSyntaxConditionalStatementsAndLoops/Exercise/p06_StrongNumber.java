package Exercise;

import java.util.Scanner;

public class p06_StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int currentNum = num;
        int sum = 0;

        while (currentNum > 0) {
            int currentDigit = currentNum % 10;
            int factorial = 1;

            for (int i = 1; i <= currentDigit; i++) {
                factorial *= i;
            }

            sum += factorial;
            currentNum /= 10;
        }

        if (sum == num) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
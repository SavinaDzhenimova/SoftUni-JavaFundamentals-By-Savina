package MoreExercise;

import java.util.Scanner;

public class p05_Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String num = scanner.nextLine();
            int numberOfDigits = num.length();
            int number = Integer.parseInt(num);
            int mainDigit = number % 10;
            int offset;
            int letter;

            if (number == 0) {
                letter = 32;
            } else {
                if (mainDigit == 8 || mainDigit == 9) {
                    offset = (mainDigit - 2) * 3;
                    offset += 1;
                } else {
                    offset = (mainDigit - 2) * 3;
                }

                int letterIndex = (offset + numberOfDigits - 1);
                letter = 97 + letterIndex;
            }
            System.out.printf("%c", letter);
        }
    }
}
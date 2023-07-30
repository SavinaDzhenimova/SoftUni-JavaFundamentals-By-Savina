package MoreExercise;

import java.util.Scanner;

public class p02_AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char startChar = scanner.nextLine().charAt(0);
        char endChar = scanner.nextLine().charAt(0);
        String text = scanner.nextLine();

        int sum = 0;
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (currentChar > startChar && currentChar < endChar) {
                sum += currentChar;
            }
        }

        System.out.println(sum);
    }
}
package MoreExercise;

import java.util.Scanner;

public class p04_ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String reversed = "";

        for (int i = text.length() - 1; i >= 0; i--) {
            char currentChar = text.charAt(i);
            reversed += currentChar;
        }

        System.out.println(reversed);
    }
}
package MoreExercise;

import java.util.Scanner;

public class p05_DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int interval = Integer.parseInt(scanner.nextLine());
        StringBuilder message = new StringBuilder();

        for (int i = 0; i < interval; i++) {
            char symbol = scanner.nextLine().charAt(0);
            char currentChar = (char) (symbol + key);
            message.append(currentChar);
        }

        System.out.println(message);
    }
}
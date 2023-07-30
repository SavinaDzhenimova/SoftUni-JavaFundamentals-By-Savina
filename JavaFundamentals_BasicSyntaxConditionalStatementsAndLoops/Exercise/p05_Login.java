package Exercise;

import java.util.Scanner;

public class p05_Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = "";

        for (int i = username.length() - 1; i >= 0; i--) {
            char currentChar = username.charAt(i);
            password += currentChar;
        }

        String input = scanner.nextLine();
        int count = 0;
        while (!input.equals(password)) {
            count++;
            if (count >= 4) {
                System.out.printf("User %s blocked!%n", username);
                break;
            }

            System.out.println("Incorrect password. Try again.");
            input = scanner.nextLine();
        }

        if (input.equals(password)) {
            System.out.printf("User %s logged in.%n", username);
        }
    }
}
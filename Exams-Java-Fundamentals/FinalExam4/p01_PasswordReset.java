package FinalExam4;

import java.util.Scanner;

public class p01_PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        String command = scanner.nextLine();

        while (command.equals("Done")) {
            String[] commands = command.split(" ");

            switch (commands[0]) {
                case "TakeOdd":
                    StringBuilder newPassword = new StringBuilder();
                    for (int i = 1; i < password.length(); i += 2) {
                        newPassword.append(password.charAt(i));
                    }

                    password = newPassword.toString();
                    System.out.println(password);
                    break;
                case "Cut":
                    int start = Integer.parseInt(commands[1]);
                    int end = start + Integer.parseInt(commands[2]);

                    password = new StringBuilder(password).delete(start, end).toString();

                    System.out.println(password);
                    break;
                case "Substitute":
                    String target = commands[1];
                    String replacement = commands[2];
                    if (password.contains(target)) {
                        password = password.replace(target, replacement);
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println("Your password is: " + password);
    }
}
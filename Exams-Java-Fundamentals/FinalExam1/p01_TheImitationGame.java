package FinalExam1;

import java.util.Scanner;

public class p01_TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("Decode")) {
            String[] commands = command.split("\\|");

            switch (commands[0]) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(commands[1]);

                    if (numberOfLetters <= message.length()) {
                        String part = message.substring(0, numberOfLetters);
                        message.replace(0, numberOfLetters, "");
                        message.append(part);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(commands[1]);
                    String value = commands[2];

                    message.insert(index, value);
                    break;
                case "ChangeAll":
                    StringBuilder substring = new StringBuilder(commands[1]);
                    String replacement = commands[2];

                    for (int i = 0; i < message.length(); i++) {
                        int indexOfOccurrence = message.indexOf(String.valueOf(substring));
                        if (indexOfOccurrence == -1) {
                            break;
                        }
                        message.replace(indexOfOccurrence, indexOfOccurrence + 1, replacement);
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.printf("The decrypted message is: %s%n", message);
    }
}
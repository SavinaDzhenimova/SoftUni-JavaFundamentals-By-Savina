package FinalExam7;

import java.util.Scanner;

public class p01_DecryptingCommands {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.equals("Finish")) {
            String[] tokens = command.split("\\s+");

            switch (tokens[0]) {
                case "Replace":
                    String currentChar = tokens[1];
                    String newChar = tokens[2];

                    if (input.contains(currentChar)) {
                        input = input.replaceAll(currentChar, newChar);
                    }

                    System.out.println(input);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);

                    String toRemove = "";
                    if (startIndex >= 0 && endIndex < input.length()) {
                        toRemove = input.substring(startIndex, endIndex + 1);
                        input = input.replace(toRemove, "");
                        System.out.println(input);
                    } else {
                        System.out.println("Invalid indices!");
                    }

                    break;
                case "Make":
                    switch (tokens[1]) {
                        case "Upper":
                            input = input.toUpperCase();
                            break;
                        case "Lower":
                            input = input.toLowerCase();
                            break;
                    }

                    System.out.println(input);
                    break;
                case "Check":
                    String toCheck = tokens[1];

                    if (input.contains(toCheck)) {
                        System.out.printf("Message contains %s%n", toCheck);
                    } else {
                        System.out.printf("Message doesn't contain %s%n", toCheck);
                    }
                    break;
                case "Sum":
                    int start = Integer.parseInt(tokens[1]);
                    int end = Integer.parseInt(tokens[2]);

                    int sum = 0;
                    if (start >= 0 && end < input.length()) {
                        String toSum = input.substring(start, end + 1);

                        for (int i = 0; i < toSum.length(); i++) {
                            char currentSymbol = toSum.charAt(i);
                            sum += currentSymbol;
                        }
                    } else {
                        System.out.println("Invalid indices!");
                    }

                    if (sum > 0) {
                        System.out.println(sum);
                    }
                    break;
            }

            command = scanner.nextLine();
        }
    }
}
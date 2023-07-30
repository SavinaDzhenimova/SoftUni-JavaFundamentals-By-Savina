package FinalExam3;

import java.util.Scanner;

public class p01_SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("Reveal")) {
            String[] tokens = command.split(":\\|:");

            String result = "";
            switch (tokens[0]) {
                case "InsertSpace":
                    int index = Integer.parseInt(tokens[1]);

                    message.insert(index, " ");
                    System.out.println(message);
                    break;
                case "Reverse":
                    StringBuilder substring = new StringBuilder(tokens[1]);

                    result = String.valueOf(message);
                    if (result.contains(substring)) {
                        result = result.replaceFirst(String.valueOf(substring), "");
                        substring.reverse();
                        message = new StringBuilder(result.concat(String.valueOf(substring)));

                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }

                    break;
                case "ChangeAll":
                    String toReplace = tokens[1];
                    String replacement = tokens[2];

                    result = String.valueOf(message);
                    message = new StringBuilder(result.replaceAll(toReplace, replacement));

                    System.out.println(message);
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.printf("You have a new text message: %s%n", message);
    }
}
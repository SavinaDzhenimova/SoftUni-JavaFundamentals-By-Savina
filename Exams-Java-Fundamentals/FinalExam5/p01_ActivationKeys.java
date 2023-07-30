package FinalExam5;

import java.util.Scanner;

public class p01_ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.equals("Generate")) {
            String[] tokens = command.split(">>>");

            switch (tokens[0]) {
                case "Contains":
                    String substring = tokens[1];

                    if (input.contains(substring)) {
                        System.out.printf("%s contains %s%n", input, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endIndex = Integer.parseInt(tokens[3]);

                    String startText = input.substring(0, startIndex);
                    String toChange = input.substring(startIndex, endIndex);
                    String endText = input.substring(endIndex);

                    if (tokens[1].equals("Upper")) {
                        toChange = toChange.toUpperCase();
                    } else if (tokens[1].equals("Lower")) {
                        toChange = toChange.toLowerCase();
                    }

                    input = startText + toChange + endText;
                    System.out.println(input);
                    break;
                case "Slice":
                    int start = Integer.parseInt(tokens[1]);
                    int end = Integer.parseInt(tokens[2]);

                    StringBuilder text = new StringBuilder(input);
                    text.delete(start, end);
                    input = String.valueOf(text);
                    System.out.println(input);
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println("Your activation key is: " + input);
    }
}
package FinalExam6;

import java.util.Scanner;

public class p01_ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String activationKey = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.equals("Generate")) {
            String[] tokens = command.split(">>>");

            switch (tokens[0]) {
                case "Contains":
                    String substring = tokens[1];

                    if (activationKey.contains(substring)) {
                        System.out.printf("%s contains %s%n", activationKey, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endIndex = Integer.parseInt(tokens[3]);

                    String start = activationKey.substring(0, startIndex);
                    String toChange = activationKey.substring(startIndex, endIndex);
                    String end = activationKey.substring(endIndex);

                    switch (tokens[1]) {
                        case "Upper":
                            toChange = toChange.toUpperCase();
                            break;
                        case "Lower":
                            toChange = toChange.toLowerCase();
                            break;
                    }

                    activationKey = start + toChange + end;
                    System.out.println(activationKey);
                    break;
                case "Slice":
                    int indexStart = Integer.parseInt(tokens[1]);
                    int indexEnd = Integer.parseInt(tokens[2]);

                    String toRemove = activationKey.substring(indexStart, indexEnd);
                    activationKey = activationKey.replace(toRemove, "");
                    System.out.println(activationKey);
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.printf("Your activation key is: %s%n", activationKey);
    }
}
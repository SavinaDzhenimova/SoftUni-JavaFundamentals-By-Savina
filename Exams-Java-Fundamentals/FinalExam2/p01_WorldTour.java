package FinalExam2;

import java.util.Scanner;

public class p01_WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String command = scanner.nextLine();

        //•	"Switch:{old_string}:{new_string}":
        //o	If the old string is in the initial string, replace it with the new one (all occurrences)
        while (!command.equals("Travel")) {
            String[] tokens = command.split(":");

            switch (tokens[0]) {
                case "Add Stop":
                    int index = Integer.parseInt(tokens[1]);
                    String stringToAdd = tokens[2];

                    StringBuilder result = new StringBuilder();
                    if (index >= 0 && index < input.length()) {
                        result.append(input, 0, index);
                        result.append(stringToAdd);
                        result.append(input.substring(index));
                    }

                    input = String.valueOf(result);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);

                    if (startIndex >= 0 && endIndex < input.length()) {
                        String toRemove = input.substring(startIndex, endIndex + 1);
                        input = input.replace(toRemove, "");
                    }

                    break;
                case "Switch":
                    String oldString = tokens[1];
                    String newString = tokens[2];

                    if (input.contains(oldString)) {
                        input = input.replaceAll(oldString, newString);
                    }

                    break;
            }
            System.out.println(input);

            command = scanner.nextLine();
        }

        System.out.printf("Ready for world tour! Planned stops: %s%n", input);
    }
}
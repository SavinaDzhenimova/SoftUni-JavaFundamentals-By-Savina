package MidExam8;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p02_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Finish")) {
            String[] commands = input.split(" ");
            int value = Integer.parseInt(commands[1]);

            switch (commands[0]) {
                case "Add":
                    numbersList.add(value);
                    break;
                case "Remove":
                    if (numbersList.contains(value)) {
                        numbersList.remove(Integer.valueOf(value));
                    }
                    break;
                case "Replace":
                    int replacement = Integer.parseInt(commands[2]);

                    if (numbersList.contains(value)) {
                        numbersList.set(numbersList.indexOf(value), replacement);
                    }
                    break;
                case "Collapse":

                    numbersList.removeIf(number -> number < value);
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(numbersList.toString().replaceAll("[\\[\\],]", ""));
    }
}
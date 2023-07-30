package Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p05_ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] commands = input.split(" ");

            switch (commands[0]) {
                case "Contains":
                    int numToContain = Integer.parseInt(commands[1]);
                    if (numbersList.contains(numToContain)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    if (commands[1].equals("even")) {
                        for (int item : numbersList) {
                            if (item % 2 == 0) {
                                System.out.printf("%d ", item);
                            }
                        }
                        System.out.println();
                    } else if (commands[1].equals("odd")) {
                        for (int item : numbersList) {
                            if (item % 2 != 0) {
                                System.out.printf("%d ", item);
                            }
                        }
                        System.out.println();
                    }
                    break;
                case "Get":
                    int sumOfNumbers = 0;
                    for (int item : numbersList) {
                        sumOfNumbers += item;
                    }
                    System.out.println(sumOfNumbers);
                    break;
                case "Filter":
                    String condition = commands[1];
                    int num = Integer.parseInt(commands[2]);

                    switch (condition) {
                        case "<":
                            for (int item : numbersList) {
                                if (item < num) {
                                    System.out.printf("%d ", item);
                                }
                            }
                            System.out.println();
                            break;
                        case "<=":
                            for (int item : numbersList) {
                                if (item <= num) {
                                    System.out.printf("%d ", item);
                                }
                            }
                            System.out.println();
                            break;
                        case ">":
                            for (int item : numbersList) {
                                if (item > num) {
                                    System.out.printf("%d ", item);
                                }
                            }
                            System.out.println();
                            break;
                        case ">=":
                            for (int item : numbersList) {
                                if (item >= num) {
                                    System.out.printf("%d ", item);
                                }
                            }
                            System.out.println();
                            break;
                        }
                        break;
                    }

            input = scanner.nextLine();
        }
    }
}
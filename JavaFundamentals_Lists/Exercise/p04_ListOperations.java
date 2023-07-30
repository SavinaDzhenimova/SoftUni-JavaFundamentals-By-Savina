package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p04_ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //• Add {number} - add number at the end
        //• Insert {number} {index} - insert number at given index
        //• Remove {index} - remove that index
        //• Shift left {count} - first number becomes last 'count' times
        //• Shift right {count} - last number becomes first 'count' times

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] commands = input.split(" ");

            switch (commands[0]) {
                case "Add":
                    int numToAdd = Integer.parseInt(commands[1]);
                    numbersList.add(numToAdd);
                    break;
                case "Insert":
                    int numToInsert = Integer.parseInt(commands[1]);
                    int insertIndex = Integer.parseInt(commands[2]);

                    if (insertIndex >= 0 && insertIndex < numbersList.size()) {
                        numbersList.add(insertIndex, numToInsert);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int removeIndex = Integer.parseInt(commands[1]);

                    if (removeIndex >= 0 && removeIndex < numbersList.size()) {
                        numbersList.remove(removeIndex);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    int count = Integer.parseInt(commands[2]);

                    switch (commands[1]) {
                        case "left":
                            for (int i = 1; i <= count; i++) {
                                int currentElement = numbersList.get(0);

                                numbersList.add(currentElement);
                                numbersList.remove(0);
                            }
                            break;
                        case "right":
                            for (int i = 1; i <= count; i++) {
                                int currentElement = numbersList.get(numbersList.size() - 1);

                                numbersList.add(0, currentElement);
                                numbersList.remove(numbersList.size() - 1);
                            }
                            break;
                    }
            }

            input = scanner.nextLine();
        }

        System.out.println(numbersList.toString().replaceAll("[\\[\\],]", ""));
    }
}
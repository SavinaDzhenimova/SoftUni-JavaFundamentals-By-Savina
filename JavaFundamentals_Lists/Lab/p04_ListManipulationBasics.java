package Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p04_ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] commands = input.split(" ");

            switch (commands[0]) {
                case "Add":
                    int numToAdd = Integer.parseInt(commands[1]);
                    numbersList.add(numToAdd);
                    break;
                case "Remove":
                    int numToRemove = Integer.parseInt(commands[1]);
                    numbersList.remove(Integer.valueOf(numToRemove));
                    break;
                case "RemoveAt":
                    int removeIndex = Integer.parseInt(commands[1]);
                    numbersList.remove(removeIndex);
                    break;
                case "Insert":
                    int numToInsert = Integer.parseInt(commands[1]);
                    int insertIndex = Integer.parseInt(commands[2]);
                    numbersList.add(insertIndex, numToInsert);
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(numbersList.toString().replaceAll("[\\[\\],]", ""));
    }
}
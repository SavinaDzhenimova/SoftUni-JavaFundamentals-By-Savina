package MidExam6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p02_TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> chest = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Yohoho!")) {
            String[] commands = input.split(" ");

            switch (commands[0]) {
                case "Loot":
                    for (int i = 1; i < commands.length; i++) {
                        String newElement = commands[i];

                        if (!chest.contains(newElement)) {
                            chest.add(0, newElement);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(commands[1]);

                    if (index >= 0 && index < chest.size()) {
                        String elementToRemove = chest.get(index);
                        chest.remove(index);
                        chest.add(elementToRemove);
                    }
                    break;
                case "Steal":
                    int countOfElements = Integer.parseInt(commands[1]);

                    if (countOfElements < chest.size()) {
                        int startIndex = chest.size() - countOfElements;

                        List<String> stolenElements = new ArrayList<>(chest.subList(startIndex, chest.size()));
                        chest.subList(startIndex, chest.size()).clear();
                        System.out.println(stolenElements.toString().replaceAll("[\\[\\]]", ""));
                    } else {
                        System.out.println(chest.toString().replaceAll("[\\[\\]]", ""));
                        chest.clear();
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        if (chest.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            int sumOfElements = 0;

            for (String element : chest) {
                sumOfElements += element.length();
            }
            double averageSum = sumOfElements * 1.0 / chest.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.%n", averageSum);
        }
    }
}
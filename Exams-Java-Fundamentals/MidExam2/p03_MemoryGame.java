package MidExam2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p03_MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elementsList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String command = scanner.nextLine();
        int movesCounter = 0;

        while (!command.equals("end")) {
            String[] indexes = command.split(" ");
            int firstIndex = Integer.parseInt(indexes[0]);
            int secondIndex = Integer.parseInt(indexes[1]);
            movesCounter++;

            if (firstIndex < 0 || secondIndex < 0 || firstIndex >= elementsList.size()
                    || secondIndex >= elementsList.size() || firstIndex == secondIndex) {
                String insertedElement = "-" + movesCounter + "a";
                elementsList.add(elementsList.size() / 2, insertedElement);
                elementsList.add(elementsList.size() / 2, insertedElement);
                System.out.println("Invalid input! Adding additional elements to the board");
            } else {
                if (elementsList.get(firstIndex).equals(elementsList.get(secondIndex))) {
                    System.out.printf("Congrats! You have found matching elements - %s!%n", elementsList.get(firstIndex));

                    if (firstIndex > secondIndex) {
                        elementsList.remove(firstIndex);
                        elementsList.remove(secondIndex);
                    } else {
                        elementsList.remove(secondIndex);
                        elementsList.remove(firstIndex);
                    }
                    if (elementsList.isEmpty()) {
                        System.out.printf("You have won in %d turns!%n", movesCounter);
                        break;
                    }
                } else {
                    System.out.println("Try again!");
                }
            }

            command = scanner.nextLine();
        }

        if (!elementsList.isEmpty()) {
            System.out.println("Sorry you lose :(");
            System.out.println(elementsList.toString().replaceAll("[\\[\\],]", ""));
        }
    }
}
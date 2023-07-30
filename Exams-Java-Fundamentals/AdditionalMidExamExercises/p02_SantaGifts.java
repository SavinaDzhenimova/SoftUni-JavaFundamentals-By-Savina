package AdditionalMidExamExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p02_SantaGifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        List<Integer> housesList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int currentIndex = 0;
        for (int i = 0; i < numberOfCommands; i++) {
            String[] commands = scanner.nextLine().split(" ");

            switch (commands[0]) {
                case "Forward":
                    int numberOfStepsForward = Integer.parseInt(commands[1]);
                    int indexForward = currentIndex + numberOfStepsForward;

                    if (indexForward >= 0 && indexForward < housesList.size()) {
                        housesList.remove(indexForward);
                        currentIndex = indexForward;
                    }
                    break;
                case "Back":
                    int numberOfStepsBack = Integer.parseInt(commands[1]);
                    int indexBack = currentIndex - numberOfStepsBack;

                    if (indexBack >= 0 && indexBack < housesList.size()) {
                        housesList.remove(indexBack);
                        currentIndex = indexBack;
                    }
                    break;
                case "Gift":
                    int giftIndex = Integer.parseInt(commands[1]);
                    int houseNumber = Integer.parseInt(commands[2]);

                    if (giftIndex >= 0 && giftIndex < housesList.size()) {
                        housesList.add(giftIndex, houseNumber);
                        currentIndex = giftIndex;
                    }
                    break;
                case "Swap":
                    int firstHouseNumber = Integer.parseInt(commands[1]);
                    int secondHouseNumber = Integer.parseInt(commands[2]);

                    if (housesList.contains(firstHouseNumber) && housesList.contains(secondHouseNumber)) {
                        int indexOfFirstHouse = housesList.indexOf(firstHouseNumber);
                        int indexOfSecondHouse = housesList.indexOf(secondHouseNumber);

                        housesList.set(indexOfFirstHouse, secondHouseNumber);
                        housesList.set(indexOfSecondHouse, firstHouseNumber);
                    }
                    break;
            }
        }

        System.out.printf("Position: %d%n", currentIndex);
        System.out.println(housesList.toString().replaceAll("[\\[\\]]", ""));
    }
}
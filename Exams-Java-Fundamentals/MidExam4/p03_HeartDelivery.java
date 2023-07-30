package MidExam4;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p03_HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("@"))
                        .map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();
        int lastPositionIndex = 0;

        while (!input.equals("Love!")) {
            String[] commands = input.split(" ");
            int jumpLength = Integer.parseInt(commands[1]);
            lastPositionIndex += jumpLength;

            if (lastPositionIndex >= numbersList.size()) {
                lastPositionIndex = 0;
            }

            if (numbersList.get(lastPositionIndex) == 0) {
                System.out.printf("Place %d already had Valentine's day.%n", lastPositionIndex);
            } else {
                int newElement = numbersList.get(lastPositionIndex) - 2;
                if (newElement == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", lastPositionIndex);
                }
                numbersList.set(lastPositionIndex, newElement);
            }

            input = scanner.nextLine();
        }

        System.out.printf("Cupid's last position was %d.%n", lastPositionIndex);
        int numberOfHousesWithoutValentinesDay = 0;
        for (Integer number : numbersList) {
            if (number != 0) {
                numberOfHousesWithoutValentinesDay++;
            }
        }

        if (numberOfHousesWithoutValentinesDay == 0) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.%n", numberOfHousesWithoutValentinesDay);
        }
    }
}
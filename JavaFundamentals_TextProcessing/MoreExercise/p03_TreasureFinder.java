package MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class p03_TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] keyArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();

        while (!command.equals("find")) {
            StringBuilder text = new StringBuilder(command);
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < keyArr.length; i++) {
                if (text.length() == 0) {
                    break;
                }

                int key = keyArr[i];
                char symbol = text.charAt(0);

                symbol -= key;
                result.append(symbol);
                text.deleteCharAt(0);

                if (keyArr.length - 1 == i) {
                    i = -1;
                }
            }

            int startIndexTreasure = result.indexOf("&");
            int endIndexTreasure = result.lastIndexOf("&");
            String treasure = result.substring(startIndexTreasure + 1, endIndexTreasure);

            int startIndexCoordinates = result.indexOf("<");
            int endIndexCoordinates = result.lastIndexOf(">");
            String coordinates = result.substring(startIndexCoordinates + 1, endIndexCoordinates);

            System.out.printf("Found %s at %s%n", treasure, coordinates);

            command = scanner.nextLine();
        }
    }
}
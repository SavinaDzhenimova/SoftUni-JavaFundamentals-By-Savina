package AdditionalMidExamExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p07_EnduranceRally {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> driversList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        List<Double> trackLayout = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());
        List<Integer> checkpointIndexes = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        for (String currentDriver : driversList) {
            double fuel = currentDriver.charAt(0);
            boolean trackCompleted = true;
            int indexReached = 0;

            for (int i = 0; i < trackLayout.size(); i++) {
                double currentStation = trackLayout.get(i);

                if (checkpointIndexes.contains(i)) {
                    fuel += currentStation;
                } else {
                    fuel -= currentStation;
                }

                if (fuel <= 0) {
                    trackCompleted = false;
                    indexReached = i;
                    break;
                }
            }

            if (trackCompleted) {
                System.out.printf("%s - fuel left %.2f%n", currentDriver, fuel);
            } else {
                System.out.printf("%s - reached %d%n", currentDriver, indexReached);
            }
        }
    }
}
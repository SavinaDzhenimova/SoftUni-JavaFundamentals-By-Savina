package AdditionalMidExamExercises;

import java.util.*;
import java.util.stream.Collectors;

public class p05_SinoTheWalker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> timeToLeave = Arrays.stream(scanner.nextLine().split(":")).map(Integer::parseInt).collect(Collectors.toList());
        int numberOfSteps = Integer.parseInt(scanner.nextLine()) % 86400;
        int timeInSecondsForEachStep = Integer.parseInt(scanner.nextLine()) % 86400;

        int hoursToLeave = timeToLeave.get(0);
        int minutesToLeave = timeToLeave.get(1);
        int secondsToLeave = timeToLeave.get(2);
        int timeToLeaveInSeconds = secondsToLeave + minutesToLeave * 60 + hoursToLeave * 3600;

        int timeWalkingInSeconds = numberOfSteps * timeInSecondsForEachStep;
        int totalTimeInSeconds = timeToLeaveInSeconds + timeWalkingInSeconds;

        int hoursOfArriving = totalTimeInSeconds / 3600;
        totalTimeInSeconds %= 3600;
        int minutesOfArriving = totalTimeInSeconds / 60;
        int secondsOfArriving = totalTimeInSeconds % 60;

        if (hoursOfArriving > 23) {
            hoursOfArriving -= 24;
        }

        System.out.printf("Time Arrival: %02d:%02d:%02d%n", hoursOfArriving, minutesOfArriving, secondsOfArriving);
    }
}
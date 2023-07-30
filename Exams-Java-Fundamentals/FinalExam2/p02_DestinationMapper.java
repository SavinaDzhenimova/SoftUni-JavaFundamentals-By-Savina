package FinalExam2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p02_DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "([=/])?(?<destination>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        int totalPoints = 0;
        List<String> destinationsList = new ArrayList<>();
        while (matcher.find()) {
            String destination = matcher.group("destination");
            destinationsList.add(destination);
            int points = destination.length();
            totalPoints += points;
        }

        System.out.printf("Destinations: %s%n", String.join(", ", destinationsList));
        System.out.printf("Travel Points: %d", totalPoints);
    }
}
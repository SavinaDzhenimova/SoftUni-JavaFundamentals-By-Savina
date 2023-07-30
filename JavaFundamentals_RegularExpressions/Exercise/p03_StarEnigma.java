package Exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p03_StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfMessages = Integer.parseInt(scanner.nextLine());

        String regex = "@(?<planetName>[A-Za-z]+)[^@\\-!:>]*:(?<population>\\d+)[^@\\-!:>]*!(?<attackType>A|D)![^@\\-!:>]*->(?<soldierCount>\\d+)";

        List<String> attackedPlanetsList = new ArrayList<>();
        List<String> destroyedPlanetsList = new ArrayList<>();
        for (int i = 0; i < numberOfMessages; i++) {
            String encryptedMessage = scanner.nextLine();
            int key = 0;

            for (int j = 0; j < encryptedMessage.length(); j++) {
                char currentChar = encryptedMessage.charAt(j);

                switch (currentChar) {
                    case 's':
                    case 't':
                    case 'a':
                    case 'r':
                    case 'S':
                    case 'T':
                    case 'A':
                    case 'R':
                        key++;
                        break;
                }
            }

            StringBuilder decryptedMessage = new StringBuilder();
            for (int j = 0; j < encryptedMessage.length(); j++) {
                char currentChar = encryptedMessage.charAt(j);

                currentChar -= key;
                decryptedMessage.append(currentChar);
            }

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(decryptedMessage);

            while (matcher.find()) {
                String planetName = matcher.group("planetName");
                String attackType = matcher.group("attackType");

                switch (attackType) {
                    case "A":
                        attackedPlanetsList.add(planetName);
                        break;
                    case "D":
                        destroyedPlanetsList.add(planetName);
                        break;
                }
            }
        }

        System.out.printf("Attacked planets: %d%n", attackedPlanetsList.size());
        Collections.sort(attackedPlanetsList);
        for (String planet : attackedPlanetsList) {
            System.out.printf("-> %s%n", planet);
        }
        System.out.printf("Destroyed planets: %d%n", destroyedPlanetsList.size());
        Collections.sort(destroyedPlanetsList);
        for (String planet : destroyedPlanetsList) {
            System.out.printf("-> %s%n", planet);
        }
    }
}
package MidExam6;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p03_ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShip = Arrays.stream(scanner.nextLine().split(">"))
                        .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> warship = Arrays.stream(scanner.nextLine().split(">"))
                        .map(Integer::parseInt).collect(Collectors.toList());
        int maxHealthCapacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        boolean stalemate = false;

        while (!input.equals("Retire")) {
            String[] commands = input.split(" ");

            switch (commands[0]) {
                case "Fire":
                    int indexToDamage = Integer.parseInt(commands[1]);
                    int damage = Integer.parseInt(commands[2]);

                    if (indexToDamage >= 0 && indexToDamage < warship.size()) {
                        int damagedSection = warship.get(indexToDamage) - damage;
                        if (damagedSection <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            stalemate = true;
                            break;
                        } else {
                            warship.set(indexToDamage, damagedSection);
                        }
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(commands[1]);
                    int endIndex = Integer.parseInt(commands[2]);
                    damage = Integer.parseInt(commands[3]);

                    if (startIndex >= 0 && startIndex < pirateShip.size() && endIndex >= 0 && endIndex < pirateShip.size()) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            int currentSection = pirateShip.get(i);
                            int damagedSection = currentSection - damage;

                            if (damagedSection <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                stalemate = true;
                                break;
                            } else {
                                pirateShip.set(i, damagedSection);
                            }
                        }
                    }
                    break;
                case "Repair":
                    int indexToRepair = Integer.parseInt(commands[1]);
                    int health = Integer.parseInt(commands[2]);

                    if (indexToRepair >= 0 && indexToRepair < pirateShip.size()) {
                        int sectionToRepair = pirateShip.get(indexToRepair) + health;

                        if (sectionToRepair > maxHealthCapacity) {
                            sectionToRepair = maxHealthCapacity;
                        }

                        pirateShip.set(indexToRepair, sectionToRepair);
                    }
                    break;
                case "Status":
                    int sectionsToRepairCount = 0;
                    double sectionToRepair = maxHealthCapacity * 0.20;

                    for (Integer section : pirateShip) {
                        if (section < sectionToRepair) {
                            sectionsToRepairCount++;
                        }
                    }

                    System.out.printf("%d sections need repair.%n", sectionsToRepairCount);
                    break;
            }

            if (stalemate) {
                break;
            }

            input = scanner.nextLine();
        }

        if (!stalemate) {
            int pirateShipSum = 0;
            for (Integer section : pirateShip) {
                pirateShipSum += section;
            }

            int warshipSum = 0;
            for (Integer section : warship) {
                warshipSum += section;
            }

            System.out.printf("Pirate ship status: %d%n", pirateShipSum);
            System.out.printf("Warship status: %d%n", warshipSum);
        }
    }
}
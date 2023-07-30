package Exercise;

import java.util.Scanner;

public class p10_TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] initialLoot = scanner.nextLine().split("\\|");
        String input = scanner.nextLine();

        while (!input.equals("Yohoho!")) {
            String[] commands = input.split(" ");

            switch (commands[0]) {
                case "Loot":
                    for (int i = 1; i < commands.length; i++) {
                        boolean alreadyContained = false;
                        for (String item : initialLoot) {
                            if (commands[i].equals(item)) {
                                alreadyContained = true;
                                break;
                            }
                        }
                        if (!alreadyContained) {
                            String newChest = commands[i] + " " + String.join(" ", initialLoot);
                            initialLoot = newChest.split(" ");
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(commands[1]);

                    if (index >= 0 && index <= initialLoot.length - 1) {
                        String dropItem = initialLoot[index];

                        for (int i = index; i < initialLoot.length - 1; i++) {
                            initialLoot[i] = initialLoot[i + 1];
                        }
                        initialLoot[initialLoot.length - 1] = dropItem;
                    } else {
                        break;
                    }
                    break;
                case "Steal":
                    int stolenItemsCount = Integer.parseInt(commands[1]);

                    if (stolenItemsCount >= 0 && stolenItemsCount < initialLoot.length) {
                        for (int i = 0; i < stolenItemsCount; i++) {
                            System.out.print(initialLoot[initialLoot.length - stolenItemsCount + i]);
                            if (i != stolenItemsCount - 1) {
                                System.out.print(", ");
                            }
                        }

                        String[] tempLoot = new String[initialLoot.length - stolenItemsCount];
                        for (int i = 0; i < tempLoot.length; i++) {
                            tempLoot[i] = initialLoot[i];
                        }
                        initialLoot = tempLoot;
                    } else if (stolenItemsCount >= 0) {
                        for (int i = 0; i < initialLoot.length; i++) {
                            System.out.print(initialLoot[i]);
                            if (i != initialLoot.length - 1) {
                                System.out.print(", ");
                            }
                        }
                        initialLoot = new String[0];
                    }
                    System.out.println();
                    break;
            }

            input = scanner.nextLine();
        }

        String treasureCount = String.join("", initialLoot);
        int charCounter = 0;
        for (int i = 0; i < treasureCount.length(); i++) {
            charCounter++;
        }
        double averageTreasure = (1.0 * charCounter) / initialLoot.length;
        if (charCounter > 0) {
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageTreasure);
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}
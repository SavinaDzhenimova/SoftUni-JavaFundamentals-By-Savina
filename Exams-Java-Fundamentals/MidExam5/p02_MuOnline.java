package MidExam5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p02_MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputList = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());
        int health = 100;
        int bitcoins = 0;

        for (int index = 0; index < inputList.size(); index++) {
            String[] commands = inputList.get(index).split(" ");

            if (commands[0].equals("potion")) {
                int potionPower = Integer.parseInt(commands[1]);

                if (health + potionPower > 100) {
                    System.out.printf("You healed for %d hp.%n", 100 - health);
                    health = 100;
                } else {
                    health += potionPower;
                    System.out.printf("You healed for %d hp.%n", potionPower);
                }

                System.out.printf("Current health: %d hp.%n", health);
            } else if (commands[0].equals("chest")) {
                int foundedBitcoins = Integer.parseInt(commands[1]);
                bitcoins += foundedBitcoins;

                System.out.printf("You found %d bitcoins.%n", foundedBitcoins);
            } else {
                String monster = commands[0];
                int monsterPower = Integer.parseInt(commands[1]);

                if (health - monsterPower > 0) {
                    health -= monsterPower;
                    System.out.printf("You slayed %s.%n", monster);
                } else if (health - monsterPower <= 0) {
                    System.out.printf("You died! Killed by %s.%n", monster);
                    System.out.printf("Best room: %d%n", index + 1);
                    break;
                }
            }

            if (index == inputList.size() - 1) {
                System.out.println("You've made it!");
                System.out.printf("Bitcoins: %d%n", bitcoins);
                System.out.printf("Health: %d%n", health);
            }
        }
    }
}
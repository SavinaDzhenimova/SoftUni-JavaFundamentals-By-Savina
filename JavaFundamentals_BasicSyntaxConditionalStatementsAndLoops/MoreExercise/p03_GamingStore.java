package MoreExercise;

import java.util.Scanner;

public class p03_GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double currentBalance = Double.parseDouble(scanner.nextLine());
        String gameName = scanner.nextLine();
        double totalSpent = 0;
        boolean outOfMoney = false;

        while (!gameName.equals("Game Time")) {
            double gamePrice = 0.0;

            boolean invalidGame = false;
            switch (gameName) {
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    gamePrice = 39.99;
                    break;
                case "CS: OG":
                    gamePrice = 15.99;
                    break;
                case "Zplinter Zell":
                    gamePrice = 19.99;
                    break;
                case "Honored 2":
                    gamePrice = 59.99;
                    break;
                case "RoverWatch":
                    gamePrice = 29.99;
                    break;
                default:
                    invalidGame = true;
                    break;
            }

            if (invalidGame) {
                System.out.println("Not Found");
            } else if (currentBalance < gamePrice) {
                System.out.println("Too Expensive");
            } else {
                System.out.printf("Bought %s%n", gameName);
                currentBalance -= gamePrice;
                totalSpent += gamePrice;
            }
            if (currentBalance == 0) {
                outOfMoney = true;
                break;
            }
            gameName = scanner.nextLine();
        }

        if (outOfMoney) {
            System.out.println("Out of money");
        } else {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSpent, currentBalance);
        }
    }
}

package Exercise;

import java.util.Scanner;

public class p07_VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalMoney = 0.0;

        while (!input.equals("Start")) {
            double coins = Double.parseDouble(input);

            if (coins == 0.10 || coins == 0.20 || coins == 0.50 || coins == 1.00 || coins == 2.00) {
                totalMoney += coins;
            } else {
                System.out.printf("Cannot accept %.2f%n", coins);
            }

            input = scanner.nextLine();
        }

        String product = scanner.nextLine();
        double price = 0;
        while (!product.equals("End")) {
            boolean invalid = false;

            switch (product) {
                case "Nuts":
                    price = 2.00;
                    break;
                case "Water":
                    price = 0.70;
                    break;
                case "Crisps":
                    price = 1.50;
                    break;
                case "Soda":
                    price = 0.80;
                    break;
                case "Coke":
                    price = 1.00;
                    break;
                default:
                    invalid = true;
                    break;
            }

            if (invalid) {
                System.out.println("Invalid product");
            } else if (totalMoney >= price) {
                totalMoney -= price;
                System.out.printf("Purchased %s%n", product);
            } else {
                System.out.println("Sorry, not enough money");
            }

            product = scanner.nextLine();
        }

        System.out.printf("Change: %.2f", totalMoney);
    }
}
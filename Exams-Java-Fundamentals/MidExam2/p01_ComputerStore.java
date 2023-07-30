package MidExam2;

import java.util.Scanner;

public class p01_ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double priceWithoutTaxes = 0;
        while (true) {
            if (input.equals("regular") || input.equals("special")) {
                break;
            }

            double price = Double.parseDouble(input);
            if (price < 0) {
                System.out.println("Invalid price!");
            } else {
                priceWithoutTaxes += price;
            }

            input = scanner.nextLine();
        }

        double taxes = priceWithoutTaxes * 0.20;
        double priceWithTaxes = priceWithoutTaxes + taxes;
        if (input.equals("special")) {
            priceWithTaxes -= priceWithTaxes * 0.10;
        }

        if (priceWithoutTaxes == 0) {
            System.out.println("Invalid order!");
        } else {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", priceWithoutTaxes);
            System.out.printf("Taxes: %.2f$%n", taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$%n", priceWithTaxes);
        }
    }
}
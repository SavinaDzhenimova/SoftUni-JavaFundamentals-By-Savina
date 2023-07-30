package Lab;

import java.util.Scanner;

public class p05_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        double price = 0;
        double totalPrice = 0;

        switch (product) {
            case "water":
                price = 1.00;
                totalPrice = calculateTotalPrice(price, quantity);
                break;
            case "coffee":
                price = 1.50;
                totalPrice = calculateTotalPrice(price, quantity);
                break;
            case "coke":
                price = 1.40;
                totalPrice = calculateTotalPrice(price, quantity);
                break;
            case "snacks":
                price = 2.00;
                totalPrice = calculateTotalPrice(price, quantity);
                break;
        }

        System.out.printf("%.2f", totalPrice);
    }

    public static double calculateTotalPrice(double price, int quantity) {
        return price * quantity;
    }
}
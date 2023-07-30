package Exercise;

import java.util.Scanner;

public class p03_Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleCount = Integer.parseInt(scanner.nextLine());
        String typeOfGroup = scanner.nextLine();
        String day = scanner.nextLine();
        double price = 0;

        switch (typeOfGroup) {
            case "Students":
                switch (day) {
                    case "Friday":
                        price = 8.45;
                        break;
                    case "Saturday":
                        price = 9.80;
                        break;
                    case "Sunday":
                        price = 10.46;
                        break;
                }
                break;
            case "Business":
                switch (day) {
                    case "Friday":
                        price = 10.90;
                        break;
                    case "Saturday":
                        price = 15.60;
                        break;
                    case "Sunday":
                        price = 16.00;
                        break;
                }
                break;
            case "Regular":
                switch (day) {
                    case "Friday":
                        price = 15.00;
                        break;
                    case "Saturday":
                        price = 20.00;
                        break;
                    case "Sunday":
                        price = 22.50;
                        break;
                }
                break;
        }

        double totalPrice = peopleCount * price;
        if (typeOfGroup.equals("Students") && peopleCount >= 30) {
            totalPrice *= 0.85;
        } else if (typeOfGroup.equals("Business") && peopleCount >= 100) {
            totalPrice -= 10 * price;
        } else if (typeOfGroup.equals("Regular") && peopleCount >= 10 && peopleCount <= 20) {
            totalPrice *= 0.95;
        }

        System.out.printf("Total price: %.2f", totalPrice);
    }
}
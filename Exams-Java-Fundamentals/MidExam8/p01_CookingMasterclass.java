package MidExam8;

import java.util.Scanner;

public class p01_CookingMasterclass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        double flourPackagePrice = Double.parseDouble(scanner.nextLine());
        double singleEggPrice = Double.parseDouble(scanner.nextLine());
        double singleApronPrice = Double.parseDouble(scanner.nextLine());

        double apronTotalPrice = singleApronPrice * Math.ceil(studentsCount * 1.20);
        double eggsTotalPrice = singleEggPrice * 10 * studentsCount;
        int freePackagesFlour = studentsCount / 5;
        double flourTotalPrice = flourPackagePrice * (studentsCount - freePackagesFlour);
        double totalPrice = apronTotalPrice + flourTotalPrice + eggsTotalPrice;

        if (totalPrice <= budget) {
            System.out.printf("Items purchased for %.2f$.%n", totalPrice);
        } else {
            System.out.printf("%.2f$ more needed.%n", totalPrice - budget);
        }
    }
}
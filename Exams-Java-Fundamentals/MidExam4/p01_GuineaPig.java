package MidExam4;

import java.util.Scanner;

public class p01_GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double foodQuantity = Double.parseDouble(scanner.nextLine());
        double foodQuantityInGrams = foodQuantity * 1000;
        double hayQuantity = Double.parseDouble(scanner.nextLine());
        double hayQuantityInGrams = hayQuantity * 1000;
        double coverQuantity = Double.parseDouble(scanner.nextLine());
        double coverQuantityInGrams = coverQuantity * 1000;
        double guineaWeight = Double.parseDouble(scanner.nextLine());
        double guineaWeightInGrams = guineaWeight * 1000;

        int days = 1;
        while (days <= 30) {
            if (foodQuantityInGrams > 0) {
                foodQuantityInGrams -= 300;
            } else {
                break;
            }

            if (days % 2 == 0) {
                if (hayQuantityInGrams > 0) {
                    hayQuantityInGrams -= foodQuantityInGrams * 0.05;
                } else {
                    break;
                }
            }

            if (days % 3 == 0) {
                if (coverQuantityInGrams > 0) {
                    coverQuantityInGrams -= guineaWeightInGrams * (1 / 3.00);
                } else {
                    break;
                }
            }
            days++;
        }

        if (foodQuantityInGrams <= 0 || hayQuantityInGrams <= 0 || coverQuantityInGrams <= 0) {
            System.out.println("Merry must go to the pet store!");
        } else {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.%n",
                    foodQuantityInGrams / 1000, hayQuantityInGrams / 1000, coverQuantityInGrams / 1000);
        }
    }
}
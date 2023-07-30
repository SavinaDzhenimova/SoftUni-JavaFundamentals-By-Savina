package AdditionalMidExamExercises;

import java.util.Scanner;

public class p01_SantaCookies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int amountOfBatches = Integer.parseInt(scanner.nextLine());
        int totalBoxesOfCookies = 0;

        for (int i = 0; i < amountOfBatches; i++) {
            int amountOfFloorInGrams = Integer.parseInt(scanner.nextLine());
            int amountOfSugarInGrams = Integer.parseInt(scanner.nextLine());
            int amountOfCocoaInGrams = Integer.parseInt(scanner.nextLine());

            int floorCups = amountOfFloorInGrams / 140;
            int sugarSpoons = amountOfSugarInGrams / 20;
            int cocoaSpoons = amountOfCocoaInGrams / 10;

            if (floorCups <= 0 || sugarSpoons <= 0 || cocoaSpoons <= 0) {
                System.out.println("Ingredients are not enough for a box of cookies.");
            } else {
                double totalCookiesPerBake = Math.floor((170 * Math.min(floorCups, Math.min(sugarSpoons, cocoaSpoons)) * 1.00) / 25);
                double boxesOfCookies = Math.floor(totalCookiesPerBake / 5);
                totalBoxesOfCookies += boxesOfCookies;

                System.out.printf("Boxes of cookies: %.0f%n", boxesOfCookies);
            }
        }

        System.out.printf("Total boxes: %.0f%n", Math.floor(totalBoxesOfCookies));
    }
}
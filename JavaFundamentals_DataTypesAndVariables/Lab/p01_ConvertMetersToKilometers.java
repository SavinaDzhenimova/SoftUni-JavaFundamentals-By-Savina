package Lab;

import java.util.Scanner;

public class p01_ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double meters = Double.parseDouble(scanner.nextLine());
        double kilometers = meters / 1000;
        System.out.printf("%.2f", kilometers);
    }
}
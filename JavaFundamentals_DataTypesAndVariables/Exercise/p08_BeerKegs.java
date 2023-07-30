package Exercise;

import java.util.Scanner;

public class p08_BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double biggestVolume = 0;
        String biggest = "";

        for (int i = 0; i < n; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            double volume = Math.PI * (radius * radius) * height;

            if (volume >= biggestVolume) {
                biggestVolume = volume;
                biggest = model;
            }
        }

        System.out.println(biggest);
    }
}
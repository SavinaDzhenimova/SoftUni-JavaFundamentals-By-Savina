package Exercise;

import java.util.Scanner;

public class p07_WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int tankCapacity = 255;
        int litersInTank = 0;

        for (int i = 0; i < n; i++) {
            int waterQuantity = Integer.parseInt(scanner.nextLine());

            if (tankCapacity >= waterQuantity) {
                tankCapacity -= waterQuantity;
                litersInTank += waterQuantity;
            } else {
                System.out.println("Insufficient capacity!");
            }
        }

        System.out.println(litersInTank);
    }
}
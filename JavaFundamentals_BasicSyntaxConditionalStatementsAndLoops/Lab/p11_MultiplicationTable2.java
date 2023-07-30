package Lab;

import java.util.Scanner;

public class p11_MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int multiplier = Integer.parseInt(scanner.nextLine());
        int product = 0;

        if (multiplier > 10) {
            product = num * multiplier;
            System.out.printf("%d X %d = %d%n", num, multiplier, product);
        } else {
            for (int i = multiplier; i <= 10; i++) {
                product = num * i;
                System.out.printf("%d X %d = %d%n", num, i, product);
            }
        }
    }
}
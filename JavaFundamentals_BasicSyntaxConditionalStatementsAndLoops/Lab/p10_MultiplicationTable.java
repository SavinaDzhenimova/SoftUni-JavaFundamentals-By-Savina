package Lab;

import java.util.Scanner;

public class p10_MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= 10; i++) {
            int product = num * i;
            System.out.printf("%d X %d = %d%n", num, i, product);
        }
    }
}
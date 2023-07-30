package Lab;

import java.util.Scanner;

public class p12_EvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        while (num % 2 != 0) {
            System.out.println("Please write an even number.");
            num = Integer.parseInt(scanner.nextLine());
        }

        System.out.printf("The number is: %d%n", Math.abs(num));
    }
}
package Exercise;

import java.util.Scanner;

public class p04_SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sumOfChars = 0;

        for (int i = 1; i <= n; i++) {
            char symbol = scanner.nextLine().charAt(0);
            sumOfChars += symbol;
        }

        System.out.printf("The sum equals: %d%n", sumOfChars);
    }
}
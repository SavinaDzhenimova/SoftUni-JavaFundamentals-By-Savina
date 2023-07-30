package MoreExercise;

import java.util.Scanner;

public class p04_RefactoringPrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbers = Integer.parseInt(scanner.nextLine());

        for (int i = 2; i <= numbers; i++) {
            boolean isPrime = true;
            for (int divisor = 2; divisor < i; divisor++) {
                if (i % divisor == 0) {
                    isPrime = false;
                    break; }
            }
            System.out.printf("%d -> %b%n", i, isPrime);
        }
    }
}
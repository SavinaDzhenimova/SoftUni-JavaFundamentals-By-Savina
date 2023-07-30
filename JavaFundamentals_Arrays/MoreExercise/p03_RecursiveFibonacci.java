package MoreExercise;

import java.util.Scanner;

public class p03_RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(FibonacciRecursion(n));
    }

    static long FibonacciRecursion(int n) {
        if (n <= 2) {
            return 1;
        }
        return FibonacciRecursion(n - 1) + FibonacciRecursion(n - 2);
    }
}
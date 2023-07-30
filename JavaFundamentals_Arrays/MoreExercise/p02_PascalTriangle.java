package MoreExercise;

import java.util.Scanner;

public class p02_PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = Integer.parseInt(scanner.nextLine());

        for (long line = 1; line <= n; line++) {
            long C = 1;
            for(long i = 1; i <= line; i++) {
                System.out.print(C + " ");
                C = C * (line - i) / i;
            }
            System.out.println();
        }
    }
}
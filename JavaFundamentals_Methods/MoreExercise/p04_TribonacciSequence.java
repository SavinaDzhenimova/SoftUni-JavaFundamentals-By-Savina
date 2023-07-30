package MoreExercise;

import java.util.Scanner;

public class p04_TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        printTribonacciSequence(num);
    }

    public static void printTribonacciSequence(int num) {
        int first = 1;
        int second = 1;
        int third = 2;

        if (num <= 3) {
            for (int i = 1; i <= num; i++) {
                System.out.printf("%d ", first);
                first = second;
                second = third;
            }
        } else {
            System.out.printf("%d %d %d ", first, second, third);
            for (int i = 4; i <= num; i++) {
                int fourth = first + second + third;
                System.out.printf("%d ", fourth);
                first = second;
                second = third;
                third = fourth;
            }
        }
    }
}
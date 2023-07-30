package MoreExercise;

import java.util.Scanner;

public class p02_FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            int digitSum = 0;

            long leftNumber = Long.parseLong(input[0]);
            long rightNumber = Long.parseLong(input[1]);

            if (leftNumber >= rightNumber) {
                for (int j = 0; j < input[0].length(); j++) {
                    digitSum += Math.abs(leftNumber % 10);
                    leftNumber = leftNumber / 10;
                }
            } else {
                for (int j = 0; j < input[1].length(); j++) {
                    digitSum += Math.abs(rightNumber % 10);
                    rightNumber = rightNumber / 10;
                }
            }
            System.out.println(digitSum);
        }
    }
}
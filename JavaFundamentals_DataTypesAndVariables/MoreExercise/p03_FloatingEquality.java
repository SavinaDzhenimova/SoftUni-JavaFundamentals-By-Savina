package MoreExercise;

import java.util.Scanner;

public class p03_FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1 = Double.parseDouble(scanner.nextLine());
        double num2 = Double.parseDouble(scanner.nextLine());
        double eps = 0.000001d;
        boolean isTrue = (Math.abs(num1 - num2) <= eps);
        if (isTrue) {
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }
}
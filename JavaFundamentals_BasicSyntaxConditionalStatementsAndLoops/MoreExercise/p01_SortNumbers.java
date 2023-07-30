package MoreExercise;

import java.util.Scanner;

public class p01_SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        if (firstNum > secondNum && firstNum > thirdNum){
            System.out.println(firstNum);
            if (secondNum > thirdNum) {
                System.out.println(secondNum);
                System.out.println(thirdNum);
            } else {
                System.out.println(thirdNum);
                System.out.println(secondNum);
            }
        } else if (secondNum > firstNum && secondNum > thirdNum) {
            System.out.println(secondNum);
            if (firstNum > thirdNum) {
                System.out.println(firstNum);
                System.out.println(thirdNum);
            } else {
                System.out.println(thirdNum);
                System.out.println(firstNum);
            }
        } else if (thirdNum > firstNum && thirdNum > secondNum) {
            System.out.println(thirdNum);
            if (firstNum > secondNum) {
                System.out.println(firstNum);
                System.out.println(secondNum);
            } else {
                System.out.println(secondNum);
                System.out.println(firstNum);
            }
        }
    }
}
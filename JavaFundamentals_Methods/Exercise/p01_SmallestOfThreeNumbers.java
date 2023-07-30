package Exercise;

import java.util.Scanner;

public class p01_SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        printTheSmallestNumber(firstNum, secondNum, thirdNum);
    }

    public static void printTheSmallestNumber(int first, int second, int third) {
        int smallerNumber = Math.min(first, second);
        int smallestNumber = Math.min(smallerNumber, third);
        System.out.println(smallestNumber);
    }
}
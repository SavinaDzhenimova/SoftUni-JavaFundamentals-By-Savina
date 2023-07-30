package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class p03_SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int evenSum = 0;
        for (int currentNum : numbersArr) {
            if (currentNum % 2 == 0) {
                evenSum += currentNum;
            }
        }

        System.out.println(evenSum);
    }
}
package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class p10_MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Math.abs(Integer.parseInt(scanner.nextLine()));

        System.out.println(getMultipleOfEvensAndOdds(number));
    }

    public static int getMultipleOfEvensAndOdds(int num) {
        int evenSum = getEvenSum(num);
        int oddSum = getOddSum(num);

        return evenSum * oddSum;
    }

    public static int getEvenSum(int num) {
        String intToString = Integer.toString(num);
        int[] arr = Arrays.stream(intToString.split("")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        for (int n : arr) {
            if (n % 2 == 0) {
                sum += n;
            }
        }

        return sum;
    }

    public static int getOddSum(int num) {
        String intToString = Integer.toString(num);
        int[] arr = Arrays.stream(intToString.split("")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        for (int n : arr) {
            if (n % 2 != 0) {
                sum += n;
            }
        }

        return sum;
    }
}
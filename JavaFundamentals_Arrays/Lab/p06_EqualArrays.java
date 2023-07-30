package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class p06_EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        int diffIndex = -1;
        for (int i = 0; i < firstArr.length; i++) {
            int firstElement = firstArr[i];
            int secondElement = secondArr[i];

            if (firstElement == secondElement) {
                sum += firstElement;
            } else {
                diffIndex = i;
                break;
            }
        }

        if (diffIndex == -1) {
            System.out.printf("Arrays are identical. Sum: %d%n", sum);
        } else {
            System.out.printf("Arrays are not identical. Found difference at %d index.%n", diffIndex);
        }
    }
}
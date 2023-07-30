package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class p06_EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int index = 0;
        boolean flag = false;
        for (int i = 0; i < numbersArr.length; i++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int j = 0; j < i; j++) {
                leftSum += numbersArr[j];
            }

            for (int k = i + 1; k < numbersArr.length; k++) {
                rightSum += numbersArr[k];
            }

            if (leftSum == rightSum) {
                flag = true;
                index = i;
                break;
            }
        }

        if (flag) {
            System.out.println(index);
        } else {
            System.out.println("no");
        }
    }
}
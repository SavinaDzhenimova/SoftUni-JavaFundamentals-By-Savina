package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class p05_TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < numbersArr.length; i++) {
            int currentNum = numbersArr[i];
            boolean isTopInteger = true;

            for (int j = i + 1; j < numbersArr.length; j++) {
                int comparingElement = numbersArr[j];
                if (currentNum <= comparingElement) {
                    isTopInteger = false;
                    break;
                }
            }

            if (isTopInteger) {
                System.out.print(currentNum + " ");
            }
        }
    }
}
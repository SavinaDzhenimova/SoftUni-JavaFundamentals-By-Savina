package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class p07_MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int number = 0;
        int repeats = 1;
        int maxRepeats = 0;
        for (int i = 0; i < numbersArr.length; i++) {
            if (i == numbersArr.length - 1) {
                break;
            }

            int currentNum = numbersArr[i];
            int nextNum = numbersArr[i + 1];

            if (currentNum == nextNum) {
                repeats++;
            } else {
                repeats = 1;
            }

            if (repeats > maxRepeats) {
                maxRepeats = repeats;
                number = currentNum;
            }
        }

        for (int i = 0; i < maxRepeats; i++) {
            System.out.print(number + " ");
        }
    }
}
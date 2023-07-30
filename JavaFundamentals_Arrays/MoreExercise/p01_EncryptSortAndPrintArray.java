package MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class p01_EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] inputArr = new String[n];
        int[] sumArr = new int[inputArr.length];

        for (int i = 0; i < n; i++) {
            inputArr[i] = scanner.nextLine();
            int sum = 0;

            for (int j = 0; j < inputArr[i].length(); j++) {
                char symbol = inputArr[i].charAt(j);

                if (symbol == 'a' || symbol == 'o' || symbol == 'e' || symbol == 'i' || symbol == 'u' ||
                        symbol == 'A' || symbol == 'O' || symbol == 'E' || symbol == 'I' || symbol == 'U') {
                    sum += (symbol * inputArr[i].length());
                } else {
                    sum += (symbol / inputArr[i].length());
                }
            }
            sumArr[i] = sum;
        }

        Arrays.sort(sumArr);
        for (int item : sumArr) {
            System.out.println(item);
        }
    }
}
package Exercise;

import java.util.Scanner;

public class p03_ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] firstArr = new int[n];
        int[] secondArr = new int[n];

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            int firstNum = Integer.parseInt(input[0]);
            int secondNum = Integer.parseInt(input[1]);

            if (i % 2 == 0) {
                firstArr[i] = firstNum;
                secondArr[i] = secondNum;
            } else {
                firstArr[i] = secondNum;
                secondArr[i] = firstNum;
            }
        }

        for (int element : firstArr) {
            System.out.print(element + " ");
        }
        System.out.println();
        for (int element : secondArr) {
            System.out.print(element + " ");
        }
    }
}
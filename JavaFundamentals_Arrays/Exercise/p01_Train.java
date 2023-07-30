package Exercise;

import java.util.Scanner;

public class p01_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] numbersArr = new int[n];
        int sum = 0;

        for (int i = 0; i < numbersArr.length; i++) {
            numbersArr[i] = Integer.parseInt(scanner.nextLine());
            sum += numbersArr[i];
        }

        for (int element : numbersArr) {
            System.out.print(element + " ");
        }
        System.out.printf("%n%d", sum);
    }
}
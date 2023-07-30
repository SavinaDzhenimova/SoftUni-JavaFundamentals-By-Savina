package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class p04_ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(scanner.nextLine());
        if (n >= numbersArr.length) {
            n -= numbersArr.length;
        }

        for (int i = n; i < numbersArr.length; i++) {
            System.out.print(numbersArr[i] + " ");
        }

        for (int i = 0; i < n; i++) {
            System.out.print(numbersArr[i] + " ");
        }
    }
}
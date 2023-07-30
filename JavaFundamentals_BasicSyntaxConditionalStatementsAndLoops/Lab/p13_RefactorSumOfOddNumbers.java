package Lab;

import java.util.Scanner;

public class p13_RefactorSumOfOddNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = Integer.parseInt(sc.nextLine());
        int sum = 0;

        for (int i = 1; i <= num * 2; i += 2) {
            sum += i;
            System.out.println(i);
        }

        System.out.printf("Sum: %d%n", sum);
    }
}
package Exercise;

import java.util.Scanner;

public class p05_AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        int sum = addNumbers(firstNum, secondNum);
        System.out.println(subtractNumbers(sum, thirdNum));
    }

    public static int addNumbers(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }

    public static int subtractNumbers(int sum, int thirdNum) {
        return sum - thirdNum;
    }
}
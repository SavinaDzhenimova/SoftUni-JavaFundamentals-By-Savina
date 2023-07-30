package Lab;

import java.util.Scanner;

public class p04_Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        switch (command) {
            case "add":
                System.out.println(addition(firstNum, secondNum));
                break;
            case "multiply":
                System.out.println(multiplication(firstNum, secondNum));
                break;
            case "subtract":
                System.out.println(subtraction(firstNum, secondNum));
                break;
            case "divide":
                System.out.println(division(firstNum, secondNum));
                break;
        }
    }

    public static int addition(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }

    public static int subtraction(int firstNum, int secondNum) {
        return firstNum - secondNum;
    }

    public static int multiplication(int firstNum, int secondNum) {
        return firstNum * secondNum;
    }

    public static int division(int firstNum, int secondNum) {
        return firstNum / secondNum;
    }
}
package Lab;

import java.util.Scanner;

public class p09_GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dataType = scanner.nextLine();

        switch (dataType) {
            case "int":
                int firstNum = Integer.parseInt(scanner.nextLine());
                int secondNum = Integer.parseInt(scanner.nextLine());

                System.out.println(getMax(firstNum, secondNum));
                break;
            case "char":
                char firstChar = scanner.nextLine().charAt(0);
                char secondChar = scanner.nextLine().charAt(0);

                System.out.println(getMax(firstChar, secondChar));
                break;
            case "string":
                String firstString = scanner.nextLine();
                String secondString = scanner.nextLine();

                System.out.println(getMax(firstString, secondString));
            }
        }

    public static int getMax(int firstNum, int secondNum) {
        return Math.max(firstNum, secondNum);
    }

    public static char getMax(char firstChar, char secondChar) {
        if (firstChar > secondChar) {
            return firstChar;
        } else {
            return secondChar;
        }
    }

    public static String getMax(String firstString, String secondString) {
        if (firstString.compareTo(secondString) >= 1) {
            return firstString;
        } else {
            return secondString;
        }
    }
}
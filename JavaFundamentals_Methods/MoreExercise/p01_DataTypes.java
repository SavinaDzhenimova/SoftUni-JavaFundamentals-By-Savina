package MoreExercise;

import java.util.Scanner;

public class p01_DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dataType = scanner.nextLine();
        String data = scanner.nextLine();

        switch (dataType) {
            case "int":
                int number = Integer.parseInt(data);
                System.out.println(printDataType(number));
                break;
            case "real":
                double num = Double.parseDouble(data);
                System.out.printf("%.2f%n", printDataType(num));
                break;
            case "string":
                System.out.println(printDataType(data));
                break;
        }
    }

    public static int printDataType(int number) {
        return number * 2;
    }

    public static double printDataType(double number) {
        return number * 1.5;
    }

    public static String printDataType(String text) {
        return "$" + text + "$";
    }
}
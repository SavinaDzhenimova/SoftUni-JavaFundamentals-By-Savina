package Lab;

import java.util.Scanner;

public class p06_CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());

        int rectangleArea = rectangleArea(width, length);
        System.out.println(rectangleArea);
    }

    public static int rectangleArea(int width, int length) {
        return width * length;
    }
}
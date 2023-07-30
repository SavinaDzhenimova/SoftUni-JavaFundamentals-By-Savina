package MoreExercise;

import java.util.Scanner;

public class p03_LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());

        int x3 = Integer.parseInt(scanner.nextLine());
        int y3 = Integer.parseInt(scanner.nextLine());
        int x4 = Integer.parseInt(scanner.nextLine());
        int y4 = Integer.parseInt(scanner.nextLine());

        printLongerLine(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    public static void printCloserPoint(int a, int b, int c, int d) {
        double first = Math.sqrt(Math.pow(Math.abs(a), 2) + Math.pow(Math.abs(b), 2));
        double second = Math.sqrt(Math.pow(Math.abs(c), 2) + Math.pow(Math.abs(d), 2));

        if (first > second) {
            System.out.printf("(%d, %d)(%d, %d)", c, d, a, b);
        } else {
            System.out.printf("(%d, %d)(%d, %d)", a, b, c, d);
        }
    }

    public static void printLongerLine(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        double firstLine = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
        double secondLine = Math.sqrt(Math.pow((x3 - x4), 2) + Math.pow((y3 - y4), 2));

        if (firstLine >= secondLine) {
            printCloserPoint(x1, y1, x2, y2);
        } else {
            printCloserPoint(x3, y3, x4, y4);
        }
    }
}

package Exercise;

import java.util.Scanner;

public class p05_PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startChar = Integer.parseInt(scanner.nextLine());
        int endChar = Integer.parseInt(scanner.nextLine());

        for (int i = startChar; i <= endChar; i++) {
            System.out.printf("%c ", i);
        }
    }
}
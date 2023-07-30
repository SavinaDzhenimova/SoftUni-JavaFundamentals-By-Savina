package Exercise;

import java.util.Scanner;

public class p03_CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char startChar = scanner.nextLine().charAt(0);
        char endChar = scanner.nextLine().charAt(0);

        printCharactersInRange(startChar, endChar);
    }

    public static void printCharactersInRange(char start, char end) {
        if (end > start) {
            for (int i = start + 1; i < end; i++) {
                System.out.printf("%c ", i);
            }
        } else {
            for (int i = end + 1; i < start; i++) {
                System.out.printf("%c ", i);
            }
        }
    }
}
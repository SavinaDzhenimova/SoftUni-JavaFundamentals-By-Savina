package Exercise;

import java.util.Scanner;

public class p06_MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        printMiddleCharacters(text);
    }

    public static void printMiddleCharacters(String text) {
        if (text.length() % 2 != 0) {
            System.out.println(text.charAt(text.length() / 2));
        } else {
            System.out.println(text.charAt(text.length() / 2 - 1) + "" + text.charAt(text.length() / 2));
        }
    }
}
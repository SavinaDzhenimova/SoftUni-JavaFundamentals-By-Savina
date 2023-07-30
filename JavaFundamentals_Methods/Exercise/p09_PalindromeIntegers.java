package Exercise;

import java.util.Scanner;

public class p09_PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            System.out.printf("%s%n", isPalindrome(input));

            input = scanner.nextLine();
        }
    }

    public static boolean isPalindrome(String n) {
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < n.length(); i++) {
            number.append(n.charAt(i));
        }

        StringBuilder reversed = new StringBuilder();
        for (int i = n.length() - 1; i >= 0; i--) {
            reversed.append(n.charAt(i));
        }

        if (number.compareTo(reversed) == 0) {
            return true;
        } else {
            return false;
        }
    }
}
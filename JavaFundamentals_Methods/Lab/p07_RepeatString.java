package Lab;

import java.util.Scanner;

public class p07_RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int repeats = Integer.parseInt(scanner.nextLine());

        System.out.println(repeatedString(input, repeats));
    }

    public static StringBuilder repeatedString(String text, int repeats) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < repeats; i++) {
            result.append(text);
        }
        return result;
    }
}
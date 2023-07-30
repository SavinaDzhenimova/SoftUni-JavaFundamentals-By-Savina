package Exercise;

import java.util.Scanner;

public class p02_VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        System.out.println(printCountOfVowels(text));
    }

    public static int printCountOfVowels(String text) {
        int vowelsCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (symbol == 'a' || symbol == 'o' || symbol == 'i' || symbol == 'e' || symbol == 'u' ||
            symbol == 'A' || symbol == 'O' || symbol == 'I' || symbol == 'E' || symbol == 'U') {
                vowelsCount++;
            }
        }

        return vowelsCount;
    }
}
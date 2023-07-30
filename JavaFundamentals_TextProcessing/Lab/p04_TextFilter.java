package Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p04_TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> bannedWords = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String text = scanner.nextLine();

        for (String bannedWord : bannedWords) {
            String asterisk = repeatAsterisks(bannedWord);
            text = text.replaceAll(bannedWord, asterisk);
        }

        System.out.println(text);
    }

    public static String repeatAsterisks (String word) {
        return "*".repeat(word.length());
    }
}
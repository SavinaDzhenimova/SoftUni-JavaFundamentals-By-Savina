package Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p02_RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> wordsList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        StringBuilder result = new StringBuilder();

        for (String currentWord : wordsList) {
            result.append(repeatWord(currentWord));
        }

        System.out.println(result);
    }

    public static StringBuilder repeatWord (String word) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            result.append(word);
        }
        return result;
    }
}
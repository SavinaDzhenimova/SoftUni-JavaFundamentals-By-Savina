package Exercise;

import java.util.Scanner;

public class p02_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        String firstWord = words[0];
        String secondWord = words[1];

        int length = Math.min(firstWord.length(), secondWord.length());
        int sum = 0;
        for (int i = 0; i < length; i++) {
            char firstChar = firstWord.charAt(i);
            char secondChar = secondWord.charAt(i);

            sum += firstChar * secondChar;
        }

        if (firstWord.length() > secondWord.length()) {
            for (int i = length; i < firstWord.length(); i++) {
                sum += firstWord.charAt(i);
            }
        } else {
            for (int i = length; i < secondWord.length(); i++) {
                sum += secondWord.charAt(i);
            }
        }

        System.out.println(sum);
    }
}
package FinalExam5;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p02_EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        BigInteger coolThreshold = new BigInteger("1");
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (Character.isDigit(currentChar)) {
                BigInteger number = new BigInteger(String.valueOf(currentChar));
                coolThreshold = coolThreshold.multiply(number);
            }
        }
        System.out.println("Cool threshold: " + coolThreshold);

        String regex = "(::|\\*\\*)(?<emoji>[A-Z][a-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        int counter = 0;
        List<String> coolEmojisList = new ArrayList<>();
        while (matcher.find()) {
            counter++;
            String fullEmoji = matcher.group();
            String emoji = matcher.group("emoji");
            BigInteger coolness = new BigInteger("0");

            for (int i = 0; i < emoji.length(); i++) {
                char currentChar = emoji.charAt(i);

                coolness = coolness.add(BigInteger.valueOf(currentChar));
            }

            int result = coolness.compareTo(coolThreshold);
            if (result == 1) {
                coolEmojisList.add(fullEmoji);
            }
        }

        System.out.printf("%d emojis found in the text. The cool ones are:%n", counter);
        for (String emoji : coolEmojisList) {
            System.out.println(emoji);
        }
    }
}
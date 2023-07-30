package FinalExam3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p02_MirrorWords {
    public static class MirrorWords{
        String word1;
        String word2;

        public MirrorWords(String word1, String word2) {
            this.word1 = word1;
            this.word2 = word2;
        }

        public String getWord1() {
            return this.word1;
        }

        public String getWord2() {
            return this.word2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "([@|#])(?<word1>[A-Za-z]{3,})\\1\\1(?<word2>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> foundWordsList = new ArrayList<>();

        while (matcher.find()) {
            String word1 = matcher.group("word1");
            String word2 = matcher.group("word2");
            foundWordsList.add(word1);
            foundWordsList.add(word2);
        }

        if (foundWordsList.isEmpty()) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", foundWordsList.size() / 2);
        }

        List<MirrorWords> mirrorWordsList = new ArrayList<>();
        while (!foundWordsList.isEmpty()) {
            String word1 = foundWordsList.get(0);
            String word2 = foundWordsList.get(1);

            StringBuilder word2Reversed = new StringBuilder(word2);
            word2Reversed.reverse();

            if (word1.equals(String.valueOf(word2Reversed))) {
                MirrorWords mirrorWords = new MirrorWords(word1, word2);
                mirrorWordsList.add(mirrorWords);
            }

            foundWordsList.remove(0);
            foundWordsList.remove(0);
        }

        if (mirrorWordsList.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            for (int i = 0; i < mirrorWordsList.size(); i++) {
                System.out.printf("%s <=> %s", mirrorWordsList.get(i).getWord1(), mirrorWordsList.get(i).getWord2());
                if (i != mirrorWordsList.size() - 1) {
                    System.out.print(", ");
                }
            }
        }
    }
}
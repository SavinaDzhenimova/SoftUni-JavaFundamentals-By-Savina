package MoreExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p02_RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "(\\D+)([0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            String symbols = matcher.group(1);
            int repeats = Integer.parseInt(matcher.group(2));

            result.append(symbols.toUpperCase().repeat(Math.max(0, repeats)));
        }

        List<Character> uniqueSymbols = new ArrayList<>();
        for (int i = 0; i < result.length(); i++) {
            char currentChar = result.charAt(i);

            if (!uniqueSymbols.contains(currentChar)) {
                uniqueSymbols.add(currentChar);
            }
        }

        System.out.printf("Unique symbols used: %d%n", uniqueSymbols.size());
        System.out.println(result);
    }
}
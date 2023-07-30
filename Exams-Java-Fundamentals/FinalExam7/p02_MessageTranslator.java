package FinalExam7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p02_MessageTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());
        String regex = "!(?<command>[A-Z][a-z]{2,})!:(\\[)(?<text>[A-Za-z]{8,})(\\])";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < numberOfLines; i++) {
            String input = scanner.nextLine();

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String command = matcher.group("command");
                String text = matcher.group("text");

                List<Integer> result = new ArrayList<>();
                for (int j = 0; j < text.length(); j++) {
                    int symbol = text.charAt(j);
                    result.add(symbol);
                }

                System.out.print(command + ": ");
                System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
            } else {
                System.out.println("The message is invalid");
            }
        }
    }
}
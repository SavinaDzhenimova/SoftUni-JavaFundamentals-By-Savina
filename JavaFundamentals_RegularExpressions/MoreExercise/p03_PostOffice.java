package MoreExercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p03_PostOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex1 = "([#$%*&])(?<code>[A-Z]+)\\1";
        String regex2 = "(?<letter>[0-9]{2}):(?<length>[0-9]{2})";

        String[] inputArr = scanner.nextLine().split("\\|");
        String firstPart = inputArr[0];
        String secondPart = inputArr[1];
        String thirdPart = inputArr[2];

        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(firstPart);

        List<String> matcher2List = new ArrayList<>();

        if (matcher1.find()) {
            String code = matcher1.group("code");

            Pattern pattern2 = Pattern.compile(regex2);
            Matcher matcher2 = pattern2.matcher(secondPart);

            while (matcher2.find()) {
                matcher2List.add(matcher2.group());
            }

            for (char symbol : code.toCharArray()) {
                boolean isFound = false;

                for (String matcher : matcher2List) {
                    int codeOfLetter = Integer.parseInt(matcher.split(":")[0]);
                    int length = Integer.parseInt(matcher.split(":")[1]) + 1;

                    for (String word : thirdPart.split("\\s+")) {
                        String firstLetter = word.substring(0, 1);

                        if (firstLetter.equals(symbol + "")) {
                            if (symbol == codeOfLetter && word.length() == length) {
                                System.out.println(word);
                                isFound = true;
                            }
                        }
                        if (isFound) {
                            break;
                        }
                    }
                    if (isFound) {
                        break;
                    }
                }
            }
        }
    }
}
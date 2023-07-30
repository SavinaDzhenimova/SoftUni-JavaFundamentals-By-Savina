package MoreExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p03_TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputText = scanner.nextLine();
        List<Integer> numbersList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < inputText.length(); i++) {
            char currentChar = inputText.charAt(i);

            if (currentChar >= 48 && currentChar <= 57) {
                numbersList.add(Integer.parseInt(String.valueOf(currentChar)));
            } else {
                stringList.add(String.valueOf(currentChar));
            }
        }

        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();
        for (int i = 0; i < numbersList.size(); i++) {
            int currentDigit = numbersList.get(i);

            if (i % 2 == 0) {
                takeList.add(currentDigit);
            } else {
                skipList.add(currentDigit);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < takeList.size(); i++) {
            int takeIndexes = takeList.get(0);
            int skipIndexes = skipList.get(0);

            for (int j = 0; j < takeIndexes; j++) {
                if (stringList.isEmpty()) {
                    break;
                }
                result.append(stringList.get(0));
                stringList.remove(0);
            }
            takeList.remove(0);

            for (int j = 0; j < skipIndexes; j++) {
                if (stringList.isEmpty()) {
                    break;
                }
                stringList.remove(0);
            }
            skipList.remove(0);
            i = -1;
        }

        System.out.println(result);
    }
}
package MoreExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p01_Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbersList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        StringBuilder text = new StringBuilder(scanner.nextLine());
        StringBuilder result = new StringBuilder();

        for (String currentNumber : numbersList) {
            int sumOfDigits = 0;

            for (int j = 0; j < currentNumber.length(); j++) {
                int currentDigit = Integer.parseInt(String.valueOf(currentNumber.charAt(j)));
                sumOfDigits += currentDigit;
            }

            if (text.length() > sumOfDigits) {
                char letter = text.charAt(sumOfDigits);
                result.append(letter);
                text.deleteCharAt(sumOfDigits);
            } else {
                char letter = text.charAt(sumOfDigits - text.length());
                result.append(letter);
                text.deleteCharAt(sumOfDigits - text.length());
            }
        }

        System.out.println(result);
    }
}
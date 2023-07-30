package Exercise;

import java.util.Scanner;

public class p08_LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split("\\s+");

        double totalSum = 0;
        for (String currentText : text) {
            double sum = getModifiedNumber(currentText);
            totalSum += sum;
        }

        System.out.printf("%.2f", totalSum);
    }

    public static double getModifiedNumber(String text) {
        char letterBefore = text.charAt(0);
        char letterAfter = text.charAt(text.length() - 1);
        double number = Double.parseDouble(text.replace(letterBefore, ' ').replace(letterAfter, ' ').trim());

        if (Character.isUpperCase(letterBefore)) {
            int positionUpperLetter = (int) letterBefore - 64;
            number /= positionUpperLetter;
        } else  {
            int positionLowerLetter = (int)letterBefore - 96;
            number *= positionLowerLetter;
        }

        if (Character.isUpperCase(letterAfter)) {
            int positionUpperLetter = (int) letterAfter - 64;
            number -= positionUpperLetter;
        } else {
            int positionLowerLetter = (int) letterAfter - 96;
            number += positionLowerLetter;
        }

        return number;
    }
}
package MoreExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p02_CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());
        double leftSum = 0;
        double rightSum = 0;

        int finishLine = numbersList.size() / 2;
        for (int i = 0; i < finishLine; i++) {
            int leftTime = numbersList.get(i);
            leftSum += leftTime;

            if (leftTime == 0) {
                leftSum *= 0.80;
            }
        }

        for (int i = numbersList.size() - 1; i >= numbersList.size() - finishLine; i--) {
            int rightTime = numbersList.get(i);
            rightSum += rightTime;

            if (rightTime == 0) {
                rightSum *= 0.80;
            }
        }

        if (leftSum < rightSum) {
            System.out.printf("The winner is left with total time: %.1f%n", leftSum);
        } else {
            System.out.printf("The winner is right with total time: %.1f%n", rightSum);
        }
    }
}
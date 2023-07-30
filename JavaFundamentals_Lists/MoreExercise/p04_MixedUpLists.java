package MoreExercise;

import java.util.*;
import java.util.stream.Collectors;

public class p04_MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> resultList = new ArrayList<>();

        while (!firstList.isEmpty() && !secondList.isEmpty()) {
            resultList.add(firstList.get(0));
            firstList.remove(0);
            resultList.add(secondList.get(secondList.size() - 1));
            secondList.remove(secondList.size() - 1);
        }

        int min = 0;
        int max = 0;
        if (!firstList.isEmpty()) {
            min = Math.min(firstList.get(0), firstList.get(1));
            max = Math.max(firstList.get(0), firstList.get(1));
        } else {
            min = Math.min(secondList.get(0), secondList.get(1));
            max = Math.max(secondList.get(0), secondList.get(1));
        }

        List<Integer> outputList = new ArrayList<>();
        for (Integer number : resultList) {
            if (number > min && number < max) {
                outputList.add(number);
            }
        }

        Collections.sort(outputList);
        System.out.println(outputList.toString().replaceAll("[\\[\\],]", ""));
    }
}
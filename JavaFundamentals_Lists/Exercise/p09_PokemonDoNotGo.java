package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p09_PokemonDoNotGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());
        int sumOfRemovedNumbers = 0;

        while (!numbersList.isEmpty()) {
            int indexToRemove = Integer.parseInt(scanner.nextLine());
            int removedNumber = 0;

            if (indexToRemove < 0) {
                removedNumber = numbersList.get(0);
                numbersList.remove(0);
                numbersList.add(0, numbersList.get(numbersList.size() - 1));
            } else if (indexToRemove > numbersList.size() - 1) {
                removedNumber = numbersList.get(numbersList.size() - 1);
                numbersList.remove(numbersList.size() - 1);
                numbersList.add(numbersList.size(), numbersList.get(0));
            } else {
                removedNumber = numbersList.get(indexToRemove);
                numbersList.remove(indexToRemove);
            }

            for (int i = 0; i < numbersList.size(); i++) {
                int currentNumber = numbersList.get(i);

                if (currentNumber <= removedNumber) {
                    currentNumber += removedNumber;
                    numbersList.set(i, currentNumber);
                } else {
                    currentNumber -= removedNumber;
                    numbersList.set(i, currentNumber);
                }
            }
            sumOfRemovedNumbers += removedNumber;
        }

        System.out.println(sumOfRemovedNumbers);
    }
}
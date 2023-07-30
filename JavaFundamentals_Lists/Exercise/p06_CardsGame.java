package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p06_CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPlayerCards = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());

        while (!firstPlayerCards.isEmpty() && !secondPlayerCards.isEmpty()) {
            int firstPlayerCard = firstPlayerCards.get(0);
            int secondPlayerCard = secondPlayerCards.get(0);

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerCards.add(firstPlayerCard);
                firstPlayerCards.add(secondPlayerCard);
                firstPlayerCards.remove(0);
                secondPlayerCards.remove(0);
            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayerCards.add(secondPlayerCard);
                secondPlayerCards.add(firstPlayerCard);
                secondPlayerCards.remove(0);
                firstPlayerCards.remove(0);
            } else {
                firstPlayerCards.remove(0);
                secondPlayerCards.remove(0);
            }
        }

        int winnerCardsSum = 0;
        if (firstPlayerCards.isEmpty()) {
            for (int item : secondPlayerCards) {
                winnerCardsSum += item;
            }
            System.out.printf("Second player wins! Sum: %d%n", winnerCardsSum);
        } else if (secondPlayerCards.isEmpty()) {
            for (int item : firstPlayerCards) {
                winnerCardsSum += item;
            }
            System.out.printf("First player wins! Sum: %d%n", winnerCardsSum);
        }
    }
}
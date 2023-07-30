package MidExam8;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p03_DeckOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> deckOfCards = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] commands = scanner.nextLine().split(", ");

            switch (commands[0]) {
                case "Add":
                    String cardNameToAdd = commands[1];

                    if (deckOfCards.contains(cardNameToAdd)) {
                        System.out.println("Card is already in the deck");
                    } else {
                        deckOfCards.add(cardNameToAdd);
                        System.out.println("Card successfully added");
                    }
                    break;
                case "Remove":
                    String cardNameToRemove = commands[1];

                    if (deckOfCards.contains(cardNameToRemove)) {
                        deckOfCards.remove(cardNameToRemove);
                        System.out.println("Card successfully removed");
                    } else {
                        System.out.println("Card not found");
                    }
                    break;
                case "Remove At":
                    int indexToRemove = Integer.parseInt(commands[1]);

                    if (indexToRemove >= 0 && indexToRemove < deckOfCards.size()) {
                        deckOfCards.remove(indexToRemove);
                        System.out.println("Card successfully removed");
                    } else {
                        System.out.println("Index out of range");
                    }
                    break;
                case "Insert":
                    int indexToInsert = Integer.parseInt(commands[1]);
                    String cardNameToInsert = commands[2];

                    if (indexToInsert >= 0 && indexToInsert < deckOfCards.size()) {
                        if (deckOfCards.contains(cardNameToInsert)) {
                            System.out.println("Card is already added");
                        } else {
                            deckOfCards.add(indexToInsert, cardNameToInsert);
                            System.out.println("Card successfully added");
                        }
                    } else {
                        System.out.println("Index out of range");
                    }
                    break;
            }
        }

        System.out.println(deckOfCards.toString().replaceAll("[\\[\\]]", ""));
    }
}
package Lab;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p02_WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfWords = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, ArrayList<String>> wordSynonymsMap = new LinkedHashMap<>();

        for (int i = 0; i < numberOfWords; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            if (!wordSynonymsMap.containsKey(word)) {
                wordSynonymsMap.put(word, new ArrayList<>());
            }
            wordSynonymsMap.get(word).add(synonym);
        }

        for (Map.Entry<String, ArrayList<String>> entry : wordSynonymsMap.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(),
                    entry.getValue().toString().replaceAll("[\\[\\]]", ""));
        }
    }
}
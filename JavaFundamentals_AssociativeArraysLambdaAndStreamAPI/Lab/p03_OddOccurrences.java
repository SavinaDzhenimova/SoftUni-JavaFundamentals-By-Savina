package Lab;

import java.util.*;
import java.util.stream.Collectors;

public class p03_OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> wordsList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        LinkedHashMap<String, Integer> oddOccurrencesMap = new LinkedHashMap<>();

        for (int i = 0; i < wordsList.size(); i++) {
            String currentWord = wordsList.get(i).toLowerCase();

            if (!oddOccurrencesMap.containsKey(currentWord)) {
                oddOccurrencesMap.put(currentWord, 0);
            }
            oddOccurrencesMap.put(currentWord, oddOccurrencesMap.get(currentWord) + 1);
        }

        ArrayList<String> resultList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : oddOccurrencesMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                resultList.add(entry.getKey());
            }
        }

        System.out.println(resultList.toString().replaceAll("[\\[\\]]", ""));
    }
}
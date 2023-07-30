package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p01_CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().replaceAll("\\s+", "");
        LinkedHashMap<Character, Integer> charsCountMap = new LinkedHashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char currentLetter = text.charAt(i);

            if (!charsCountMap.containsKey(currentLetter)) {
                charsCountMap.put(currentLetter, 0);
            }
            charsCountMap.put(currentLetter, charsCountMap.get(currentLetter) + 1);
        }

        for (Map.Entry<Character, Integer> entry : charsCountMap.entrySet()) {
            System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
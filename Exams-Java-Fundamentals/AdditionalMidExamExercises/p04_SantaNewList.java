package AdditionalMidExamExercises;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p04_SantaNewList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> childrenMap = new HashMap<>();
        Map<String, Integer> toysMap = new LinkedHashMap<>();
        while (!input.equals("END")) {
            String[] tokens = input.split("->");

            if (tokens.length == 2) {
                String nameToRemove = tokens[1];

                if (childrenMap.containsKey(nameToRemove)) {
                    childrenMap.remove(nameToRemove);
                }
            } else {
                String childName = tokens[0];
                String toy = tokens[1];
                int numberOfToys = Integer.parseInt(tokens[2]);

                if (!childrenMap.containsKey(childName)) {
                    childrenMap.put(childName, numberOfToys);
                } else {
                    childrenMap.put(childName, childrenMap.get(childName) + numberOfToys);
                }

                if (!toysMap.containsKey(toy)) {
                    toysMap.put(toy, numberOfToys);
                } else {
                    toysMap.put(toy, toysMap.get(toy) + numberOfToys);
                }
            }

            input = scanner.nextLine();
        }

        System.out.println("Children:");
        childrenMap.entrySet()
                        .stream()
                        .sorted((p1, p2) -> {
                            int result = p2.getValue().compareTo(p1.getValue());
                            if (result == 0) {
                                result = p1.getKey().compareTo(p2.getKey());
                            }
                            return result;
                        })
                .forEach(entry -> System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue()));

        System.out.println("Presents:");
        for (Map.Entry<String, Integer> entry : toysMap.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
package Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class p07_LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> legendaryItemsMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> junkItemsMap = new LinkedHashMap<>();
        boolean isFound = false;

        while (!isFound) {
            List<String> inputList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

            while (inputList.size() > 0) {
                int quantity = Integer.parseInt(inputList.get(0));
                String material = inputList.get(1).toLowerCase();

                inputList.remove(0);
                inputList.remove(0);

                if (material.equals("shards")) {
                    if (legendaryItemsMap.containsKey("shards")) {
                        legendaryItemsMap.put("shards", legendaryItemsMap.get("shards") + quantity);
                    }
                    legendaryItemsMap.putIfAbsent("shards", quantity);

                    if (legendaryItemsMap.get("shards") >= 250) {
                        System.out.println("Shadowmourne obtained!");
                        legendaryItemsMap.put("shards", legendaryItemsMap.get("shards") - 250);
                        isFound = true;
                        break;
                    }
                } else if (material.equals("fragments")) {
                    if (legendaryItemsMap.containsKey("fragments")) {
                        legendaryItemsMap.put("fragments", legendaryItemsMap.get("fragments") + quantity);
                    }
                    legendaryItemsMap.putIfAbsent("fragments", quantity);

                    if (legendaryItemsMap.get("fragments") >= 250) {
                        System.out.println("Valanyr obtained!");
                        legendaryItemsMap.put("fragments", legendaryItemsMap.get("fragments") - 250);
                        isFound = true;
                        break;
                    }
                } else if (material.equals("motes")) {
                    if (legendaryItemsMap.containsKey("motes")) {
                        legendaryItemsMap.put("motes", legendaryItemsMap.get("motes") + quantity);
                    }
                    legendaryItemsMap.putIfAbsent("motes", quantity);

                    if (legendaryItemsMap.get("motes") >= 250) {
                        System.out.println("Dragonwrath obtained!");
                        legendaryItemsMap.put("motes", legendaryItemsMap.get("motes") - 250);
                        isFound = true;
                        break;
                    }
                } else {
                    if (junkItemsMap.containsKey(material)) {
                        junkItemsMap.put(material, junkItemsMap.get(material) + quantity);
                    }
                    junkItemsMap.putIfAbsent(material, quantity);
                }
            }
        }

        if (legendaryItemsMap.get("shards") == null) legendaryItemsMap.put("shards", 0);
        System.out.printf("shards: %d%n", legendaryItemsMap.get("shards"));
        if (legendaryItemsMap.get("fragments") == null) legendaryItemsMap.put("fragments", 0);
        System.out.printf("fragments: %d%n", legendaryItemsMap.get("fragments"));
        if (legendaryItemsMap.get("motes") == null) legendaryItemsMap.put("motes", 0);
        System.out.printf("motes: %d%n", legendaryItemsMap.get("motes"));
        for (Map.Entry<String, Integer> entry : junkItemsMap.entrySet()) {
            if (junkItemsMap.get(entry.getKey()) == null) junkItemsMap.put(entry.getKey(), 0);
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }
}
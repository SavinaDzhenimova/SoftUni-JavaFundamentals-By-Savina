package MidExam5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p03_Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inventoryList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Craft!")) {
            String[] commands = input.split(" - ");

            switch (commands[0]) {
                case "Collect":
                    String itemToCollect = commands[1];

                    if (!inventoryList.contains(itemToCollect)) {
                        inventoryList.add(itemToCollect);
                    }
                    break;
                case "Drop":
                    String itemToDrop = commands[1];

                    if (inventoryList.contains(itemToDrop)) {
                        inventoryList.remove(itemToDrop);
                    }
                    break;
                case "Combine Items":
                    String[] items = commands[1].split(":");
                    String oldItem = items[0];
                    String newItem = items[1];

                    if (inventoryList.contains(oldItem)) {
                        inventoryList.add(inventoryList.indexOf(oldItem) + 1, newItem);
                    }
                    break;
                case "Renew":
                    String itemToRenew = commands[1];

                    if (inventoryList.contains(itemToRenew)) {
                        inventoryList.remove(itemToRenew);
                        inventoryList.add(itemToRenew);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(inventoryList.toString().replaceAll("[\\[\\]]", ""));
    }
}
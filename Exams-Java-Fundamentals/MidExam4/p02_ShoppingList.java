package MidExam4;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p02_ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> productsList = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Go Shopping!")) {
            String[] commands = input.split(" ");
            String item = commands[1];

            switch (commands[0]) {
                case "Urgent":
                    if (!productsList.contains(item)) {
                        productsList.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    if (productsList.contains(item)) {
                        productsList.remove(item);
                    }
                    break;
                case "Correct":
                    String oldItem = commands[1];
                    String newItem = commands[2];

                    if (productsList.contains(oldItem)) {
                        productsList.set(productsList.indexOf(oldItem), newItem);
                    }
                    break;
                case "Rearrange":
                    if (productsList.contains(item)) {
                        productsList.remove(item);
                        productsList.add(item);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(productsList.toString().replaceAll("[\\[\\]]", ""));
    }
}
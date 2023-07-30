package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p03_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        LinkedHashMap<String, Double> productAndPriceMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> productsAndQuantityMap = new LinkedHashMap<>();
        LinkedHashMap<String, Double> productsAndTotalPriceMap = new LinkedHashMap<>();

        while (!command.equals("buy")) {
            String[] productsData = command.split(" ");
            String productName = productsData[0];
            double productPrice = Double.parseDouble(productsData[1]);
            int productQuantity = Integer.parseInt(productsData[2]);

            if (!productAndPriceMap.containsKey(productName) && !productsAndQuantityMap.containsKey(productName)) {
                productAndPriceMap.put(productName, productPrice);
                productsAndQuantityMap.put(productName, productQuantity);
            } else {
                productAndPriceMap.put(productName, productPrice);
                productsAndQuantityMap.put(productName, productsAndQuantityMap.get(productName) + productQuantity);
            }

            double totalPrice = productAndPriceMap.get(productName) * productsAndQuantityMap.get(productName);
            productsAndTotalPriceMap.put(productName, totalPrice);

            command = scanner.nextLine();
        }

        for (Map.Entry<String, Double> entry : productsAndTotalPriceMap.entrySet()) {
            System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue());
        }
    }
}
package FinalExam1;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p02_AdAstra {
    public static class Product{
        String product;
        String expirationDate;
        int calories;

        public Product(String product, String expirationDate, int calories) {
            this.product = product;
            this.expirationDate = expirationDate;
            this.calories = calories;
        }

        public String getProduct() {
            return this.product;
        }

        public String getExpirationDate() {
            return this.expirationDate;
        }

        public int getCalories() {
            return this.calories;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "([|#])(?<product>[A-Za-z]+\\s?[A-Za-z]+)\\1(?<expirationDate>\\d{2}/\\d{2}/\\d{2})\\1(?<calories>\\d+)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        int totalCalories = 0;
        List<Product> productsList = new ArrayList<>();
        while (matcher.find()) {
            String product = matcher.group("product");
            String expirationDate = matcher.group("expirationDate");
            int calories = Integer.parseInt(matcher.group("calories"));
            totalCalories += calories;

            Product currentProduct = new Product(product, expirationDate, calories);
            productsList.add(currentProduct);
        }

        int days = totalCalories / 2000;
        System.out.printf("You have food to last you for: %d days!%n", days);

        for (Product currentProduct : productsList) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %d%n",
                    currentProduct.getProduct(), currentProduct.getExpirationDate(), currentProduct.getCalories());
        }
    }
}
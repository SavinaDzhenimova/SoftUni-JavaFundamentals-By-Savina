package Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p02_SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "\\%(?<name>[A-Z][a-z]+)\\%([^\\|\\$\\%\\.]*)\\<(?<product>\\w+)\\>([^\\|\\$\\%\\.]*)" +
                "\\|(?<count>\\d+)\\|([^\\|\\$\\%\\.]*?)(?<price>\\d+\\.?\\d+)\\$";

        double totalPrice = 0;
        while (!input.equals("end of shift")) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String name = matcher.group("name");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                totalPrice += count * price;

                System.out.printf("%s: %s - %.2f%n", name, product, count * price);
            }

            input = scanner.nextLine();
        }

        System.out.printf("Total income: %.2f%n", totalPrice);
    }
}
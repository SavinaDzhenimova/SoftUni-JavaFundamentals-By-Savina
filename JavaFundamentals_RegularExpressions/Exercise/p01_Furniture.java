package Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p01_Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = ">>(?<furniture>[A-Z]+[a-z]*)<<(?<price>\\d+\\.?\\d+)!(?<count>\\d+)";

        double totalPrice = 0;
        System.out.println("Bought furniture:");
        while (!input.equals("Purchase")) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String furniture = matcher.group("furniture");
                double price = Double.parseDouble(matcher.group("price"));
                int count = Integer.parseInt(matcher.group("count"));
                totalPrice += price * count;

                System.out.println(furniture);
            }

            input = scanner.nextLine();
        }

        System.out.printf("Total money spend: %.2f%n", totalPrice);
    }
}
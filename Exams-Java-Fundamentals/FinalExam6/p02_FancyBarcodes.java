package FinalExam6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p02_FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfBarcodes = Integer.parseInt(scanner.nextLine());
        String regex = "@#+(?<barcode>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+";
        Pattern pattern = Pattern.compile(regex);

        List<String> barcodesList = new ArrayList<>();
        for (int i = 0; i < numberOfBarcodes; i++) {
            String input = scanner.nextLine();
            barcodesList.add(input);
        }

        for (String currentBarcode : barcodesList) {
            Matcher matcher = pattern.matcher(currentBarcode);

            if (matcher.find()) {
                String barcode = matcher.group("barcode");
                StringBuilder group = new StringBuilder();

                for (int i = 0; i < barcode.length(); i++) {
                    char symbol = barcode.charAt(i);

                    if (Character.isDigit(symbol)) {
                        group.append(symbol);
                    }
                }

                if (group.length() == 0) {
                    group = new StringBuilder("00");
                }

                System.out.printf("Product group: %s%n", group);
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
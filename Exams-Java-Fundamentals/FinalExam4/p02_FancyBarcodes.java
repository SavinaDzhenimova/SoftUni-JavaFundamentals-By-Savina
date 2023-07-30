package FinalExam4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class p02_FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfBarcodes = Integer.parseInt(scanner.nextLine());
        String regex = "@#+(?<barcode>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < numberOfBarcodes; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            StringBuilder barcodeGroup = new StringBuilder();

            if (matcher.find()) {
                String barcode = matcher.group("barcode");

                for (int j = 0; j < barcode.length(); j++) {
                    char currentChar = barcode.charAt(j);

                    if (Character.isDigit(currentChar)) {
                        barcodeGroup.append(currentChar);
                    }
                }

                if (barcodeGroup.length() == 0) {
                    barcodeGroup = new StringBuilder("00");
                }

                System.out.printf("Product group: %s%n", barcodeGroup);
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
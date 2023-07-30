package Exercise;

import java.util.Scanner;

public class p07_StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());

        int totalStrength = 0;
        for (int position = 0; position < text.length(); position++) {
            char currentSymbol = text.charAt(position);

            if (currentSymbol == '>') {
                int strength = Integer.parseInt(String.valueOf(text.charAt(position + 1)));
                totalStrength += strength;
            } else if (totalStrength > 0) {
                text.deleteCharAt(position);
                totalStrength--;
                position--;
            }
        }

        System.out.println(text);
    }
}
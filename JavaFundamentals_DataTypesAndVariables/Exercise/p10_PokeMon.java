package Exercise;

import java.math.BigDecimal;
import java.util.Scanner;

public class p10_PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int power = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int factor = Integer.parseInt(scanner.nextLine());
        double halfPokePower = power * 0.50;
        int targets = 0;

        while (power >= distance) {
            power -= distance;
            targets++;
            if (power == halfPokePower && factor != 0) {
                power /= factor;
            }
        }
        System.out.println(power);
        System.out.println(targets);
    }
}
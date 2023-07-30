package Exercise;

import java.util.Scanner;

public class p11_RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGamesCount = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int brokenHeadsets = lostGamesCount / 2;
        int brokenMouses = lostGamesCount / 3;
        int brokenKeyboards = lostGamesCount / 6;
        int brokenDisplays = lostGamesCount / 12;

        double rageExpenses = brokenHeadsets * headsetPrice + brokenMouses * mousePrice +
                brokenKeyboards * keyboardPrice + brokenDisplays * displayPrice;
        System.out.printf("Rage expenses: %.2f lv.", rageExpenses);
    }
}
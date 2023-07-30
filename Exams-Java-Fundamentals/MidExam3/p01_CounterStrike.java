package MidExam3;

import java.util.Scanner;

public class p01_CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int wonBattles = 0;

        while (!command.equals("End of battle")) {
            int target = Integer.parseInt(command);

            if (initialEnergy >= target) {
                initialEnergy -= target;
                wonBattles++;

                if (wonBattles % 3 == 0) {
                    initialEnergy += wonBattles;
                }
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy%n", wonBattles, initialEnergy);
                break;
            }

            command = scanner.nextLine();
        }

        if (command.equals("End of battle")) {
            System.out.printf("Won battles: %d. Energy left: %d%n", wonBattles, initialEnergy);
        }
    }
}
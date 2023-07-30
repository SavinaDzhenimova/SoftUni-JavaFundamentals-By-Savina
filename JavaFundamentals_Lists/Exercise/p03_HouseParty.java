package Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p03_HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> guestsList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<String> commands = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
            String guestName = commands.get(0);

            if (commands.contains("not")) {
                if (guestsList.contains(guestName)) {
                    guestsList.remove(guestName);
                } else {
                    System.out.printf("%s is not in the list!%n", guestName);
                }
            } else {
                if (guestsList.contains(guestName)) {
                    System.out.printf("%s is already in the list!%n", guestName);
                } else {
                    guestsList.add(guestName);
                }
            }
        }

        for (String guest : guestsList) {
            System.out.println(guest);
        }
    }
}
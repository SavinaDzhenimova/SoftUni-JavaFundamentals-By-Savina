package MoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p05_DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double savings = Double.parseDouble(scanner.nextLine());
        List<Integer> drumSetList = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> initialDrumSetList = new ArrayList<>(drumSetList);
        String command = scanner.nextLine();

        while (!command.equals("Hit it again, Gabsy!")) {
            int hitPower = Integer.parseInt(command);

            for (int i = 0; i < drumSetList.size(); i++) {
                int currentDrum = drumSetList.get(i);
                int newDrumValue = currentDrum - hitPower;

                if (newDrumValue <= 0) {
                    drumSetList.set(i, initialDrumSetList.get(i));

                    if (savings - initialDrumSetList.get(i) * 3 <= 0) {
                        drumSetList.remove(drumSetList.get(i));
                        initialDrumSetList.remove(initialDrumSetList.get(i));
                        i -= 1;
                    } else {
                        savings -= initialDrumSetList.get(i) * 3;
                    }
                } else {
                    drumSetList.set(i, newDrumValue);
                }
            }

            if (savings < 0) {
                break;
            }
            command = scanner.nextLine();
        }

        System.out.println(drumSetList.toString().replaceAll("[\\[\\],]", ""));
        System.out.printf("Gabsy has %.2flv.%n", savings);
    }
}
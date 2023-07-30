package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p01_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagonsList = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacityOfEachWagon = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] commands = input.split(" ");

            if (commands[0].equals("Add")) {
                int wagonToAdd = Integer.parseInt(commands[1]);
                wagonsList.add(wagonToAdd);
            } else {
                int peopleToAdd = Integer.parseInt(commands[0]);
                for (int i = 0; i < wagonsList.size(); i++) {
                    int peopleInWagon = wagonsList.get(i);
                    if (peopleToAdd <= maxCapacityOfEachWagon - peopleInWagon) {
                        peopleInWagon = peopleInWagon + peopleToAdd;
                        wagonsList.set(i,peopleInWagon);
                        break;
                    }
                }
            }

            input = scanner.nextLine();
        }

        System.out.println(wagonsList.toString().replaceAll("[\\[\\],]", ""));
    }
}
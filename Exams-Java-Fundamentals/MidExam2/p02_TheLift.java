package MidExam2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class p02_TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        List<Integer> lift = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < lift.size(); i++) {
            if ((lift.get(i) < 4)) {
                if (people >= 4 - lift.get(i)) {
                    people -= 4 - lift.get(i);
                    lift.set(i, 4);
                } else {
                    int currentPeople = lift.get(i) + people;
                    lift.set(i, currentPeople);
                    people = 0;
                }
            }
        }
        boolean full = IntStream.range(0, lift.size()).noneMatch(i -> lift.get(i) != 4);

        if (people == 0 && !full) {
            System.out.println("The lift has empty spots!");
        } else if (people > 0 && full) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", people);
        }

        System.out.println(lift.toString().replaceAll("[\\[\\],]", ""));
    }
}
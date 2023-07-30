package MoreExercise;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class p01_Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, String> contests = new LinkedHashMap<>();

        while (!input.equals("end of contests")) {
            List<String> inputData = Arrays.stream(input.split(":")).collect(Collectors.toList());
            String contest = inputData.get(0);
            String password = inputData.get(1);

            contests.put(contest, password);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        TreeMap<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();

        while (!input.equals("end of submissions")) {
            List<String> inputData = Arrays.stream(input.split("=>")).collect(Collectors.toList());
            String contest = inputData.get(0);
            String password = inputData.get(1);
            String username = inputData.get(2);
            int points = Integer.parseInt(inputData.get(3));

            if (contests.containsKey(contest) && contests.get(contest).equals(password)) {
                LinkedHashMap<String, Integer> course = new LinkedHashMap<>();
                course.put(contest, points);

                if (!users.containsKey(username)) {
                    users.put(username, course);
                } else {
                    if (!users.get(username).containsKey(contest)) {
                        users.get(username).put(contest, points);
                    } else {
                        users.get(username).put(contest, Math.max(points, users.get(username).get(contest)));
                    }
                }
            }

            input = scanner.nextLine();
        }

        int totalSum = 0;
        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : users.entrySet()) {
            int sum = user.getValue().values().stream().mapToInt(i -> i).sum();
            if (sum > totalSum) {
                totalSum = sum;
            }
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : users.entrySet()) {
            if (user.getValue().values().stream().mapToInt(i -> i).sum() == totalSum) {
                System.out.printf("Best candidate is %s with total %d points.%n", user.getKey(), totalSum);
            }
        }

        System.out.println("Ranking:");
        users.forEach((key, value) -> {
            System.out.printf("%s%n", key);
            value.entrySet().stream().
                    sorted((f, s) -> s.getValue() - f.getValue()).
                    forEach(i -> System.out.printf("#  %s -> %d%n", i.getKey(), i.getValue()));
        });
    }
}
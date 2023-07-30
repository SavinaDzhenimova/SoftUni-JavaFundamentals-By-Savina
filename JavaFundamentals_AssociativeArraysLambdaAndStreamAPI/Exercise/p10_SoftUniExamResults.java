package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p10_SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        LinkedHashMap<String, Integer> usersAndPointsMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> languagesCountMap = new LinkedHashMap<>();
        while (!command.equals("exam finished")) {
            String[] examData = command.split("-");

            String username = examData[0];
            if (examData.length == 3) {
                String language = examData[1];
                int points = Integer.parseInt(examData[2]);

                if (!usersAndPointsMap.containsKey(username)) {
                    usersAndPointsMap.put(username, points);
                } else {
                    if (points > usersAndPointsMap.get(username)) {
                        usersAndPointsMap.put(username, points);
                    }
                }

                if (!languagesCountMap.containsKey(language)) {
                    languagesCountMap.put(language, 0);
                }
                languagesCountMap.put(language, languagesCountMap.get(language) + 1);
            } else {

                if (usersAndPointsMap.containsKey(username)) {
                    usersAndPointsMap.remove(username);
                }
            }

            command = scanner.nextLine();
        }

        System.out.println("Results:");
        for (Map.Entry<String, Integer> entry : usersAndPointsMap.entrySet()) {
            System.out.printf("%s | %d%n", entry.getKey(), entry.getValue());
        }

        System.out.println("Submissions:");
        for (Map.Entry<String, Integer> entry : languagesCountMap.entrySet()) {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        }
    }
}
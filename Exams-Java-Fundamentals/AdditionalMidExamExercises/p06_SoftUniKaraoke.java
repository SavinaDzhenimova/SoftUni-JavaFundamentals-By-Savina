package AdditionalMidExamExercises;

import java.util.*;
import java.util.stream.Collectors;

public class p06_SoftUniKaraoke {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> participants = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        List<String> songs = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        Map<String, List<String>> awardsMap = new HashMap<>();
        String command = scanner.nextLine();

        while (!command.equals("dawn")) {
            String[] stagePerformance = command.split(",\\s+");
            String participant = stagePerformance[0];
            String song = stagePerformance[1];
            String award = stagePerformance[2];

            if (participants.contains(participant) && songs.contains(song)) {
                if (!awardsMap.containsKey(participant)) {
                    awardsMap.put(participant, new ArrayList<>());
                    awardsMap.get(participant).add(award);
                } else {
                    if (!awardsMap.get(participant).contains(award)) {
                        awardsMap.get(participant).add(award);
                    }
                }
            }

            command = scanner.nextLine();
        }

        if (awardsMap.size() > 0) {
            awardsMap.entrySet().
                    stream().
                    sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size())).
                    forEach(entry -> {
                        System.out.printf("%s: %d awards%n", entry.getKey(), entry.getValue().size());
                        entry.getValue().
                                stream().
                                sorted(String::compareTo).
                                forEach(element -> System.out.printf("--%s%n", element));
                    });
        } else {
            System.out.println("No awards");
        }
    }
}
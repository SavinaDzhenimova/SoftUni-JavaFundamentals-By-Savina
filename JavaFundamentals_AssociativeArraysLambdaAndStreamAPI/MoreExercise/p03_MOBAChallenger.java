package MoreExercise;

import java.util.Scanner;
import java.util.TreeMap;

public class p03_MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        TreeMap<String, TreeMap<String, Integer>> playersMap = new TreeMap<>();

        while (!command.equals("Season end")) {
            if (command.contains("->")) {
                String[] playerData = command.split(" -> ");
                String playerName = playerData[0];
                String position = playerData[1];
                int skill = Integer.parseInt(playerData[2]);

                if (!playersMap.containsKey(playerName)) {
                    playersMap.put(playerName, new TreeMap<>());
                    playersMap.get(playerName).put(position, skill);
                } else {
                    if (!playersMap.get(playerName).containsKey(position)) {
                        playersMap.get(playerName).put(position, skill);
                    } else {
                        if (skill > playersMap.get(playerName).get(position)) {
                            playersMap.get(playerName).put(position, skill);
                        }
                    }
                }
            } else if (command.contains("vs")) {
                String[] playerData = command.split(" vs ");
                String firstPlayer = playerData[0];
                String secondPlayer = playerData[1];

                if (playersMap.containsKey(firstPlayer) && playersMap.containsKey(secondPlayer)) {
                    boolean hasCommon = false;

                    for (String firstPosition : playersMap.get(firstPlayer).keySet()) {
                        for (String secondPosition : playersMap.get(secondPlayer).keySet()) {
                            if (firstPosition.equals(secondPosition)) {
                                hasCommon = true;
                            }
                        }
                    }

                    if (hasCommon) {
                        if (playersMap.get(firstPlayer).values().stream().mapToInt(i -> i).sum() >
                                playersMap.get(secondPlayer).values().stream().mapToInt(i -> i).sum()) {
                            playersMap.remove(secondPlayer);
                        } else if (playersMap.get(firstPlayer).values().stream().mapToInt(i -> i).sum() <
                                playersMap.get(secondPlayer).values().stream().mapToInt(i -> i).sum()) {
                            playersMap.remove(firstPlayer);
                        }
                    }
                }
            }

            command = scanner.nextLine();
        }

        playersMap.entrySet()
                .stream()
                .sorted((p1, p2) -> {
                    int result = Integer.compare(p2.getValue().values().stream().mapToInt(i -> i).sum(),
                            p1.getValue().values().stream().mapToInt(i -> i).sum());
                    if (result == 0) {
                        result = p1.getKey().compareTo(p2.getKey());
                    }
                    return result;
                })
                .forEach(entry -> {
                    System.out.printf("%s: %d skill%n", entry.getKey(), entry.getValue().values().stream().mapToInt(i -> i).sum());
                    entry.getValue()
                            .entrySet()
                            .stream()
                            .sorted((e1, e2) -> {
                                int res = Integer.compare(e2.getValue(), e1.getValue());
                                if (res == 0) {
                                    res = e1.getKey().compareTo(e2.getKey());
                                }
                                return res;
                            }).forEach(e -> {
                                System.out.printf("- %s <::> %d%n", e.getKey(), e.getValue());
                            });
                });
    }
}
package Exercise;

import java.util.*;

public class p09_ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        LinkedHashMap<String, ArrayList<String>> forceSidesMap = new LinkedHashMap<>();

        while (!inputLine.equals("Lumpawaroo")) {
            if (inputLine.contains("|")) {
                String[] inputData = inputLine.split(" \\| ");
                String forceSide = inputData[0];
                String forceUser = inputData[1];

                if (!forceSidesMap.containsKey(forceSide)) {
                    forceSidesMap.put(forceSide, new ArrayList<>());
                }

                boolean isExist = false;
                for (List<String> list : forceSidesMap.values()) {
                    if (list.contains(forceUser)) {
                        isExist = true;
                    }
                }

                if (!isExist) {
                    forceSidesMap.get(forceSide).add(forceUser);
                }
            } else if (inputLine.contains("->")) {
                String[] inputData = inputLine.split(" -> ");
                String forceUser = inputData[0];
                String forceSide = inputData[1];

                forceSidesMap.entrySet().forEach(entry -> entry.getValue().remove(forceUser));

                if (forceSidesMap.containsKey(forceSide)) {
                    List<String> currentPlayers = forceSidesMap.get(forceSide);
                    currentPlayers.add(forceUser);
                } else {
                    forceSidesMap.put(forceSide, new ArrayList<>());
                    forceSidesMap.get(forceSide).add(forceUser);
                }

                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);

            }

            inputLine = scanner.nextLine();
        }

        forceSidesMap.entrySet()
                .stream().filter(entry -> entry.getValue().size() > 0)
                .forEach(entry -> {
                    System.out.println("Side: " + entry.getKey() + ", Members: " + entry.getValue().size());
                    entry.getValue().forEach(player -> System.out.println("! " + player));
                });
    }
}
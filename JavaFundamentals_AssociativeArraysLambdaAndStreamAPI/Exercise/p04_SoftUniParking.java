package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p04_SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, String> registeredUsernamesMap = new LinkedHashMap<>();
        for (int i = 0; i < numberOfCommands; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String username = tokens[1];

            switch (tokens[0]) {
                case "register":
                    String plateNumber = tokens[2];
                    if (!registeredUsernamesMap.containsKey(username)) {
                        registeredUsernamesMap.put(username, plateNumber);
                        System.out.printf("%s registered %s successfully%n", username, plateNumber);
                    } else {
                        System.out.printf("ERROR: already registered with plate number %s%n", plateNumber);
                    }
                    break;
                case "unregister":
                    if (registeredUsernamesMap.containsKey(username)) {
                        registeredUsernamesMap.remove(username);
                        System.out.printf("%s unregistered successfully%n", username);
                    } else {
                        System.out.printf("ERROR: user %s not found%n", username);
                    }
                    break;
            }
        }

        for (Map.Entry<String, String> entry : registeredUsernamesMap.entrySet()) {
            System.out.printf("%s => %s%n", entry.getKey(), entry.getValue());
        }
    }
}
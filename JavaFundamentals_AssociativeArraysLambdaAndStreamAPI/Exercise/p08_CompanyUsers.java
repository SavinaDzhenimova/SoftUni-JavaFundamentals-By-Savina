package Exercise;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p08_CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        LinkedHashMap<String, ArrayList<String>> companiesMap = new LinkedHashMap<>();

        while (!command.equals("End")) {
            String[] employeeData = command.split(" -> ");
            String companyName = employeeData[0];
            String employeeId = employeeData[1];

            companiesMap.putIfAbsent(companyName, new ArrayList<>());

            if (!companiesMap.get(companyName).contains(employeeId)) {
                companiesMap.get(companyName).add(employeeId);
            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, ArrayList<String>> entry : companiesMap.entrySet()) {
            System.out.printf("%s%n", entry.getKey());
            for (String employee : entry.getValue()) {
                System.out.printf("-- %s%n", employee);
            }
        }
    }
}
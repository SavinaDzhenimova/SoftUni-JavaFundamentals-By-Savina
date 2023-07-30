package Exercise;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p06_StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, ArrayList<Double>> studentsMap = new LinkedHashMap<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String studentName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            studentsMap.putIfAbsent(studentName, new ArrayList<>());
            studentsMap.get(studentName).add(grade);
        }

        for (Map.Entry<String, ArrayList<Double>> entry : studentsMap.entrySet()) {
            double avgGrade = entry.getValue().stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .getAsDouble();

            if (avgGrade >= 4.50) {
                System.out.printf("%s -> %.2f%n", entry.getKey(), avgGrade);
            }
        }
    }
}
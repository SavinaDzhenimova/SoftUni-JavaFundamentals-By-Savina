package Exercise;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p05_Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        LinkedHashMap<String, ArrayList<String>> coursesMap = new LinkedHashMap<>();

        while (!command.equals("end")) {
            String[] courseData = command.split(" : ");
            String courseName = courseData[0];
            String registeredStudent = courseData[1];

            coursesMap.putIfAbsent(courseName, new ArrayList<>());
            coursesMap.get(courseName).add(registeredStudent);

            command = scanner.nextLine();
        }

        for (Map.Entry<String, ArrayList<String>> entry : coursesMap.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
            for (String student : entry.getValue()) {
                System.out.printf("-- %s%n", student);
            }
        }
    }
}
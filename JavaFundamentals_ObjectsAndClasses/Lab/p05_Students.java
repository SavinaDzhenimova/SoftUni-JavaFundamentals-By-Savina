package Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p05_Students {
    public static class Student {
        String firstName;
        String lastName;
        String age;
        String hometown;

        public Student (String firstName, String lastName, String age, String hometown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.hometown = hometown;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public String getAge() {
            return this.age;
        }

        public String getHometown() {
            return this.hometown;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<Student> studentsList = new ArrayList<>();
        while (!command.equals("end")) {
            String[] studentArr = command.split(" ");
            String firstName = studentArr[0];
            String lastName = studentArr[1];
            String age = studentArr[2];
            String hometown = studentArr[3];

            Student currentStudent = new Student(firstName, lastName, age, hometown);
            studentsList.add(currentStudent);

            command = scanner.nextLine();
        }

        String townToPrint = scanner.nextLine();
        for (Student currentStudent : studentsList) {
            if (currentStudent.getHometown().equals(townToPrint)) {
                System.out.printf("%s %s is %s years old%n",
                        currentStudent.getFirstName(), currentStudent.getLastName(), currentStudent.getAge());
            }
        }
    }
}
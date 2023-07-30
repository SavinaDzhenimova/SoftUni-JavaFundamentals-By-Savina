package Exercise;

import java.util.*;

public class p04_Students {
    public static class Student {
        String firstName;
        String lastName;
        double grade;

        public Student(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public double getGrade() {
            return this.grade;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Student> studentsList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] studentInformation = scanner.nextLine().split(" ");
            String firstName = studentInformation[0];
            String lastName = studentInformation[1];
            double grade = Double.parseDouble(studentInformation[2]);

            Student currentStudent = new Student(firstName, lastName, grade);
            studentsList.add(currentStudent);
        }

        studentsList.sort(Comparator.comparingDouble(Student::getGrade).reversed());
        for (Student currentStudent : studentsList) {
            System.out.printf("%s %s: %.2f%n",
                    currentStudent.getFirstName(), currentStudent.getLastName(), currentStudent.getGrade());
        }
    }
}
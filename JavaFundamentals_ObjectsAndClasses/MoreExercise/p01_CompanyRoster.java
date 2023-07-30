package MoreExercise;

import java.util.*;
import java.util.stream.Collectors;

public class p01_CompanyRoster {
    static class Employee {
        String name;
        double salary;
        String position;
        String department;
        String email;
        int age;

        public Employee() {
            this.email = "n/a";
            this.age = -1;
        }

        public double getSalary() {
            return this.salary;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return this.name;
        }

        public String getEmail() {
            return this.email;
        }

        public String getDepartment() {
            return this.department;
        }

        public int getAge() {
            return this.age;
        }
    }

    static class Department {
        String name;
        List<Employee> employees;
        double avgSalary;

        public Department(String name, List<Employee> employees) {
            this.name = name;
            this.employees = employees;
            this.avgSalary = employees.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
        }

        public String getName() {
            return this.name;
        }

        public List<Employee> getEmployees() {
            return this.employees;
        }

        public double getAvgSalary() {
            return this.avgSalary;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            List<String> inputData = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
            String name = inputData.get(0);
            double salary = Double.parseDouble(inputData.get(1));
            String position = inputData.get(2);
            String department = inputData.get(3);

            Employee employee = new Employee();

            employee.setName(name);
            employee.setSalary(salary);
            employee.setPosition(position);
            employee.setDepartment(department);

            if (inputData.size() == 5) {
                if (inputData.get(4).contains("@")) {
                    employee.setEmail(inputData.get(4));
                } else {
                    employee.setAge(Integer.parseInt(inputData.get(4)));
                }
            } else if (inputData.size() == 6) {
                employee.setEmail(inputData.get(4));
                employee.setAge(Integer.parseInt(inputData.get(5)));
            }

            employees.add(employee);
        }

        List<String> departmentsList = employees.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());

        List<Department> departments = new ArrayList<>();
        for (String department : departmentsList) {
            departments.add(new Department(department,
                    employees.stream().filter(employee -> employee.getDepartment().equals(department))
                            .collect(Collectors.toList())));
        }

        departments.sort(Comparator.comparingDouble(Department::getAvgSalary).reversed());
        Department department = departments.get(0);
        department.getEmployees().sort(Comparator.comparingDouble(Employee::getSalary).reversed());

        System.out.printf("Highest Average Salary: %s%n", department.getName());
        for (Employee employee : department.getEmployees()) {
            System.out.printf("%s %.2f %s %d%n",
                    employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge());
        }
    }
}
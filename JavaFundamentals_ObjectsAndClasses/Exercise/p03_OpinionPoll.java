package Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p03_OpinionPoll {
    public static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return this.name;
        }

        public int getAge() {
            return this.age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> peopleList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] personInformation = scanner.nextLine().split(" ");
            String name = personInformation[0];
            int age = Integer.parseInt(personInformation[1]);

            Person currentPerson = new Person(name, age);
            peopleList.add(currentPerson);
        }

        for (Person person : peopleList) {
            if (person.getAge() > 30) {
                System.out.printf("%s - %d%n", person.getName(), person.getAge());
            }
        }
    }
}
package Exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class p06_OrderByAge {
    public static class Person {
        String name;
        String id;
        int age;

        public Person(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public int getAge() {
            return this.age;
        }

        @Override
        public String toString() {
            return this.name + " with ID: " + this.id + " is " + this.age + " years old.";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<Person> peopleList = new ArrayList<>();
        while (!command.equals("End")) {
            String[] personData = command.split(" ");
            String name = personData[0];
            String id = personData[1];
            int age = Integer.parseInt(personData[2]);

            Person currentPerson = new Person(name, id, age);
            peopleList.add(currentPerson);

            command = scanner.nextLine();
        }

        peopleList.sort(Comparator.comparingInt(Person::getAge));
        for (Person person : peopleList) {
            System.out.println(person);
        }
    }
}
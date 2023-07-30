package groomingSalon;

public class Pet {
    String name;
    int age;
    String owner;

    public Pet(String name, int age, String owner) {
        this.name = name;
        this.age = age;
        this.owner = owner;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getOwner() {
        return this.owner;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age + " - (" + this.owner + ")";
    }
}
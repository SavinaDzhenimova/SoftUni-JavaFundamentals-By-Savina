package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    List<Pet> data;
    int capacity;

    public GroomingSalon(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public List<Pet> getPets() {
        return this.data;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void add(Pet pet) {
        if (this.data.size() < this.capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (Pet pet : this.data) {
            if (pet.getName().equals(name)) {
                this.data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : this.data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        String output = "";

        output += "The grooming salon has the following clients:\n";

        for (Pet pet : this.data) {
            output += pet.getName() + " " + pet.getOwner() + "\n";
        }
        return output;
    }
}

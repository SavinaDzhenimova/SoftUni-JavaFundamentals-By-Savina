package FinalExam2;

import java.util.*;

public class p03_PlantDiscovery {
    public static class Plant{
        String plant;
        int rarity;
        ArrayList<Double> rating;

        public Plant(String plant, int rarity, ArrayList<Double> rating) {
            this.plant = plant;
            this.rarity = rarity;
            this.rating = rating;
        }

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }

        public void setRating(ArrayList<Double> rating) {
            this.rating = rating;
        }

        public ArrayList<Double> getRating() {
            return this.rating;
        }

        public String getPlant() {
            return this.plant;
        }

        public int getRarity() {
            return this.rarity;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPlants = Integer.parseInt(scanner.nextLine());

        List<Plant> plantsList = new ArrayList<>();
        for (int i = 0; i < numberOfPlants; i++) {
            String[] input = scanner.nextLine().split("<->");
            String plant = input[0];
            int rarity = Integer.parseInt(input[1]);

            Plant currentPlant = new Plant(plant, rarity, new ArrayList<>());
            plantsList.add(currentPlant);
        }

        String input = scanner.nextLine();

        while (!input.equals("Exhibition")) {
            String[] tokens = input.split(": ");
            String[] data = tokens[1].split(" - ");

            String plant = data[0];

            boolean isExist = false;
            for (Plant currentPlant : plantsList) {
                if (currentPlant.getPlant().equals(plant)) {
                    isExist = true;
                    break;
                }
            }

            if (!isExist) {
                System.out.println("error");
            }

            switch (tokens[0]) {
                case "Rate":
                    double rating = Double.parseDouble(data[1]);

                    for (Plant currentPlant : plantsList) {
                        if (currentPlant.getPlant().equals(plant)) {
                            if (currentPlant.getRating().isEmpty()) {
                                currentPlant.setRating(new ArrayList<>());
                                currentPlant.getRating().add(rating);
                            } else {
                                currentPlant.getRating().add(rating);
                            }
                            break;
                        }
                    }
                    break;
                case "Update":
                    int rarity = Integer.parseInt(data[1]);

                    for (Plant currentPlant : plantsList) {
                        if (currentPlant.getPlant().equals(plant)) {
                            currentPlant.setRarity(rarity);
                            break;
                        }
                    }
                    break;
                case "Reset":
                    for (Plant currentPlant : plantsList) {
                        if (currentPlant.getPlant().equals(plant)) {
                            currentPlant.setRating(new ArrayList<>());
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("error");
            }

            input = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");
        for (Plant currentPlant : plantsList) {
            double avgRating = 0;
            if (!currentPlant.getRating().isEmpty()) {
                avgRating = currentPlant.getRating().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
            }

            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", currentPlant.getPlant(), currentPlant.getRarity(), avgRating);
        }
    }
}
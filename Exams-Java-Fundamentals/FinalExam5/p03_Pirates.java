package FinalExam5;

import java.util.*;

public class p03_Pirates {
    public static class City{
        int population;
        int gold;

        public City(int population, int gold) {
            this.population = population;
            this.gold = gold;
        }

        public int getPopulation() {
            return this.population;
        }

        public int getGold() {
            return this.gold;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, City> citiesMap = new LinkedHashMap<>();
        while (!input.equals("Sail")) {
            String[] tokens = input.split("\\|\\|");
            String cityName = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);

            if (!citiesMap.containsKey(cityName)) {
                citiesMap.put(cityName, new City(population, gold));
            } else {
                int newPopulation = citiesMap.get(cityName).getPopulation() + population;
                int newGold = citiesMap.get(cityName).getGold() + gold;
                citiesMap.put(cityName, new City(newPopulation, newGold));
            }

            input = scanner.nextLine();
        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] tokens = command.split("=>");
            String town = tokens[1];

            switch (tokens[0]) {
                case "Plunder":
                    int people = Integer.parseInt(tokens[2]);
                    int gold = Integer.parseInt(tokens[3]);

                    if (citiesMap.containsKey(town)) {
                        citiesMap.get(town).setPopulation(citiesMap.get(town).getPopulation() - people);
                        citiesMap.get(town).setGold(citiesMap.get(town).getGold() - gold);
                        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);

                        if (citiesMap.get(town).getPopulation() <= 0 || citiesMap.get(town).getGold() <= 0) {
                            citiesMap.remove(town);
                            System.out.printf("%s has been wiped off the map!%n", town);
                        }
                    }
                    break;
                case "Prosper":
                    int goldToAdd = Integer.parseInt(tokens[2]);

                    if (goldToAdd < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        if (citiesMap.containsKey(town)) {
                            citiesMap.get(town).setGold(citiesMap.get(town).getGold() + goldToAdd);
                            System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",
                                    goldToAdd, town, citiesMap.get(town).getGold());
                        }
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        if (citiesMap.size() > 0) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", citiesMap.size());
            for (Map.Entry<String, City> entry : citiesMap.entrySet()) {
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                        entry.getKey(), entry.getValue().getPopulation(), entry.getValue().getGold());
            }
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}
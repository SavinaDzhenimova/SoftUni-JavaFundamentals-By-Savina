package MoreExercise;

import java.util.*;

public class p05_DragonArmy {
    public static class DragonStats {
        String name;
        int damage;
        int health;
        int armor;

        public DragonStats(String name, int damage, int health, int armor) {
            this.name = name;
            this.damage = damage;
            this.health = health;
            this.armor = armor;
        }

        public String getName() {
            return this.name;
        }

        public int getDamage() {
            return this.damage;
        }

        public int getHealth() {
            return this.health;
        }

        public int getArmor() {
            return this.armor;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public void setArmor(int armor) {
            this.armor = armor;
        }

        @Override
        public String toString() {
            return "-" + this.name + " -> damage: " + this.damage + ", health: " + this.health + ", armor: " + this.armor;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dragonsCount = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, TreeMap<String, DragonStats>> dragons = new LinkedHashMap<>();

        for (int i = 0; i < dragonsCount; i++) {
            String[] inputData = scanner.nextLine().split(" ");
            String color = inputData[0];
            String name = inputData[1];
            int damage;
            if (inputData[2].equals("null")) {
                damage = 45;
            } else {
                damage = Integer.parseInt(inputData[2]);
            }
            int health;
            if (inputData[3].equals("null")) {
                health = 250;
            } else {
                health = Integer.parseInt(inputData[3]);
            }
            int armor;
            if (inputData[4].equals("null")) {
                armor = 10;
            } else {
                armor = Integer.parseInt(inputData[4]);
            }

            DragonStats dragonStats = new DragonStats(name, damage, health, armor);

            if (!dragons.containsKey(color)) {
                dragons.put(color, new TreeMap<>());
                dragons.get(color).put(name, dragonStats);
            } else {
                if (dragons.get(color).containsKey(name)) {
                    dragons.get(color).get(name).setDamage(damage);
                    dragons.get(color).get(name).setHealth(health);
                    dragons.get(color).get(name).setArmor(armor);
                } else {
                    dragons.get(color).put(name, dragonStats);
                }
            }
        }

        for (Map.Entry<String, TreeMap<String, DragonStats>> entry : dragons.entrySet()) {
            String key = entry.getKey();
            TreeMap<String, DragonStats> value = entry.getValue();
            double damageAvg = 0;
            double healthAvg = 0;
            double armorAvg = 0;
            for (DragonStats dragon : value.values()) {
                damageAvg += dragon.getDamage();
                healthAvg += dragon.getHealth();
                armorAvg += dragon.getArmor();
            }
            damageAvg /= value.size();
            healthAvg /= value.size();
            armorAvg /= value.size();

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", key, damageAvg, healthAvg, armorAvg);
            dragons.get(key).forEach((k, v) -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",
                            k, v.getDamage(), v.getHealth(), v.getArmor()));
        }
    }
}
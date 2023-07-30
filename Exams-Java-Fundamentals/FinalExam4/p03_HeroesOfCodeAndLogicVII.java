package FinalExam4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p03_HeroesOfCodeAndLogicVII {
    public static class Hero{
        String name;
        int hitPoints;
        int manaPoints;

        public Hero(String name, int hitPoints, int manaPoints) {
            this.name = name;
            this.hitPoints = hitPoints;
            this.manaPoints = manaPoints;
        }

        public String getName() {
            return this.name;
        }

        public int getHitPoints() {
            return this.hitPoints;
        }

        public int getManaPoints() {
            return this.manaPoints;
        }

        public void setHitPoints(int hitPoints) {
            this.hitPoints = hitPoints;
        }

        public void setManaPoints(int manaPoints) {
            this.manaPoints = manaPoints;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfHeroes = Integer.parseInt(scanner.nextLine());

        List<Hero> heroesList = new ArrayList<>();
        for (int i = 0; i < numberOfHeroes; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            int hitPoints = Integer.parseInt(input[1]);
            int manaPoints = Integer.parseInt(input[2]);

            Hero currentHero = new Hero(name, hitPoints, manaPoints);
            heroesList.add(currentHero);
        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] tokens = command.split(" - ");
            String heroName = tokens[1];

            switch (tokens[0]) {
                case "CastSpell":
                    int manaPointsNeeded = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];

                    for (Hero currentHero : heroesList) {
                        if (currentHero.getName().equals(heroName)) {
                            if (currentHero.getManaPoints() >= manaPointsNeeded) {
                                int newManaPoints = currentHero.getManaPoints() - manaPointsNeeded;
                                currentHero.setManaPoints(newManaPoints);
                                System.out.printf("%s has successfully cast %s and now has %d MP!%n",
                                        heroName, spellName, currentHero.getManaPoints());
                            } else {
                                System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                            }
                            break;
                        }
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];

                    for (Hero currentHero : heroesList) {
                        if (currentHero.getName().equals(heroName)) {
                            int newHitPoints = currentHero.getHitPoints() - damage;

                            if (newHitPoints > 0) {
                                currentHero.setHitPoints(newHitPoints);
                                System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                                        heroName, damage, attacker, currentHero.getHitPoints());
                            } else {
                                System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                                heroesList.remove(currentHero);
                            }
                            break;
                        }
                    }
                    break;
                case "Recharge":
                    int amountToRecharge = Integer.parseInt(tokens[2]);

                    for (Hero currentHero : heroesList) {
                        if (currentHero.getName().equals(heroName)) {
                            int newManaPoints = currentHero.getManaPoints() + amountToRecharge;

                            if (newManaPoints <= 200) {
                                currentHero.setManaPoints(newManaPoints);
                                System.out.printf("%s recharged for %d MP!%n", heroName, amountToRecharge);
                            } else {
                                System.out.printf("%s recharged for %d MP!%n", heroName, 200 - currentHero.getManaPoints());
                                currentHero.setManaPoints(200);
                            }
                        }
                    }
                    break;
                case "Heal":
                    int amountToHeal = Integer.parseInt(tokens[2]);

                    for (Hero currentHero : heroesList) {
                        if (currentHero.getName().equals(heroName)) {
                            int newHitPoints = currentHero.getHitPoints() + amountToHeal;

                            if (newHitPoints <= 100) {
                                currentHero.setHitPoints(newHitPoints);
                                System.out.printf("%s healed for %d HP!%n", heroName, amountToHeal);
                            } else {
                                System.out.printf("%s healed for %d HP!%n", heroName, 100 - currentHero.getHitPoints());
                                currentHero.setHitPoints(100);
                            }
                        }
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        for (Hero hero : heroesList) {
            System.out.println(hero.getName());
            System.out.println("  HP: " + hero.getHitPoints());
            System.out.println("  MP: " + hero.getManaPoints());
        }
    }
}
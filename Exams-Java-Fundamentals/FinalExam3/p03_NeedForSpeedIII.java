package FinalExam3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p03_NeedForSpeedIII {
    public static class Car{
        String car;
        int mileage;
        int fuel;

        public Car(String car, int mileage, int fuel) {
            this.car = car;
            this.mileage = mileage;
            this.fuel = fuel;
        }

        public String getCar() {
            return this.car;
        }

        public int getMileage() {
            return this.mileage;
        }

        public int getFuel() {
            return this.fuel;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public void setFuel(int fuel) {
            this.fuel = fuel;
        }

        @Override
        public String toString() {
            return this.car + " -> Mileage: " + this.mileage + " kms, Fuel in the tank: " + this.fuel + " lt.";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        List<Car> carsList = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            String[] input = scanner.nextLine().split("\\|");
            String car = input[0];
            int mileage = Integer.parseInt(input[1]);
            int fuel = Integer.parseInt(input[2]);

            Car currentCar = new Car(car, mileage, fuel);
            carsList.add(currentCar);
        }

        String command = scanner.nextLine();

        while (!command.equals("Stop")) {
            String[] tokens = command.split(" : ");
            String car = tokens[1];

            switch (tokens[0]) {
                case "Drive":
                    int distance = Integer.parseInt(tokens[2]);
                    int fuel = Integer.parseInt(tokens[3]);

                    for (Car currentCar : carsList) {
                        if (currentCar.getCar().equals(car)) {
                            if (currentCar.getFuel() < fuel) {
                                System.out.println("Not enough fuel to make that ride");
                            } else {
                                int newMileage = currentCar.getMileage() + distance;
                                int newFuel = currentCar.getFuel() - fuel;

                                currentCar.setMileage(newMileage);
                                currentCar.setFuel(newFuel);
                                System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",
                                        currentCar.getCar(), distance, fuel);
                            }

                            if (currentCar.getMileage() >= 100000) {
                                System.out.printf("Time to sell the %s!%n", currentCar.getCar());
                                carsList.remove(currentCar);
                            }

                            break;
                        }
                    }
                    break;
                case "Refuel":
                    int fuelToRefill = Integer.parseInt(tokens[2]);

                    int neededFuel = 0;
                    for (Car currentCar : carsList) {
                        if (currentCar.getCar().equals(car)) {
                            int newFuel = currentCar.getFuel() + fuelToRefill;

                            if (newFuel < 75) {
                                neededFuel = fuelToRefill;
                                currentCar.setFuel(newFuel);
                            } else {
                                neededFuel = 75 - currentCar.getFuel();
                                currentCar.setFuel(75);
                            }

                            System.out.printf("%s refueled with %d liters%n", currentCar.getCar(), neededFuel);
                            break;
                        }
                    }
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(tokens[2]);

                    for (Car currentCar : carsList) {
                        if (currentCar.getCar().equals(car)) {
                            int newMileage = currentCar.getMileage() - kilometers;

                            if (newMileage < 10000) {
                                currentCar.setMileage(10000);
                            } else {
                                currentCar.setMileage(newMileage);
                                System.out.printf("%s mileage decreased by %d kilometers%n", currentCar.getCar(), kilometers);
                            }
                        }
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        for (Car currentCar : carsList) {
            System.out.println(currentCar);
        }
    }
}
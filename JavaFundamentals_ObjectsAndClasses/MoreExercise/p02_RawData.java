package MoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p02_RawData {
    static class Engine {
        int speed;
        int power;

        public Engine(int speed, int power) {
            this.speed = speed;
            this.power = power;
        }

        public int getPower() {
            return this.power;
        }
    }

    static class Cargo {
        int weight;
        String type;

        public Cargo(int weight, String type) {
            this.weight = weight;
            this.type = type;
        }

        public String getType() {
            return this.type;
        }
    }

    static class Tire {
        double pressure;
        int age;

        public Tire(double pressure, int age) {
            this.pressure = pressure;
            this.age = age;
        }

        public double getPressure() {
            return this.pressure;
        }
    }

    static class Car {
        String model;
        Engine engine;
        Cargo cargo;
        Tire tire1;
        Tire tire2;
        Tire tire3;
        Tire tire4;

        public Car(String model, Engine engine, Cargo cargo, Tire tire1, Tire tire2, Tire tire3, Tire tire4) {
            this.model = model;
            this.engine = engine;
            this.cargo = cargo;
            this.tire1 = tire1;
            this.tire2 = tire2;
            this.tire3 = tire3;
            this.tire4 = tire4;
        }

        public Cargo getCargo() {
            return this.cargo;
        }

        public List<Tire> getTires() {
            return List.of(new Tire[]{tire1, tire2, tire3, tire4});
        }

        public String getModel() {
            return this.model;
        }

        public Engine getEngine() {
            return this.engine;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Car> carsList = new ArrayList<>();
        Car car;
        Cargo cargo;

        for (int i = 0; i < n; i++) {
            List<String> inputData = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
            String model = inputData.get(0);
            int engineSpeed = Integer.parseInt(inputData.get(1));
            int enginePower = Integer.parseInt(inputData.get(2));
            int cargoWeight = Integer.parseInt(inputData.get(3));
            String cargoType = inputData.get(4);
            double tire1Pressure = Double.parseDouble(inputData.get(5));
            int tire1Age = Integer.parseInt(inputData.get(6));
            double tire2Pressure = Double.parseDouble(inputData.get(7));
            int tire2Age = Integer.parseInt(inputData.get(8));
            double tire3Pressure = Double.parseDouble(inputData.get(9));
            int tire3Age = Integer.parseInt(inputData.get(10));
            double tire4Pressure = Double.parseDouble(inputData.get(11));
            int tire4Age = Integer.parseInt(inputData.get(12));

            Engine engine = new Engine(engineSpeed, enginePower);
            cargo = new Cargo(cargoWeight, cargoType);
            Tire tire1 = new Tire(tire1Pressure, tire1Age);
            Tire tire2 = new Tire(tire2Pressure, tire2Age);
            Tire tire3 = new Tire(tire3Pressure, tire3Age);
            Tire tire4 = new Tire(tire4Pressure, tire4Age);

            car = new Car(model, engine, cargo, tire1, tire2, tire3, tire4);
            carsList.add(car);
        }

        List<String> output = new ArrayList<>();
        String command = scanner.nextLine();
        switch (command) {
            case "fragile":
                for (Car currentCar : carsList) {
                    if (currentCar.getCargo().getType().equals("fragile")) {
                        for (Tire currentTire : currentCar.getTires()) {
                            if (currentTire.getPressure() < 1) {
                                output.add(currentCar.getModel());
                                break;
                            }
                        }
                    }
                }
                break;
            case "flamable":
                for (Car currentCar : carsList) {
                    if (currentCar.getCargo().getType().equals("flamable") && currentCar.getEngine().getPower() > 250) {
                        output.add(currentCar.getModel());
                    }
                }
                break;
        }

        for (String item : output) {
            System.out.println(item);
        }
    }
}
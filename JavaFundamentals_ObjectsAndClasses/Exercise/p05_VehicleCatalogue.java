package Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p05_VehicleCatalogue {
    public static class Vehicle {
        String typeOfVehicle;
        String model;
        String color;
        int horsepower;

        public Vehicle(String typeOfVehicle, String model, String color, int horsepower) {
            this.typeOfVehicle = typeOfVehicle;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }

        public String getTypeOfVehicle() {
            return this.typeOfVehicle;
        }

        public int getHorsepower() {
            return this.horsepower;
        }

        @Override
        public String toString() {
            String typeVeh = typeOfVehicle.equals("car") ? "Car" : "Truck";
            return "Type: " + typeVeh + "\n" +
                    "Model: " + model + "\n" +
                    "Color: " + color + "\n" +
                    "Horsepower: " + horsepower;
        }
    }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            String vehicles = scanner.nextLine();

            List<Vehicle> vehiclesList = new ArrayList<>();
            while (!vehicles.equals("End")) {
                String[] vehiclesData = vehicles.split(" ");
                String typeOfVehicle = vehiclesData[0];
                String model = vehiclesData[1];
                String color = vehiclesData[2];
                int horsepower = Integer.parseInt(vehiclesData[3]);

                Vehicle currentVehicle = new Vehicle(typeOfVehicle, model, color, horsepower);
                vehiclesList.add(currentVehicle);

                vehicles = scanner.nextLine();
            }

            String carModel = scanner.nextLine();
            while (!carModel.equals("Close the Catalogue")) {
                for (Vehicle vehicle : vehiclesList) {
                    if (vehicle.model.equals(carModel)) {
                        System.out.println(vehicle);
                    }
                }

                carModel = scanner.nextLine();
            }

            double totalCarsHorsepower = 0;
            double totalTrucksHorsepower = 0;
            int carsCount = 0;
            int trucksCount = 0;
            for (Vehicle vehicle : vehiclesList) {
                if (vehicle.getTypeOfVehicle().equals("car")) {
                    carsCount++;
                    totalCarsHorsepower += vehicle.getHorsepower();
                } else if (vehicle.getTypeOfVehicle().equals("truck")) {
                    trucksCount++;
                    totalTrucksHorsepower += vehicle.getHorsepower();
                }
            }

            double avgCarsHorsepower = totalCarsHorsepower / carsCount;
            if (carsCount == 0) avgCarsHorsepower = 0;
            System.out.printf("Cars have average horsepower of: %.2f.%n", avgCarsHorsepower);

            double avgTrucksHorsepower = totalTrucksHorsepower / trucksCount;
            if (trucksCount == 0) avgTrucksHorsepower = 0;
            System.out.printf("Trucks have average horsepower of: %.2f.%n", avgTrucksHorsepower);
    }
}
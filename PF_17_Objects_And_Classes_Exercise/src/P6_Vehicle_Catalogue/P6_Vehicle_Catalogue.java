package P6_Vehicle_Catalogue;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P6_Vehicle_Catalogue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dataInput = scanner.nextLine();
        List<Vehicle> vehicles = new ArrayList<>();
        double countCars = 0;
        double sumHorsePowersOfCars = 0;
        double countTrucks = 0;
        double sumHorsePowersOfTrucks = 0;

        while (!dataInput.equals("End")) {
            // {typeOfVehicle} {model} {color} {horsepower}
            String type = dataInput.split("\\s+")[0];
            String model = dataInput.split("\\s+")[1];
            String color = dataInput.split("\\s+")[2];
            double horsePowers = Double.parseDouble(dataInput.split("\\s+")[3]);

            if (type.equals("car")) {
                countCars++;
                sumHorsePowersOfCars += horsePowers;
                type = type.substring(0,1).toUpperCase() + type.substring(1);
            } else {
                countTrucks++;
                sumHorsePowersOfTrucks += horsePowers;
                type = type.substring(0,1).toUpperCase() + type.substring(1);
            }

            Vehicle vehicle = new Vehicle(type, model, color, horsePowers);
            vehicles.add(vehicle);

            dataInput = scanner.nextLine();
        }
        String showModel = scanner.nextLine();

        while (!showModel.equals("Close the Catalogue")) {
            for (Vehicle vehicle : vehicles) {
                if (showModel.equals(vehicle.getModel())) {
                    System.out.printf("Type: %s%nModel: %s%nColor: %s%nHorsepower: %.0f"
                            , vehicle.getType(), vehicle.getModel(), vehicle.getColor(), vehicle.getHorsePowers());
                    System.out.println();
                }
            }

            showModel = scanner.nextLine();
        }
        double averageHorsePowerCars = sumHorsePowersOfCars / countCars;
        double averageHorsePowerTrucks = sumHorsePowersOfTrucks / countTrucks;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (countCars > 0 && averageHorsePowerCars > 0) {
            System.out.println("Cars have average horsepower of: " + decimalFormat.format(averageHorsePowerCars) + ".");
        } else {
            System.out.println("Cars have average horsepower of: 0.00.");
        }
        if (countTrucks > 0 && averageHorsePowerTrucks > 0) {
            System.out.println("Trucks have average horsepower of: " + decimalFormat.format(averageHorsePowerTrucks) + ".");
        } else {
            System.out.println("Trucks have average horsepower of: 0.00.");
        }
    }
}

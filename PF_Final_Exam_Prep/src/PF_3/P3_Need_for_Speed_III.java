package PF_3;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P3_Need_for_Speed_III {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, ArrayList<Integer>> carDatabase = new LinkedHashMap<>();
        for (int i = 1; i <= n; i++) {
        String[] tokens = scanner.nextLine().split("\\|");
        String carModel = tokens[0];
        int mileage = Integer.parseInt(tokens[1]);
        int fuel = Integer.parseInt(tokens[2]);
        carDatabase.put(carModel, new ArrayList<>());
        carDatabase.get(carModel).add(mileage);
        carDatabase.get(carModel).add(fuel);
        }
        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            String[] moreTokens = input.split(" : ");
            String command = moreTokens[0];
            String car = moreTokens[1];
            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(moreTokens[2]);
                    int fuelNeeded = Integer.parseInt(moreTokens[3]);
                    if (carDatabase.get(car).get(1) >= fuelNeeded) {
                        int newMileage = carDatabase.get(car).get(0) + distance;
                        carDatabase.get(car).set(0, newMileage);
                        int newFuel = carDatabase.get(car).get(1) - fuelNeeded;
                        carDatabase.get(car).set(1, newFuel);
                        System.out.println(car + " driven for " + distance + " kilometers. " + fuelNeeded +
                                " liters of fuel consumed.");
                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                    if (isInvalidCar(carDatabase, car)) {
                        carDatabase.remove(car);
                        System.out.println("Time to sell the " + car + "!");
                    }
                    break;
                case "Refuel":
                    int refuelValue = Integer.parseInt(moreTokens[2]);
                    if (carDatabase.get(car).get(1) + refuelValue <= 75) {
                        int newFuel = carDatabase.get(car).get(1) + refuelValue;
                        carDatabase.get(car).set(1, newFuel);
                        System.out.println(car + " refueled with " + refuelValue + " liters");
                    } else {
                        int newFuelMore = 75 - carDatabase.get(car).get(1);
                        carDatabase.get(car).set(1, 75);
                        System.out.println(car + " refueled with " + newFuelMore + " liters");
                    }
                    break;
                case "Revert":
                    int kilometersToRevert = Integer.parseInt(moreTokens[2]);
                    if (carDatabase.get(car).get(0) - kilometersToRevert < 10000) {
                        carDatabase.get(car).set(0, 10000);
                    } else {
                        int newMileage = carDatabase.get(car).get(0) - kilometersToRevert;
                        carDatabase.get(car).set(0, newMileage);
                        System.out.println(car + " mileage decreased by " + kilometersToRevert + " kilometers");
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        carDatabase.entrySet().stream().sorted((e1, e2) -> {
            int result = e2.getValue().get(0).compareTo(e1.getValue().get(0));
            if (result == 0) {
                result = e1.getKey().compareTo(e2.getKey());
            }
            return result;
        }).forEach(entry -> System.out.println(entry.getKey() + " -> Mileage: " + entry.getValue().get(0) +
                " kms, Fuel in the tank: " + entry.getValue().get(1) +" lt."));
    }

    private static boolean isInvalidCar(Map<String, ArrayList<Integer>> carDatabase, String car) {
            return carDatabase.get(car).get(0) >= 100000;
    }
}

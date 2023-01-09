package PF_6;

import java.util.Arrays;
import java.util.Scanner;

public class P3_Man_O_War {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] pirateShip = Arrays.stream(scanner.nextLine().split(">")).mapToInt(Integer::parseInt).toArray();
        int[] warShip = Arrays.stream(scanner.nextLine().split(">")).mapToInt(Integer::parseInt).toArray();
        int maxHealth = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        boolean warShipSunken = false;
        boolean pirateShipSunken = false;

        while (!input.equals("Retire")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Fire":
                    int index = Integer.parseInt(tokens[1]);
                    int damage = Integer.parseInt(tokens[2]);
                    if (indexIsValidWarShip(index, warShip)) {
                        if ((warShip[index] - damage) <= 0) {
                            warShipSunken = true;
                            System.out.println("You won! The enemy ship has sunken.");
                        } else {
                            warShip[index] -= damage;
                        }
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    int damagePirateShip = Integer.parseInt(tokens[3]);
                    if (indexIsValidPirateShip(startIndex, endIndex, pirateShip)) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            if (pirateShip[i] - damagePirateShip <= 0) {
                                pirateShipSunken = true;
                                System.out.println("You lost! The pirate ship has sunken.");
                                break;
                            } else {
                                pirateShip[i] -= damagePirateShip;
                            }
                        }
                    }
                    break;
                case "Repair":
                    int indexRepair = Integer.parseInt(tokens[1]);
                    int healthRepair = Integer.parseInt(tokens[2]);
                    if (indexIsValidPirateShip(indexRepair, indexRepair, pirateShip)) {
                        if (pirateShip[indexRepair] + healthRepair > maxHealth) {
                            pirateShip[indexRepair] = maxHealth;
                        } else {
                            pirateShip[indexRepair] += healthRepair;
                        }
                    }
                    break;
                case "Status":
                    int needRepair = 0;
                    for (int i = 0; i < pirateShip.length; i++) {
                        double minHealth = maxHealth * 0.20;
                        if (pirateShip[i] < minHealth) {
                            needRepair++;
                        }
                    }
                    System.out.println(needRepair + " sections need repair.");
                    break;
            }

            if (warShipSunken || pirateShipSunken) {
                break;
            }

            input = scanner.nextLine();
        }

        if (!pirateShipSunken && !warShipSunken) {
            int pirateShipHealth = calculateSum(pirateShip);
            int warShipHealth = calculateSum(warShip);

            System.out.println("Pirate ship status: " + pirateShipHealth);
            System.out.println("Warship status: " + warShipHealth);
        }

    }

    private static int calculateSum(int[] ship) {
        int sum = 0;

        for (int section : ship) {
            sum += section;
        }

        return sum;
    }

    private static boolean indexIsValidPirateShip(int startIndex, int endIndex, int[] pirateShip) {
        boolean startIndexIsValid = false;
        boolean endIndexIsValid = false;
        if (startIndex >= 0 && startIndex < pirateShip.length) {
            startIndexIsValid = true;
        }
        if (endIndex >= 0 && endIndex < pirateShip.length) {
            endIndexIsValid = true;
        }
        return startIndexIsValid && endIndexIsValid;
    }

    private static boolean indexIsValidWarShip(int index, int[] warShip) {
        return index >= 0 && index < warShip.length;
    }
}

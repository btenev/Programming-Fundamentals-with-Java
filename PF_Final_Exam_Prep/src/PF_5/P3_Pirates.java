package PF_5;

import java.util.*;

public class P3_Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<Integer>> citiesToPlunder = new LinkedHashMap<>();
        while (!input.equals("Sail")) {
            String[] tokens = input.split("\\|\\|");
            String city = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);
            if (!citiesToPlunder.containsKey(city)) {
                citiesToPlunder.put(city, new ArrayList<>());
                citiesToPlunder.get(city).add(population);
                citiesToPlunder.get(city).add(gold);
            } else {
                int newPopulation = citiesToPlunder.get(city).get(0) + population;
                citiesToPlunder.get(city).set(0, newPopulation);
                int newGold = citiesToPlunder.get(city).get(1) + gold;
                citiesToPlunder.get(city).set(1, newGold);
            }
            input = scanner.nextLine();
        }
        String action = scanner.nextLine();
        while (!action.equals("End")) {
            String[] moreTokens = action.split("=>");
            String command = moreTokens[0];
            String town = moreTokens[1];
            switch (command) {
                case "Plunder":
                    int people = Integer.parseInt(moreTokens[2]);
                    int gold = Integer.parseInt(moreTokens[3]);
                    int peopleLeft = citiesToPlunder.get(town).get(0) - people;
                    int goldLeft = citiesToPlunder.get(town).get(1) - gold;
                    System.out.println(town + " plundered! " + gold + " gold stolen, " + people + " citizens killed.");
                    if (peopleLeft > 0 && goldLeft > 0) {
                        citiesToPlunder.get(town).set(0, peopleLeft);
                        citiesToPlunder.get(town).set(1, goldLeft);
                    } else {
                        citiesToPlunder.remove(town);
                        System.out.println( town + " has been wiped off the map!");
                    }
                    break;
                case "Prosper":
                    int goldToAdd = Integer.parseInt(moreTokens[2]);
                    if (validateGold(goldToAdd)) {
                        int newGoldAmount = citiesToPlunder.get(town).get(1) + goldToAdd;
                        citiesToPlunder.get(town).set(1, newGoldAmount);
                        System.out.println(goldToAdd + " gold added to the city treasury. "
                                + town + " now has " + newGoldAmount +" gold.");
                    } else {
                        System.out.println("Gold added cannot be a negative number!");
                    }
            }
            action = scanner.nextLine();
        }
        if (citiesToPlunder.values().size() > 0) {
            System.out.println("Ahoy, Captain! There are " + citiesToPlunder.values().size() + " wealthy settlements to go to:");
            citiesToPlunder.entrySet().stream().sorted((e1,e2) -> {
                int result = e2.getValue().get(1).compareTo(e1.getValue().get(1));
                if (result == 0) {
                    result = e1.getKey().compareTo(e2.getKey());
                }
                return result;
            })
                    .forEach(entry -> System.out.println( entry.getKey() + " -> Population: " + entry.getValue().get(0)
                            + " citizens, Gold: " + entry.getValue().get(1) + " kg"));
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
    private static boolean validateGold(int gold) {
        return gold >= 0;
    }
}

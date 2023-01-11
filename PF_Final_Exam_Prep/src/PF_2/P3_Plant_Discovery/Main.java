package PF_2.P3_Plant_Discovery;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, PlantData> plantDatabase = new LinkedHashMap<>();
        for (int i = 1; i <= n; i++) {
            String[] tokens = scanner.nextLine().split("<->");
            String plant = tokens[0];
            int rarity = Integer.parseInt(tokens[1]);

            PlantData newPlant = new PlantData(new ArrayList<>(), rarity);
            plantDatabase.put(plant, newPlant);
        }

        String input = scanner.nextLine();
        while (!input.equals("Exhibition")) {
            String[] moreTokens = input.split("[: -]+");
            String command = moreTokens[0];
            String plant = moreTokens[1];

            if (!plantDatabase.containsKey(plant)) {
                input = scanner.nextLine();
                System.out.println("error");
                continue;
            }

            switch (command) {
                case "Rate":
                    int rating = Integer.parseInt(moreTokens[2]);
                    plantDatabase.get(plant).addRating(rating);
                    break;
                case "Update":
                    int rarity = Integer.parseInt(moreTokens[2]);
                    plantDatabase.get(plant).setRarity(rarity);
                    break;
                case "Reset":
                    plantDatabase.get(plant).clearRatings();
                    break;

            }
            input = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        DecimalFormat df = new DecimalFormat("0.00");
        plantDatabase.entrySet().stream().sorted((e1, e2) -> {
            int result = Integer.compare(e2.getValue().getRarity(), e1.getValue().getRarity());
            if (result == 0) {
                result = Double.compare(e2.getValue().getAverageRatings(), e1.getValue().getAverageRatings());
            }
            return result;
        }).forEach(e -> System.out.println("- " + e.getKey() + "; " + "Rarity: " + e.getValue().getRarity() + "; " +
                "Rating: " + df.format(e.getValue().getAverageRatings())));

    }
}

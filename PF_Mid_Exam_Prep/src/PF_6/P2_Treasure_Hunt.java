package PF_6;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P2_Treasure_Hunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> treasureChest = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Yohoho!")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Loot":
                    for (int i = 1; i < tokens.length; i++) {
                        String currentItem= tokens[i];
                        boolean isAvailable = false;
                        for (int j = 0; j < treasureChest.size(); j++) {
                            if (currentItem.equals(treasureChest.get(j))){
                                isAvailable = true;
                                break;
                            }
                        }
                        if (!isAvailable) {
                            treasureChest.add(0,currentItem);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(tokens[1]);
                   ;
                    if (isValidIndex(index, treasureChest)) {
                        String itemToRemove = treasureChest.get(index);
                        treasureChest.remove(index);
                        treasureChest.add(treasureChest.size(), itemToRemove);
                    }
                    break;
                case "Steal":
                    int countSteal = Integer.parseInt(tokens[1]);
                    String stolen = "";
                    if (countSteal > treasureChest.size() - 1) {
                        for (int i = 0; i < treasureChest.size() - 1; i++) {
                            stolen += treasureChest.get(i) + ", ";
                        }
                            stolen += treasureChest.get(treasureChest.size() - 1);
                        int chestLength = treasureChest.size();
                        for (int i = 0; i < chestLength; i++) {
                            treasureChest.remove(0);
                        }
                    } else {
                        for (int i = treasureChest.size() - countSteal; i < treasureChest.size() - 1; i++) {
                            stolen += treasureChest.get(i) + ", ";
                        }
                            stolen += treasureChest.get(treasureChest.size() - 1);
                        for (int i = treasureChest.size() - countSteal; i < treasureChest.size(); i++) {
                            treasureChest.remove(i);
                            i--;
                        }
                    }

                    System.out.println(stolen);
                    break;
            }

            input = scanner.nextLine();
        }

        if (treasureChest.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            int countItems = 0;
            double sumOfTreasures = 0;
            for (String item : treasureChest) {
                countItems ++;
                sumOfTreasures += item.length();
            }
            double averageTreasure = sumOfTreasures / countItems;
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageTreasure);
        }
    }
    public static boolean isValidIndex (int index, List<String> items) {
        return index >= 0 && index <= items.size() - 1;
    }
 }

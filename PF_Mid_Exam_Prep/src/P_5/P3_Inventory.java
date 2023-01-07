package P_5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P3_Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> journalOfItems = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String[] tokens = scanner.nextLine().split(" - ");
        String command = tokens[0];
        while (!command.equals("Craft!")) {
            switch (command) {
                case "Collect":
                    if (!journalOfItems.contains(tokens[1])) {
                        journalOfItems.add(tokens[1]);
                    }
                    break;
                case "Drop":
                    if (journalOfItems.contains(tokens[1])) {
                        journalOfItems.remove(tokens[1]);
                    }

                    break;
                case "Combine Items":
                    String[] itemsToCombine = tokens[1].split(":");
                    String oldItem = itemsToCombine[0];
                    String newItem = itemsToCombine[1];
                    if (journalOfItems.contains(oldItem)){
                        int index = journalOfItems.indexOf(oldItem) + 1;
                        journalOfItems.add(index, newItem);
                    }
                    break;
                case "Renew":
                    if (journalOfItems.contains(tokens[1])) {
                        journalOfItems.remove(tokens[1]);
                        journalOfItems.add(tokens[1]);
                    }
                    break;
            }
            tokens = scanner.nextLine().split(" - ");
            command = tokens[0];
        }
        System.out.println(String.join(", ", journalOfItems));
    }
}

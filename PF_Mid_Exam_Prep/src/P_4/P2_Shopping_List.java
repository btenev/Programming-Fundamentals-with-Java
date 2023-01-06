package P_4;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P2_Shopping_List {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> initialShoppingList = Arrays.stream(scanner.nextLine().split("!"))
                                        .collect(Collectors.toList());
       String input = scanner.nextLine();

       while (!input.equals("Go Shopping!")) {
           String command = input.split(" ")[0];
           String item = input.split(" ")[1];
            switch (command) {
                case "Urgent":
                    if (!initialShoppingList.contains(item)) {
                        initialShoppingList.add(0,item);
                    }
                    break;
                case "Unnecessary":
                    if (initialShoppingList.contains(item)) {
                        initialShoppingList.remove(item);
                    }
                    break;
                case "Correct":
                    String newItem =input.split(" ")[2];
                    if (initialShoppingList.contains(item)) {
                        initialShoppingList.set(initialShoppingList.indexOf(item),newItem);
                    }
                    break;
                case "Rearrange":
                    if (initialShoppingList.contains(item)) {
                        initialShoppingList.add(item);
                        initialShoppingList.remove(item);
                    }
                    break;
            }
           input = scanner.nextLine();
       }
        System.out.println(String.join(", ", initialShoppingList));
    }
}

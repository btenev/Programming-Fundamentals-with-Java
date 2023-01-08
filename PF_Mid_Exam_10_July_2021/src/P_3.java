import java.util.*;
import java.util.stream.Collectors;

public class P_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> oldDeck = Arrays.stream(scanner.nextLine().split(":")).collect(Collectors.toList());
        String input = scanner.nextLine();
        List<String> newDeck = new ArrayList<>();

        while (!input.equals("Ready")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Add":
                    String addCard = tokens[1];
                    if (oldDeck.contains(addCard)) {
                        newDeck.add(addCard);
                    } else {
                        System.out.println("Card not found.");
                    }
                    break;
                case "Insert":
                    String insertCard = tokens[1];
                    int indexInsert = Integer.parseInt(tokens[2]);
                    if (oldDeck.contains(insertCard)) {
                        if (isValidIndex(indexInsert, oldDeck)) {
                            newDeck.add(indexInsert, insertCard);
                        } else {
                            System.out.println("Error!");
                        }
                    } else {
                        System.out.println("Error!");
                    }
                    break;
                case "Remove":
                    String cardRemove = tokens[1];
                    if (newDeck.contains(cardRemove)) {
                        newDeck.remove(cardRemove);
                    } else {
                        System.out.println("Card not found.");
                    }
                    break;
                case "Swap":
                    String firstCard = tokens[1];
                    String secondCard = tokens[2];

                    newDeck.set(newDeck.indexOf(secondCard) , firstCard);
                    newDeck.set(newDeck.indexOf(firstCard) , secondCard);
                    break;
                case "Shuffle":
                    Collections.reverse(newDeck);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.print(String.join(" ",newDeck));
    }

    private static boolean isValidIndex(int index, List<String> deck) {
        return index >= 0 && index <= deck.size() - 1;
    }
}

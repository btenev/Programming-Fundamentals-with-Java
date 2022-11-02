import java.util.Arrays;
import java.util.Scanner;

public class P3_Treasure_Finder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] key = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();

        while (!input.equals("find")) {
            int counter = 0;
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                char current = input.charAt(i);
                int currentKey = key[counter];
                char decryptedSymbol = (char) (current - currentKey);
                stringBuilder.append(decryptedSymbol);
                counter++;
                if (counter == key.length) {
                    counter = 0;
                }

            }

            String decryptedMessage = stringBuilder.toString();
            int startIndexTreasure = decryptedMessage.indexOf('&');
            int endIndexTreasure = decryptedMessage.lastIndexOf('&');
            String treasure = decryptedMessage.substring(startIndexTreasure + 1, endIndexTreasure);
            int startIndexCoordinates = decryptedMessage.indexOf('<');
            int endIndexCoordinates = decryptedMessage.indexOf('>');
            String coordinates = decryptedMessage.substring(startIndexCoordinates + 1, endIndexCoordinates);
            System.out.println("Found " + treasure + " at " + coordinates);

            input = scanner.nextLine();
        }
    }
}

package PF_1;

import java.util.*;

public class P3_The_Pianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map <String, ArrayList<String>> pieceDatabase = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] tokens = scanner.nextLine().split("\\|");
            String pieceName = tokens[0];
            String composer = tokens[1];
            String key = tokens[2];

            pieceDatabase.putIfAbsent(pieceName, new ArrayList<>());
            pieceDatabase.get(pieceName).add(composer);
            pieceDatabase.get(pieceName).add(key);
        }
        String commandInput = scanner.nextLine();
        while (!commandInput.equals("Stop")) {
            String[] moreTokens = commandInput.split("\\|");
            String command = moreTokens[0];
            String piece = moreTokens[1];
            switch (command) {
                case "Add":
                    String composerName = moreTokens[2];
                    String keySign = moreTokens[3];
                    if (pieceDatabase.containsKey(piece)) {
                        System.out.println(piece + " is already in the collection!");
                    } else {
                        pieceDatabase.put(piece,new ArrayList<>());
                        pieceDatabase.get(piece).add(composerName);
                        pieceDatabase.get(piece).add(keySign);
                        System.out.println(piece + " by " + composerName + " in " + keySign
                                + " added to the collection!");
                    }
                    break;
                case "Remove":
                    if (pieceDatabase.containsKey(piece)) {
                        pieceDatabase.remove(piece);
                        System.out.println("Successfully removed " + piece + "!");
                    } else {
                        System.out.println("Invalid operation! " + piece + " does not exist in the collection.");
                    }
                    break;
                case "ChangeKey":
                    String newKey = moreTokens[2];
                    if (pieceDatabase.containsKey(piece)) {
                        pieceDatabase.get(piece).set(1, newKey);
                        System.out.println("Changed the key of " + piece + " to " + newKey + "!");
                    } else {
                        System.out.println("Invalid operation! " + piece + " does not exist in the collection.");
                    }
                    break;
            }

            commandInput = scanner.nextLine();
        }
        pieceDatabase.entrySet().stream().sorted(Map.Entry.comparingByKey())
 //       pieceDatabase.entrySet().stream().sorted((e1,e2) -> {
 //           int result = e1.getKey().compareTo(e2.getKey());
 //           if (result == 0) {
 //               result = e1.getValue().get(0).compareTo(e2.getValue().get(0));
  //          }
//            return result;
 //               })
                .forEach(entry -> System.out.println(entry.getKey() + " -> Composer: " + entry.getValue().get(0)
                        + ", Key: " + entry.getValue().get(1)));
    }
}

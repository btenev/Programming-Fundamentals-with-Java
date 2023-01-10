package PF_1;

import java.util.Scanner;

public class P1_The_Imitation_Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encryptedMessage = scanner.nextLine();
        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder(encryptedMessage);
        while (!input.equals("Decode")) {
            String[] tokens = input.split("\\|");
            String instruction = tokens[0];

            switch (instruction) {
                case "Move":
                    int numLetters = Integer.parseInt(tokens[1]);
                    String lettersToMove = sb.substring(0,numLetters);
                    sb.replace(0,numLetters, "");
                    sb.append(lettersToMove);
                    break;
                case "Insert":
                    int insertIndex = Integer.parseInt(tokens[1]);
                    String stringToInsert = tokens[2];
                    sb.insert(insertIndex, stringToInsert);
                    break;
                case "ChangeAll":
                    encryptedMessage = sb.toString();
                    String changeThis = tokens[1];
                    String changeWith = tokens[2];
                    encryptedMessage = encryptedMessage.replace(changeThis, changeWith);
                    sb = new StringBuilder(encryptedMessage);
                    break;
            }

            input = scanner.nextLine();
        }
        String decryptedMessage = sb.toString();
        System.out.println("The decrypted message is: " + decryptedMessage);
    }
}

package PF_3;

import java.util.Scanner;
public class P1_Secret_Chat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String encodedMessage = scanner.nextLine();
        String input = scanner.nextLine();

        StringBuilder sb = new StringBuilder(encodedMessage);
        String temporaryMessage = "";

        while (!input.equals("Reveal")) {
            String[] tokens = input.split(":\\|:");
            String command = tokens[0];
            switch (command) {
                case "InsertSpace":
                    int indexToInsert = Integer.parseInt(tokens[1]);
                    sb.insert(indexToInsert, " ");
                    System.out.println(sb);
                    break;
                case "Reverse":
                    String toReplace = tokens[1];
                    temporaryMessage = sb.toString();
                    if (temporaryMessage.contains(toReplace)) {
                        int firstIndex = temporaryMessage.indexOf(toReplace);
                        int endIndex = firstIndex + toReplace.length();
                        sb.replace(firstIndex,endIndex,"");
                        StringBuilder temp = new StringBuilder(toReplace);
                        temp.reverse();
                        sb.append(temp);
                        System.out.println(sb);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String toReplaceAll = tokens[1];
                    String replacement = tokens[2];
                    temporaryMessage = sb.toString();
                    while (temporaryMessage.contains(toReplaceAll)) {
                        temporaryMessage = temporaryMessage.replace(toReplaceAll, replacement);
                    }
                    sb = new StringBuilder(temporaryMessage);
                    System.out.println(sb);
                    break;
            }
            input = scanner.nextLine();
        }
        String decodedMessage = sb.toString();
        System.out.println("You have a new text message: " + decodedMessage);
    }
}

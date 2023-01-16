package PF_5;

import java.util.Scanner;

public class P1_Activations_Keys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rawActivationKey = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Generate")) {
            String[] tokens = input.split(">>>");
            String command = tokens[0];
            switch (command) {
                case "Contains":
                    String substring = tokens[1];
                    if (rawActivationKey.contains(substring)) {
                        System.out.println(rawActivationKey + " contains " + substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String upperLower = tokens[1];
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endIndex = Integer.parseInt(tokens[3]);
                    String substringToReplace = rawActivationKey.substring(startIndex, endIndex);
                    String replacementString = "";
                    if (upperLower.equals("Upper")) {
                        replacementString = substringToReplace.toUpperCase();
                    } else {
                        replacementString = substringToReplace.toLowerCase();
                    }
                    rawActivationKey = rawActivationKey.replace(substringToReplace, replacementString);
                    System.out.println(rawActivationKey);
                    break;
                case "Slice":
                    int startIndexSlice = Integer.parseInt(tokens[1]);
                    int endIndexSlice = Integer.parseInt(tokens[2]);
                    StringBuilder sb = new StringBuilder(rawActivationKey);
                    sb.replace(startIndexSlice, endIndexSlice, "");
                    rawActivationKey = sb.toString();
                    System.out.println(rawActivationKey);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + rawActivationKey);
    }
}

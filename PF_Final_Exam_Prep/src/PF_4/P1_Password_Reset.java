package PF_4;

import java.util.Scanner;

public class P1_Password_Reset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            StringBuilder sb = new StringBuilder();
            switch (command) {
                case "TakeOdd":
                    for (int i = 0; i < string.length(); i++) {
                       if (i % 2 != 0) {
                           char oddPositions = string.charAt(i);
                           sb.append(oddPositions);
                       }
                    }
                    string = sb.toString();
                    System.out.println(string);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    int endIndex = startIndex + length;
                    sb = new StringBuilder(string);
                    sb.replace(startIndex,endIndex, "");
                    string = sb.toString();
                    System.out.println(string);
                    break;
                case "Substitute":
                    String subStringToReplace = tokens[1];
                    String substringToInsert = tokens[2];
                    if (string.contains(subStringToReplace)) {
                        string = string.replace(subStringToReplace, substringToInsert);
                        System.out.println(string);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("Your password is: " + string);
    }
}

package PF_2;

import java.util.Scanner;

public class P1_World_Tour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String travelStops = scanner.nextLine();
        StringBuilder sb = new StringBuilder(travelStops);
        String input = scanner.nextLine();
        while (!input.equals("Travel")) {
            String[] tokens = input.split(":");
            String instruction = tokens[0];
            switch (instruction) {
                case "Add Stop":
                    int insertIndex = Integer.parseInt(tokens[1]);
                    String toInsert = tokens[2];
                    if (validateIndex(insertIndex, sb)) {
                        sb.insert(insertIndex, toInsert);
                        System.out.println(sb);
                    }
                    break;
                case "Remove Stop":
                    int removeStartIndex = Integer.parseInt(tokens[1]);
                    int removeEndIndex = Integer.parseInt(tokens[2]);
                    if (validateIndex(removeStartIndex, sb) && validateIndex(removeEndIndex, sb)) {
                        sb.replace(removeStartIndex,removeEndIndex + 1, "");
                    }
                    System.out.println(sb);
                    break;
                case "Switch":
                    String stringToReplace = tokens[1];
                    String stringToInsert = tokens[2];
                    String newString = sb.toString();

                    if (newString.contains(stringToReplace)) {
                        newString = newString.replace(stringToReplace, stringToInsert);
                    }
                    sb.replace(0, newString.length(), newString);
                    System.out.println(sb);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + sb);
    }

    private static boolean validateIndex(int index, StringBuilder sb) {
            return index >= 0 && index < sb.length();
    }
}

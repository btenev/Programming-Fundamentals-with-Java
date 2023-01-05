package one;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P3_Memory_Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> sequenceOfElements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        int countNumberOfMoves = 0;
        boolean youHaveWon = false;
        while (!input.equals("end")) {
            int[] indices = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int indexA = indices[0];
            int indexB = indices[1];
            countNumberOfMoves++;
            if (!indicesAreValid(indexA, indexB, sequenceOfElements)) {
                sequenceOfElements.add(sequenceOfElements.size() / 2, "-" + countNumberOfMoves + "a");
                sequenceOfElements.add(sequenceOfElements.size() / 2, "-" + countNumberOfMoves + "a");
                System.out.println("Invalid input! Adding additional elements to the board");
                input = scanner.nextLine();
                continue;
            }
            if (sequenceOfElements.get(indexA).equals(sequenceOfElements.get(indexB))) {
                String index = sequenceOfElements.get(indexA);
                if (indexA > indexB) {
                    sequenceOfElements.remove(indexA);
                    sequenceOfElements.remove(indexB);
                } else {
                    sequenceOfElements.remove(indexB);
                    sequenceOfElements.remove(indexA);
                }

                System.out.println("Congrats! You have found matching elements - " + index + "!");
            } else {
                System.out.println("Try again!");
            }
            input = scanner.nextLine();

            if (sequenceOfElements.isEmpty()) {
                youHaveWon = true;
                System.out.println("You have won in " + countNumberOfMoves + " turns!");
                break;
            }
        }
        if (!youHaveWon) {
            System.out.println("Sorry you lose :(");
            System.out.println(String.join(" ", sequenceOfElements));
        }
    }

    public static boolean indicesAreValid(int indexA, int indexB, List<String> sequenceOfElements) {
        boolean indexAInBound = false;
        boolean indexBInBound = false;
        if (indexA >= 0 && indexA <= sequenceOfElements.size() - 1) {
            indexAInBound = true;
        }

        if (indexB >= 0 && indexB <= sequenceOfElements.size() - 1) {
            indexBInBound = true;
        }

        if (indexAInBound && indexBInBound) {
            return indexA != indexB;
        }
        return false;
    }
}

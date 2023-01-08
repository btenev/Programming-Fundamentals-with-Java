package one;

import java.util.Arrays;
import java.util.Scanner;

public class P2_The_Lift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        int[] wagons = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < wagons.length; i++) {
            if (wagons[i] < 4) {
                int freePlaces = 4 - wagons[i];
                if (people >= freePlaces) {
                    people -= freePlaces;
                    wagons[i] = 4;
                } else {
                    wagons[i] += people;
                    people = 0;
                    break;
                }

            }
        }

        if (people == 0) {
            for (int wagon : wagons) {
                if (wagon < 4) {
                    System.out.println("The lift has empty spots!");
                    break;
                }

            }
            for (int wagon : wagons) {
                System.out.print(wagon + " ");
            }
        } else if (people > 0) {
            System.out.println("There isn't enough space! " + people + " people in a queue!");
            for (int wagon : wagons) {
                System.out.print(wagon + " ");
            }
            System.out.println();
        }

    }
}
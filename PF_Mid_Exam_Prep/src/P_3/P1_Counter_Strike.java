package P_3;

import java.util.Scanner;

public class P1_Counter_Strike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int wonBattles = 0;
        boolean hasWon = true;
        while(!input.equals("End of battle")) {
            int distance = Integer.parseInt(input);
            if (distance <= initialEnergy) {
                initialEnergy -= distance;
                wonBattles++;
            } else {
                System.out.println("Not enough energy! Game ends with " + wonBattles + " won battles and " + initialEnergy +" energy");
                hasWon = false;
                break;
            }
            if (wonBattles % 3 == 0) {
                initialEnergy += wonBattles;
            }

            input = scanner.nextLine();
        }
        if (hasWon) {
            System.out.println("Won battles: " + wonBattles + ". Energy left: " + initialEnergy);
        }
    }
}

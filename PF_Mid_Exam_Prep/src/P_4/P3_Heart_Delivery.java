package P_4;

import java.util.Arrays;
import java.util.Scanner;

public class P3_Heart_Delivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] neighbourHood = Arrays.stream(scanner.nextLine()
                .split("@")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();
        int currentJumpLength = 0;

        while (!input.equals("Love!")) {
            int jumpLength = Integer.parseInt(input.split(" ")[1]);
            currentJumpLength += jumpLength;

            if (currentJumpLength > neighbourHood.length - 1) {
                currentJumpLength = 0;
                neighbourHood[currentJumpLength] -= 2;

            } else {
                neighbourHood[currentJumpLength] -= 2;
            }

            if (neighbourHood[currentJumpLength] == 0) {
                System.out.println("Place " + currentJumpLength + " has Valentine's day.");
            } else if (neighbourHood[currentJumpLength] < 0) {
                System.out.println("Place " + currentJumpLength + " already had Valentine's day.");
            }

            input = scanner.nextLine();
        }

        int countFailed = 0;
        for (int i = 0; i < neighbourHood.length; i++) {
            if (neighbourHood[i] > 0) {
                countFailed++;
            }
        }
        System.out.println("Cupid's last position was " + currentJumpLength + ".");
        if (countFailed == 0) {
            System.out.println("Mission was successful.");
        } else {
            System.out.println("Cupid has failed " + countFailed + " places.");
        }
    }
}

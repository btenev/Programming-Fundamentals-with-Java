package P_3;

import java.util.Arrays;
import java.util.Scanner;

public class P2_Shoot_For_The_Win {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targetSequences = Arrays.stream(scanner.nextLine().split("\\s+"))
                              .mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            int index = Integer.parseInt(input);
            if (index > targetSequences.length - 1) {
                input = scanner.nextLine();
                continue;
            }
            int originalValue = targetSequences[index];
            if (targetSequences[index] != -1) {
                targetSequences[index] = -1;
                for (int i = 0; i < targetSequences.length; i++) {
                    if (targetSequences[i] != -1) {
                        if (targetSequences[i] > originalValue) {
                            targetSequences[i] -= originalValue;
                        } else {
                            targetSequences[i] += originalValue;
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        int shotTargets = 0;
        for (int j = 0; j < targetSequences.length; j++) {
            if (targetSequences[j] == -1) {
                shotTargets++;
            }
        }
        System.out.print("Shot targets: " + shotTargets + " -> ");
        for (int number : targetSequences) {
            System.out.print(number + " ");
        }
    }
}

package P_3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P3_Moving_Target {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> sequenceOfTargets = Arrays.stream(scanner.nextLine().split("\\s+"))
                                        .map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String command = input.split("\\s+")[0];
            int index = Integer.parseInt(input.split("\\s+")[1]) ;
            switch (command) {
                case "Shoot":
                    int power = Integer.parseInt(input.split("\\s+")[2]);
                    if (isValidIndex(index, sequenceOfTargets)) {
                        sequenceOfTargets.set(index, sequenceOfTargets.get(index) - power);
                        if (sequenceOfTargets.get(index) <= 0) {
                            sequenceOfTargets.remove(index);
                        }
                    }
                    break;
                case "Add":
                    int value = Integer.parseInt(input.split("\\s+")[2]);
                    if(isValidIndex(index,sequenceOfTargets)) {
                        sequenceOfTargets.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    int radius = Integer.parseInt(input.split("\\s+")[2]);
                    if (index - radius >= 0 && index + radius <= sequenceOfTargets.size() - 1) {
                        for (int i = index - radius; i < index; i++) {
                            sequenceOfTargets.remove(index - radius);

                        }
                        for (int j = index; j <= index + radius; j++) {
                            sequenceOfTargets.remove(index - radius);
                        }
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        for (int g = 0; g < sequenceOfTargets.size() - 1; g++) {
            System.out.print(sequenceOfTargets.get(g) + "|");
        }
        System.out.print(sequenceOfTargets.get(sequenceOfTargets.size() - 1));
    }

    private static boolean isValidIndex(int index, List<Integer> targets) {
        return (index >= 0 && index <= targets.size() - 1);
    }
}

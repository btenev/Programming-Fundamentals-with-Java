import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P2_Car_Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> arrayOfNums = Arrays.stream(scanner.nextLine().split("\\s+"))
                                    .map(Integer::parseInt).collect(Collectors.toList());
        double timeLeftRacer = 0;
        for (int i = 0; i < arrayOfNums.size() / 2; i++) {
            int passedTime = arrayOfNums.get(i);
            if (passedTime == 0) {
                timeLeftRacer *= 0.80;
            } else {
                timeLeftRacer += passedTime;
            }
        }
        double timeRightRacer = 0;
        for (int j = arrayOfNums.size() - 1; j > arrayOfNums.size() / 2; j--) {
            int passedTime = arrayOfNums.get(j);
            if (passedTime == 0) {
                timeRightRacer *= 0.80;
            } else {
                timeRightRacer += passedTime;
            }
        }
        if (timeLeftRacer < timeRightRacer) {
            System.out.printf("The winner is left with total time: %.1f%n", timeLeftRacer);
        } else if (timeRightRacer < timeLeftRacer) {
            System.out.printf("The winner is right with total time: %.1f%n", timeRightRacer);
        }
    }
}

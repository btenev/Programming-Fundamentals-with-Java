import java.util.Arrays;
import java.util.Scanner;

public class P6_Equal_Sums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(value -> Integer.parseInt(value))
                .toArray();
        int leftSum = 0;
        boolean leftEqualsRight = false;
        int finalIndex = 0;
        for (int i = 0; i < numbers.length ; i++) {
            int rightSum = 0;
            if (i > 0) {
                leftSum += numbers[i -1];
            }

            for (int j = i + 1; j < numbers.length; j++) {
                rightSum += numbers[j];
            }
            if (leftSum == rightSum) {
                leftEqualsRight = true;
                finalIndex = i;
                break;
            }
        }
        if (leftEqualsRight) {
            System.out.println(finalIndex);
        } else {
            System.out.println("no");
        }
    }
}

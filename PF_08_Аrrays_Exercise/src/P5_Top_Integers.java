import java.util.Arrays;
import java.util.Scanner;

public class P5_Top_Integers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e) ).toArray();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] <= numbers[j]) {
                    break;
                } else if (j == numbers.length - 1) {
                    System.out.print(numbers[i] + " ");
                }
            }

        }
        System.out.println(numbers[numbers.length -1] + " ");

    }
}

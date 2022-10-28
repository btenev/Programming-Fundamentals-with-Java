import java.util.Arrays;
import java.util.Scanner;

public class P8_Magic_Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e->Integer.parseInt(e)).toArray();
        int givenNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length ; j++) {
                if (numbers[i] + numbers[j] == givenNumber) {
                    int[] temp = new int[2];
                    temp[0] = numbers[i];
                    temp[1] = numbers[j];
                    for (int digit : temp) {
                        System.out.print(digit + " ");

                    }
                    System.out.println();
                }
            }
        }
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class P3_Zig_Zag_Arrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int [] array1 = new int [n];
        int [] array2 = new int [n];

        for (int i = 0; i < n; i++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();
            if ((i + 1) % 2 == 0) {
                array1 [i] = numbers[1];
                array2 [i] = numbers[0];

            } else {
                array1 [i] = numbers[0];
                array2 [i] = numbers[1];
            }
         }
        for (int digit1:array1) {
            System.out.print(digit1 + " ");
        }
        System.out.println();
        for (int digit2:array2) {
            System.out.print(digit2 + " ");
        }
    }
}

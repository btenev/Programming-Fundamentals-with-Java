import java.util.Arrays;
import java.util.Scanner;

public class P6_Equal_Arrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] array1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int [] array2 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int arraySum = 0;
        boolean areIdentical = true;
        int difference = 0;

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == array2[i]) {
                arraySum += array1[i];
            } else {
                areIdentical = false;
                difference = i;
                break;
            }
        }
        if (areIdentical) {
            System.out.println("Arrays are identical. Sum: "+ arraySum);
        } else {
            System.out.println("Arrays are not identical. Found difference at " + difference  + " index.");
        }
    }
}

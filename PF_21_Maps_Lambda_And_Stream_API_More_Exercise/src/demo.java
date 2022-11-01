import java.util.Arrays;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] intArray = new int [] {52,45,32,64,12,87,78,98,23,7};
        int temp = 0;

        for (int i = 0; i < intArray.length; i++) {
            for (int j = i + 1; j < intArray.length; j++) {
                if (intArray[i] > intArray[j]) {
                    temp = intArray[i];
                    intArray[i] = intArray[j];
                    intArray[j] = temp;

                }
            }
        }
        System.out.println(Arrays.toString(intArray));
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class P1_Encrypt_Sort_And_Print_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] collection = new int[n];
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            collection[i] = sumLetters(name);
        }
        Arrays.sort(collection);
        for (int currentNumber : collection) {
            System.out.println(currentNumber);
        }
    }


    public static int sumLetters(String name) {
        int sum = 0;
        for (int j = 0; j < name.length(); j++) {
            char currentLetter = name.charAt(j);
            switch (currentLetter) {
                case 'A':
                case 'a':
                case 'E':
                case 'e':
                case 'I':
                case 'i':
                case 'O':
                case 'o':
                case 'U':
                case 'u':
                    sum += currentLetter * name.length();
                    break;
                default:
                    sum += currentLetter / name.length();
                    break;

            }
        }
        return sum;
    }
}

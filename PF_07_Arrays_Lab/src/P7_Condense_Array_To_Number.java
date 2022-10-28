import java.util.Arrays;
import java.util.Scanner;

public class P7_Condense_Array_To_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        while (array.length > 1) { // итерираме докато дължина на основният масив е по-голяма от 1;
            int[] condensed = new int[array.length - 1]; // правим нов масив,по-малък с едно от основният
            for (int i = 0; i < condensed.length; i++) { // итерираме новият масив до неговата дължина и му даваме нови стойности
                condensed[i] = array[i] + array[i + 1]; // стойностите са на база елементи от старият масив

            }
            array = condensed; // даваме нова стойност на основният масив
        }
        System.out.println(array[0]);
    }
}

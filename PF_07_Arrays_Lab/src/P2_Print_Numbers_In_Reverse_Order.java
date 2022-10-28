
import java.util.Scanner;

public class P2_Print_Numbers_In_Reverse_Order {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); // въвеждаме n на брой числа

        int [] numbers = new int[n]; // създаваме масив с n  на брой елементи

        for (int j = 0; j < numbers.length; j++) {   // придаваме стойност на всеки елемент
            numbers [j] = Integer.parseInt(scanner.nextLine());
        }
        for (int i = numbers.length - 1; i >= 0 ; i--) {    // печатаме всеки елемент отзад напред
            System.out.print (numbers[i] + " ");
        }
    }
}

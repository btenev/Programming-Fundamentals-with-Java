import java.util.Arrays;
import java.util.Scanner;

public class P7_Max_Sequence_Of_Equal_Elements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e->Integer.parseInt(e))
                .toArray();
        // 2 1 1 2 3 3 2 2 2 1
        int length = 1; // дължина на дадена поредица
        int maxLength = 0; // максимална дължина

        int startIndex = 0;
        int bestStartIndex = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == numbers[i - 1]) {  // сравняваме елемента на i позиция и на i -1
                length++;  // увеличаваме дължина на поредицата
            } else {
                length = 1;  // ако не връщаме на 1
                startIndex = i; // индекса в който започва новата поредица
            }
            if (length > maxLength) {  // проверяваме максималната дължина спрямо настоящата дължина
                maxLength = length;    // максималната дължина става равна на дължината
                bestStartIndex = startIndex;
            }
        }
        for (int i = bestStartIndex; i < bestStartIndex + maxLength; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}

import java.util.Scanner;

public class PF_03_Characters_In_Range {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char one = scanner.nextLine().charAt(0);
        char two = scanner.nextLine().charAt(0);

        printSymbolsInRange(one, two);
    }

    private static void printSymbolsInRange(char one, char two) {
        if (one < two) {
            for (int i = one + 1; i < two; i++) {
                char current = (char) i;
                System.out.print(current + " ");
            }
        } else {
            for (int i = two + 1; i < one; i++) {
                char current1 = (char) i;
                System.out.print(current1 + " ");
            }
        }
    }
}

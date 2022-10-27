import java.util.Scanner;

public class P5_Print_Part_Of_ASCII_Table {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());

        for (int i = start; i <= end ; i++) {
           // char currentSymbol = (char) i;

            System.out.print((char) i + " ");
        }

    }
}

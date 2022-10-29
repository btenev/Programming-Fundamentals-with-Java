import java.util.Scanner;

public class PF_03_Printing_Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = Integer.parseInt(scanner.nextLine());
        printPyramid(height);
    }

    private static void printPyramid(int height) {
        printTopHalf(height);
        printBottomHalf(height);
    }

    private static void printTopHalf(int height) {
        for (int i = 1; i < height; i++) {
         printSingleLine(i);
        }
    }

    private static void printSingleLine(int i) {
        for (int j = 1; j <= i; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    private static void printBottomHalf(int height) {
        for (int i = height; i >= 1; i--) {
            printSingleLine(i);
        }
    }
}

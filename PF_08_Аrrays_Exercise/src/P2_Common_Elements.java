import java.util.Scanner;

public class P2_Common_Elements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elements = scanner.nextLine().split(" ");
        String[] elements2 = scanner.nextLine().split(" ");

        for (int i = 0; i < elements2.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                if (elements2[i].equals(elements[j])) {
                    System.out.print(elements2[i] + " ");
                }

            }
        }
    }
}
import java.util.Scanner;

public class P1_Ages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());

        if (0 <= age && age <= 2) {
            System.out.println("baby");
        } else if (2 < age && age <= 13) {
            System.out.println("child");
        } else if (3 < age && age <= 19) {
            System.out.println("teenager");
        } else if (19 < age && age <= 65) {
            System.out.println("adult");
        } else if (age > 65) {
            System.out.println("elder");
        }
    }
}

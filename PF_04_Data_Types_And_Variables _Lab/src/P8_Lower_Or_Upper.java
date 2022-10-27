import java.util.Scanner;

public class P8_Lower_Or_Upper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char letter = scanner.nextLine().charAt(0);

        if (letter >= 97 &&  letter <= 122) {
            System.out.println("lower-case");
        } else if (letter >= 60 && letter <= 90) {
            System.out.println("upper-case");
        }
    }
}

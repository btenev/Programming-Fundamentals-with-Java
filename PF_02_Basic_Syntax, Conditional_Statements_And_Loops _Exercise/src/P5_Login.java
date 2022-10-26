import java.util.Scanner;

public class P5_Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String input = scanner.nextLine();
        String password = "";
        int counter = 0;
        boolean passwordCorrect = true;
        for (int i = username.length() - 1; i >= 0; i--) {
            char currentSymbol = username.charAt(i);
            password += currentSymbol;
        }

        while (!input.equals(password)) {
            counter++;
            if (counter > 3) {
                passwordCorrect = false;
                break;
            }
            System.out.println("Incorrect password. Try again.");
            input = scanner.nextLine();
        }
        if (passwordCorrect) {
            System.out.println("User " + username + " logged in.");
        } else {
            System.out.println("User " + username + " blocked!");
        }
    }
}


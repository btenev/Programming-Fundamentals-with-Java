import java.util.Scanner;

public class PF_04_Password_Validator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	6 – 10 characters (inclusive);
        //•	Consists only of letters and digits;
        //•	Have at least 2 digits.
        String password = scanner.nextLine();
        boolean isValidLength = checkPasswordLength(password);
        if (!isValidLength) {
            System.out.println("Password must be between 6 and 10 characters");
        }

        boolean isValidSymbol = isValidContent(password);
        if (!isValidSymbol) {
            System.out.println("Password must consist only of letters and digits");
        }

        boolean isValidCount = isValidCountDigits(password);
        if (!isValidCount) {
            System.out.println("Password must have at least 2 digits");
        }
        if (isValidCount && isValidLength && isValidSymbol) {
            System.out.println("Password is valid");
        }
    }

    private static boolean isValidCountDigits(String password) {
        int counter = 0;
        for (int i = 0; i < password.length(); i++) {
            char currentSymbol =  password.charAt(i);
            if (Character.isDigit(currentSymbol)) {
                counter++;
            }
        }
        return counter >= 2;
    }

    private static boolean isValidContent(String password) {
        for (int i = 0; i < password.length(); i++) {
            char currentSymbol = password.charAt(i);
            if (!(Character.isLetterOrDigit(currentSymbol))) {
                // !(Character.isLetter(currentSymbol)) || (Character.isDigit(currentSymbol))
                return false;
            }
        }
        return true;
    }

    private static boolean checkPasswordLength(String password) {
        if (password.length() >= 6 && password.length() <= 10) {
            return true;
        } else {
            return false;
        }
    }
}


import java.util.Scanner;

public class P1_Valid_Usernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        for (String username : input) {
            if(isValidLength(username.length())) {
                if (isValidSymbols(username)) {
                    System.out.println(username);
                }
            }
        }
    }
    private static boolean isValidLength (int length) {
        return length >= 3 && length <= 16;
    }

    private static boolean isValidSymbols (String username) {
        for (int i = 0; i < username.length(); i++) {
            char currentCharacter = username.charAt(i);
            boolean isLetterOrDigit = Character.isLetterOrDigit(currentCharacter);
            boolean isHyphens = currentCharacter == '-';
            boolean isUnderscores = currentCharacter == '_';
            if (!(isLetterOrDigit || isHyphens || isUnderscores)) {
                return false;
            }
        }
        return true;
    }
}

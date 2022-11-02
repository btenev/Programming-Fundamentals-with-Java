import java.util.Scanner;

public class P4_Caesar_Cipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String input = scanner.nextLine();
        for (Character symbol : input.toCharArray()) {
                char currentChar = symbol;
                char encryptedChar = (char)(currentChar + 3);
                sb.append(encryptedChar);
        }
        System.out.println(sb);
    }
}

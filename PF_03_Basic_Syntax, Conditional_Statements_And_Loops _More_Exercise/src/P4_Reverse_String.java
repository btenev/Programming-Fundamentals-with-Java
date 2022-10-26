import java.util.Scanner;

public class P4_Reverse_String {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String reverseWord = "";

        for (int i = text.length() - 1; i >= 0; i--) {
            char currentLetter = text.charAt(i);
            reverseWord += currentLetter;
        }
        System.out.println(reverseWord);
    }
}

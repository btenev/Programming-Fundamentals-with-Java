import java.util.Scanner;

public class P4_Text_Filter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] forbiddenWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();
        for (String forbiddenWord : forbiddenWords) {
                String wordToReplace = covertForbiddenWord(forbiddenWord);
                text = text.replace(forbiddenWord, wordToReplace);
        }
        System.out.println(text);
    }

    private static String covertForbiddenWord(String forbiddenWord) {
        String result = "";
        for (int i = 0; i < forbiddenWord.length(); i++) {
            result += "*";
        }
        return result;
    }
}

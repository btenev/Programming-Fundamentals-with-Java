import java.util.Locale;
import java.util.Scanner;

public class PF_02_Vowels_Count {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().toLowerCase(Locale.ROOT);
        printCountOfVowels(text);
    }

    private static void printCountOfVowels(String text) {
        int countVowels = 0;
        for (int i = 0; i <= text.length() - 1; i++) {
            char vowels = text.charAt(i);
            switch (vowels) {
                case 'a':
                case 'e':
                case 'o':
                case 'u':
                case 'i':
                    countVowels++;
                    break;
//            if (vowels == 'a') {
//                countVowels++;
//            } else if (vowels == 'e') {
//                countVowels++;
//            } else if (vowels == 'o') {
//                countVowels++;
//            } else if (vowels == 'u') {
//                countVowels++;
//            } else if (vowels == 'i') {
//                countVowels++;
            }

        }
        System.out.println(countVowels);
    }
}
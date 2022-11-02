import java.util.Scanner;

public class P4_Morse_Code_Translator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String morseCodeMessage = scanner.nextLine();

        if (morseCodeMessage.contains("--..")) {
            morseCodeMessage = morseCodeMessage.replace("--..", "Z");
        }
        if (morseCodeMessage.contains("-.--")) {
            morseCodeMessage = morseCodeMessage.replace("-.--", "Y");
        }
        if (morseCodeMessage.contains("-..-")) {
            morseCodeMessage = morseCodeMessage.replace("-..-", "X");
        }
        if (morseCodeMessage.contains("...-")) {
            morseCodeMessage = morseCodeMessage.replace("...-", "V");
        }
        if (morseCodeMessage.contains("-...")) {
            morseCodeMessage = morseCodeMessage.replace("-...", "B");
        }
        if (morseCodeMessage.contains("-.-.")) {
            morseCodeMessage = morseCodeMessage.replace("-.-.", "C");
        }
        if (morseCodeMessage.contains("..-.")) {
            morseCodeMessage = morseCodeMessage.replace("..-.", "F");
        }
        if (morseCodeMessage.contains("....")) {
            morseCodeMessage = morseCodeMessage.replace("....", "H");
        }
        if (morseCodeMessage.contains(".---")) {
            morseCodeMessage = morseCodeMessage.replace(".---", "J");
        }
        if (morseCodeMessage.contains(".-..")) {
            morseCodeMessage = morseCodeMessage.replace(".-..", "L");
        }
        if (morseCodeMessage.contains(".--.")) {
            morseCodeMessage = morseCodeMessage.replace(".--.", "P");
        }
        if (morseCodeMessage.contains("--.-")) {
            morseCodeMessage = morseCodeMessage.replace("--.-", "Q");
        }
        if (morseCodeMessage.contains("-..")) {
            morseCodeMessage = morseCodeMessage.replace("-..", "D");
        }
        if (morseCodeMessage.contains("--.")) {
            morseCodeMessage = morseCodeMessage.replace("--.", "G");
        }
        if (morseCodeMessage.contains("-.-")) {
            morseCodeMessage = morseCodeMessage.replace("-.-", "K");
        }
        if (morseCodeMessage.contains("---")) {
            morseCodeMessage = morseCodeMessage.replace("---", "O");
        }
        if (morseCodeMessage.contains(".-.")) {
            morseCodeMessage = morseCodeMessage.replace(".-.", "R");
        }
        if (morseCodeMessage.contains("...")) {
            morseCodeMessage = morseCodeMessage.replace("...", "S");
        }
        if (morseCodeMessage.contains("..-")) {
            morseCodeMessage = morseCodeMessage.replace("..-", "U");
        }
        if (morseCodeMessage.contains(".--")) {
            morseCodeMessage = morseCodeMessage.replace(".--", "W");
        }
        if (morseCodeMessage.contains(".-")) {
            morseCodeMessage = morseCodeMessage.replace(".-", "A");
        }
        if (morseCodeMessage.contains("..")) {
            morseCodeMessage = morseCodeMessage.replace("..", "I");
        }
        if (morseCodeMessage.contains("--")) {
            morseCodeMessage = morseCodeMessage.replace("--", "M");
        }
        if (morseCodeMessage.contains("-.")) {
            morseCodeMessage = morseCodeMessage.replace("-.", "N");
        }
        if (morseCodeMessage.contains(".")) {
            morseCodeMessage = morseCodeMessage.replace(".", "E");
        }
        if (morseCodeMessage.contains("-")) {
            morseCodeMessage = morseCodeMessage.replace("-", "T");
        }

        morseCodeMessage = morseCodeMessage.replace(" ", "");
        morseCodeMessage = morseCodeMessage.replace("|", " ");
        System.out.println(morseCodeMessage);
    }
}

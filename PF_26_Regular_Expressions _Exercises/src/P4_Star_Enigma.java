import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P4_Star_Enigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "@(?<planet>[A-Za-z]+)[^@!:>\\-]*:(?<population>[0-9]+)[^@!:>\\-]*!(?<attackType>[AD])![^@!:>\\-]*->(?<soldierCount>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();
        int numberOfMessages = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= numberOfMessages; i++) {
            String message = scanner.nextLine();
            int count = countLetters(message);
            String decryptedMessage = decryptMessage(message, count);
            Matcher matcher = pattern.matcher(decryptedMessage);
            if (matcher.find()) {
                if (matcher.group("attackType").equals("A")) {
                    attacked.add(matcher.group("planet"));
                } else if (matcher.group("attackType").equals("D")) {
                    destroyed.add(matcher.group("planet"));
                }
            }
        }
        System.out.println("Attacked planets: " + attacked.size());
        /*attacked.stream().sorted(Comparator.naturalOrder()).forEach(e -> System.out.println("-> " + e));*/
        Collections.sort(attacked);
        attacked.forEach(e -> System.out.println("-> " + e));
        System.out.println("Destroyed planets: " + destroyed.size());
        Collections.sort(destroyed);
        /*destroyed.stream().sorted(Comparator.naturalOrder()).forEach(e -> System.out.println("-> " + e));*/
        destroyed.forEach(e -> System.out.println("-> " + e));
    }

    private static String decryptMessage(String message, int count) {
        StringBuilder decryptedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char encryptedLetter = message.charAt(i);
            decryptedMessage.append((char) (encryptedLetter - count));
        }
        return decryptedMessage.toString();
    }

    private static int countLetters(String message) {
        int result = 0;
        for (int j = 0; j < message.length(); j++) {
            char current = message.charAt(j);
            switch (current) {
                case 'S':
                case 's':
                case 'T':
                case 't':
                case 'A':
                case 'a':
                case 'R':
                case 'r':
                    result++;
                    break;
            }
        }
        return result;
    }
}

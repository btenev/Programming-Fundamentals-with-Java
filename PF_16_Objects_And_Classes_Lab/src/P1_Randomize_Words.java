import java.util.Random;
import java.util.Scanner;

public class P1_Randomize_Words {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");
        Random random = new Random();
        for (int pos1 = 0; pos1 < words.length; pos1++) {
            int pos2 = random.nextInt(words.length);
            String a = words[pos1];
            String b = words[pos2];
            words[pos1] = b;
            words[pos2] = a;

        }
        System.out.println(String.join(System.lineSeparator(), words));
    }
}

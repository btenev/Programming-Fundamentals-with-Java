import java.util.Scanner;

public class P7_String_Explosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        int explosionStrength = 0;
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (Character.isLetter(current) || current == '_') {
                if (explosionStrength == 0) {
                    sb.append(current);
                } else {
                    explosionStrength--;

                }
            } else if (current == '>') {
                sb.append(current);
                char nextSymbol = input.charAt(i + 1);
                explosionStrength += nextSymbol - 48;
                i++;
                if (explosionStrength > 0) {
                    explosionStrength--;
                }
            }
        }
        System.out.println(sb);
    }
}


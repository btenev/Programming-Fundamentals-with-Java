import java.util.Scanner;

public class PF_07_Repeat_String {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        String result = repeatString(text, n);
        System.out.println(result);
    }

    private static String repeatString(String text, int n) {
        String concatenated = "";
        for (int i = 1; i <= n; i++) {
            concatenated += text;

        }
        return concatenated;
    }
}

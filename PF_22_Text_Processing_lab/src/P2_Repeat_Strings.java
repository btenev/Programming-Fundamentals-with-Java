import java.util.Scanner;

public class P2_Repeat_Strings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
//        String result = "";
//        for (String word : input) {
//            for (int j = 0; j < word.length(); j++) {
//                result += word;
//            }
//        }
//        System.out.println(result);
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : input) {
            int count = word.length();
            for (int i = 0; i < count; i++) {
                stringBuilder.append(word);
            }
        }
        System.out.println(stringBuilder);
    }
}

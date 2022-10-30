import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1_Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String text = scanner.nextLine();

        String result = "";
        for (int element = 0; element < numbers.size(); element++) {
            int currentElement = numbers.get(element);
            int sum = 0;
            while (currentElement > 0) {
                int digit = currentElement % 10;
                sum += digit;
                currentElement /= 10;
            }

            int index = 0;
            if (sum >= text.length()) {
                index = sum - text.length();
            } else {
                index = sum;
            }
            result += text.charAt(index);
            StringBuilder remove = new StringBuilder(text);
            remove.deleteCharAt(index);
            text = remove.toString();
        }
        System.out.println(result);
    }
}


import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1_Sum_Adjacent_Equal_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        List<Double> number = Arrays.stream(text.split(" ")).map(Double::parseDouble).collect(Collectors.toList());

        for (int i = 0; i < number.size() - 1; i++) {

           if (number.get(i).equals(number.get(i + 1))) {
               number.set(i,(number.get(i) + number.get(i + 1)));
               number.remove(i + 1);
               i = -1;
           }
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.#");
        for (int j = 0; j < number.size(); j++) {
            System.out.print(decimalFormat.format(number.get(j)) + " ");
        }

    }
}

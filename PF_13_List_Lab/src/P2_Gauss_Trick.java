import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P2_Gauss_Trick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        List<Integer> number = Arrays.stream(text.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int size = number.size();
        for (int i = 0; i < size / 2; i++) {
            number.set(i,number.get(i) + number.get(number.size() - 1));
            number.remove(number.size() - 1);
        }
        for (int num : number) {
            System.out.print(num + " ");
        }
    }
}

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P5_Bomb_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int specialNumber = tokens[0];
        int power = tokens[1];

        while (numbers.contains(specialNumber)) {
            int indexSpecialNumber = numbers.lastIndexOf(specialNumber);

            int leftSide = Math.max(0,indexSpecialNumber - power);
            int rightSide = Math.min(numbers.size() - 1, indexSpecialNumber + power);
            for (int i = rightSide; i >= leftSide; i--) {
                numbers.remove(i);
            }
        }
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }
}

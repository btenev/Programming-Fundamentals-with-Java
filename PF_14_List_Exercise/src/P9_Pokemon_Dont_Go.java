import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P9_Pokemon_Dont_Go {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int sum = 0;
        while (!list.isEmpty()) {
            int index = Integer.parseInt(scanner.nextLine());
            int numberToRemove = 0;
            if (index < 0) {
                numberToRemove = list.get(0);
                list.remove(0);
                list.add(0, list.get(list.size() -1));
            } else if (index > list.size() - 1) {
                numberToRemove = list.get(list.size() -1);
                list.remove(list.size() - 1);
                list.add (list.get(0));
            } else {
                numberToRemove = list.get(index);
                list.remove(index);
            }

            sum += numberToRemove;

            for (int i = 0; i < list.size(); i++) {
                int currentNumber = list.get(i);
                if (currentNumber <= numberToRemove) {
                    list.set(i, currentNumber + numberToRemove);
                } else {
                    list.set(i, currentNumber - numberToRemove);
                }
            }
        }
        System.out.println(sum);
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P3_Merging_Lists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> first = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> second = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();
        if (first.size() > second.size()) {
            for (int i = 0; i < second.size(); i++) {
                result.add(first.get(i));
                result.add(second.get(i));
            }
            for (int j = second.size(); j < first.size(); j++) {
                result.add(first.get(j));
            }
        } else {
            for (int i = 0; i < first.size(); i++) {
                result.add(first.get(i));
                result.add(second.get(i));
            }
            for (int j = first.size(); j < second.size(); j++) {
                result.add(second.get(j));
            }
        }
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

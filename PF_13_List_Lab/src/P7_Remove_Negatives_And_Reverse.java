import java.util.*;

public class P7_Remove_Negatives_And_Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(""))
//                .map(Integer::parseInt).collect(Collectors.toList());
        String[] text = scanner.nextLine().split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < text.length; i++) {
            int currentNumber = Integer.parseInt(text[i]);
            numbers.add(currentNumber);
        }
        for (int j = 0; j < numbers.size(); j++) {
            if (numbers.get(j) < 0) {
                numbers.remove(j);
                j--;
            }
        }
        if (numbers.isEmpty()) {
            System.out.println("empty");
        }
        Collections.reverse(numbers);
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}

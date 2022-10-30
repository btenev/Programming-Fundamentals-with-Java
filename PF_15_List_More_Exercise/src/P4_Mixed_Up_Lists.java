import java.util.*;
import java.util.stream.Collectors;

public class P4_Mixed_Up_Lists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> arrayOne = Arrays.stream(scanner.nextLine().split("\\s+"))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList());
        List<Integer> arrayTwo = Arrays.stream(scanner.nextLine().split("\\s+"))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList());
        //int endIndex = 0;
        int startIndex = 0;

        if (arrayOne.size() > arrayTwo.size()) {
            //endIndex = arrayOne.size();
            startIndex = arrayTwo.size();
        } else if (arrayTwo.size() > arrayOne.size()){
            //endIndex = arrayTwo.size();
            startIndex = arrayOne.size();
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < startIndex; i++) {
            result.add(arrayOne.get(0));
            arrayOne.remove(arrayOne.get(0));
            result.add(arrayTwo.get(arrayTwo.size() - 1));
            arrayTwo.remove(arrayTwo.get(arrayTwo.size() - 1));
        }

        boolean arrayOneIsEmpty = arrayOne.isEmpty();
        int indexOne = 0;
        int indexTwo = 0;
        if (arrayOneIsEmpty) {
            if (arrayTwo.get(0) > arrayTwo.get(1)) {
                indexOne = arrayTwo.get(1);
                indexTwo = arrayTwo.get(0);
            } else {
                indexOne = arrayTwo.get(0);
                indexTwo = arrayTwo.get(1);
            }
        } else {
            if (arrayOne.get(0) > arrayOne.get(1)) {
                indexOne = arrayOne.get(1);
                indexTwo = arrayOne.get(0);
            } else {
                indexOne = arrayOne.get(0);
                indexTwo = arrayOne.get(1);
            }
        }
        for (int j = 0; j < result.size(); j++) {
            int currentNum = result.get(j);
            if (!(currentNum > indexOne) || !(currentNum < indexTwo)) {
                result.remove(result.get(j));
                j--;
            }
        }
        Collections.sort(result);
        System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
    }
}

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P4_List_Operations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String commandWord = tokens[0];
            switch (commandWord) {
                case "Add":
                    int numberToAdd = Integer.parseInt(tokens[1]);
                    numbers.add(numberToAdd);
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(tokens[1]);
                    if(indexIsValid(indexToRemove,numbers.size())) {
                        numbers.remove(indexToRemove);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    String direction = tokens[1];
                    int timesToShift = Integer.parseInt(tokens[2]);
                    if (direction.equals("left")) {
                        shiftLeft(numbers, timesToShift);
                    } else if (direction.equals("right")) {
                       shiftRight(numbers, timesToShift);
                    }
                    break;
                case "Insert":
                    int number = Integer.parseInt(tokens[1]);
                    int index = Integer.parseInt(tokens[2]);
                    if (indexIsValid(index, numbers.size())) {
                        numbers.add(index, number);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void shiftRight(List<Integer> numbers, int timesToShift) {
        for (int i = 0; i < timesToShift; i++) {
            numbers.add(0,numbers.get(numbers.size() - 1));
            numbers.remove(numbers.size() - 1);
        }
    }

    private static void shiftLeft(List<Integer> numbers, int timesToShift) {
        for (int i = 0; i < timesToShift; i++) {
            numbers.add(numbers.get(0));
            numbers.remove(numbers.get(0));
        }
    }

    public static boolean indexIsValid(int index, int size) {
        return index >= 0 && index <= size - 1;
    }
}

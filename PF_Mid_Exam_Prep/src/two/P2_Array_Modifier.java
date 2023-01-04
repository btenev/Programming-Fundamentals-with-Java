package two;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P2_Array_Modifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> arrayOfIntegers = Arrays.stream(scanner.nextLine().split("\\s+"))
                                        .map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "swap":
                    int indexOne = Integer.parseInt(tokens[1]);
                    int indexTwo = Integer.parseInt(tokens[2]);
                    int elementOne = arrayOfIntegers.get(indexOne);
                    int elementTwo = arrayOfIntegers.get(indexTwo);
                    arrayOfIntegers.set(indexTwo,elementOne);
                    arrayOfIntegers.set(indexOne,elementTwo);
                    break;
                case "multiply":
                    int indexOneMultiply = Integer.parseInt(tokens[1]);
                    int indexTwoMultiply = Integer.parseInt(tokens[2]);
                    int elementOneMultiply = arrayOfIntegers.get(indexOneMultiply);
                    int elementTwoMultiply = arrayOfIntegers.get(indexTwoMultiply);
                    int newElement = elementOneMultiply * elementTwoMultiply;
                    arrayOfIntegers.set(indexOneMultiply,newElement);
                    break;
                case "decrease":
                    for (int i = 0; i < arrayOfIntegers.size(); i++) {
                        arrayOfIntegers.set(i, arrayOfIntegers.get(i) - 1);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < arrayOfIntegers.size() - 1; i++) {
            System.out.print(arrayOfIntegers.get(i) + ", ");
        }
        System.out.print(arrayOfIntegers.get(arrayOfIntegers.size() - 1));
    }
}

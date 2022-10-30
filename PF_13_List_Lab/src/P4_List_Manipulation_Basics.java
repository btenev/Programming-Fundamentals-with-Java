import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P4_List_Manipulation_Basics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] currentInstruction = command.split("\\s+");
            String currentCommand = currentInstruction[0];


            switch (currentCommand) {
                case "Add":
                    int numberToAdd = Integer.parseInt(currentInstruction[1]);
                    numbers.add(numberToAdd);
                    break;
                case "Remove":
                    int numberToRemove = Integer.parseInt(currentInstruction[1]);
                    numbers.remove(Integer.valueOf(numberToRemove));
                    break;
                case "RemoveAt":
                    int indexToRemove = Integer.parseInt(currentInstruction[1]);
                    numbers.remove(indexToRemove);
                    break;
                case "Insert":
                    int numberToInsert = Integer.parseInt(currentInstruction[1]);
                    int index = Integer.parseInt(currentInstruction[2]);
                    numbers.add(index, numberToInsert);
                    break;
            }
            command = scanner.nextLine();
        }
//        for (int num : numbers) {
//            System.out.print(num + " ");
//        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]",""));
    }
}

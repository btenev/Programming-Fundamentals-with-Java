import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P2_Change_List {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        List<String> inputList = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            inputList.add(input[i]);
        }
        String command = scanner.nextLine();
        while(!command.equals("end")) {
            String[] commandElements = command.split("\\s+");
            switch (commandElements[0]) {
                case "Delete":
                    for (int j = 0; j < inputList.size(); j++) {
                        inputList.remove(String.valueOf(commandElements[1]));
                    }
                    break;
                case "Insert":
                    int insertToPosition = Integer.parseInt(commandElements[2]);
                    inputList.add(insertToPosition,commandElements[1]);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(inputList.toString().replaceAll("[\\[\\],]",""));
    }
}

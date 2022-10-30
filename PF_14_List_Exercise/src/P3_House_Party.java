import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P3_House_Party {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> names = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String currentName = input[0];
            String command = input[2];

            if(command.equals("going!")) {
                if(names.contains(currentName)) {
                    System.out.printf("%s is already in the list!%n",currentName);
                } else {
                    names.add(currentName);
                }
            } else if (command.equals("not")) {
                if(names.contains(currentName)){
                    names.remove(currentName);
                } else {
                    System.out.printf("%s is not in the list!%n", currentName);
                }
            }
        }
        for (String name : names) {
            System.out.println(name);
        }

    }
}



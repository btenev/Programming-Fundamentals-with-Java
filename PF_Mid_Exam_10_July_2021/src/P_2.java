import java.util.Scanner;

public class P_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(",\\s+");
        String input = scanner.nextLine();

        while (!input.equals("Report")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Blacklist":
                    String name = tokens[1];
                    boolean nameFound = false;
                    for (int i = 0; i < names.length; i++) {
                        if (name.equals(names[i])) {
                            names[i] = "Blacklisted";
                            nameFound = true;
                            System.out.println(name + " was blacklisted.");
                        }
                    }
                    if (!nameFound) {
                        System.out.println(name + " was not found.");
                    }
                    break;
                case "Error":
                    int index = Integer.parseInt(tokens[1]);
                    if (isValidIndex(index, names)) {
                        String nameError = names[index];
                            if (!nameError.equals("Blacklisted") && !nameError.equals("Lost")) {
                                names[index] = "Lost";
                                System.out.println(nameError + " was lost due to an error.");
                            }
                    }
                    break;
                case "Change":
                    int indexChange = Integer.parseInt(tokens[1]);
                    String newName = tokens[2];
                    if (isValidIndex(indexChange,names)) {
                        String oldName = names[indexChange];
                        names[indexChange]= newName;
                        System.out.println(oldName + " changed his username to " + newName + ".");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        int countBlacklisted = 0;
        int countLost = 0;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals("Blacklisted")) {
                countBlacklisted++;
            } else if (names[i].equals("Lost")) {
                countLost++;
            }
        }
        System.out.println("Blacklisted names: " + countBlacklisted);
        System.out.println("Lost names: " + countLost);
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println();
    }
    private static boolean isValidIndex (int index, String[] names) {
        return index >= 0 && index <= names.length - 1;
    }
}

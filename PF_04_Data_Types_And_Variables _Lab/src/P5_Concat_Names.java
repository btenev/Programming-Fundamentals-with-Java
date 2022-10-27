import java.util.Scanner;

public class P5_Concat_Names {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String secondName = scanner.nextLine();
        String delimiter = scanner.nextLine();

        String all = firstName + delimiter + secondName;
        System.out.println(all);

    }
}

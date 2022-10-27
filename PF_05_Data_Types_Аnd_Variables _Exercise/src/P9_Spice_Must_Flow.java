import java.util.Scanner;

public class P9_Spice_Must_Flow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int yield = Integer.parseInt(scanner.nextLine());
        int countDays = 0;
        int extracted = 0;
        while(yield >= 100) {
            extracted += yield - 26;

            countDays++;
            yield -= 10;
        }
        if (extracted >= 26) {
            extracted -= 26;
        } else {
            extracted = 0;
        }


        System.out.println(countDays);
        System.out.println(extracted);
    }
}

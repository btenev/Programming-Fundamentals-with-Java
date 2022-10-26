import java.util.Scanner;

public class P4_Back_In_30_Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int totalMinutes = (hours * 60) + minutes + 30;

        int hoursOutput = totalMinutes / 60;
        int minutesOutput = totalMinutes % 60;

        if (minutesOutput > 59) {
            hoursOutput += 1;
        }
        if (hoursOutput > 23) {
            hoursOutput = 0;
        }

        System.out.printf("%d:%02d", hoursOutput, minutesOutput);
    }
}

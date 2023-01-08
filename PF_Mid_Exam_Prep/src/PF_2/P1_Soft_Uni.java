package two;

import java.util.Scanner;

public class P1_Soft_Uni {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int employOneEfficiency = Integer.parseInt(scanner.nextLine());
        int employTwoEfficiency = Integer.parseInt(scanner.nextLine());
        int employThreeEfficiency = Integer.parseInt(scanner.nextLine());
        int studentCount = Integer.parseInt(scanner.nextLine());
        int allEmployEfficiency = employOneEfficiency + employTwoEfficiency + employThreeEfficiency;
        int countHours = 0;

        while (studentCount > 0) {
            countHours++;
            if (countHours % 4 != 0) {
                studentCount -= allEmployEfficiency;
            }
        }
        System.out.println("Time needed: " + countHours + "h.");
    }
}

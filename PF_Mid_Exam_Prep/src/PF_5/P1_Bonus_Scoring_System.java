package P_5;

import java.util.Scanner;

public class P1_Bonus_Scoring_System {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfStudents = Integer.parseInt(scanner.nextLine());
        int countOfLecturers = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());
        double maxBonus = 0;
        int numberOfAttendances = 0;

        for (int i = 1; i <= countOfStudents; i++) {
            int studentAttendance = Integer.parseInt(scanner.nextLine());
            double totalBonus = (1.0 * studentAttendance / countOfLecturers) * (5 + additionalBonus);
            if (totalBonus > maxBonus) {
                maxBonus = totalBonus;
                numberOfAttendances = studentAttendance;
            }
        }
        System.out.printf("Max Bonus: %.0f.%n",Math.ceil(maxBonus));
        System.out.println("The student has attended " + numberOfAttendances + " lectures.");
    }
}

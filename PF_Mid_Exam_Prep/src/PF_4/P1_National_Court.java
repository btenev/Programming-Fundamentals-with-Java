package P_4;

import java.util.Scanner;

public class P1_National_Court {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int servicedPeopleEmployOne = Integer.parseInt(scanner.nextLine());
        int servicedPeopleEmployTwo = Integer.parseInt(scanner.nextLine());
        int servicedPeopleEmployThree = Integer.parseInt(scanner.nextLine());
        int peopleToBeServiced = Integer.parseInt(scanner.nextLine());
        int countHours = 0;
        int totalProductivity = servicedPeopleEmployOne + servicedPeopleEmployTwo + servicedPeopleEmployThree;

        while(peopleToBeServiced > 0) {
            countHours += 1;
            if (!(countHours % 4 == 0)) {
                peopleToBeServiced -= totalProductivity;
            }
        }
        System.out.println("Time needed: " + countHours + "h" +".");
    }
}

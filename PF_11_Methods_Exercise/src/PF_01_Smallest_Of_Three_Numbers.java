import java.util.Scanner;

public class PF_01_Smallest_Of_Three_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOne = Integer.parseInt(scanner.nextLine());
        int numTwo = Integer.parseInt(scanner.nextLine());
        int numThree = Integer.parseInt(scanner.nextLine());
        printSmallestNumber(numOne,numTwo,numThree);
    }

    private static void printSmallestNumber(int numOne, int numTwo, int numThree) {
        if (numOne <= numTwo && numOne <= numThree) {
            System.out.println(numOne);
        } else if (numTwo <= numThree && numTwo <= numOne) {
            System.out.println(numTwo);
        } else  {
            System.out.println(numThree);
        }
    }
}

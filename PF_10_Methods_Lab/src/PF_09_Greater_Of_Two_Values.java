import java.util.Scanner;

public class PF_09_Greater_Of_Two_Values {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        switch (text) {
            case "int":
                int numOne = Integer.parseInt(scanner.nextLine());
                int numTwo = Integer.parseInt(scanner.nextLine());
                int biggerNum = getMax(numOne, numTwo);
                System.out.println(biggerNum);
                break;
            case "char":
                char one = scanner.nextLine().charAt(0);
                char two = scanner.nextLine().charAt(0);
                char biggerChar = getMax(one, two);
                System.out.println(biggerChar);
                break;
            case "string":
                String first = scanner.nextLine();
                String second = scanner.nextLine();
                String biggerString = getMax(first, second);
                System.out.println(biggerString);
                break;
        }
    }

    private static int getMax(int numOne, int numTwo) {
        if (numOne > numTwo) {
            return numOne;
        }
        return numTwo;
    }

    private static char getMax(char one, char two) {
        if (one > two) {
            return one;
        }
        return two;
    }

    private static String getMax(String first, String second) {
        if (first.compareTo(second) >= 0) {
            return first;
        }
        return second;
    }
}


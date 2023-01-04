package two;

import java.util.Arrays;
import java.util.Scanner;

public class P3_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sequenceOfIntegers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        double sumAllNumbers = 0;
        int count = 0;
        for (int i = 0; i < sequenceOfIntegers.length; i++) {
            sumAllNumbers += sequenceOfIntegers[i];
            count++;
        }
        int[] topNumbers = new int[sequenceOfIntegers.length];
        double averageNumber = sumAllNumbers / count;
        int countTopIntegers = 0;
        for (int j = 0; j < sequenceOfIntegers.length; j++) {
            if (sequenceOfIntegers[j] > averageNumber) {
                topNumbers[j] = sequenceOfIntegers[j];
                countTopIntegers++;
            }
        }
        if (countTopIntegers == 0) {
            System.out.println("No");
        } else {
            Arrays.sort(topNumbers);
            int countStop = 5;
            for (int g = topNumbers.length - 1; g >= 0; g--) {
                if (topNumbers[g] != 0) {
                    System.out.print(topNumbers[g] + " ");
                    countStop--;
                    if(countStop == 0) {
                        break;
                    }
                }
            }
        }
    }
}

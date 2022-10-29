import java.util.Arrays;
import java.util.Scanner;

public class PF_11_Array_Manipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] data = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String command = input.split("\\s+")[0];
            switch (command) {
                case "exchange":
                    data = exchangeDigits(input, data);
                    break;
                case "max":
                    printMaxNumber(input, data);
                    break;
                case "min":
                    printMinNumber(input, data);
                    break;
                case "first":
                    printFistElements(input, data);
                    break;
                case "last":
                    printLastElements(input, data);
                    break;
            }
            input = scanner.nextLine();
        }
        String[] temporaryEnd = Arrays.stream(data).mapToObj(String::valueOf).toArray(String[]::new);
        System.out.print(Arrays.toString(temporaryEnd));
    }

    private static boolean isValidIndex(int index, int[] data) {
        return index >= 0 && index <= data.length - 1;
    }
    private static boolean countIsValid (int count, int [] data) {
        return count <= data.length;
    }
    public static int[] exchangeDigits(String input, int[] data) {
        int index = Integer.parseInt(input.split("\\s+")[1]);
        if (isValidIndex(index, data)) {
            int count = 0;
            int[] temporaryArray = new int[data.length];
            for (int i = index + 1; i < data.length; i++) {
                temporaryArray[i - (index + 1)] = data[i];
                count++;
            }
            for (int j = 0; j <= index; j++) {
                temporaryArray[count + j] = data[j];
            }
            data = temporaryArray;
        } else {
            System.out.println("Invalid index");
        }
        return data;
    }

    private static void printMaxNumber(String input, int[] data) {
        String evenOrOddMax = input.split("\\s+")[1];
        int max = Integer.MIN_VALUE;
        int indexMax = 0;
        boolean noMatches = true;
        if (evenOrOddMax.equals("even")) {
            for (int i = 0; i < data.length; i++) {
                if (data[i] % 2 == 0) {
                    if (data[i] >= max) {
                        max = data[i];
                        indexMax = i;
                        noMatches = false;
                    }
                }
            }
        } else {
            for (int i = 0; i < data.length; i++) {
                if (data[i] % 2 != 0) {
                    if (data[i] >= max) {
                        max = data[i];
                        indexMax = i;
                        noMatches = false;
                    }
                }
            }
        }
        if (noMatches) {
            System.out.println("No matches");
        } else {
            System.out.println(indexMax);
        }

    }

    private static void printMinNumber(String input, int[] data) {
        String evenOrOddMin = input.split("\\s+")[1];
        int min = Integer.MAX_VALUE;
        int indexMin = 0;
        boolean noMatches = true;
        if (evenOrOddMin.equals("even")) {
            for (int i = 0; i < data.length; i++) {
                if (data[i] % 2 == 0) {
                    if (data[i] <= min) {
                        min = data[i];
                        indexMin = i;
                        noMatches = false;
                    }
                }
            }
        } else {
            for (int i = 0; i < data.length; i++) {
                if (data[i] % 2 != 0) {
                    if (data[i] <= min) {
                        min = data[i];
                        indexMin = i;
                        noMatches = false;
                    }
                }
            }
        }
        if (noMatches) {
            System.out.println("No matches");
        } else {
            System.out.println(indexMin);
        }
    }

    public static void printFistElements(String input, int[] data) {
        int count = Integer.parseInt(input.split("\\s+")[1]);
        String evenOrOdd = input.split("\\s+")[2];
        if (countIsValid(count, data)) {
            int[] numbers = new int[count];
            int n = 0;
            if (evenOrOdd.equals("even")) {
                for (int i = 0; i < data.length; i++) {
                    if (data[i] % 2 == 0) {
                        numbers[n] = data[i];
                        n++;
                        if(isEnough(count, n)) {
                            break;
                        }
                    }
                }

            } else {
                for (int i = 0; i < data.length; i++) {
                    if (data[i] % 2 != 0) {
                        numbers[n] = data[i];
                        n++;
                        if(isEnough(count, n)) {
                            break;
                        }
                    }
                }
            }
            if (n == 0) {
                System.out.println("[]");
            } else {
                String[] temporary = Arrays.stream(numbers).filter(e -> e != 0).mapToObj(String::valueOf).toArray(String[]::new);
                System.out.println(Arrays.toString(temporary));
            }
        } else {
            System.out.println("Invalid count");
        }

    }

    private static boolean isEnough (int count, int n) {
        return count == n;
    }
    private static void printLastElements (String input, int[] data) {
        int count = Integer.parseInt(input.split("\\s+")[1]);
        String evenOrOdd = input.split("\\s+")[2];
        if (countIsValid(count, data)) {
            int[] numbers = new int[count];
            int n = 0;
            if (evenOrOdd.equals("even")) {
                for (int i = data.length - 1; i >= 0; i--) {
                    if (data[i] % 2 == 0) {
                        numbers[n] = data[i];
                        n++;
                        if(isEnough(count, n)) {
                            break;
                        }
                    }
                }

            } else {
                for (int i = data.length - 1; i >= 0; i--) {
                    if (data[i] % 2 != 0) {
                        numbers[n] = data[i];
                        n++;
                        if(isEnough(count, n)) {
                            break;
                        }
                    }
                }
            }
            if (n == 0) {
                System.out.println("[]");
            } else {
                String[] temporaryLast = Arrays.stream(numbers).filter(e-> e != 0)
                                .mapToObj(String::valueOf).toArray(String[]::new);
                String[] reverse = new String[temporaryLast.length];

                for (int i = 0; i <= reverse.length - 1 ; i++) {
                    reverse[i] = temporaryLast[temporaryLast.length - (i + 1)];
                }
                temporaryLast = reverse;
                System.out.println(Arrays.toString(temporaryLast));
            }
        } else {
            System.out.println("Invalid count");
        }

    }

}



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P5_List_Manipulation_Advanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> number = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String token = scanner.nextLine();

        while (!token.equals("end")) {
            String[] currentToken = token.split("\\s+");
            String command = currentToken[0];

            switch (command) {
                case "Contains":
                    int num = Integer.parseInt(currentToken[1]);
                    boolean isAvailable = number.contains(num);
                    if (isAvailable) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    String evenOrOdd = currentToken[1];
                    List<Integer> even = new ArrayList<>();
                    List<Integer> odd = new ArrayList<>();
                    if (evenOrOdd.equals("even")) {
                        for (int i = 0; i < number.size(); i++) {
                            int currentNum = number.get(i);
                            if (currentNum % 2 == 0) {
                                even.add(currentNum);
                            }
                        }
                        System.out.print(even.toString().replaceAll("[\\[\\],]", ""));
                        System.out.println();
                    } else if (evenOrOdd.equals("odd")) {
                        for (int j = 0; j < number.size(); j++) {
                            if (number.get(j) % 2 != 0) {
                                odd.add(number.get(j));
                            }
                        }
                        System.out.print(odd.toString().replaceAll("[\\[\\],]", ""));
                        System.out.println();
                    }
                    break;
                case "Get":
                    int sum = 0;
                    for (int i = 0; i < number.size(); i++) {
                        sum += number.get(i);
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    String comparison = currentToken[1];
                    int index = Integer.parseInt(currentToken[2]);
                    List<Integer> biggerComparison = new ArrayList<>();
                    if (comparison.equals(">=")) {
                        for (int i = 0; i < number.size(); i++) {
                            if (number.get(i) >= index) {
                                biggerComparison.add(number.get(i));
                            }
                        }
                    } else if (comparison.equals("<=")){
                        for (int j = 0; j < number.size(); j++) {
                            if (number.get(j) <= index) {
                                biggerComparison.add(number.get(j));
                            }
                        }
                    } else if (comparison.equals(">")) {
                        for (int j = 0; j < number.size(); j++) {
                            if (number.get(j) > index) {
                                biggerComparison.add(number.get(j));
                            }
                        }
                    } else if (comparison.equals("<")) {
                        for (int j = 0; j < number.size(); j++) {
                            if (number.get(j) < index) {
                                biggerComparison.add(number.get(j));
                            }
                        }
                    }
                    System.out.print(biggerComparison.toString().replaceAll("[\\[\\],]", ""));
                    System.out.println();
                    break;
            }
            token = scanner.nextLine();
        }
    }
}


import java.util.Scanner;

public class P4_Array_Rotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(" ");
        int rotations = Integer.parseInt(scanner.nextLine());

        for (int start = 1; start <= rotations; start++) {
            String[] temp = new String[numbers.length];  // създаваме временен стринг масив - контейнер
            for (int i = 1; i < numbers.length; i++) { // итерираме от първият до последният елемент
                temp[i - 1] = numbers[i];              // нулевият временен елемент = първият елемент от намбърс масива
            }
            temp[numbers.length - 1] = numbers[0];     // последният елемент от временият масив равен на първият от намбърс масива
            numbers = temp;
        }
        for (String number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

    }
}

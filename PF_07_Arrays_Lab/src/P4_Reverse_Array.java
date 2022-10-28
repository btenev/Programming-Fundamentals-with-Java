import java.util.Scanner;

public class P4_Reverse_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String [] input = scanner.nextLine().split(" ");  // въвеждаме един стринг, който превръщаме в стрингов масив

        for (int i = 0; i < input.length / 2; i++) {  // въртим елементите от масива на база индекс до средата
            String temp = input [i]; // запазваме стойността на елемент i във временна променлива
            input [i] = input[input.length - 1 - i]; // сменяме стойността на i елемента с тази на противоположният елемент
            input[input.length -1 - i] = temp;      // сменяме сотойността на противоположният елемент с тази на i съдържаща се във темп
        }
        System.out.println(String.join(" ",  input)); // печатаме обърнатият стрингов масив във стринг със разстояние
    }
}

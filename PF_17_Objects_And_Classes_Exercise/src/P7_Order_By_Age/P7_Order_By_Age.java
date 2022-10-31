package P7_Order_By_Age;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class P7_Order_By_Age {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String data = scanner.nextLine();
        List<Person> people = new ArrayList<>();
        while (!data.equals("End")) {
            String name = data.split("\\s+")[0];
            String id = data.split("\\s+")[1];
            int age = Integer.parseInt(data.split("\\s+")[2]);

            Person person = new Person(name, id, age);
            people.add(person);
            data = scanner.nextLine();
        }
        people.sort(Comparator.comparing(Person::getAge));

        for (Person person : people) {
            System.out.println(person);
        }
    }
}

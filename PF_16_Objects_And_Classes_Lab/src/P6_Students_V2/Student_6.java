package P6_Students_V2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // John Smith 15 Sofia
        String input = scanner.nextLine();
        List<Student> students = new ArrayList<>();

        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            String hometown = tokens[3];
            if (!isStudentExisting(firstName, lastName, age, hometown, students)) {
                Student student = new Student(firstName, lastName, age, hometown);
                students.add(student);
            }
            input = scanner.nextLine();
        }
        String cityName = scanner.nextLine();

        for (Student student : students) {
            if (student.getHometown().equals(cityName)) {
                System.out.println(student);
            }
        }
    }

    private static boolean isStudentExisting(String firstName, String lastName, int age, String hometown, List<Student> students) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                student.setAge(age);
                student.setHometown(hometown);
                return true;
            }
        }

        return false;
    }
}

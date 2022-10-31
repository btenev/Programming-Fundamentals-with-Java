package P5_Students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class P5_Students {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String[] studentData = scanner.nextLine().split("\\s+");
            String firstName = studentData[0];
            String lastName = studentData[1];
            double grade = Double.parseDouble(studentData[2]);

            Student student = new Student(firstName, lastName, grade);
            students.add(student);
        }
        students.sort(Comparator.comparing(Student::getGrade).reversed());

        for (Student student : students) {
            System.out.println(student);
        }
    }
}

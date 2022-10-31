package P5_Students;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private String homeTown;

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + "is " + age + " years old";
    }

    public Student(String firstName, String lastName, int age, String homeTown) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.homeTown = homeTown;
    }

    public String getHomeTown() {
        return homeTown;
    }
}

package P7_Order_By_Age;

public class Person {
    private String name;
    private String id;
    private int age;

    public Person(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public int getAge () {
        return age;
    }

    @Override
    public String toString() {
        return name + " with ID: " + id + " is " + age + " years old.";

    }
}

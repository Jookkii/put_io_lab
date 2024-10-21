public class Person {
    // Attributes
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        if (age >= 0) { // Ensure age is not negative
            this.age = age;
        } else {
            System.out.println("Age cannot be negative.");
        }
    }

    // Method to display person's details
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    // Main method to test the class
    public static void main(String[] args) {
        Person person = new Person("Alice", 30);
        person.displayInfo();

        person.setAge(31);
        person.setName("Alice Smith");
        person.displayInfo();
    }
}

package packperson;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Roman", 20, "@roman.com", "14-41-14");

        System.out.println(person.email);
        System.out.println(person.getAge());
        System.out.println(person.getPhone());

        System.out.println();
        person.displayInfo();

        Employee employee = new Employee("Alex", 20, "@alex.com", "22-33-22");
        employee.displayInfo();
        employee.displayPhone();
    }
}


class Person {
    private String name;
    private int age;
    public String email;
    protected String phone;

    public Person(String name, int age, String email, String phone) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    private String getName() {
        return name;
    }

     int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    protected String getPhone() {
        return phone;
    }

    public void displayInfo() {
        System.out.println("Имя: " + getName());
        System.out.println("Возраст: " + getAge());
        System.out.println("Эл. почта: " + getEmail());
    }
}


class Employee extends Person {
    public Employee(String name, int age, String email, String phone) {
        super(name, age, email, phone);
    }

    void displayPhone() {
        System.out.println("Номер телефона: " + getPhone());
    }
}
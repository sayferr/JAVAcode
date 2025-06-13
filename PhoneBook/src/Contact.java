import java.io.Serializable;

public class Contact implements Serializable {
    private static int idCounter = 1;
    private int id;
    private String surname;
    private String name;
    private String phonenumber;
    private int age;

    public Contact(int id, String surname, String name, String phonenumber, int age){
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.phonenumber = phonenumber;
        this.age = age;
    }

    public Contact(String surname, String name, int age, String phonenumber) {
    }

    public int getId() { return id; }
    public String getSurname() { return surname; }
    public String getName() { return name; }
    public String getPhonenumber() { return phonenumber; }
    public int getAge() { return age; }

    public void setId(int id) { this.id = id; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setName(String name) { this.name = name; }
    public void setPhonenumber(String phonenumber) { this.phonenumber = phonenumber; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString(){
        return id + " ) " + surname + " " + name + " | " + age + " | " + phonenumber;
    }
}
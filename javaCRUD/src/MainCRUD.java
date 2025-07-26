import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainCRUD {
    static final String FILE_PATH = "persone.txt";
    static List<Person> people = new ArrayList<>();

    public static void main(String[] args){
        LoadFromFile();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("""
                    1 - ADD
                    2 - READ
                    3 - UPDATE
                    4 - DELETE
                    5 - EXIT
                    """);
            System.out.println("Choose option: ");
            String choice = scanner.nextLine();

            switch (choice){
                case "1" -> AddPerson(scanner);
                case "2" -> PrintAll();
                case "3" -> UpdatePerson(scanner);
                case "4" -> RemovePersone(scanner);
                case "5" -> {
                    SaveToFile();
                    System.out.println("Exiting.");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
    static void AddPerson(Scanner scanner){
        System.out.println("Enter name please: ");
        String name = scanner.nextLine();

        System.out.println("Enter surname: ");
        String surname = scanner.nextLine();

        System.out.println("Enter age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter email: ");
        String email = scanner.nextLine();

        people.add(new Person(name, surname, age, email));
        SaveToFile();
        System.out.println("Person added.");
    }

    static void RemovePersone(Scanner scanner){
        System.out.println("Enter name person: ");
        String name = scanner.nextLine();

        boolean removed = people.removeIf(p -> p.getName().equals(name));

        if (removed){

            System.out.println("Person removed");
        }else {
            System.out.println("Person not found");
        }
    }

    static void UpdatePerson(Scanner scanner){
        System.out.println("Enter name person for update");
        String name = scanner.nextLine();

        for (Person p : people){
            if (p.getName().equalsIgnoreCase(name)){
                System.out.println("Enter new age: ");
                int NewAge = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter new email: ");
                String NewEmail = scanner.nextLine();

                p.setAge(NewAge);
                p.setEmail(NewEmail);
                SaveToFile();
                System.out.println("Persone updated.");
                return;
            }
        }
        System.out.println("Person not found.");
    }

    static void PrintAll(){
        if (people.isEmpty()){
            System.out.println("Don't found person.");
        }else {
            for (Person p : people){
                System.out.println(p);
            }
        }
    }

    static void LoadFromFile(){
        File file = new File(FILE_PATH);

        if (!file.exists()) return;

        try (BufferedReader b = new BufferedReader(new FileReader(file))){
            String line;
            while((line = b.readLine()) != null ){
                people.add(Person.FromString(line));
            }
        }catch (IOException ex){
            System.out.println("Error load: " + ex.getMessage());
        }
    }

    static void SaveToFile(){
        try (BufferedWriter b = new BufferedWriter(new FileWriter(FILE_PATH))){
            for (Person p : people){
                b.write(p.toString());
                b.newLine();
            }
        }catch (IOException e){
            System.out.println("Error save: " + e.getMessage());
        }
    }
}

import java.io.*;
import java.util.List;

class FileManager {
    private static final String File_Name = "contacts.txt";

    public static void saveContacts(List<Contact> contacts) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(File_Name))) {
            out.writeObject(contacts);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении контактов: " + e.getMessage());
        }
    }

    public static List<Contact> loadContacts() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(File_Name))) {
            return (List<Contact>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке контактов: " + e.getMessage());
        }

        return List.of();
    }
}
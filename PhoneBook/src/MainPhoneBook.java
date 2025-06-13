import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

class PhoneBook {
    private List<Contact> contacts = new ArrayList<>();
    private int nextId = 1;

    public void addContact(String surname, String name, int age, String phonenumber) {
        //contacts.add(new Contact(surname, name, age, phonenumber));
        Contact contact = new Contact(surname, name, age, phonenumber);
       contact.setId(nextId++);
       contacts.add(contact);
    }

    public void setContacts(List<Contact> contacts){
        this.contacts = contacts;
    }

    public List<Contact> getAllContact(){
        return contacts;
    }

    public boolean deleteContact(int id){
        return contacts.removeIf(contact -> contact.getId() == id);
    }

    public boolean updateContact(int id, String surname, String name, int age, String phonenumber){
        for (Contact contact : contacts){
            if (contact.getId() == id) {
                contact.setName(name);
                contact.setSurname(surname);
                contact.setAge(age);
                contact.setPhonenumber(phonenumber);
                return true;
            }
        }
        return false;
    }

    public List<Contact> searchContacts(String query){
        return contacts.stream()
                .filter(contact -> contact.getName().toLowerCase().contains(query.toLowerCase()) ||
                        contact.getSurname().toLowerCase().contains(query.toLowerCase()) ||
                        contact.getPhonenumber().contains(query))
               .collect(Collectors.toList());
    }

    public void sortAge(){
        contacts.sort(Comparator.comparing(Contact::getAge));
    }

    public void sortName(){
        contacts.sort(Comparator.comparing(Contact::getName));
    }

    public void sortSurName(){
        contacts.sort(Comparator.comparing(Contact::getSurname));
    }

    public void sortPhonenumber(){
        contacts.sort(Comparator.comparing(Contact::getPhonenumber));
    }
}
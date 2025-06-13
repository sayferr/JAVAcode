import java.util.Scanner;

class Main{
    public static void main(String[] args) {
    PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);

        boolean run = true;

        while (run){
            System.out.println("Выберите нужный пункт");
            System.out.println("_____________________________________________________________");
            System.out.println("|                                                           |");
            System.out.println("|            0 - создать контакт                            |");
            System.out.println("|            1 - добавить контакт                           |");
            System.out.println("|            2 - удалить контакт                            |");
            System.out.println("|            3 - редактирование существующего контакта      |");
            System.out.println("|            4 - поиск                                      |");
            System.out.println("|            5 - сохранить контакт                          |");
            System.out.println("|            6 - загрузить конаткты                         |");
            System.out.println("|            7 - выход                                      |");
            System.out.println("|                                                           |");
            System.out.println("_____________________________________________________________");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 0: {
                    System.out.println("id контакта: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Фамилия: ");
                    String surname = scanner.nextLine();
                    System.out.println("Имя: ");
                    String name = scanner.nextLine();
                    System.out.println("Возраст: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Телефонный номер: ");
                    String phonenumber = scanner.nextLine();
                    phoneBook.addContact(surname, name, age, phonenumber);
                    System.out.println("Контакт успешно добавлен");
                    break;
                }

                case 1: {
                    for (Contact c : phoneBook.getAllContact()){
                    System.out.println(c);
                        System.out.println("Все контакты");
                    }
                    break;
                }

                case 2: {
                    System.out.println("Введите ID для удаления: ");
                    int id = scanner.nextInt();
                    boolean result = phoneBook.deleteContact(id);
                    System.out.println("Контакт" + result + "удален");
                    break;
                }
                case 3: {
                    System.out.println("Введите ID для изменения: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Новая фамилия: ");
                    String surname = scanner.nextLine();
                    System.out.println("Новое имя: ");
                    String name = scanner.nextLine();
                    System.out.println("Новый возраст: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Новый телефонный номер: ");
                    String phonenumber = scanner.nextLine();
                    boolean result = phoneBook.updateContact(id, surname, name, age, phonenumber);
                    System.out.println(result ? "Контак изменен" : "Контакт не изменен");
                    break;
                }
                case 4: {
                    System.out.println("Введите данные для поиска: ");
                    String query = scanner.nextLine();
                    var result = phoneBook.searchContacts(query);
                    if (result.isEmpty()){
                        System.out.println("Контакт не найден!");
                    }else {
                        for (Contact c : result){
                        System.out.println(c);
                        }
                    }
                    break;
                }
                case 5: {
                    FileManager.saveContacts(phoneBook.getAllContact());
                    System.out.println("Контакты сохранены");
                    break;
                }
                case 6: {
                    var load = FileManager.loadContacts();
                    phoneBook.setContacts(load);
                    System.out.println("Контакт загружен");
                    break;
                }
                case 7: {
                    FileManager.saveContacts(phoneBook.getAllContact());
                    run = false;
                    System.out.println("Пока!");
                    break;
                }
                default:{
                    System.out.println("Неверный выбор!");
                    break;
                }
            }
        }
        scanner.close();
    }
}
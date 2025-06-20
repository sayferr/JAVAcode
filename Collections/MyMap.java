import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MyMap {

    // Метод очистки словаря
    public static void cls(Map<String, String> dictionary) {
        dictionary.clear();
        System.out.println("Словарь очищен!");
    }

    // Печать количества слов
    public static void size(Map<String, String> dictionary) {
        System.out.println("Количество слов в словаре: " + dictionary.size());
    }

    // Печать количества букв в словаре
    public static void letter(Map<String, String> dictionary) {
        int count = 0;
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            count += entry.getKey().replaceAll("[^A-Za-zА-Яа-я]", "").length();
            count += entry.getValue().replaceAll("[^A-Za-zА-Яа-я]", "").length();
        }
        System.out.println("Всего букв в словаре: " + count);
    }

    // Печать количества чисел в словаре
    public static void num(Map<String, String> dictionary) {
        int count = 0;
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            count += entry.getKey().replaceAll("[^0-9]", "").length();
            count += entry.getValue().replaceAll("[^0-9]", "").length();
        }
        System.out.println("Всего чисел в словаре: " + count);
    }

    // Удаление по ключу или значению
    public static void delete(Scanner scanner, Map<String, String> dictionary) {
        System.out.println("Введите слово для удаления:");
        String word = scanner.nextLine().toLowerCase();

        if (dictionary.containsKey(word)) {
            dictionary.remove(word);
            System.out.println("Удалено по ключу.");
        } else if (dictionary.containsValue(word)) {
            String keyToRemove = null;
            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                if (entry.getValue().equals(word)) {
                    keyToRemove = entry.getKey();
                    break;
                }
            }
            if (keyToRemove != null) {
                dictionary.remove(keyToRemove);
                System.out.println("Удалено по значению.");
            }
        } else {
            System.out.println("Такого слова нет.");
        }
    }

    // Обновление слова
    public static void update(Scanner scanner, Map<String, String> dictionary) {
        System.out.println("Введите старое слово:");
        String oldWord = scanner.nextLine().toLowerCase();

        System.out.println("Введите новое слово:");
        String newWord = scanner.nextLine().toLowerCase();

        // 6.1 — если пара уже существует
        if (dictionary.containsKey(oldWord) && dictionary.get(oldWord).equals(newWord)) {
            System.out.println("Такая пара уже существует.");
            return;
        }
        if (dictionary.containsKey(newWord) && dictionary.get(newWord).equals(oldWord)) {
            System.out.println("Такая пара уже существует.");
            return;
        }

        // 6.2 — если совпадает ключ
        if (dictionary.containsKey(oldWord)) {
            dictionary.put(oldWord, newWord);
            System.out.println("Значение для ключа '" + oldWord + "' изменено на '" + newWord + "'.");
            return;
        }

        // 6.3 — если совпадает значение
        String keyToUpdate = null;
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            if (entry.getValue().equals(oldWord)) {
                keyToUpdate = entry.getKey();
                break;
            }
        }
        if (keyToUpdate != null) {
            String value = dictionary.remove(keyToUpdate);
            dictionary.put(newWord, value);
            System.out.println("Ключ для значения '" + oldWord + "' изменён на '" + newWord + "'.");
        } else {
            System.out.println("Такого слова нет.");
        }
    }

    public static void main(String[] args) {
        Map<String, String> dictionary = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);

        // начальные слова
        dictionary.put("dog", "sobaka");
        dictionary.put("mother", "mama");
        dictionary.put("brother", "brat");
        dictionary.put("sister", "sestra");
        dictionary.put("father", "papa");
        dictionary.put("home", "dom");

        do {
            System.out.println();
            System.out.print("Введите слово для перевода: ");
            String word = scanner.nextLine().toLowerCase();

            if (word.equals("command")) {
                System.out.print("Введите команду: ");
                word = scanner.nextLine().toLowerCase();

                // подключаем методы сюда
                switch (word) {
                    case "print":
                        for (String key : dictionary.keySet()) {
                            System.out.println(key + " (en) => " + dictionary.get(key) + " (ru)");
                        }
                        break;
                    case "cls":
                        cls(dictionary);
                        break;
                    case "size":
                        size(dictionary);
                        break;
                    case "letter":
                        letter(dictionary);
                        break;
                    case "num":
                        num(dictionary);
                        break;
                    case "delete":
                        delete(scanner, dictionary);
                        break;
                    case "update":
                        update(scanner, dictionary);
                        break;
                    default:
                        System.out.println("Неизвестная команда.");
                }

            } else if (dictionary.containsKey(word)) {
                System.out.println(word + " (en) => " + dictionary.get(word) + " (ru)");
            } else if (dictionary.containsValue(word)) {
                for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                    if (entry.getValue().equals(word)) {
                        System.out.println(word + " (ru) => " + entry.getKey() + " (en)");
                        break;
                    }
                }
            } else {
                System.out.println("Слово отсутствует. Хотите добавить? 1 — да / 2 — нет");
                int select = scanner.nextInt();
                scanner.nextLine();

                if (select == 1) {
                    System.out.print("Введите перевод слова: ");
                    String translate = scanner.nextLine().toLowerCase();

                    if (dictionary.containsKey(word) || dictionary.containsValue(word) ||
                    dictionary.containsKey(translate) || dictionary.containsValue(translate)) {
                        System.out.println("Такое слово уже есть.");
                    } else {
                        System.out.println("Выберите направление: 1 — en->ru / 2 — ru->en");
                        select = scanner.nextInt();
                        scanner.nextLine();

                        if (select == 1) {
                            dictionary.put(word, translate);
                        } else if (select == 2) {
                            dictionary.put(translate, word);
                        } else {
                            System.out.println("Неверный выбор.");
                        }
                        System.out.println("Слово добавлено.");
                    }
                } else {
                    System.out.println("Ок.");
                }
            }
        } while (true);
    }
}
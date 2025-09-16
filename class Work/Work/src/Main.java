import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public  static void main(String[] args) {
        // 1
        /** Scanner scanner = new Scanner(System.in);
        int angle = scanner.nextInt();
        if (angle < 90) {
            System.out.println("Acute angle");
        } else if (angle == 90) {
            System.out.println("Right angle");
        } else if (angle > 90 && angle < 180) {
            System.out.println("Obtuse angle");
        } else if (angle == 180) {
            System.out.println("Straight angle");
        } else if (angle > 180 && angle < 360) {
            System.out.println("Invalid angle");
        } else {
            System.out.println("The angle is not exists");
        } */

        // 2
        /**  Scanner scanner = new Scanner(System.in);
        System.out.println("Your age: ");
        int age =  scanner.nextInt();
        System.out.println("Your salary: ");
        int salary = scanner.nextInt();
        System.out.println("Sum: ");
        int sum = scanner.nextInt();

        if (age >= 18 && age <= 65 && salary >= 50000 && sum <= salary * 10 ) {
            System.out.println("True");
        } else  {
            System.out.println("False");
        } */

        // 3
       /** Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        System.out.print("Enter the operator (+, -, *, /): ");
        String operator = scanner.next();

        int result;

        switch (operator) {
            case "+":
                result = num1 + num2;
                System.out.println("Результат: " + result);
                break;

            case "-":
                result = num1 - num2;
                System.out.println("Результат: " + result);
                break;

            case "*":
                result = num1 * num2;
                System.out.println("Результат: " + result);
                break;

            case "/":
                if (num2 == 0) {
                    System.out.println("Ошибка: деление на ноль!");
                } else {
                    result = num1 / num2;
                    System.out.println("Результат: " + result);
                }
                break;

            default:
                System.out.println("Ошибка: некорректный оператор!");
        }
        scanner.close(); */

       // 4
       /** Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number element n: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Error: n must be a positive number.");
            return;
        }

        int a = 0;
        int b = 1;
        int count = 0;
        int temp;

        while (count < n) {
            temp = a + b;
            a = b;
            b = temp;
            count++;
       // System.out.println(n + "- element: " + a);
        }

        System.out.println(n + "- element: " + a); */

       // 5
        /** Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the word: ");
        String word = scanner.nextLine();

        int left = 0;
        int right = word.length() - 1;
        boolean isPalindrome = true;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }
        if (isPalindrome) {
            System.out.println("The word is palindrome");
        }else  {
            System.out.println("The word is not palindrome");
        } */

        // 8
       /** List<Integer> numbers = Arrays.asList(5, 12, 7, 3, 14, 18, 6);

        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 == 0)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println(result); */

       // 9
       /** List<String> words = Arrays.asList("кот", "слон", "крокодил", "тигр", "леопард");

        String longest = words.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("");

        System.out.println("Самое длинное слово: " + longest); */

       // 10
       /** String inputFile = "input.txt";
        String outputFile = "output.txt";

        try {
            List<String> lines = Files.readAllLines(Paths.get(inputFile));

            int sum = lines.stream()
                    .mapToInt(Integer::parseInt)
                    .sum();

            Files.write(Paths.get(outputFile),
                    ("Sum of numbers: " + sum).getBytes());

            System.out.println("The result written in " + outputFile);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } */
    }
}
        // 6
/** class bankAccount{
    double balance;
    String owner;

    public bankAccount(int balance, String owner) {
        this.balance = balance;
        this.owner = owner;
    }

    public void deposit(double amount){
        if(amount > 0){
            this.balance += amount;
            System.out.println("Deposited "+amount);
        }else{
            System.out.println("False");
        }
    }

    public void withdraw(double amount){
        if(amount > 0){
            if(this.balance >= amount){
                this.balance -= amount;
                System.out.println("Withdrawn "+amount);
            } else{
                System.out.println("False");
            }
        } else{
            System.out.println("The sum must be positive");
        }
    }

    public double getBalance(){
        return this.balance;
    }
} */

        // 7
/** class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " (" + price + " руб.)";
    }
}

class Order {
    List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product p : products) {
            total += p.price;
        }
        return total;
    }

    public void printOrder() {
        System.out.println("Товары в заказе:");
        for (Product p : products) {
            System.out.println("- " + p);
        }
        System.out.println("Итого: " + getTotalPrice() + " руб.");
    }
} */
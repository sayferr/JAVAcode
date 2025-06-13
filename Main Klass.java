import java.util.Scanner;

public class Main {


//Player player = new Player(); //Object
//player.username = "sayfer";
//player.name = "Roman";
//player.dataCreateAccount = 2099;
//
//player.print();


//class Player { //Klass
//    String name;
//    String username;
//    int dataCreateAccount;
//
//    public Player(){ //Konstructor
//        System.out.println("Аккаунт");
//    }
//
//    public void print(){
//        System.out.println(name + " " + username + " " + dataCreateAccount);
//    }
//}
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

// 1 Задание
//public static void main(String[] args) {
//
//    class Circle{
//       private double radius;
//
//        public Circle(double radius){
//            this.radius = radius;
//        }
//        public double calculateArea(){
//            return Math.PI * Math.pow(radius, 2);
//        }
//    }
//    Circle circle = new Circle(10);
//    System.out.println(circle.calculateArea());
//}



    // 2 Задание
//    public static void main(String[] args) {
//
//        class Rectangle{
//           private double length;
//           private double width;
//
//            public Rectangle(double length, double width) {
//                this.length = length;
//                this.width = width;
//            }
//            public double calculatePerimeter(){
//                return 2 * (length + width);
//            }
//        }
//        Rectangle rectangle = new Rectangle(20, 3);
//        System.out.println(rectangle.calculatePerimeter());
//    }




// 3 задание
//    public static void main(String[] args) {
//
//        class Student {
//           private String name;
//            private int age;
//
//            public Student(String name, int age) {    //Konstructor
//                this.name = name;
//                this.age = age;
//            }
//
//            public void displayInfo() {
//                System.out.println(name + " " + age);
//            }
//
//        }
//        Student student = new Student("Romam", 19);   //Object
//        student.displayInfo();
//
//    }



    // 4 Задание
//    public static void main(String[] args) {
//
//        class Car {
//            private String Brand;
//            private int Speed;
//
//            public Car(String Brand, int Speed){
//                this.Brand = Brand;
//                this.Speed = Speed;
//            }
//
//            public void accelerate(){
//                Scanner scanner = new Scanner(System.in);
//                int increment = Speed + scanner.nextInt();
//                System.out.println("Название : " + Brand + " " + "Максимальная скорость (Stage 1) : " + Speed);
//                System.out.println("Название : " + Brand + " " + "Максимальная скорость(Stage 2) : " + increment);
//            }
//        }
//        Car car = new Car("Pagani huayra", 370);
//        car.accelerate();
//    }



    //5 Задание
//    public static void main(String[] args) {
//        class Book{
//           private String title;
//            private String author;
//
//            public Book(String author, String title) {
//                this.author = author;
//                this.title = title;
//            }
//
//            public void getBookInfo(){
//                System.out.println();//Мне Визуально код так приятнее выглядит при выводе
//                System.out.print(author);
//                System.out.println();
//                System.out.print(title);
//                System.out.println();
//            }
//
//        }
//        Book book = new Book("Fullmetal Alchemist", "Hiromu Arakawa");
//        book.getBookInfo();
//    }



    // 6 Задание
//    public static void main(String[] args) {
//
//        class Point{
//            private int x;
//            private int y;
//
//            public Point(int x, int y){
//                this.x = x;
//                this.y = y;
//            }
//
//            public void move(){
//                Scanner scanner = new Scanner(System.in);
//                int dx = x + scanner.nextInt();
//                int dy = y + scanner.nextInt();
//                System.out.println("Координаты точки : " + dx + "." + dy);
//            }
//        }
//        Point point = new Point(2, 3);
//        point.move();
//    }



    // 7 Задание
//    public static void main(String[] args) {
//
//        class Person{
//           private String FirstName;
//           private String LastName;
//
//           public Person(String FirstName, String LastName){
//               this.FirstName = FirstName;
//               this.LastName = LastName;
//           }
//
//           public String getFullName(){
//               return FirstName + " " + LastName;
//           }
//        }
//        Person person = new Person("Roman", "Sadagyan");
//        System.out.println(person.getFullName());
//    }



    // 8 Задание
//    public static void main(String[] args) {
//
//        class Temperature{
//            private double celsius;
//
//            public Temperature(double celsius){
//                this.celsius = celsius;
//            }
//
//            public double toFahrenheit(){
//                return  (celsius * 9.0 / 5) + 32;
//
//            }
//
//            public double toKelvin(){
//                return  (celsius + 273.15);
//            }
//        }
//        Temperature temperature = new Temperature(5);
//        System.out.println(temperature.toFahrenheit());
//        System.out.println(temperature.toKelvin());
//    }


//    public static void main(String[] args) {
//
//        class Count{
//            private int count;
//
//            public Count(int count){
//                this.count = count;
//            }
//            public int getCount() {
//                return count;
//            }
//
//            public int increment(){
//              return ++count;
//            }
//
//           public int decrement(){
//                return --count;
//           }
//
//        }
//        Count count = new Count(0);
//        System.out.println("Значение начальное: " + count.getCount());
//        System.out.println("Значеие инкремента: " + count.increment());
//        System.out.println("Значение первого декремента: " + count.decrement());
//        System.out.println("Значение второго декремента: " + count.decrement());
//    }


    // 10 Задание
    public static void main(String[] args) {
         class Time {
            private int hours;
            private int minutes;

            public Time(int hours, int minutes) {
                this.hours = hours;
                this.minutes = minutes;
                normalTime();
            }

            public void addMinutes(int minutes) { //  добавления минут происходят в этом методе
                this.minutes += minutes;
                normalTime();
            }


            private void normalTime() { //перенос лишних минут в часы
                hours += minutes / 60;
                minutes %= 60;
                hours %= 24; // Чтобы часы оставались в пределах от 0 до 23
            }

            public String displayTime() {
                return String.format("Текущее время: %02d:%02d*/", hours, minutes); // Метод для вывода времени
            }

            public int getHours() {
                return hours;
            }

            public int getMinutes() {
                return minutes;
            }
        }
        Time time = new Time(20, 59);
        System.out.println(time.displayTime());

        time.addMinutes(190);
        System.out.println(time.displayTime());
    }




}
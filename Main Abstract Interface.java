/** 1 задание, Базовое задание: Абстрактный класс */
//abstract class Shape {
//    abstract double calculateArea();
//}
//
//class Circle extends Shape{
//private double radius;
//
//  Circle(double radius){
//      this.radius = radius;
//  }
//
//  @Override
//    double calculateArea() {
//      return Math.PI * radius * radius;
//  }
//}
//
//class Rectangle extends Shape{
//    private double height;
//    private double width;
//
//    Rectangle(double height, double width){
//        this.width = width;
//        this.height = height;
//    }
//
//    @Override
//    double calculateArea(){
//        return width * height;
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Circle circle = new Circle(4);
//        Rectangle rectangle = new Rectangle(5, 2.4);
//
//        System.out.println("Area Circle: " + circle.calculateArea());
//        System.out.println("Area Rectangle: " + rectangle.calculateArea());
//    }
//}

/** 2 задание, Интерфейс для животных */
//interface Animal{
//    void makeSound();
//    void move();
//}
//class Dog implements Animal{
//    @Override
//    public void makeSound(){
//        System.out.println("Gaw gaw");
//    }
//    @Override
//    public void move(){
//        System.out.println("walk");
//    }
//}
//
//class Bird implements Animal{
//    @Override
//    public void makeSound(){
//        System.out.println("Chirp chirp");
//    }
//    @Override
//    public void move(){
//        System.out.println("fly");
//    }
//}
//public class Main {
//    public static void main(String[] args) {
//    Dog dog = new Dog();
//    Bird bird = new Bird();
//    dog.makeSound();
//    dog.move();
//        System.out.println();
//        bird.makeSound();
//        bird.move();
//    }
//}



/** 3 задание, Абстрактный класс + интерфейс */
//abstract class Vehicle{
//    abstract void startEngine();
//}
//
//interface Flyable {
//    void fly();
//}
//    class Car extends Vehicle{
//   private String name;
//
//    Car(String name){
//        this.name = name;
//    }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        @Override
//    public void startEngine(){
//        System.out.println(name + ":" + " launching from a card");
//    }
//}
//
//class Plane extends Vehicle implements Flyable {
//private String name;
//
//    Plane(String name){
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public void startEngine(){
//        System.out.println(name + ": " + " starting with a key");
//    }
//
//    @Override
//    public void fly(){
//        System.out.println(name + ":" + " Above the clouds!");
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//    Car car = new Car("Tesla");
//    Plane plane = new Plane("Cessna");
//        System.out.println();
//        car.startEngine();
//        plane.startEngine();
//        plane.fly();
//    }
//}


/** 4 задание, Список сотрудников*/
//abstract class Employee{
//    abstract void getSalary();
//    abstract void getRole();
//}
//class Manager extends Employee{
//String name;
//
//Manager(String name){
//    this.name = name;
//}
//    @Override
//    public void getSalary(){
//        System.out.println(name + ": salary 700$");
//    }
//
//    @Override
//    public void getRole(){
//        System.out.println(name + ": The most important");
//    }
//}
//
//class Developer extends Employee{
//    String name;
//
//    Developer(String name){
//        this. name = name;
//    }
//    @Override
//    public void getSalary(){
//        System.out.println(name + ": salary 400$");
//    }
//
//    @Override
//    public void getRole(){
//        System.out.println(name + ": this ordinary employee");
//    }
//}
//public class Main {
//    public static void main(String[] args) {
//        Manager manager = new Manager("Roman");
//        Developer developer = new Developer("David");
//        manager.getRole();
//        manager.getSalary();
//        System.out.println();
//        developer.getRole();
//        developer.getSalary();
//    }
//}



/** 5 задание, Управление устройствами*/
//interface Switchable{
//    void turnON();
//    void turnOFF();
//}
//class LightBulb implements Switchable{
//    private  boolean IsON = false;
//
//    @Override
//    public void turnON(){
//        IsON = true;
//        System.out.println("Lightbuld ON");
//    }
//
//    @Override
//    public void turnOFF(){
//        IsON = false;
//        System.out.println("Lightbuld OFF");
//    }
//}
//
//class Fan implements Switchable{
//    private  boolean IsON = false;
//
//    @Override
//    public void turnON(){
//        IsON = true;
//        System.out.println("Fan ON");
//    }
//
//    @Override
//    public void turnOFF(){
//        IsON = false;
//        System.out.println("Fan OFF");
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        LightBulb lightBulb = new LightBulb();
//        Fan fan = new Fan();
//        System.out.println();
//        lightBulb.turnON();
//        lightBulb.turnOFF();
//        System.out.println();
//        fan.turnON();
//        fan.turnOFF();
//    }
//}


/** 6 задание, Геометрические фигуры */
//interface Drawable{
//    void draw();
//}
//
//class Circle implements  Drawable{
//
//    @Override
//    public void draw(){
//        System.out.println("Рисуем круг");
//    }
//}
//
//class Square implements Drawable{
//
//    @Override
//    public void draw(){
//        System.out.println("Рисуем квадрат");
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Circle circle = new Circle();
//        Square square = new Square();
//        System.out.println();
//        circle.draw();
//        square.draw();
//    }
//}


/** 7 задание, Работа с базой данных*/
//interface Database{
//    void connect();
//    void disconnect();
//}
//
//class MySQLDatabase implements Database{
//    private boolean isConnected = false;
//    @Override
//    public void connect(){
//        isConnected = true;
//        System.out.println("MySQLDatabase: You are connected");
//    }
//
//    @Override
//    public void disconnect(){
//        isConnected = false;
//        System.out.println("MySQLDatabase: You are disconnected");
//    }
//}
//class PostgreSQLDatabase implements Database{
//    private boolean isConnected = false;
//    @Override
//    public void connect(){
//        isConnected = true;
//        System.out.println("PostgreSQLDatabase: You are connected");
//    }
//
//    @Override
//    public void disconnect(){
//        isConnected = false;
//        System.out.println("PostgreSQLDatabase: You are disconnected");
//    }
//}
//public class Main {
//    public static void main(String[] args) {
//        MySQLDatabase mySQLDatabase = new MySQLDatabase();
//        PostgreSQLDatabase postgreSQLDatabase = new PostgreSQLDatabase();
//        System.out.println();
//        mySQLDatabase.connect();
//        mySQLDatabase.disconnect();
//        System.out.println();
//        postgreSQLDatabase.connect();
//        postgreSQLDatabase.disconnect();
//    }
//}


/** 8 задание, Спортивные соревнования*/
//interface Athlete{
//    void run();
//    void jump();
//}
//
//class Runner implements Athlete{  // Метод Runner реализует соответствующий метод run
//    private String name;
//
//    Runner(String name){
//        this.name = name;
//    }
//
//    @Override
//    public void run(){
//        System.out.println(name + ": run");
//    }
//
//    @Override
//    public void jump(){
//
//    }
//}
//
//class Jumper implements Athlete{ // Метод jumper реализует соответствующий метод jump
//    private String name;
//
//    Jumper(String name){
//        this.name = name;
//    }
//
//    @Override
//    public void jump(){
//        System.out.println(name + ": jump");
//    }
//
//
//    public void run(){
//
//    }
//}
//public class Main {
//    public static void main(String[] args) {
//        Runner runner = new Runner("Roma");
//        Jumper jumper = new Jumper("Sava");
//        System.out.println();
//        runner.run();
//        jumper.jump();
//
//    }
//}


/** 9 задание */
//abstract class Product {
//    protected String name;
//    protected double price;
//
//    Product(String name, double price) {
//        this.name = name;
//        this.price = price;
//    }
//
//    abstract double getPrice();
//    abstract String getName();
//}
//
//class Electronics extends Product {
//    Electronics(String name, double price) {
//        super(name, price);
//    }
//
//    @Override
//    double getPrice() {
//        return price;
//    }
//
//    @Override
//    String getName() {
//        return name + ": TUF Gaming";
//    }
//}
//
//class Clothing extends Product {
//    Clothing(String name, double price) {
//        super(name, price);
//    }
//
//    @Override
//    double getPrice() {
//        return price;
//    }
//
//    @Override
//    String getName() {
//        return name + ": T-Shirt";
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Electronics electronics = new Electronics("Asus", 1100);
//        Clothing clothing = new Clothing("Uniqlo", 50);
//
//        System.out.println();
//        System.out.println(electronics.getName() + " - $" + electronics.getPrice());
//        System.out.println();
//        System.out.println(clothing.getName() + " - $" + clothing.getPrice());
//    }
//}


/** 10 задание, Зоопарк */
abstract class Animal {
    protected String name;

    Animal(String name) {
        this.name = name;
    }

    abstract void eat();
    abstract void sleep();
}

interface SoundMaker {
    void makeSound();
}

class Lion extends Animal implements SoundMaker {
    Lion(String name) {
        super(name);
    }

    @Override
    void eat() {
        System.out.println(name + " ест мясо.");
    }

    @Override
    void sleep() {
        System.out.println(name + " спит в саванне.");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " рычит: Rooooar!");
    }
}

class Elephant extends Animal implements SoundMaker {
    Elephant(String name) {
        super(name);
    }

    @Override
    void eat() {
        System.out.println(name + " ест траву и листья.");
    }

    @Override
    void sleep() {
        System.out.println(name + " спит стоя.");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " издает трубящий звук: Pooooo!");
    }
}

public class Main {
    public static void main(String[] args) {
        Lion lion = new Lion("Лев");
        Elephant elephant = new Elephant("Слон");

        System.out.println();
        lion.eat();
        lion.sleep();
        lion.makeSound();

        System.out.println();
        elephant.eat();
        elephant.sleep();
        elephant.makeSound();
    }
}

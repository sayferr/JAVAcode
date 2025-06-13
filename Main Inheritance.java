
// Задание №1, простое наследование
//      class Animal{
//          String name;
//
//          Animal(String name){
//              this.name = name;
//          }
//      }
//      class Dog extends Animal{
//
//          Dog(String name){
//              super(name);
//
//          }
//      }
//            public class Main {
//                public static void main(String[] args) {
//      Dog dog = new Dog("Rottweiler");
//        System.out.println("Порода: " + dog.name);
//    }
//}


// Задание 2, Добавление нового атрибута
//   class Vehicle{
//    protected String brand;
//
//    Vehicle(String brand){
//        this.brand = brand;
//    }
//
//    public String getBrand(){
//        return brand;
//    }
//
//    public void setBrand(){
//        this.brand = brand;
//    }
//}
//class Car extends Vehicle{
//    private String model;
//
//    Car(String brand, String model){
//        super(brand);
//        this.model = model;
//    }
//
//    public String getModel() {
//        return model;
//    }
//    public void setModel(){
//        this.model = model;
//    }
//
//    public void displayInfo(){
//        System.out.println("Vehicle: " + brand + " " + model);
//    }
//}
//   public class Main {
//    public static void main(String[] args) {
//     Car myCar = new Car("koeningsegg", "Jesko");
//     myCar.displayInfo();
//    }
//}


// Задание 3, Наследование с использованием метода базового класса
//class Person{
//    String name;
//    int age;
//    Person(String name, int age){
//    this.name = name;
//    this.age = age;
//    }
//
//    public void introduce(){
//        System.out.println("I am a person");
//    }
//}
//
//class Student extends Person{
//    Student(String name, int age){
//        super(name, age);
//    }
//}
//
//
//public class Main {
//    public static void main(String[] args) {
//Student student = new Student("Roman", 20);
//        student.introduce();
//    }
//}


// Задание 4,
//class Bird{
//    String species;
//
//    Bird(String species){
//        this.species = species;
//    }
//
//    public void swim(){
//        System.out.println("I can't swim");
//    }
//}
//class Penguin extends Bird{
//    Penguin(String species){
//        super(species);
//    }
//    @Override
//    public void swim(){
//        System.out.println("I can swim!");
//    }
//}
//public class Main {
//    public static void main(String[] args) {
//        Bird bird =new Bird("Eagle");
//        bird.swim();
//        System.out.println();
//        Penguin penguin = new Penguin("penguin");
//        penguin.swim();
//    }
//}


// 6 задание, Создание нескольких дочерних классов
//      class Animal{
//          String name;
//
//          Animal(String name){
//              this.name = name;
//          }
//}
//      class Dog extends Animal{
//    String breed;
//          Dog(String name, String breed){
//              super(name);
//              this.breed = breed;
//          }
//}
//      class  Cat extends Animal{
//    String color;
//         Cat(String name, String color){
//        super(name);
//        this.color = color;
//        }
//}
//
//
//            public class Main {
//            public static void main(String[] args) {
//      Dog dog = new Dog("Bruno", "Rotweiller");
//        System.out.println(dog.name + " " + dog.breed);
//        System.out.println();
//        Cat cat = new Cat("Sima", "white");
//                System.out.println(cat.name + " " + cat.color);
//    }
//}



// 5 задание, Наследование с использованием конструктора
//class Shape{
//    protected String color;
//
//    Shape(String color){
//        this.color = color;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//}
//class Rectangle extends Shape{
//
//    Rectangle(String color) {
//        super(color);
//    }
//}
//public class Main {
//    public static void main(String[] args) {
//            Rectangle rectangle = new Rectangle("Pink");
//        System.out.println(rectangle.getColor());
//    }
//}


// 7 Задание, Наследование с передачей значений в конструктор
//class Appliance{
//    private String brand;
//
//    Appliance(String brand){
//        this.brand = brand;
//    }
//
//    public String getBrand() {
//        return brand;
//    }
//
//    public void setBrand(String brand) {
//        this.brand = brand;
//    }
//}
//class WashingMachine extends Appliance{
//
//    WashingMachine(String brand) {
//        super(brand);
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        WashingMachine washingMachine = new WashingMachine("Haier");
//        System.out.println(washingMachine.getBrand());;
//    }
//}


// 8 задание, Создание цепочки наследования
//class LivingBeing{
//  private String type;
//
//  LivingBeing(String type){
//      this.type = type;
//  }
//
//  public String getType() {
//        return type;
//  }
//
//  public void setType(String type) {
//        this.type = type;
//  }
//}
//
//class Animal extends LivingBeing{
//private String species;
//    Animal(String type, String species) {
//        super(type);
//        this.species = species;
//    }
//
//    public String getSpecies() {
//        return species;
//    }
//
//    public void setSpecies(String species) {
//        this.species = species;
//    }
//}
//class Mammal extends  Animal{
//    private String name;
//
//    Mammal(String type, String species, String name) {
//        super(type, species);
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
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Mammal mammal = new Mammal("Water", "Cetacean", "Orca");
//        System.out.println("Living: " + mammal.getType() + "  " + "Species: " + mammal.getSpecies() + "  " + "Name: " + mammal.getName());
//    }
//}



// 10 задание, Дочерний класс с дополнительным методом
//class Device{
//    private String name;
//
//    Device(String name){
//        this.name = name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//}
//class Phone extends Device{
//private String model;
//
//    Phone(String name, String model) {
//        super(name);
//        this.model = model;
//    }
//
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String model) {
//        this.model = model;
//    }
//
//    public void make_call(){
//        System.out.println("Calling....");
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Phone phone = new Phone("Phone","Iphone 16");
//        phone.make_call();
//    }
//}


// 9 задание,
class Fruit {

    Fruit() {
        System.out.println("Надкусанное яблоко испоьзуется в логотипе Apple inc");
    }
}

class Apple extends Fruit {
    Apple() {
        System.out.println("Яблок упало на чью-то голову");
    }
}

public class Main {
    public static void main(String[] args) {
        Apple apple = new Apple();

        if (apple instanceof Fruit) {
            System.out.println("Все четко");
        } else {
            System.out.println("Все ужасно");
        }
    }
}




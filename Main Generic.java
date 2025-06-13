/** 1 задание, Создайте обобщённый метод для вывода элементов */
//class Main{
//    public static <T> void printElement(T element){
//        System.out.println(element);;
//    }
//
//    public static void main(String[] args){
//        printElement(77);
//        printElement("Roma");
//        printElement(14.3);
//    }
//}

/** 2 задание, Создайте обобщённый метод для работы с массивами */
//class Main{
//    public static <T> void printFirstElement(T[] element){
//        System.out.println(element);
//    }
//
//    public static <T> T getFirstElement(T[] element){
//       // System.out.println(element[0]);
//        return element[0];
//    }
//
//    public static void main(String[] args){
//        Character[] chars = new Character[]{'R', 'o', 'm', 'a'};
//        Integer[] ints = new Integer[]{1, 2, 3, 4};
//        System.out.println(getFirstElement(chars));
//        System.out.println(getFirstElement(ints));
//    }
//}

/** 3 задание, Напишите метод для проверки равенства */
//class Main{
//    public static <T> boolean isEqual(T element, T element2){
//        return element.equals(element2);
////        if (element == element2){
////            return true;
////        }else{
////            return false;
////        }
//    }
//
//    public static void main(String[] args){
//        System.out.println(isEqual(20,20));
//        System.out.println(isEqual("Roma", "Roma"));
//    }
//}

/** 4 задание, Создайте обобщённый класс для хранения пары*/
//class Pair<T1, T2>{
//    private T1 first;
//    private T2 second;
//
//    Pair(T1 first, T2 second){
//        this.first = first;
//        this.second = second;
//    }
//
//    public T1 getFirst(){
//        return first;
//    }
//
//    public T2 getSecond() {
//        return second;
//    }
//}
//class main{
//    public static void main(String[] args){
//        Pair<String, Integer> pair = new Pair<>("Roman", 20);
//
//        System.out.println(pair.getFirst());
//        System.out.println(pair.getSecond());
//    }
//}

/** 5 заадние, Обобщённый метод для реверса массива*/
//class Main {
//    public static <T> T[] reverseElement(T[] element) {
//        for (int i = 0; i < element.length / 2; i++) {
//            T result = element[i];
//            element[i] = element[element.length - 1 - i];
//            element[element.length - 1 - i] = result;
//        }
//        return element;
//    }
//
//        public static <T> void printElement(T[] element) {
//        for (int i = 0; i < element.length; i++) {
//            System.out.print(element[i] + " ");
//        }
//        System.out.println();
//    }
//
//    public static void main(String[] args) {
//        Character[] chars = {'R', 'o', 'm', 'a'};
//        Integer[] ints = {1, 2, 3, 4};
//
//        reverseElement(chars);
//        reverseElement(ints);
//
//        printElement(chars);
//        printElement(ints);
//    }
//}

/** 6 задание, Сравнение элементов */
//class Main{
//        public static <T> String compareElements(T element, T element2) {
//            if (element == element2) {
//                return "Элементы равны";
//            }else{
//                return "Элементы не равны";
//            }
//        }
//        public static void main(String[] args){
//            System.out.println(compareElements(2, 9));
//            System.out.println(compareElements("Kamilla", "Roma"));
//            System.out.println(compareElements("20", "20"));
//        }
//}

/** 7 задние, Создайте обобщённый метод для поиска элемента */
//class Main{
//    public static <T> int findIndex(T[] array, T element) {
//        for (int i = 0; i < array.length; i++) {
//            if (array[i].equals(element)){
//                return i;
//            }
//        }
//        return -1;
//    }
//    public static void main(String[] args){
//        Integer[] numb = {18, 23, 32, 41, 50};
//        String[] word = {"Roma", "Kamilla", "David"};
//        System.out.println(findIndex(numb, 32));
//        System.out.println(findIndex(word, "Kamilla"));
//    }
//}

/** 8 задание, Обобщённый метод для создания списка*/
//import java.util.List;
//import java.util.ArrayList;
//class Main{
//    public static <T> List<T> toList(T[] element){
//        List<T> list = new ArrayList<>();
//        for (int i = 0; i < element.length; i++) {
//            list.add(element[i]);
//        }
//        return list;
//    }
//    public static void main(String[] args){
//        Integer[] numbs = {18, 23, 32, 41, 50};
//        String[] words = {"Roma", "Kamilla", "David"};
//        List<Integer> numbsList = toList(numbs);
//        List<String> wordsList = toList(words);
//        System.out.println(numbsList);
//        System.out.println(wordsList);
//    }
//}

/** 9 задание, Метод для копирования массива */
//class Main{
//    public static <T> T[] copyArray(T[] array) {
//        return array.clone();
//    }
//    public static void main(String[] args){
//        Integer[] numbs = {18, 23, 32, 41, 50};
//        String[] words = {"Roma", "Kamilla", "David"};
//
//        Integer[] copyNumbs = copyArray(numbs);
//        String[] copyWords = copyArray(words);
//
//        System.out.println(java.util.Arrays.toString(copyNumbs));
//        System.out.println(java.util.Arrays.toString(copyWords));
//    }
//}

/** 10 задание, Создайте класс для хранения трёх объектов */
//class Triple<T1, T2, T3>{
//private T1 name;
//private T2 money;
//private T3 age;
//
//    Triple(T1 name, T2 money, T3 age){
//    this.name = name;
//    this.money = money;
//    this.age = age;
//    }
//
//    public T1 getName() {
//        return name;
//    }
//
//    public T2 getMoney() {
//        return money;
//    }
//
//    public T3 getAge() {
//        return age;
//    }
//}
//
//class Main{
//    public static void main(String[] args){
//        Triple<String, Double, Integer> triple = new Triple<>("Roma", 30.5, 20);
//        System.out.println(triple.getName() + " " + triple.getAge() + " " + triple.getMoney() + "$");
//    }
//}
/** можно еще добавить сетеры, чтобы мы могли менять значения, но я не стал их добавлятьт */
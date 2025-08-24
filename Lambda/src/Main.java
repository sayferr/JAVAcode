//        1) Напишите лямбда-выражение, которое принимает два целых числа и возвращает их сумму.
/** interface Test1{
    int sum(int a,int b);
}
public class Main {
    public static void main(String[] args) {
        Test1 test1 = (a, b) -> a + b;
        System.out.println(test1.sum(20, 20));
    }
} */
//        2) Создайте лямбда-выражение, которое проверяет, является ли строка пустой.
/** interface Test{
    boolean isEmpty(String s);
}

public class Main {
    public static void main(String[] args) {
        Test test = (s -> s.isEmpty());
        String s = "";
        System.out.println(test.isEmpty(s));
    }
} */
//        3) Напишите лямбда-выражение, которое принимает строку и возвращает её длину.
/** interface Test{
    int value(String s);
}
public class Main {
    public static void main(String[] args) {
        Test test = (s -> s.length());
        System.out.println(test.value("hello"));
    }
} */
//        4) Создайте лямбда-выражение, которое возвращает максимальное из двух чисел.
/** interface Test{
int max (int a, int b);
}
public class Main {
    public static void main(String[] args) {
        Test test = (a, b) -> a > b ? a : b;
        System.out.println(test.max(110, 20));
    }
} */
//        5) Напишите лямбда-выражение для проверки, является ли число четным.
/** interface Test{
    boolean Even(int a);
}
public class Main {
    public static void main(String[] args) {
        Test test = ((a) -> a % 2 == 0);
        System.out.println(test.Even(12));
    }
} */
//        6) Напишите лямбда-выражение, которое возводит число в квадрат.
/** interface Test{
    int num(int a);
}
public class Main {
    public static void main(String[] args) {
        Test test = (a -> a*a);
        System.out.println(test.num(5));
    }
} */
//        7) Создайте лямбда-выражение, которое выводит на экран строку.
/** interface Test{
    String str(String s);
}
public class Main {
    public static void main(String[] args) {
        Test test = (s -> s);
        System.out.println(test.str("hello"));
    }
} */
//        8) Напишите лямбда-выражение, которое принимает строку и возвращает её в верхнем регистре.
/** interface Test{
    String str(String s);
}
public class Main {
    public static void main(String[] args) {
        Test test = (s -> s.toUpperCase());
        System.out.println(test.str("hello"));
    }
} */
//        9) Напишите лямбда-выражение, которое проверяет, содержит ли строка подстроку.
/** interface Test{
    Boolean contains(String s, String sub);
}
public class Main {
    public static void main(String[] args) {
        Test test = ((s, sub) -> s.contains(sub));
        System.out.println(test.contains("Hello world", "Hello world"));
    }
} */
//        10) Напишите лямбда-выражение, которое преобразует строку в число.
/** interface Test{
    int parse(String s);
}
public class Main {
    public static void main(String[] args) {
        Test test = (s -> Integer.parseInt(s));
        System.out.println(test.parse("123"));
    }
} */
//        11) Создайте лямбда-выражение, которое умножает два числа и возвращает результат.
/** interface Test{
 int sum(int a, int b);
}
public class Main {
    public static void main(String[] args) {
        Test test = ((a, b) ->  a * b);
        System.out.println(test.sum(10, 20));
    }
} */
//        12) Напишите лямбда-выражение, которое проверяет, является ли число положительным.
import java.util.List;
import java.util.stream.Collectors;

/** interface Test{
 boolean isPositive(int x);
}
public class Main {
    public static void main(String[] args) {
        Test test = x -> x > 0;
        System.out.println(test.isPositive(-10));
    }
} */
//        13) Напишите лямбда-выражение для фильтрации всех чётных чисел из списка.
/** interface Test{
    List<Integer> filterEvens(List<Integer> numbers);
}
public class Main {
    public static void main(String[] args) {
        Test test = list -> list.stream().filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(test.filterEvens(List.of(1, 2, 3, 4, 5)));
    }
} */
//        14) Напишите лямбда-выражение, которое находит наибольший элемент в списке чисел.
/** interface Test {
    int max(List<Integer> list);
}
public class Main {
    public static void main(String[] args) {
        Test test = list -> list.stream().max(Integer::compare).get();
        System.out.println(test.max(List.of(10, 20, 5, 30)));
    }
} */
//        15) Напишите лямбда-выражение, которое сортирует список строк по длине.
/** interface Test {
    List<String> sortByLength(List<String> list);
}
public class Main {
    public static void main(String[] args) {
        Test test = list -> list.stream().sorted((a, b) ->
                        Integer.compare(a.length(), b.length()))
                .collect(Collectors.toList());
        System.out.println(test.sortByLength(List.of("java", "lambda", "hi", "programming")));
    }
} */
//        16) Создайте лямбда-выражение, которое возвращает строку без пробелов в начале и в конце.
/** interface Test {
    String trim(String s);
}
public class Main {
    public static void main(String[] args) {
        Test test = s -> s.trim();
        System.out.println(test.trim("   hello   ")); // "hello"
    }
} */
//        17) Напишите лямбда-выражение, которое объединяет два списка в один.
import java.util.ArrayList;

/** interface Test {
    List<Integer> merge(List<Integer> list1, List<Integer> list2);
}
public class Main {
    public static void main(String[] args) {
        Test test = (list1, list2) -> {
            List<Integer> merged = new ArrayList<>(list1);
            merged.addAll(list2);
            return merged;
        };
        System.out.println(test.merge(List.of(1, 2), List.of(3, 4))); // [1, 2, 3, 4]
    }
} */
//        18) Напишите лямбда-выражение, которое возвращает строку с первой буквой в верхнем регистре.
/** interface Test {
    String capitalize(String s);
}
public class Main {
    public static void main(String[] args) {
        Test test = s -> s.substring(0, 1).toUpperCase() + s.substring(1);
        System.out.println(test.capitalize("hello")); // Hello
    }
} */
//        19) Напишите лямбда-выражение, которое находит разницу между двумя датами.
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/** interface Test {
    long diff(LocalDate d1, LocalDate d2);
}
public class Main {
    public static void main(String[] args) {
        Test test = (d1, d2) -> ChronoUnit.DAYS.between(d1, d2);
        System.out.println(test.diff(LocalDate.of(2023, 1, 1),
                LocalDate.of(2023, 1, 10)));
    }
} */
//        20) Напишите лямбда-выражение, которое проверяет, является ли строка числом
interface Test {
    boolean isNumber(String s);
}
public class Main {
    public static void main(String[] args) {
        Test test = s -> {
            try {
                Integer.parseInt(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        };
        System.out.println(test.isNumber("123"));
        System.out.println(test.isNumber("abc"));
    }
}
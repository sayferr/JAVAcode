//public class Enums {
//    public static void main(String[] args) {
//    }
//}

/** 1  */
enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

class Main {
    public static void printDay(Day day) {
        switch (day) {
            case MONDAY:
                System.out.println("Сегодня Понедельник");
                break;
            case TUESDAY:
                System.out.println("Сегодня Вторник");
                break;
            case WEDNESDAY:
                System.out.println("Сегодня Среда");
                break;
            case THURSDAY:
                System.out.println("Сегодня Четверг");
                break;
            case FRIDAY:
                System.out.println("Сегодня Пятница");
                break;
            case SATURDAY:
                System.out.println("Сегодня Суббота");
                break;
            case SUNDAY:
                System.out.println("Сегодня Воскресенье");
                break;
        }
    }

    public static void main(String[] args) {
        printDay(Day.FRIDAY);
    }
}

/** 2 */
//enum Season {
//    WINTER,
//    SPRING,
//    SUMMER,
//    FALL
//}
//
//class Main {
//    public static boolean isSummer(Season season) {
//        if (season == Season.SUMMER) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public static void main(String[] args) {
//        boolean result = isSummer(Season.SPRING);
//        System.out.println("Это лето? " + result);
//    }
//}

/** 3 */
//enum Difficulty {
//    EASY,
//    MEDIUM,
//    HARD
//}
//
//class Main {
//    public static void listDifficulties() {
//        Difficulty[] allDifficulties = Difficulty.values();
//        for (int i = 0; i < allDifficulties.length; i++) {
//            System.out.println("Уровень сложности: " + allDifficulties[i]);
//        }
//    }
//
//    public static void main(String[] args) {
//        listDifficulties();
//    }
//}

/** 4 */
//enum Direction {
//    NORTH,
//    EAST,
//    SOUTH,
//    WEST
//}
//
//class Main {
//    public static String getDirectionMessage(Direction direction) {
//        if (direction == Direction.NORTH) {
//            return "Вы движетесь на север";
//        } else if (direction == Direction.EAST) {
//            return "Вы движетесь на восток";
//        } else if (direction == Direction.SOUTH) {
//            return "Вы движетесь на юг";
//        } else {
//            return "Вы движетесь на запад";
//        }
//    }
//
//    public static void main(String[] args) {
//        String msg = getDirectionMessage(Direction.WEST);
//        System.out.println(msg);
//    }
//}

/** 5 */
//import java.util.Scanner;
//
//enum Status {
//    START,
//    PROCESSING,
//    FINISHED
//}
//
//class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Введите статус (START, PROCESSING, FINISHED): ");
//        String input = scanner.nextLine().toUpperCase(); // приведение к верхнему регистру
//
//        try {
//            Status status = Status.valueOf(input);
//            System.out.println("Вы ввели статус: " + status);
//        } catch (IllegalArgumentException e) {
//            System.out.println("Ошибка: неизвестный статус!");
//        }
//    }
//}

/** 6 */
//enum Priority {
//    LOW,
//    MEDIUM,
//    HIGH
//}
//
//class Main {
//    public static void showPriorityNumbers() {
//        for (int i = 0; i < Priority.values().length; i++) {
//            Priority current = Priority.values()[i];
//            int number = current.ordinal(); // порядковый номер
//            System.out.println("Приоритет " + current + " имеет номер " + number);
//        }
//    }
//
//    public static void main(String[] args) {
//        showPriorityNumbers();
//    }
//}

/** 7 */
//enum Month {
//    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE,
//    JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
//}
//
//class Main {
//    public static void listAllMonths() {
//        Month[] months = Month.values();
//        for (int i = 0; i < months.length; i++) {
//            System.out.println("Месяц: " + months[i]);
//        }
//    }
//
//    public static void main(String[] args) {
//        listAllMonths();
//    }
//}

/** 8 */
//enum Season {
//    WINTER("Cold"),
//    SPRING("Warm"),
//    SUMMER("Hot"),
//    FALL("Cool");
//
//    private String description;
//
//    Season(String description) {
//        this.description = description;
//    }
//
//    public String getDescription() {
//        return this.description;
//    }
//}
//
//class Main {
//    public static void main(String[] args) {
//        Season season = Season.FALL;
//        String desc = season.getDescription();
//        System.out.println("Описание сезона: " + desc);
//    }
//}

/** 9 */
//enum ProductCategory {
//    ELECTRONICS(0.2),
//    FOOD(0.05),
//    CLOTHING(0.1);
//
//    private double taxRate;
//
//    ProductCategory(double taxRate) {
//        this.taxRate = taxRate;
//    }
//
//    public double calculateTax(double price) {
//        double tax = price * this.taxRate;
//        return tax;
//    }
//}
//
//class Main {
//    public static void main(String[] args) {
//        double price = 1000.0;
//        ProductCategory category = ProductCategory.ELECTRONICS;
//        double tax = category.calculateTax(price);
//        System.out.println("Налог на товар: " + tax);
//    }
//}

/** 10 */
//enum Day {
//    MONDAY(true),
//    TUESDAY(true),
//    WEDNESDAY(true),
//    THURSDAY(true),
//    FRIDAY(true),
//    SATURDAY(false),
//    SUNDAY(false);
//
//    private boolean isWorkingDay;
//
//    Day(boolean isWorkingDay) {
//        this.isWorkingDay = isWorkingDay;
//    }
//
//    public boolean isWorkingDay() {
//        return this.isWorkingDay;
//    }
//}
//
//class Main {
//    public static void main(String[] args) {
//        Day day1 = Day.MONDAY;
//        Day day2 = Day.SUNDAY;
//
//        System.out.println(day1 + " — рабочий день? " + day1.isWorkingDay());
//        System.out.println(day2 + " — рабочий день? " + day2.isWorkingDay());
//    }
//}

public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        // 1 деление на ноль
//       try {
//           System.out.println("Введи два числа (X и Y) >> ");
//           int a = scanner.nextInt();
//           int b = scanner.nextInt();
//           System.out.println("Результат = " + a/b);
//       } catch (Exception ex) {
//           System.out.println("Делить на ноль нельзя, меняй ");
//       }


        // 2 неверный формат числа
//        try{
//            System.out.println("Введите число: ");
//            int num = Integer.parseInt(scanner.next());
//            System.out.println("Введенное число: " + num);/* Если написать слово вместо числа
//            тогда сработает блок catch*/
//        } catch (Exception ex){
//            System.out.println("Неправильный формат числа");
//        }


        // 3 Обращение к элементу массива
//        int[] arr = {10, 20, 30, 40, 50};
//        try{
//            System.out.println("Введите индекс: ");
//            int index = scanner.nextInt();
//            System.out.println("Введенный индекс: " + arr[index]);/* Если написать индекс больше 4
//            тогда сработает блок catch*/
//        } catch (Exception ex){
//            System.out.println("Выход за границы массива");
//        }


        // 4 Нахождение минимального числа
//        try {
//            System.out.println("Введите любые пять чисел");
//            int min = scanner.nextInt();
//            for (int i = 1; i < 999; i++) {
//                int num = scanner.nextInt();/*Если написать слово или букву вместо числа
//                тогда срабюотает блок catch*/
//                if(num < min) min = num;
//            }
//            System.out.println("Минимально число: " + min);
//        }catch (Exception ex){
//            System.out.println("Ошибка: введено неправильное значение");
//        }


        // 5 Чтение строки с ограничеием длины
//        try {
//            System.out.println("Введите строку: ");
//            String str = scanner.next();
//            if (str.length() > 10) throw new Exception("Строка слишком длинная! " );
//                System.out.println("Вы ввели: " + str);
//        } catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }


        // 6 поиск подстроки
//        try {
//            System.out.println("Введите строку: ");
//            String text = scanner.next();
//            System.out.println("Введите символ: ");
//            char num = scanner.next().charAt(0);
//            if (!text.contains(String.valueOf(num))) throw new Exception("Ошибка: символа не существует ");
//                System.out.println("Символ существует ");
//        }catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }


        // 7 Число в диапазоне
//        try {
//            System.out.println("Введите число от 1 до 100");
//            int num = scanner.nextInt();
//            if (num < 1 || num > 100) throw new Exception("Некоректный диапазон чисел! ");
//            System.out.println("Число в диапазоне! ");
//        }catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }


        // 8 Парсинг массива
//       try {
//           String[] strArr = {"10", "20", /*"aaa",*/ "30", "40", "50", "aaa"};
//           for (int i = 0; i < strArr.length; i++) {
//               int valu = Integer.parseInt(strArr[i]);
//               System.out.println("Значение " + valu);
//           }
//       }catch (Exception ex) {
//           System.out.println("Ошибка: некорректное значение");
//       }


        // 9 Проверка делимости
        try {
            System.out.println("Введите два числа");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a % b != 0) throw new Exception("Ошибка: число не делится без остатка ");
            System.out.println("Число делится без остатка ");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }


        // 10  Индексы и значение
//        int[] arr = new int[10];
//        try {
//            System.out.println("Введите индекс 0-9 : ");
//            int index = scanner.nextInt();
//            System.out.println("Введите значение: ");
//            int valu = scanner.nextInt();
//            arr[index] = valu;
//            System.out.println("Вы ввели: arr[" + index + "] = " + valu);
//        }catch (Exception ex){
//            System.out.println("Ошибка: значение некорректно");
//        }





    }
}
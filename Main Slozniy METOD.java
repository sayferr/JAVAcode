public class Main {


//Написать метод, который возвращает среднее арифметическое массива чисел
//    public static void main(String[] args) {
//        int[] sred = new int[]{18, 2, 34, 4, 57};
//        double average = Average(sred);
//        System.out.println("Среднее =" + " " + average);
//    }
//
//    public static double Average(int[] numbers) {
//        int sum = 0;
//        for (int i = 0; i < numbers.length; i++) {
//
//
//            sum += numbers[i];
//        }
//        return (double) sum / numbers.length;
//    }


    //Написать метод, который возвращает сумму элементов массива
//    public static void main(String[] args) {
//        int arr[] = new int[]{1, 2, 3, 4, 5};
//        int Tsum = sum(arr);
//        System.out.println("Сумма всех чисел" + " " + Tsum);
//    }
//    public static int sum(int[] numb){
//        int sum = 0;
//        for (int i = 0; i < numb.length; i++) {
//            sum += numb[i];
//        }
//       return sum;
//    }

    //Я в жизни столько не матерился, как над массивами
    //Написать метод, который возвращает наибольшее и наименьшее число из массива
//    public static void main(String[] args) {
//        int numb[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//
//        int[] result = MAXandMIN(numb);
//
//        System.out.println("Тут максимум " + result[0]);
//        System.out.println("Тут минимум " + result[1]);
//    }
//    public static int[] MAXandMIN(int[] arr){
//        //return arr;
//        int max = arr[0];
//        int min = arr[0];
//
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i] > max){
//                max = arr[i];
//            } else {
//                min = arr[i];
//            }
//        }
//        return new int[]{max, min};
//    }




    //Написать метод, который возвращает разницу между максимальным и минимальным элементом массива
//    public static void main(String[] args) {
//        int MAx[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 100};
//        int dif = Raznica(MAx);
//        System.out.println("Разница" + " " +  );
//    }
//    public static int[] Raznica(int[] raz){
//        int maxx = raz[0];
//        int minn = raz[0];
//        for (int i = 1; i < raz.length; i++) {
//            if (raz[i] > maxx) {
//                maxx = raz[i];
//            } else {
//                minn = raz[i];
//            }
//        }
//        return maxx - minn;
//    }


//    public static void main(String[] args) {
//        int Max[] = new int[]{65, 26, 3, 4, 5, 6, 7, 8, 9, 100};
//        int dif = Raznica(Max); // Метод теперь возвращает int
//        System.out.println("Разница: " + dif);
//    }
//
//    public static int Raznica(int[] raz) {
//        int maxx = raz[0];
//        int minn = raz[0];
//
//        for (int i = 1; i < raz.length; i++) {
//            if (raz[i] > maxx) {
//                maxx = raz[i];
//            } else if (raz[i] < minn) {
//                minn = raz[i];
//            }
//        }
//        return maxx - minn;  //этот рабочий
     /*Проверьте верхний закоментированный код тоже пожалуйста,
     все вроде правильно но он ругается и не выдает нужный резултат, хотя этот код вроде как идентичен верхнему*/

    //Написать метод, который возвращает произведение элементов массива
//    public static void main(String[] args){
//        int[] num = {34, 2, 3, 67};
//        int result = Proizvedenie(num);
//        System.out.println("Произведение массива: " + result);
//
//    }
//    public static int Proizvedenie(int[] pro){
//       int prod = 1;
//        for (int i = 0; i < pro.length; i++) {
//            prod *= pro[i];
//        }
//        return prod;
//    }        //когда все получается, появляется еще больше желания это все учить


    //Написать метод, который возвращает сумму квадратов элементов массива
//    public static void main(String[] args){
//        int[] num = {3, 2, 1, 4, 5};
//        int result = Kvadrat(num);
//        System.out.println("Квадрат массива: " + result);
//    }
//    public static int Kvadrat(int[] kva){
//        int sum = 0;
//        for (int i = 0; i < kva.length; i++) {
//           sum += kva[i] * kva[i];
//        }
//        return sum;
//    }



    //Написать метод, который находит объем цилиндра по радиусу и высоте.
//    public static double Cilindr(double radius, double height){
//      return Math.PI * Math.pow(radius, 2) * height;
//    }
//    public static void main(String[] args){
//        double radius = 7.0;
//        double height = 134.0;
//        double volume = Cilindr(radius, height);
//        System.out.println("Цилиндр = " + volume);
//    }


    //Написать метод, который вычисляет гипотенузу прямоугольного треугольника по двум катетам
//    public static double Treugolnik(double gipA, double gipB){
//        return Math.sqrt(Math.pow(gipA, 2) + Math.pow(gipB, 2));
//    }
//    public static void main(String[] args){
//        double gipA = 4.0;
//        double gipB = 3.0;
//
//        double gip = Treugolnik(gipA, gipB);
//        System.out.println("Гипотенуза = " + gip);
//    }



    //Написать метод, который возвращает факториал заданного числа. через рекурсию
//    public static int Factorial(int n){
//        if (n == 0 || n ==1){
//            return 1;
//        }
//        return n * Factorial(n - 1);
//    }
//    public static void main(String[] args){
//        int numb = 16;
//        int factorial = Factorial(numb);
//        System.out.println("Факториал = " + factorial);
//    }


    //Написать метод, который возвращает сумму чисел от 1 до заданного числа без использования циклов и условий.
//    public static int sum(int n) {
//        return n * (n + 1) / 2;
//    }
//    public static void main(String[] args){
//        System.out.println(sum(5));
//    }

    //Написать метод, который проверяет, является ли число степенью двойки
//    public static boolean StepDva(int n) {
//        return n > 0 && (n & (n - 1)) == 0;
//    }
//    public static void main(String[] args){
//        System.out.println(StepDva(3));
//    }

    //Написать метод, который вычисляет сумму чисел, кратных 3 или 5, в заданном диапазоне
//    public static int kratno(int ready, int finish) {
//        int sum = 0;
//        for (int i = ready; i <= finish; i++) {
//            if (i % 3 == 0 || i % 5 == 0) {
//                sum += i;
//            }
//        }
//        return sum;
//    }
//    public static void main(String[] args){
//        System.out.println(kratno(4578, 23456));
//    }


      //Написать метод, который возвращает произведение цифр числа
//    public static int Proizvedenie(int n) {
//        if (n == 0) return 1;
//        return (int) Math.log10(Math.abs(n)) + 1;
//    }
//    public static void main(String[] args){
//        System.out.println(Proizvedenie(6));
//    }

    //Написать метод, который возвращает значение числа Фибоначчи с заданным номером
//    public static int fibonacci(int n) {
//        if (n <= 1) return n;
//        return fibonacci(n - 1) + fibonacci(n - 2);
//    }
//    public static void main(String[] args) {
//        System.out.println(fibonacci(30));
//    }

    //Написать метод, который возвращает число, полученное в результате зеркального отображения (реверса) заданного числа
//    public static int reverse(int n) {
//        int reverse = 0;
//        while (n != 0) {
//            reverse = reverse * 10 + n % 10;
//            n /= 10;
//        }
//        return reverse;
//    }
//    public static void main(String[] args){
//        System.out.println(reverse(65));
//    }

    //Написать метод, который возвращает длину окружности по заданному радиусу
//    public static double radius(double radius) {
//        return 2 * Math.PI * radius;
//    }
//    public static void main(String[] args){
//        System.out.println(radius(10));
//    }

    //Написать метод, который проверяет, является ли треугольник прямоугольным по трём сторонам
    //не люблю это задание

        public static boolean isRightTriangle(int a, int b, int c) {
            int temp;
            if (a > b) {
                temp = a;
                a = b;
                b = temp;
            }
            if (a > c) {
                temp = a;
                a = c;
                c = temp;
            }
            if (b > c) {
                temp = b;
                b = c;
                c = temp;
            }

            return a * a + b * b == c * c; //теорема пифагора
        }

        public static void main(String[] args) {
            int a = 3;
            int b = 4;
            int c = 5;

            if (isRightTriangle(a, b, c)) {
                System.out.println("Треугольник прямоугольный");
            } else {
                System.out.println("Треугольник не прямоугольный");
            }
        }

//надеюсь что джава я выучу нормально, и еще мне нравится как вы рассказываете про работу в программировании
    //когда вы это рассказываете, мне становится более ясно как выглядит моя будущая работа, спасибо







}


// Задание 1: Количество положительных и отрицательных чисел
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, -5, 3, 0, -2, 6, -8, 4, -1, 2};

        // Задание 1
        int pos = 0, neg = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) pos++;
            else if (arr[i] < 0) neg++;
        }
        System.out.println("Положительных: " + pos);
        System.out.println("Отрицательных: " + neg);

        // Задание 2: Подсчет нулей
        int[] arr2 = new int[20];
        int zeroCount = 0;
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = (int)(Math.random() * 5 - 2);
            if (arr2[i] == 0) zeroCount++;
        }
        System.out.println("Нулей: " + zeroCount);

        // Задание 3: Поиск элементов, равных индексу
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i) {
                System.out.println("Элемент равный индексу: " + arr[i]);
            }
        }

        // Задание 4: Замена отрицательных на нули
        int[] arr4 = {1, -2, 3, -4, 5, -6, 7, -8, 9, -10, 11, -12, 13, -14, 15};
        for (int i = 0; i < arr4.length; i++) {
            if (arr4[i] < 0) arr4[i] = 0;
        }
        System.out.println("Кол-во нулей " + arr4.length);

        // Задание 5: Удвоение каждого элемента
        int[] arr5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        for (int i = 0; i < arr5.length; i++) {
            arr5[i] *= 2;
        }

        // Задание 6: Элементы больше предыдущего
        int[] arr6 = {1, 3, 2, 5, 4, 6};
        int count = 0;
        for (int i = 1; i < arr6.length; i++) {
            if (arr6[i] > arr6[i - 1]) count++;
        }
        System.out.println("Больше предыдущего: " + count);

        // Задание 7: Произведение элементов, кроме нулевых
        int[] arr7 = {1, 2, 0, 4, 5};
        int product = 1;
        for (int i = 0; i < arr7.length; i++) {
            if (arr7[i] != 0) product *= arr7[i];
        }
        System.out.println("Произведение: " + product);

        // Задание 8: Сравнение суммы первых и последних пяти элементов
        int[] arr8 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sumStart = 0, sumEnd = 0;
        for (int i = 0; i < 5; i++) {
            sumStart += arr8[i];
            sumEnd += arr8[arr8.length - 1 - i];
        }
        System.out.println("Сумма первых > последних: " + (sumStart > sumEnd));

        // Задание 9: Два наименьших элемента
        int[] arr9 = {12, 3, 5, 7, 1, 9, 2, 4, 6, 8};
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i = 0; i < arr9.length; i++) {
            if (arr9[i] < min1) {
                min2 = min1;
                min1 = arr9[i];
            } else if (arr9[i] < min2) {
                min2 = arr9[i];
            }
        }
        System.out.println("Минимальные: " + min1 + ", " + min2);

        // Задание 10: Проверка на возрастание
        boolean isAscending = true;
        for (int i = 1; i < arr8.length; i++) {
            if (arr8[i] < arr8[i - 1]) {
                isAscending = false;
                break;
            }
        }
        System.out.println("По возрастанию: " + isAscending);

        // Задание 11: Проверка на убывание
        boolean isDescending = true;
        for (int i = 1; i < arr8.length; i++) {
            if (arr8[i] > arr8[i - 1]) {
                isDescending = false;
                break;
            }
        }
        System.out.println("По убыванию: " + isDescending);

        // Задание 12: Частота элементов
        int[] freqArr = {1, 2, 2, 3, 1, 4, 2, 5};
        for (int i = 0; i < freqArr.length; i++) {
            int countFreq = 0;
            for (int j = 0; j < freqArr.length; j++) {
                if (freqArr[i] == freqArr[j]) countFreq++;
            }
            System.out.println(freqArr[i] + ": " + countFreq);
        }

        // Задание 13: Инвертирование знаков
        int[] arr13 = {-1, 2, -3, 4};
        for (int i = 0; i < arr13.length; i++) {
            arr13[i] = -arr13[i];
        }

        // Задание 14: Квадраты на чётных индексах
        int[] arr14 = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < arr14.length; i++) {
            if (i % 2 == 0) arr14[i] *= arr14[i];
        }

        // Задание 15: Сумма элементов на чётных индексах
        int sum = 0;
        for (int i = 0; i < arr14.length; i++) {
            if (i % 2 == 0) sum += arr14[i];
        }
        System.out.println("Сумма на четных: " + sum);

        // Задание 16: Замена минимального на 100
        int[] arr16 = {5, 2, 3, 1, 9};
        int min = arr16[0], minIndex = 0;
        for (int i = 1; i < arr16.length; i++) {
            if (arr16[i] < min) {
                min = arr16[i];
                minIndex = i;
            }
        }
        arr16[minIndex] = 100;

        // Задание 17: Обратный порядок
        int[] arr17 = {1, 2, 3, 4, 5};
        for (int i = arr17.length - 1; i >= 0; i--) {
            System.out.print(arr17[i] + " ");
        }
        System.out.println();

        // Задание 18: Замена на индекс
        int[] arr18 = new int[5];
        for (int i = 0; i < arr18.length; i++) {
            arr18[i] = i;
        }

        // Задание 19: Сумма положительных
        int[] arr19 = {-1, 2, 3, -4};
        int sum19 = 0;
        for (int i = 0; i < arr19.length; i++) {
            if (arr19[i] > 0) sum19 += arr19[i];
        }
        System.out.println("Сумма положительных: " + sum19);

        // Задание 20: Последний отрицательный на 0
        int[] arr20 = {1, -2, 3, -4, 5};
        for (int i = arr20.length - 1; i >= 0; i--) {
            if (arr20[i] < 0) {
                arr20[i] = 0;
                break;
            }
        }

        // Задание 21: Удвоение на нечётных индексах
        int[] arr21 = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr21.length; i++) {
            if (i % 2 != 0) arr21[i] *= 2;
        }

        // Задание 22: Замена максимального на минимальный
        int[] arr22 = {4, 1, 6, 3, 9};
        int max = arr22[0], maxIndex = 0;
        min = arr22[0];
        for (int i = 1; i < arr22.length; i++) {
            if (arr22[i] > max) {
                max = arr22[i];
                maxIndex = i;
            }
            if (arr22[i] < min) min = arr22[i];
        }
        arr22[maxIndex] = min;

        // Задание 23: Замена кратных 2 и 3 на 100
        int[] arr23 = {6, 4, 9, 12, 5};
        for (int i = 0; i < arr23.length; i++) {
            if (arr23[i] % 2 == 0 && arr23[i] % 3 == 0) arr23[i] = 100;
        }

        // Задание 24: Кол-во элементов больше среднего
        int[] arr24 = {1, 2, 3, 4, 5};
        int sum24 = 0;
        for (int i = 0; i < arr24.length; i++) sum24 += arr24[i];
        double avg = (double) sum24 / arr24.length;
        int count24 = 0;
        for (int i = 0; i < arr24.length; i++) {
            if (arr24[i] > avg) count24++;
        }
        System.out.println("Больше среднего: " + count24);

        // Задание 25: Индекс максимального элемента
        int[] arr25 = {1, 7, 3, 9, 4};
        int max25 = arr25[0], maxIdx = 0;
        for (int i = 1; i < arr25.length; i++) {
            if (arr25[i] > max25) {
                max25 = arr25[i];
                maxIdx = i;
            }
        }
        System.out.println("Индекс максимального: " + maxIdx);
    }
}

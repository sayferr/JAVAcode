import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //Задание пять и шесть
        System.out.println("Задание пять и шесть");
        int Numb[] = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int count = 0;
        int mcount = 0;
        for (int i = 0; i < Numb.length; i++) {
            if (Numb[i]%2==0){
                count++;
            } else {
                mcount++;
            }

        }
        System.out.println("четные =" + " " + count);
        System.out.println("нечетные =" + " " + mcount);






        System.out.println();
        System.out.println();

        //первое задание есть
        int numb[] = new int[10]; //{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Первое задание");
        for (int i = 0; i < numb.length; i++) {
            numb[i] = i + 1;
            System.out.print(numb[i] + " ");


        }

        System.out.println();
        System.out.println();


        //Второе заадние
        System.out.println("второе заадние");
        int arr[] = new int[] {1, 2, 3, 4, 5};
        int safe = 0;
        for (int i = 0; i < arr.length; i++) {
            safe += arr[i];
        }
        System.out.println("Сумма всех чисел" + " " + safe);

        System.out.println();
        System.out.println();


        //Задание три и четыре
        System.out.println("Задание три и четыре");
        int Max[] = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int max = Max[0];
        int min = Max[0];
        for (int i = 0; i < Max.length; i++) {
            if (Max[i] > max) {
                max = Max[i];
            }   else{
                min = Max[i];
            }
        }
        System.out.println("Максимальный элемент =" + " " + max);
        System.out.println("Минимальный элемент =" + " " + min);


        System.out.println();
        System.out.println();


        //Задание семь
        System.out.println("Задание семь");
        int sred[] = new int[] {18, 2, 34, 4, 57};
        int hra = 0;
        for (int i = 0; i < sred.length; i++) {
            hra += sred[i];
        }
        double aver = (double) hra / sred.length;
        System.out.println("Среднее =" + " " + aver);

        System.out.println();
        System.out.println();


        //задание восемь
        System.out.println("Задание восемь");
        int obratno[] = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = obratno.length - 1; i >= 0; i--) {
            System.out.print(obratno[i] + " ");
        }

        System.out.println();
        System.out.println();


        //Задание девять
        System.out.println("Задание девять");
        int rand[] = new int[10];
        Random random = new Random();
        for (int i = 0; i < rand.length; i++) {
            rand[i] = random.nextInt(100) + 1;
            System.out.print(rand[i] + " ");
        }

        System.out.println();
        System.out.println();




        //Задание десять
        System.out.println("Задание десять");
        int suka[] = new int[] {1, 2, 3, 4, 5};
        int temp = suka[0];
        suka[0] = suka[suka.length - 1];
        suka[suka.length - 1] = temp;
        for (int i = 0; i < suka.length; i++) {
            System.out.print(suka[i] + " ");
        }

        System.out.println();
        System.out.println();



        //Задание одиннадцать
        System.out.println("Задание одиннадцать");
        int MAx [] = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int maxx = Max[0];
        int minn = Max[0];
        for (int i = 0; i < Max.length; i++) {
            if (MAx[i] > maxx) {
                maxx = MAx[i];
            }   else{
                minn = MAx[i];
            }
        }
        int raznica = max - min;
        System.out.println("Разница" + " " + raznica);

        System.out.println();
        System.out.println();


        //задание двенадцать
        System.out.println("Задание двенадцать");
        int Sred[] = new int[] {18, 2, 34, 4, 57};
        int hran = 0;
        for (int i = 0; i < Sred.length; i++) {
            hran += Sred[i];
        }
        double avera = (double) hran / Sred.length;
        int ya = 0;
        for (int i = 0; i < Sred.length; i++) {
            if (Sred[i] > avera){
                ya++;
            }
        }
        System.out.print("Количество элементов больше средне арифметического" + " " + ya);

        System.out.println();
        System.out.println();


        //Задание тринадцать
        System.out.println("Задание тринадцать");
        int cisla[] = new int[10];
        for (int i = 0; i < cisla.length; i++) {
            cisla[i] = (i + 1) * (i + 1);
        }
        for (int i = 0; i < cisla.length; i++) {
            System.out.print(cisla[i] + " ");
        }
    }
}
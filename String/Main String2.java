public class Main {
   // public static void main(String[] args) {

//        String name1 = "Roman";
//        String name2 = "RomAn";
//        if (name1.equalsIgnoreCase(name2)){
//            System.out.println("True");
//        }else{
//            System.out.println("False");
//        }


//      String name = "Roma";
//      String username = " sayfer";
//      String result = name.concat(username);
//        System.out.println(result);


//          String str = "Roma works every day";
//        System.out.println(str.contains("R"));


//        String str = "Roma works every day";
//        System.out.println(str.startsWith("R")); //Если напишу Y, то выдаст False, учитывает размер буквы тоже
//        System.out.println(str.endsWith("y")); //Если напишу R, то выдаст False, учитывает размер буквы тоже


//        String str ="Roma works every day";
//        System.out.println(str.substring(4));//Печатает после третьего индекса
//        System.out.println(str.substring(0,4));//Печатает от инжекса 0 включительно до индекса 4 не включительно


//        String str = "Roma works every day";
//        System.out.println(str);
//        String result = str.replace("day", "week");//replace меняет одно слово на другое необходимое
//        System.out.println(result);


//        String str = "Roma.works.every.Day";
//        String[] arr = str.split("\\.");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }


//         String str = "Roma";
//         char[] arr = str.toCharArray();
//        System.out.println(arr[0] +""+ arr[1] + arr[2] + arr[3] );


//        String str = "Roma";
//        str.indexOf("om");// цифра под видом буквы
//        //str.indexOf(1); //indexOf возвращает букву под видом цифры(индекса)
//        System.out.println(str.indexOf("oma"));


        //Создание массива арр2 + 1
//        int[] arr = {1, 2, 3, 4, 5};
//        int[] arr2 = new int[arr.length + 1];
//        for (int i = 0; i < arr.length; i++) {
//            arr2[i] = arr[i];
//        }
//
//        arr2[arr.length] = 6;
//        /*arr2[arr.length] = 7;*/
//
//        for (int i = 0; i < arr2.length; i++) {
//            System.out.print(arr2[i] + " ");
//
//        }



    //////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////

        /*  Домашка + практика из видеоурока (практика именно решения домашнего задания)  */

//                   удаление пробелов слева Ltrim

//        public static char[] Ltrim(char[] arr){
//            int countSpaceL = 0;
//            for (int i = 0; i < arr.length; i++) {
//                if(arr[i] == ' '){
//                    countSpaceL++;
//                }else {
//                    break;
//                }
//            }
//            char[] newArr = new char[arr.length - countSpaceL];
//            for (int i = countSpaceL, j = 0; i < arr.length; i++, j++) {
//                newArr[j] = arr[i];
//            }
//            return newArr;
//
//        }
//
//    public static void main(String[] args){
//        String str = "     Roman     ";
//        char[] arr = str.toCharArray();
//        System.out.println(Ltrim(arr));
//        System.out.println(Ltrim(arr).length);
//    }


//           удаление пробелов справа  Rtrim

//    public static char[] Rtrim(char[] arr){
//        int countSpaceR = 0;
//        for (int i = arr.length - 1; i >= 0; i--) {
//            if(arr[i] == ' '){
//                countSpaceR++;
//            }else {
//                break;
//            }
//        }
//        char[] newArr = new char[arr.length - countSpaceR];
//        for (int i = 0; i < newArr.length; i++) {
//            newArr[i] = arr[i];
//        }
//        return newArr;
//
//    }
//
//    public static void main(String[] args){
//        String str = "     Roman     ";
//        char[] arr = str.toCharArray();
//        System.out.println(Rtrim(arr));
//        System.out.println(Rtrim(arr).length);
//    }



      //          replace

//    public static String replaceSpaces(String str) {
//    return str.replace("Hello", "Barev");
//
//    }
//
//    public static void main(String[] args) {
//        String str = "Hello brat";
//        System.out.println(replaceSpaces(str));
//    }



      //      startsWith

//    public static boolean startsWith(String str){
//        return str.startsWith("R");
//    }
//    public static void main(String[] args) {
//        String str = "Roman ";
//        System.out.println(startsWith(str));
//    }



      //         endsWith
//      public static boolean endsWith(String str){
//        return str.endsWith("n");
//      }
//    public static void main(String[] args) {
//        String str = "Roman";
//        System.out.println(endsWith(str));
//    }



    //           concat
//    public static String concat(String name, String username){
//        return name + username;
//    }
//    public static void main(String[] args){
//        String name = "Roma";
//        String username = "Sayfer";
//        String result = concat(name, username);
//        System.out.println(result);
//    }



    //            substring
//    public static String substring(String str){
//        return str.substring(0,5);//если вместо 0 и 5 написать просто 0, то он выведет букыу "R"
//    }
//    public static void main (String[] args){
//        String str = "Romanik";
//        String result = substring(str);
//        System.out.println(result);
//    }



     //  toCharArray

//     public static char[] StringtoCharArray(String str){
//         return str.toCharArray();
//     }
//    public static void main (String[] args){
//         String str = "Roma";
//         char[] resultArr = StringtoCharArray(str);
//        System.out.println(resultArr.length);
//        System.out.println(resultArr[0] + resultArr[1] + resultArr[2] + resultArr[3]);
//        System.out.println(resultArr);
//    }



     //          equals
//    public static boolean equals(String str1, String str2){
//        if (str1 == null || str2 == null){
//            return false;
//        }else if (str1.equals(str2)){
//            return true;
//        }else{
//            return false;
//        }
//    }
//    public static void main (String[] args){
//       String str1 = "Hello";
//       String str2 = "Hello";
//
//        if (equals(str1, str2)){
//            System.out.println("True");
//        }else{
//            System.out.println("False");
//        }
//    }



//                   EqualsIgnoreCase

//    public static boolean EqualsIgnoreCase(char[] one, char[] two) {
//        if (one.length != two.length) {
//            return false;
//        }
//        for (int i = 0; i < one.length; i++) {
//
//            char X = one[i];
//            char Y = two[i];
//
//            if (one[i] > 65 && one[i] < 90){
//              X = (char)(one[i] + 32);
//            }
//
//            if (two[i] > 65 && two[i] < 90){
//                Y = (char)(two[i] + 32);
//            }
//
//            if (X != Y){
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//
//public static void main (String[] args){
//    String name1 = "Roman";
//    String name2 = "RomAN";
//        if (name1.equalsIgnoreCase(name2)){
//        System.out.println("True");
//    }else{
//        System.out.println("False");
//    }
//    }



    //          index of (char a)

//    public static int indexOf(String text, char a){
//        return text.indexOf('I');//если здесь будет другой символ не совпадающий с sout, то он выведет -1
//    }
//    public static void main(String[] args){
//        String str = "I want will create my ideal world";
//        System.out.println(indexOf(str, 'I'));
//    }


    //             indexOf(String a, int fromindex)

//    public static int indexOf(String text, char a, int fromindex){
//        return text.indexOf(a, fromindex);
//    }
//    public static void main(String[] args){
//        String str = "I want will create my ideal world";
//        System.out.println(indexOf(str, 't', 3 ));/* начианет искать с индекса 3 и далее
//          если вместо 't' искать 'I' с третьего индекса, тогда он выведет нам -1 */
//    }


    //             lastIndexOf( char a)

//    public static int lastIndexOf(String text, char a){
//        return text.lastIndexOf(a);
//    }
//    public static void main(String[] args){
//        String str = "I want will create my ideal world";
//        System.out.println(lastIndexOf(str,'w'));//последнее вхождение 'w', было в слове world
//    }


    //          lastIndexOf(char a, int fromindex)

//    public static int lastIndexOf(String text, char a, int fromindex){
//        return text.lastIndexOf(a, fromindex);
//    }
//    public static void main(String[] args){
//        String str = "I want will create my ideal world";
//        System.out.println(lastIndexOf(str, 'w', 20));/* в остальных случаях
//        выходящих из под условий будет выведено -1 */
//    }


    //               lastIndexOf( char[] a)

//    public static int lastIndexOf(String text, char[] a){
//        return text.lastIndexOf(new String(a));
//    }
//    public static void main(String[] args){
//        String str = "I want will create my ideal world";
//        char[] search = {'w'};//последнее вхождение этой буквы было в слове world
//        System.out.println(lastIndexOf(str, search));
//    }



//              indexOf(char[] a)

//    public static int IndexOf(String text, char[] a){
//        return text.indexOf(new String(a));
//    }
//    public static void main(String[] args){
//        String str = "I want will create my ideal world";
//        char[] search = {'w'};//находит первое вхождение этой буквы
//        System.out.println(IndexOf(str, search));//будет 2
//    }


    //     indexOf( char[] a , int fromIndex)

//    public static int IndexOf(String text, char[] a, int fromindex){
//        return text.indexOf(new String(a), fromindex);
//    }
//    public static void main(String[] args){
//        String str = "I want will create my ideal world";
//        char[] search = {'w'};
//        System.out.println(IndexOf(str, search, 15));//ищет с 15 индекса
//    }


    //lastIndexOf( char[] a , int fromIndex)

//    public static int lastIndexOf(String text, char[] a, int fromindex){
//        return text.lastIndexOf(new String(a), fromindex);
//    }
//    public static void main(String[] args){
//        String str = "I want will create my ideal world";
//        char[] search = {'w'};
//        System.out.println(lastIndexOf(str, search, 15));
//    }



    //               split

//    public static String[] split(String str){
//        return str.split(", ");
//    }
//    public static void main(String[] args){ /* это одна из моих любимых сцен,
//    поэтому извиняюсь если цитата вышла слишком длинной */
//        String str = "I will create an ideal society, I will create a world, in which only responsible and kind peaple will live";
//        String[] result = split(str);
//        for (int i = 0; i < result.length; i++) {
//            System.out.println();
//            System.out.println(result[i]);
//        }
//    }



//               contains
//    public static boolean contains(String str){
//        return str.contains("b");/* при воде буквы "b" программа выдаст false
//         при вводе любой буквы из текста, к примерру "w" или "I" программа выдаст true */
//    }
//    public static void main(String[] args){
//        String str = "I want will create my ideal world";
//        boolean result = contains(str);
//        System.out.println(result);
//    }


    //        Trim

        public static char[] trim(char[] arr ){
       int countl = 0;
       int countR = 0;
        for (int i = 0; i < arr.length; i++) {
          if(arr[i]==' '){
              countl++;
          }
          else{
              break;
          }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i]==' '){
                countR++;
            }
            else {
                break;
            }
        }
        char[] arr2 = new char[arr.length - countl - countR];
        System.out.println(arr2.length);

        for (int i = countl, j = 0;  i < arr.length - countR; i++, j++) {
        arr2[j] = arr[i];
        }
        return arr2;
    }
    public static void main(String[] args){
        String str = "       roman   rom    ";
        char[] array = str.toCharArray();
        char[] result = trim(array);
        System.out.println(str.trim().length());
        System.out.println(result);
              // System.out.println(str);
    }




}

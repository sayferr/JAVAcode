public class Main {
    //Задание 1
//    public static int length(char[] arr){
//        int count = 0;
//        for (int i = 0; i < arr.length; i++) {
//            count++;
//
//        }
//        return count;
//    }
//
//    public static void main(String[] args){
//        char[] arr = {'r', 'o', 'm', 'a', 'n'};
//        System.out.println("Количество символов = " + length(arr));
//    }


    //Задание 2

//        public static void main(String[] args) {
//            char[] arr = {'r', 'o', 'm', 'a', 'n'};
//            int index =4;
//            char result = charAt(arr, index);
//            System.out.println("Символ " + index + ": " + result);
//        }
//
//        public static char charAt(char[] arr, int index) {
//            if (index >= 0 && index < arr.length) {
//                return arr[index];
//            }
//            return 0;
//        }



    //Задание 3
//        public static void main(String[] args) {
//            char[] arr = { 'r', 'o', 'm', 'a'};
//            char simvol = '8';
//            int index = indexOf(arr, simvol);
//            System.out.println("Индекс символа '" + simvol + "': " + index);
//        }
//
//        public static int indexOf(char[] arr, char simvol) {
//            for (int i = 0; i < arr.length; i++) {
//                if (arr[i] == simvol) {
//                    return i;
//                }
//            }
//            return -1;
//        }


    //Задание 4
//         public static void main(String[] args) {
//            char[] arr = { 'r', 'o', 'm', 'a'};
//            char simvol = 'm';
//            int index = lastindexOf(arr, simvol);
//            System.out.println("Индекс символа '" + simvol + "': " + index);
//        }
//
//        public static int lastindexOf(char[] arr, char simvol) {
//            for (int i = arr.length - 1; i >= 0; i--) {
//                if (arr[i] == simvol) {
//                    return i;
//                }
//            }
//            return -1;
//        }






    //Задание 5

//    public static char[] ToUpperCase(char[] str){
//        for (int i = 0; i < str.length; i++) {
//    if(str[i]>= 97 && str[i]<=122)
//      {
//            str[i] -= 32;
//            }
//
//        }
//        return str;
//    }
//
//    public static void main(String[] args){
//       char[] arr = {'r','o','m','a','n'};
//       arr = ToUpperCase(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]);
//        }
//    }


    //Задание 6

//    public static char[] ToLowerCase(char[] str){
//        for (int i = 0; i < str.length; i++) {
//           //if(str[i]>= 97 && str[i]<=122)
//           //{
//            str[i] += 32;
//          // }
//        }
//        return str;
//    }
//    public static void main(String[] args){
//       char[] arr = {'R','O','M','A','N'};
//       arr = ToLowerCase(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]);
//        }  //Я не пониаю, почему с условием if код работает неправильно
//    }


    //Задание 7
//    public static char[] trim(char[] arr ){
//       int countl = 0;
//       int countR = 0;
//        for (int i = 0; i < arr.length; i++) {
//          if(arr[i]==' '){
//              countl++;
//          }
//          else{
//              break;
//          }
//        }
//        for (int i = arr.length - 1; i >= 0; i--) {
//            if (arr[i]==' '){
//                countR++;
//            }
//            else {
//                break;
//            }
//        }
//        char[] arr2 = new char[arr.length - countl - countR];
//        System.out.println(arr2.length);
//
//        for (int i = countl, j = 0;  i < arr.length - countR; i++, j++) {
//        arr2[j] = arr[i];
//        }
//        return arr2;
//    }
//    public static void main(String[] args){
//        String str = "       roman   rom    ";
//        char[] array = str.toCharArray();
//        char[] result = trim(array);
//        System.out.println(str.trim().length());
//        System.out.println(result);
//              // System.out.println(str);
//    }
}
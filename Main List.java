import java.util.ArrayList;
import java.util.List;

//class DynamicArray{  //использование List
//    private List<String> data = new ArrayList<>();
//
//    public void print(){
//        for (String s : data){
//            System.out.println(s);
//        }
//    }
//
//    public void add(String value){
//        data.add(value);
//    }
//
//    public void add(int index, String value){
//        data.add(index, value);
//    }
//
//    public String get(int index){
//        return data.get(index);
//    }
//
//    public void set(int index, String value){
//        data.set(index, value);
//    }
//
//    public void remove(int index){
//        data.remove(index);
//    }
//
//    public int size(){
//       return data.size();
//    }
//
//    public void clear(){
//        data.clear();
//    }
//}


class Main{
    public static void main(String[] args){
        /**
         * add (S str) - добавляет значение в конец
         * add(Int index, S str) - добавляет значение по указанному индексу
         * get(int index) - получаем элемет по индексу
         * set(int index, S str) - замена значения по индексу
         * remove(int index) - удаляет значеие по индексу
         * sizq() - возвращает количество элементов
         * clear() - полная чистка(удаление)
         * */
         DynamicArray dynamicArray = new DynamicArray(); // использование List
         dynamicArray.add("Камилла");
         dynamicArray.add(1,"Давид");
         dynamicArray.add(2,"Рома");
         dynamicArray.remove(2);

         dynamicArray.print();
    }
}

class DynamicArray{  // без использование List
    private String[] data;
    private int size;

    public DynamicArray(){
        data = new String[10];
        size = 0;
    }
    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.println(data[i]);
        }
    }

    public void add(String value){
        if (size == data.length){
            String[] newData = new String[data.length + 1];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
        data[size] = value;
        size++;
    }

    public void add(int index, String value) {
        if (size == data.length) {
            String[] newData = new String[data.length + 1];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            newData[index] = value;
            for (int i = index; i < size; i++) {
                newData[i + 1] = data[i];
            }
            data = newData;
        } else {
            for (int i = size; i > index ; i--) {
                data[i] = data[i - 1];
            }
            data[index] = value;
        }
        size++;
    }

    public boolean remove(String value){
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)){
                index = i;
                break;
            }
        }
        if (index != -1){
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            data[size - 1] = null;
            return true;
        }
        return false;
    }

    public boolean remove(int index){
        if (index < 0 || index > size){
            return false;
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        return true;
    }

    public String get(int index){
        return data[index];
    }

    public int size(){
        return size;
    }

    public void clear(){
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }
}

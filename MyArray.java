public class MyArray {
    private int size;
    private int[] arr;

    public int getSize() {
        return size;
    }

    public int[] getArr() {
        return arr;
    }

    public MyArray() {
        arr = new int[20];
        size = 0;
    }

    public int clear() {
        return size = 0;
    }

    public boolean isHasValue(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(int value){
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void removeByIndex(int index){
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    public void removeByValue(int value){
        int index = indexOf(value);
        if (index != -1){
            removeByIndex(index);
        }
    }

    public void add(int value){
        arr[size] = value;
        size++;
    }

    public void addAll(Integer[] array){
        for (int i = 0; i < arr.length; i++) {
            add(array[i]);
        }
    }

    public void decreaseArr() {
        for (int i = 0; i < size; i++) {
            arr[i]--;
        }
    }

    public void removeAllDuplikat(){
        for (int i = 0; i < size; i++) {
            int currentvalue = arr[i];
            for (int j = i + 1; j < size; j++) {
                if (arr[i] == currentvalue){
                    removeByIndex(j);
                    j--;
                }
            }
        }
    }

    public void printInfo(){
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }
}

class Main{
    public static void main(String[] args){
        MyArray myArray = new MyArray();

        myArray.add(1);
        myArray.add(40);
        myArray.add(56);
       // myArray.removeByIndex(2);
        myArray.printInfo();
    }
}
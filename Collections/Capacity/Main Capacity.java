class MyList{
    private int[] array;
    private int size;
    private int capacity;

    {
        size = 0;
        capacity = 10;
        array = new int [capacity];
    }

    public int size(){
        return size;
    }

    public int capacity(){
        return capacity;
    }

    public void add(int value){
       increaseArr();

        array[size] = value;
        size++;
    }

    public void increaseArr(){
        if (size >= capacity){
            capacity = capacity * 2 + 1;
            int[] tmp = new int[capacity];
            for (int i = 0; i < size; i++) {
                tmp[i] = array[i];
            }
            array = tmp;
        }
    }

    public void AddStart(int valeu){
        increaseArr();

        for (int i = size; i > 0 ; i--) {
            array[i] = array[i - 1];
        }
        array[0] = valeu;
        size++;
    }

    public void AddByIndex(int index, int value){
        if (index < 0){
            AddStart(value);
        }else if (index >= size){
            add(value);
        }else {
            increaseArr();

            for (int i = size - 1, j = size; i >= 0 ; i--, j--) {
                array[j] = array[i];
                if(i == index){
                    array[j] = value;
                    break;
                }
            }
            size++;
        }
    }

    public void sort(boolean isFlag){
        for (int i = 0; i < size; i++) {
            for (int j = isFlag ? i + 1 : 0; j < size; j++) {
                if (array[i] > array[j]){
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    public void removeByIndex(int index){
        for (int i = index; i > size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = 0;
        size--;
    }

    public void removeByValue(int value){
        for (int i = 0; i < size; i++) {
            if (array[i] == value){
                for (int j = 0; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                size--;
                return;
            }
        }
    }

    public boolean isHasValue(int value){
        for (int i = 0; i < size; i++) {
            if (array[i] == value){
                return true;
            }
        }
        return false;
    }

    public void printinfo() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
       MyList myList = new MyList();
       myList.add(1);
       myList.add(2);
       myList.add(3);
       myList.add(4);
       myList.AddStart(14);

       myList.isHasValue(9);
       myList.printinfo();

        System.out.print(myList.size() + "/" + myList.capacity());
    }
}
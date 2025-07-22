import java.util.ArrayList;
import java.util.Collection;

class MySet<E>{
    private ArrayList<E> elements;

    public MySet(){
        elements = new ArrayList<>();
    }

    // 1. Добавляет элемент в множество, если его еще нет
    public boolean add(E e) {
        for (E element : elements){
            if (element == null && e == null){
                return false;
            }
            if (element != null && element.equals(e)){
                return false;
            }
        }
        elements.add(e);
        return true;
    }

    // 2. Удаляет элемент из множества
    public boolean remove(Object o) {
        for (int i = 0; i < elements.size(); i++) {
            E element = elements.get(i);
            if (element == null && o == null){
                elements.remove(i);
                return  true;
            }
            if (element != null && element.equals(o)){
                return true;
            }
        }
        return false;
    }

    // 3. Проверяет, содержит ли множество указанный элемент
    public boolean contains(Object o) {
        for (E element : elements){
            if (element == null && o == null){
                return  true;
            }
            if (element != null && element.equals(o)){
                return true;
            }
        }
        return false;
    }

    // 4. Возвращает количество элементов в множестве
    public int size() {
        return elements.size();
    }

    // 5. Проверяет, пусто ли множество
    public boolean isEmpty() {
        return elements.size() == 0;
    }

    // 6. Удаляет все элементы из множества
    public void clear() {
       elements.clear();
    }

    // 7. Добавляет все элементы из указанной коллекции в множество
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E e : c){
            if (this.add(e)){
                modified = true;
            }
        }
        return modified;
    }

    // 8. Проверяет, содержит ли множество все элементы из указанной коллекции
    public boolean containsAll(Collection<?> c) {
        for (Object o : c){
            if (!this.contains(o)){
                return false;
            }
        }
        return true;
    }

    // 9. Удаляет из множества все элементы, которые есть в указанной коллекции
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object o : c){
            if (this.remove(o)){
                modified = true;
            }
        }
        return modified;
    }

    // 10. Сохраняет только те элементы, которые есть в указанной коллекции
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (int i = 0; i < elements.size(); i++) {
            E element = elements.get(i);
            boolean found = false;
            for (Object o : c){
                if (element == null && c == null){
                    found = true;
                    break;
                }
                if (element != null && element.equals(o)){
                    found = true;
                    break;
                }
            }
            if (!found){
                elements.remove(i);
                i--;
                modified = true;
            }
        }
        return modified;
    }
}


public class Set {
    public static void main(String[] args){

        MySet <Integer> mySet = new MySet<>();
        mySet.add(20);
        mySet.add(30);
        mySet.add(40);

        System.out.println(mySet.size());

    }
}
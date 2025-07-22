//import java.util.LinkedList;
//import java.util.List;

public class LinkedList2 {
    private Node head;
    private Node tail;
    private int size = 0;

    public String removeLast(){
        if (head==null) return null;

        Node tmp = head;
        while (tmp.next.next!=null){ /** идем через одно значение */
            tmp = tmp.next;
        }
        String removed = tmp.next.value; /** когда мы на предпоследнем значении, мы удаляем последнее значение */
        tmp.next = null;
        return removed;
    }

    public String removeStart(){
        if (tail==null) return null;

        String removed = head.value;
        head = head.next;
        if (head!=null){
            head.prev = null;
        }else {
            tail = null;
        }
        return removed;
    }

    public void clear(){
        head = null;
        tail = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public String getFirst(){
        if (head == null) return null;
        return head.value;
    }

    public String getLast(){
        if (tail == null) return null;
        return tail.value;
    }

    public String remove(int index) {
        if (head == null) return null;

        int count = 0;
        Node current = head;

        while (current != null) {
            if (count == index) {
                String removed = current.value;

                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                return removed;
            }
            count++;
            current = current.next;
        }
        return null;
    }

    public String remove(String value) {
        Node current = head;

        while (current != null) {
            if (current.value.equals(value)) {
                String removed = current.value;

                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                return removed;
            }
            current = current.next;
        }
        return null;
    }

    public void set(int index, String value) {
        Node current = head;
        int count = 0;

        while (current != null) {
            if (count == index) {
                current.value = value;
                return;
            }
            count++;
            current = current.next;
        }
    }

}

class Node{
    String value;
    Node next;
    Node prev;

    Node(String value){
        this.value = value;
    }
}

class Main{
    public static void main(String[] args) {
        LinkedList2 linkedList2 = new LinkedList2();

    }
}
class Node{
    String value;
    Node next;
    Node prev;

    Node(String value){
        this.value = value;
    }
}

public class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    public int size(){
        return size;
    }

    public boolean contains(String value){
        Node current = head;
        while (current != null){
            if (current.value.equals(value)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int indexOf(String value){
        Node current = head;
        int index = 0;
        while (current != null){
            if (current.value.equals(value)){
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public String get(int index){
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public void add(int index , String value){
        Node node = new Node(value);
        if (index == 0) {
            
            if (head == null) {
                head = tail = node;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }
        } else if (index == size) {
            node.prev = tail;
            tail.next = node;
            tail = node;
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            node.prev = current.prev;
            node.next = current;
            current.prev.next = node;
            current.prev = node;
        }
        size++;
    }
}
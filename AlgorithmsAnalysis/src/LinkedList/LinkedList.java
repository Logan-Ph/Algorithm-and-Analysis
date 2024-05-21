package LinkedList;

public class LinkedList<T> {
    private int size;
    private Node<T> head;

    public LinkedList(T data){
        size = 0;
        this.head = new Node<T>(data);
    }

    public int size(){
        return size;
    }

    private boolean insertAtHead(T value){
        Node<T> newNode = new Node<T>(value);
        newNode.next = this.head;
        this.head = newNode;
        size++;
        return true;
    }

    public boolean insertAt(int index, T value){
        if (index > size) return false;

        if (index == 0) return insertAtHead(value);

        Node<T> temp = this.head;
        Node<T> newNode = new Node<T>(value);
        for (int i =0; i < index - 1; i++){
            temp = temp.next;
        }
    
        newNode.next = temp.next;
        temp.next = newNode;
        size++; 
        return true;
    }

    public boolean insertBefore(T searchValue, T data){
        if (this.head == null) return false;

        if (this.head.data.equals(data)) return insertAtHead(data);
    
        Node<T> temp = this.head;
        Node<T> newNode = new Node<T>(data);
        while (temp != null) {
            if (temp.next.data.equals(searchValue)){
                newNode.next = temp.next;
                temp.next = newNode;
                size++;
                return true;
            }
            
            temp = temp.next;
        }

        return false;
    }


    public boolean insertAfter(T searchValue, T data){
        if (this.head == null) return false;

        Node<T> temp = this.head;
        Node<T> newNode = new Node<T>(data);
        while (temp != null) {
            if (temp.data.equals(searchValue)){
                newNode.next = temp.next;
                temp.next = newNode;
                size++;
                return true;
            }

            temp = temp.next;
        }
    
        return false;
    }

    private boolean removeAtHead(){
        if (head == null) return false;

        head = head.next;
        size--;
        return true;
    }

    public boolean removeAt(int index){
        if (head == null) return false;

        if (index > size) return false;

        if (index == 0) return removeAtHead();

        Node<T> temp = this.head;
        for (int i =0; i < index - 1; i++){
            temp = temp.next;
        }

        temp.next = temp.next.next;
        size--;
        return true;
    }

    public T get(int index){
        if (index >= size) return null;

        Node<T> temp = this.head;
        for (int i = 0; i < index; i++ ){
            temp = temp.next;
        }
        return temp.data;
    }

    public void removeLoop(){
        Node<T> fast = this.head;
        Node<T> slow = this.head;

        while (true) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.equals(slow)){
                break;
            }
        }

        slow = this.head;
        while (!slow.next.data.equals(fast.next.data)) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
    }

    @Override
    public String toString() {
        Node<T> temp = this.head;
        StringBuilder buffer = new StringBuilder();

        while (temp != null) {
            buffer.append(temp.data + " -> ");
            temp =temp.next;
        }
        
        buffer.append("null");
        return buffer.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>(2);
        linkedList.insertAtHead(3);
        linkedList.insertAtHead(4);
        linkedList.insertAtHead(5);
        linkedList.insertAtHead(6);
        linkedList.insertAtHead(7);

        System.out.println(linkedList);
        linkedList.head.next.next.next.next.next.next = linkedList.head.next.next.next;

        linkedList.removeLoop();
        System.out.println(linkedList);

    }
}

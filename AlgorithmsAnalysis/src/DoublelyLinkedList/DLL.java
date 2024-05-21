package DoublelyLinkedList;

public class DLL<T> {
    Node<T> head, tail;
    int size;

    public DLL(T data){
        this.head = new Node<T>(data);
        this.tail = head;
        size = 1;
    }

    public void appendNode(T data){
        Node<T> newNode = new Node<T>(data);

        this.tail.next = newNode;
        newNode.prev = this.tail;
        this.tail = newNode;
        size++;
    }

    public Node<T> getNode(int index){
        Node<T> temp = null;

        if (index < size / 2){
            temp = this.head;
            for (int i = 0; i < index; i++){
                temp = temp.next;
            }
        }else{
            temp = this.tail;
            for (int i = 0; i < size - index; i++){
                temp = temp.prev;
            }
        }

        return temp;
    }

    public void addBefore(Node<T> w, T data){
        Node<T> newNode = new Node<T>(data);

        newNode.next = w.next;
        newNode.prev = w;
        w.next.prev = newNode;
        w.next = newNode;

        size++;
    }

    @Override
    public String toString() {
        Node<T> temp = this.head;
        StringBuilder stringBuilder = new StringBuilder();
        while (temp != null) {
            stringBuilder.append(temp.data + " -> ");
            temp = temp.next;
        }
        stringBuilder.append("null");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        DLL<Integer> linkedList = new DLL<Integer>(2);
        linkedList.appendNode(3);
        linkedList.appendNode(4);
        linkedList.appendNode(5);
        linkedList.appendNode(6);
        linkedList.appendNode(7);
        
        System.out.println(linkedList);

        System.out.println(linkedList.getNode(3).data);
    }
}

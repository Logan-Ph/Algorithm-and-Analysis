package DoublelyLinkedList;

public class Node<T> {
    T data;
    Node<T> prev, next;

    public Node(T data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
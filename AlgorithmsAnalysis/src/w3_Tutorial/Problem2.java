package w3_Tutorial;

import w3_lecture.Node;

public class Problem2 {
    public static void Josephus(CircularLinkedList cll, int k){
        Node current = cll.head;
        while (cll.head != cll.tail){
            for (int i = 0; i < k - 1; i++){
                current = current.next;
            }
            Node temp = current.next;
            cll.removeNode(current);
            current = temp;
        }
        System.out.println("The survivor is: " + cll.head.value);
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList(1);
        for (int i = 2; i< 42; i++){
            cll.appendNode(i);
        }
        Josephus(cll, 3);
    }
}

class CircularLinkedList{
    Node head;
    Node tail;

    public CircularLinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        head.next = tail;
        tail.next = head;
    }

    public void appendNode(int value){
        Node newNode = new Node(value);
        tail.next = newNode;
        tail = newNode;
        tail.next = head;
    }

    public void printList(){
        Node current = head;
        do {
            System.out.print(current.value + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("null");
    }

    public void removeNode(Node node){
        Node current = head;
        while (current.next != node){
            current = current.next;
        }
        current.next = node.next;
        if (node == head){
            head = head.next;
        }else if (node == tail){
            tail = current;
        }
    }
}

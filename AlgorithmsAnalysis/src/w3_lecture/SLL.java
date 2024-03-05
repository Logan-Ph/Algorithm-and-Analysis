package w3_lecture;

public class SLL {
    public Node tail, head;
    public int length;

    public SLL(int value) {
        this.head = new Node(value);
        tail = head;
        length = 1;
    }

    public void appendNode(int value) {
        Node newNode = new Node(value);
        appendNode(newNode);
    }

    public void appendNode(Node newNode) {
        tail.next = newNode;
        tail = tail.next;
        length++;
    }

    public void addAfter(Node w, int data) {
        if (w == this.tail) {
            appendNode(data);
            return;
        }

        Node newNode = new Node(data);
        newNode.next = w.next;
        w.next = newNode;
        length++;
        return;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public Node getNode(int index) {
        if (index < 0 || index >= length) {
            return null;
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public void add(int i, int data) {
        addAfter(getNode(i), data);
    }

    public void remove(int i) {
        if (i < 0 || i >= length) {
            return;
        }

        if (i == 0) {
            head = head.next;
        } else {
            Node prev = getNode(i - 1);
            prev.next = prev.next.next;
        }
        length--;
    }
}

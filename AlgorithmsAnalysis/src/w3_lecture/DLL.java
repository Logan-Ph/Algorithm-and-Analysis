package w3_lecture;

public class DLL {
    DNode head, tail;
    int length;

    public DLL(int value) {
        head = new DNode(value);
        tail = head;
        length = 1;
    }

    public void appendNode(int value) {
        DNode newNode = new DNode(value);
        tail.next = newNode;
        newNode.prev = tail;
        tail.next = newNode;
        length++;
    }

    public void printList() {
        DNode current = head;
        while (current != null) {
            if (current.next != null) {
                System.out.print(current.value + " -> ");
            } else {
                System.out.print(current.value);
            }
            current = current.next;
        }
        System.out.println();
    }

    public DNode getNode(int i) {
        DNode current = null;
        if (i < 0 || i >= length) {
            return current;
        }

        if (i < length / 2) {
            current = head;
            for (int j = 0; j < i; j++) {
                current = current.next;
            }
        } else {
            current = this.tail;
            for (int j = length - 1; j > i; j--) {
                current = current.prev;
            }
        }
        return current;
    }

    public void addBefore(DNode w, int data){
        if (w == head){
            DNode newDNode = new DNode(data);
            newDNode.next = head;
            head.prev = newDNode;
            head = newDNode;
            length++;
            return;

        }
        DNode newDNode = new DNode(data);
        newDNode.prev = w.prev;
        newDNode.next = w;
        w.prev.next = newDNode;
        length++;
    }
}

package w3_Tutorial;
import w3_lecture.Node;
import w3_lecture.SLL;

public class Problem1 {
    public static void removeLoop(SLL sll){
        Node fast = sll.head;
        Node slow = sll.head;
        while (fast != null && slow != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow  == fast){
                break;
            }
        }

        if (slow == fast){
            slow = sll.head;
            while (slow.next != fast.next){
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;
        }
    }

    public static void main(String[] args) {
        SLL sll = new SLL(2);
        Node n1 = new Node(3);
        Node n2 = new Node(4);
        Node n3 = new Node(5);
        Node n4 = new Node(6);
        sll.appendNode(n1);
        sll.appendNode(n2);
        sll.appendNode(n3);
        sll.appendNode(n4);
        sll.appendNode(n2);
        removeLoop(sll);
        sll.printList();
    }
}

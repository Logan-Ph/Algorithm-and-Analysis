package w8_tutorial;

public class Problem2b {
    static class LinkedList {
        public Node head;
        public Node tail;

        public LinkedList(int value) {
            this.head = new Node(value);
            this.tail = this.head;
        }

        public void appendNode(int value) {
            Node newNode = new Node(value);
            this.tail.next = newNode;
            this.tail = newNode;
        }

        public void printList() {
            Node current = this.head;
            while (current != null) {
                System.out.print(current.value + " ");
                current = current.next;
            }
        }

        public Node getNode(int index) {
            Node current = this.head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        }
    }

    static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    static class NodeBST {
        public int value;
        public NodeBST left;
        public NodeBST right;

        public NodeBST(int value) {
            this.value = value;
        }

        public static boolean isBalanced(NodeBST root) {
            return checkBalance(root) != -1;
        }
        
        private static int checkBalance(NodeBST node) {
            if (node == null) {
                return 0; // Height of an empty tree is 0 and it is balanced
            }
        
            int leftHeight = checkBalance(node.left);
            if (leftHeight == -1) return -1; // Left subtree is not balanced
        
            int rightHeight = checkBalance(node.right);
            if (rightHeight == -1) return -1; // Right subtree is not balanced
        
            if (Math.abs(leftHeight - rightHeight) > 1) {
                return -1; // Current node is not balanced
            }
        
            return 1 + Math.max(leftHeight, rightHeight); // Return the height of the current node
        }

        public static int height(NodeBST node){
            if (node == null){
                return 0;
            }
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }

    public static NodeBST constructBalancedBST(Node begin, Node end) {
        if (begin == end) return null;

        Node slow = begin;
        Node fast = begin;

        while (fast != end && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        NodeBST current = new NodeBST(slow.value);
        current.left = constructBalancedBST(begin, slow);
        current.right = constructBalancedBST(slow.next, end);
        return current;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(0);
        linkedList.appendNode(1);
        linkedList.appendNode(2);
        linkedList.appendNode(3);
        linkedList.appendNode(4);
        linkedList.appendNode(5);
        linkedList.appendNode(6);

        NodeBST root = constructBalancedBST(linkedList.head, linkedList.tail);
        // System.out.println(NodeBST.isBalanced(root));
    }
}

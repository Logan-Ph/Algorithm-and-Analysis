package w8_tutorial;

import java.util.HashMap;

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

        public static boolean isBalanced(NodeBST node, HashMap<NodeBST, Integer> hashMap){
            if (node == null){
                return true;
            }

            int leftHeight, rightHeight;

            if (!hashMap.containsKey(node.left)){
                leftHeight = height(node.left);
                hashMap.put(node.left, leftHeight);
            }else{
                leftHeight = hashMap.get(node.left);
            }
        
            if (!hashMap.containsKey(node.right)){
                rightHeight = height(node.right);
                hashMap.put(node.right, rightHeight);
            }else{
                rightHeight = hashMap.get(node.right);
            }

            return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(node.left, hashMap) && isBalanced(node.right, hashMap);
        }

        public static int height(NodeBST node){
            if (node == null){
                return 0;
            }
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }

    public static NodeBST constructBalancedBST(LinkedList linkedList, int l, int h) {
        if (l > h) {
            return null;
        }
        int m = (l + h) / 2;
        NodeBST root = new NodeBST(linkedList.getNode(m).value);
        root.left = constructBalancedBST(linkedList, l, m - 1);
        root.right = constructBalancedBST(linkedList, m + 1, h);
        return root;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(0);
        linkedList.appendNode(1);
        linkedList.appendNode(2);
        linkedList.appendNode(3);
        linkedList.appendNode(4);
        linkedList.appendNode(5);
        linkedList.appendNode(6);

        NodeBST root = constructBalancedBST(linkedList, 0, 6);
        System.out.println(NodeBST.isBalanced(root, new HashMap<>()));
    }
}

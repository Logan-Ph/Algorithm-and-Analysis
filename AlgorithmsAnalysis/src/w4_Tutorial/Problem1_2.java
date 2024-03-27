package w4_Tutorial;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
    public Node left, right;
    public int value;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BST {
    public Node root;

    public BST(int value) {
        this.root = new Node(value);
    }

    public void insert(int value) {
        insert(this.root, value);
    }

    private Node insert(Node root, int value) {
        if (root == null)
            return new Node(value);
        if (root.value > value)
            root.left = insert(root.left, value);
        if (root.value < value)
            root.right = insert(root.right, value);
        return root;
    }

    public int findHeight(Node current) {
        if (current == null)
            return 0;

        return 1 + Math.max(findHeight(current.left), findHeight(current.right));
    }

    public void preorderTraversal(Node current) {
        if (current != null) {
            System.out.println(current.value);
            inorderTraversal(current.left);
            inorderTraversal(current.right);
        }
    }

    public void inorderTraversal(Node current) {
        if (current != null) {
            inorderTraversal(current.left);
            System.out.println(current.value);
            inorderTraversal(current.right);
        }
    }

    public void postorderTraversal(Node current) {
        if (current != null) {
            inorderTraversal(current.left);
            inorderTraversal(current.right);
            System.out.println(current.value);
        }
    }

    public boolean isValidBST(Node root) {
        if (root == null)
            return true;

        if (root.left != null && root.left.value > root.value)
            return false;
        if (root.right != null && root.right.value < root.value)
            return false;

        return isValidBST(root.left) && isValidBST(root.left);

    }

    public Node searchNode(int value) {
        Node current = this.root;
        int comparison = 0;
        while (current != null) {
            if (value < current.value) {
                current = current.left;
            } else if (value > current.value) {
                current = current.right;
            } else {
                break;
            }
            comparison += 1;
        }
        System.out.println("The number of comparison is " + comparison);
        return (current != null) ? current : null;
    }

    public void breadthFirstSearch() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.value + " ");
            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }
    }

    public Node findMinimumNode(Node root, int value){
        Node temp = root;

        if (root == null) return null;

        if (root.value < value){
            Node current = findMinimumNode(root.right, value);
            temp = (current!=null) ? current : temp;
        };

        if (root.value > value){
            Node current = findMinimumNode(root.left, value);
            temp = (current!=null) ? current : temp;
        };
        
        return (temp.value >= value) ? temp : null;
    }
}

public class Problem1_2 {
    public static void main(String[] args) {
        BST bst = new BST(7);
        bst.insert(3);
        bst.insert(11);
        bst.insert(1);
        bst.insert(5);
        bst.insert(4);
        bst.insert(6);
        bst.insert(9);
        // bst.insert(8);
        bst.insert(13);
        bst.insert(12);
        bst.insert(14);
        // System.out.println(bst.findHeight(bst.root));
        // bst.inorderTraversal(bst.root);
        // bst.searchNode(11);

        System.out.println(bst.isValidBST(bst.root));
        // bst.breadthFirstSearch();
        System.out.println(bst.findMinimumNode(bst.root, 20).value);
    }
}

package w4_Tutorial;

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
        Node current = this.root;
        Node parrent = null;
        while (current != null) {
            if (value < current.value) {
                parrent = current;
                current = current.left;
            } else if (value > current.value) {
                parrent = current;
                current = current.right;
            }
        }
        if (parrent.value < value) {
            parrent.right = new Node(value);
        } else {
            parrent.left = new Node(value);
        }
    }

    public int findHeight(Node current) {
        if (current == null) {
            return 0;
        }

        return 1 + Math.max(findHeight(current.left), findHeight(current.right));
    }

    public void inorderTraversal(Node current) {
        if (current != null) {
            inorderTraversal(current.left);
            System.out.println(current.value);
            inorderTraversal(current.right);
        }
    }

    public Node searchNode(int value) {
        Node current = this.root;
        int comparison = 0;
        while (current != null) {
            if (value < current.value) {
                current = current.left;
            } else if (value > current.value) {
                current = current.right;
            }else{
                break;
            }
            comparison += 1;
        }
        System.out.println("The number of comparison is " + comparison);
        return (current != null) ? current : null;
    }
}

public class Problem1_2 {
    public static void main(String[] args) {
        BST bst = new BST(7);
        bst.insert(3);
        bst.insert(11);
        bst.insert(1);
        bst.insert(5);
        bst.insert(6);
        bst.insert(9);
        bst.insert(8);
        bst.insert(13);
        bst.insert(12);
        bst.insert(14);
        // System.out.println(bst.findHeight(bst.root));
        // bst.inorderTraversal(bst.root);
        bst.searchNode(11);
    }
}

package w4_lecture;

class Node<T extends Comparable<T>> {
    public Node<T> left, right;
    public T value;
    public int height;

    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int compareTo(T other) {
        return this.value.compareTo(other);
    }

}

public class AVL<T extends Comparable<T>> {
    public Node<T> root;

    int height(Node<T> node) {
        if (node == null) {
            return 0;
        }

        return node.height;
    }

    public int getBalance(Node<T> node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    public Node<T> leftRotate(Node<T> node) {
        Node<T> x = node.right;
        Node<T> y = x.left;

        node.right = y;
        x.left = node;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return x;
    }

    public Node<T> rightRotate(Node<T> node) {
        Node<T> x = node.left;
        Node<T> y = x.right;

        node.left = y;
        x.right = node;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return x;
    }

    Node<T> insert(Node<T> node, T value) {

        /* 1. Perform the normal BST insertion */
        if (node == null)
            return (new Node<>(value));

        if (value.compareTo(node.value) < 0) node.left = insert(node.left, value);
        else if (value.compareTo(node.value) > 0) node.right = insert(node.right, value);
        else return node;

        /* 2. Update height of this ancestor node */
        node.height = 1 + Math.max(height(node.left) , height(node.right));

        /*
         * 3. Get the balance factor of this ancestor
         * node to check whether this node became
         * unbalanced
         */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && value.compareTo(node.left.value) < 0)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && value.compareTo(node.right.value) > 0)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && value.compareTo(node.right.value) > 0) {
            node.left = leftRotate(node.left); // change to lef left case
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && value.compareTo(node.left.value) < 0) {
            node.right = rightRotate(node.right); // change to right right case
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }

}

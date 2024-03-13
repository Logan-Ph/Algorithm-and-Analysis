package w4_lecture;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST {
    public Node root;

    public BST(int value) {
        root = new Node(value);
    }

    public void preorderTraversal(Node node) {
        if (node != null) {
            System.out.println(node.value);
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    public void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.println(node.value);
            inorderTraversal(node.right);
        }
    }

    public void postorderTraversal(Node node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.println(node.value);
        }
    }

    public void breadthFirstSearch() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.println(currentNode.value);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }

    public void depthFirstSearch() {
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            System.out.println(currentNode.value);
            if (currentNode.left != null) {
                stack.add(currentNode.left);
            }
            if (currentNode.right != null) {
                stack.add(currentNode.right);
            }
        }
    }

    public Node searchNode(int data) {
        Node currentNode = this.root;
        while (currentNode != null) {
            if (data < currentNode.value) {
                currentNode = currentNode.left;
            } else if (data > currentNode.value) {
                currentNode = currentNode.right;
            } else {
                return currentNode;
            }
        }
        return null;
    }

    public Node insert(int data) {
        return insert(this.root, data);
    }
    
    private Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (root.value > data) {
            root.left = insert(root.left, data);
        } else if (root.value < data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public Node deleteNode(Node root, int value) {
        if (root == null) {
            return root;
        }
        if (value < root.value) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.value) {
            root.right = deleteNode(root.right, value);
        } else {
            if (root.left != null){
                Node current = root.left;
                while (current.right != null){
                    current = current.right;
                }
                current.right = root.right;
                return root.left;
            }else{
                return root.right;
            }
        }
        return root;
    }

    public void createBackBone() {
        Node grandParent = null;
        Node leftChild;
        Node parent = this.root;
        while (parent != null) {
            leftChild = parent.left;
            if (leftChild != null) {
                grandParent = rotateRight(grandParent, parent, leftChild);
                parent = leftChild;
            } else {
                grandParent = parent;
                parent = parent.right;
            }
        }
    }

    public Node rotateRight(Node grandParent, Node parent, Node leftChild) {
        if (grandParent != null) {
            grandParent.right = leftChild;
        } else {
            this.root = leftChild;
        }
        parent.left = leftChild.right;
        leftChild.right = parent;
        return grandParent;
    }

    public Node rotateLeft(Node grandParent, Node parent, Node rightChild) {
        if (grandParent != null) {
            grandParent.right = rightChild;
        } else {
            this.root = rightChild;
        }
        parent.right = rightChild.left;
        rightChild.left = parent;
        return grandParent;
    }

    public void createPerfectBST() {
        int n = 0;
        for (Node tmp = root; tmp != null; tmp = tmp.right) {
            n++;
        }
        // m = 2^floor[lg(n+1)]-1, ie the greatest power of 2 less than n: minus 1
        int m = greatestPowerOf2LessThanN(n + 1) - 1;
        makeRotations(n - m);

        while (m > 1) {
            makeRotations(m /= 2);
        }
    }

    /**
     * Time complexity: log(n)
     */
    public int greatestPowerOf2LessThanN(int n) {
        int x = MSB(n);// MSB
        return (int) Math.pow(2, x);// 2^x
    }

    /**
     * Time complexity: log(n)
     * return the index of most significant set bit: index of
     * least significant bit is 0
     */
    public int MSB(int n) {
        int ndx = 0;
        while (n > 1) {
            n = n / 2;
            ndx++;
        }
        return ndx;
    }

    public void makeRotations(int bound) {
        Node grandParent = null;
        Node parent = root;
        Node child = root.right;
        for (; bound > 0; bound--) {
            try {
                if (null != child) {
                    rotateLeft(grandParent, parent, child);
                    grandParent = child;
                    parent = grandParent.right;
                    child = parent.right;
                } else {
                    break;
                }
            } catch (NullPointerException convenient) {
                break;
            }
        }
    }

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

        // bst.depthFirstSearch();
        // bst.insert(10);
        // bst.breadthFirstSearch();
        bst.deleteNode(bst.root, 4);
        bst.deleteNode(bst.root, 5);
        System.out.println("Before backbone");
        bst.breadthFirstSearch();
        bst.createBackBone();
        System.out.println("After backbone");
        bst.breadthFirstSearch();

        System.out.println("Before perfect BST");
        bst.breadthFirstSearch();
        bst.createPerfectBST();
        System.out.println("After perfect BST");
        bst.breadthFirstSearch();
    }
}

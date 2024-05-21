package w8_tutorial;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Problem2a {
    static class Node {
        public int value;
        public Node left, right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static Node constructBalancedBST(int[] array, int l, int h) {
        if (l < h) {
            int m = (l + h) / 2;
            Node root = new Node(array[m]);
            root.left = constructBalancedBST(array, l, m - 1);
            root.right = constructBalancedBST(array, m + 1, h);
            return root;
        }
        return null;
    }

    public static boolean isBalanced(Node root) {
        return checkBalance(root) != -1;
    }
    
    private static int checkBalance(Node node) {
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

    public static int height(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String[] args) {
        int[] array = new int[15];
        for (int i = 0; i < 15; i++) {
            Random random = new Random();
            int number = random.nextInt(14);
            array[i] = number;
        }
        Arrays.sort(array);
        Node root = constructBalancedBST(array, 0, array.length - 1);
        System.out.println(isBalanced(root));
    }
}

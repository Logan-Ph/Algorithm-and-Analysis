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

    public static boolean isBalanced(Node root, HashMap<Node, Integer> map) {
        if (root == null) {
            return true;
        }
        int leftHeight, rightHeight;
        if (!map.containsKey(root.left)) {
            leftHeight = height(root.left);
            map.put(root.left, leftHeight);
        } else {
            leftHeight = map.get(root.left);
        }

        if (!map.containsKey(root.right)) {
            rightHeight = height(root.right);
            map.put(root.right, rightHeight);
        } else {
            rightHeight = map.get(root.right);
        }

        if (Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left, map) && isBalanced(root.right, map)) {
            return true;
        }
        return false;
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
        System.out.println(isBalanced(root, new HashMap<Node, Integer>()));
    }
}

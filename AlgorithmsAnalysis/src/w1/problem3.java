package w1;

import java.util.HashSet;
import java.util.Set;

public class problem3 {
    static void checkSequences(int[] seq1, int[] seq2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < seq1.length; i++) {
            set.add(seq1[i]);
        }

        if (seq1.length != seq2.length) {
            System.out.println("False");
            return;
        }

        for (int i = 0; i < seq2.length; i++) {
            if (!set.contains(seq2[i])) {
                System.out.println("False");
                return;
            }
        }

        System.out.println("True");
    }

    public static void main(String[] args) {
        int[] seq1 = { 1, 2, 3, 4 };
        int[] seq2 = { 4, 3, 2, 1, 1 };

        checkSequences(seq1, seq2);
    }
}

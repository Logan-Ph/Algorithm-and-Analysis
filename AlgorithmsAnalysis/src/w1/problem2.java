package w1;

public class problem2 {
    static void findMissingValues(int n, int[] arr) {
        for (int i=0; i < n; i++){
            if (i != arr[i]){
                System.out.println(i);
                return;
            }
        }
        System.out.println(n);
    }

    public static void main(String[] args) {
        int[] a = { 0, 1, 2, 3, 4 };
        int[] b = { 1, 2, 3, 4, 5 };
        int[] c = { 0, 1, 2, 4, 5 };

        findMissingValues(5, a);
        findMissingValues(5, b);
        findMissingValues(5, c);
    }
}

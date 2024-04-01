package w1;

public class problem2 {
    static void findMissingValues1(int n, int[] arr) {
        for (int i=0; i < n; i++){
            if (i != arr[i]){
                System.out.println(i);
                return;
            }
        }
        System.out.println(n);
    }

    static void findMissingValues2(int n, int[] arr){
        int sum = 0;
        int realSum = ((n+1)*n)/2;
        for (int i : arr){
            sum += i;
        }
        System.out.println(realSum - sum); 
    }

    public static void main(String[] args) {
        int[] a = { 0, 1, 2, 3, 4 };
        int[] b = { 1, 2, 3, 4, 5 };
        int[] c = { 0, 1, 2, 4, 5 };

        findMissingValues1(5, a);
        findMissingValues1(5, b);
        findMissingValues1(5, c);

        findMissingValues2(5, a);
        findMissingValues2(5, b);
        findMissingValues2(5, c);
    }
}

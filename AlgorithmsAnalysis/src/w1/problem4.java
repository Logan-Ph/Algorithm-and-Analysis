package w1;

public class problem4 {
    static void rangeSum(int[] arr, int start, int end){
        int sum = 0;
        for (int i = start; i <= end; i++){
            sum += arr[i];
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 9, 8, 5, 4, 3};
        rangeSum(arr, 0,0);
        rangeSum(arr, 6,6);
        rangeSum(arr, 0,6);
        rangeSum(arr, 3,4);
    }
}

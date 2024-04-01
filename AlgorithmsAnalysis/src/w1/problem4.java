package w1;

public class problem4 {
    static void rangeSum(int[] arr, int start, int end){
        int[] sumRange = new int[arr.length];
        sumRange[0] = arr[0];
        for (int i = 1; i < arr.length; i++){
            sumRange[i] = sumRange[i-1] + arr[i];
        }

        System.out.println(sumRange[end] - sumRange[start] + arr[start]);
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 9, 8, 5, 4, 3};
        rangeSum(arr, 0,0);
        rangeSum(arr, 6,6);
        rangeSum(arr, 0,6);
        rangeSum(arr, 3,4);
    }
}

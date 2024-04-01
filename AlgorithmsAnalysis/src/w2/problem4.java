package w2;
import java.util.Arrays;

public class problem4 {
    // Time complexity: O(nlogn)
    static void findClosestToZero(int[] arr){
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        int minSum = Integer.MAX_VALUE;
        int minLeft = 0, minRight = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < Math.abs(minSum)){
                minSum = sum;
                minLeft = left;
                minRight = right;
            }

            if (sum < 0){
                left++;
            } else {
                right--;
            }

        }
        System.out.println("Closest to zero: " + arr[minLeft] + " " + arr[minRight] + " Sum: " + minSum);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 9, 6};
        findClosestToZero(arr);
    }
}

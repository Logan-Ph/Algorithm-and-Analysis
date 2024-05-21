package w5_lecture;
import java.util.Arrays;

public class RadixSortPractive {
    static int getMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i : arr){
            if (i > max) max = i;
        }
        return max;
    }

    static int[] radixSort(int[] arr, int expo){
        int[] result = new int[arr.length];

        int[] freq = new int[10];
        for (int i : arr){
            freq[Math.floorDiv(i, expo)%10] += 1;
        }

        for (int i = 1; i < freq.length; i++){
            freq[i] += freq[i-1];
        }

        for (int i = arr.length - 1; i >= 0; i--){
            result[--freq[Math.floorDiv(arr[i], expo)%10]] = arr[i];
        }

        return result;
    }

    static void sort(int[] arr){
        int maxValue = getMax(arr);

        for (int expo = 1; maxValue/expo > 0; expo *= 10){
            arr = radixSort(arr, expo);
        }
        
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        // int[] arr = new int[10];
        // for (int i = 0; i < 10; i++) {
        //     Random random = new Random();
        //     int number = random.nextInt(20);
        //     arr[i] = number;
        // }
        // System.out.println(Arrays.toString(arr));
        int[] arr = { 4, 11, 3, 9, 7, 3, 3, 0, 10, 1 };
        sort(arr);
    }
}

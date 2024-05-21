package w5_lecture;

import java.util.Arrays;
import java.util.Random;

public class distributionSortingPratice {
    public static void sort(int[] arr) {
        int[] result = new int[arr.length];
        int maxNum = Integer.MIN_VALUE;

        for (int i : arr){
            if (i > maxNum){
                maxNum = i;
            }
        }

        int[] freq = new int[maxNum+1];
        for (int i : arr){
            freq[i] += 1;
        }

        for (int i = 1; i < freq.length; i++){
            freq[i] += freq[i-1];
        }

        for (int i = 0; i < arr.length; i++){
            result[--freq[arr[i]]] = arr[i];
        }
    
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int number = random.nextInt(20);
            arr[i] = number;
        }
        System.out.println(Arrays.toString(arr));
        sort(arr);
    }
}

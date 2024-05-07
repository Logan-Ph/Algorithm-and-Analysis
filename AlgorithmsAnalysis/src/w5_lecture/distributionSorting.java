package w5_lecture;

import java.util.Arrays;
import java.util.Random;

public class distributionSorting {
    public static void sort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // calculate the frequency of the arr using bucket method
        // why max+1? This is because if arr[i] == 0 therfore it can be out of bounds (-1)
        int[] frequency = new int[max+1];
        for (int i = 0; i < arr.length; i++) {
            frequency[arr[i]] += 1;
        }

        // calculate the cumulative frequencies 
        for (int i = 1; i < frequency.length; i++){
            frequency[i] += frequency[i-1];
        }

        int[] newArr = new int[arr.length];
        for (int i = arr.length-1; i >=0 ; i--){
            newArr[--frequency[arr[i]]] = arr[i];
        }
        System.out.println(Arrays.toString(newArr));
    }

    public static void main(String[] args) {
        int[] arr = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            Random random = new Random();
            int number = random.nextInt(1000);
            arr[i] = number;
        }
        sort(arr);
    }
}

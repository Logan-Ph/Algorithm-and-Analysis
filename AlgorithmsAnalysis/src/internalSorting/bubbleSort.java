package internalSorting;

import java.util.Arrays;

public class bubbleSort {
    public static int[] sort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 1; j < arr.length - i; j++){
                if (arr[j-1] > arr[j]) swap(arr,j-1,j);
            }
        }

        System.out.println(Arrays.toString(arr));

        return arr;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {92, 78, 34, 23, 56, 90, 17, 52, 67, 81, 18};
        sort(arr);
    }
}

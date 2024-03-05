package w8_lecture;

import java.util.Arrays;

public class QuickSort {
    public static int partition(int[] arr, int l, int h) {
        int pivot = arr[h]; 
        int i = (l-1); // index of smaller element
        for (int j=l; j<h; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
 
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[h];
        arr[h] = temp;
 
        return i+1;
    }

    public static void quickSort(int[] arr, int l, int h) {
        if (l < h) {
            int p = partition(arr, l, h);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, h);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 80, 10, 90, 40, 50, 70 };
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));
    }
}

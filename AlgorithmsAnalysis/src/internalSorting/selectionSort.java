package internalSorting;
import java.util.Arrays;

/**
 * The selectionSort class implements the selection sort algorithm.
 * This algorithm sorts an array by repeatedly finding the minimum element from the unsorted part and moving it to the sorted part.
 * It works by maintaining two subarrays in a given array:
 * 1. The subarray which is already sorted.
 * 2. The remaining subarray which is unsorted.
 * 
 * In every iteration of the selection sort, the minimum element from the unsorted subarray is picked and moved to the end of the sorted subarray.
 * 
 * Usage:
 * - Suitable for small data sets as its time complexity is O(n^2), which is inefficient for large lists.
 * - Very simple to implement and more efficient in memory usage than other simple quadratic algorithms like bubble sort, as it makes the minimum possible number of swaps.
 * 
 * Example:
 * int[] arr = {92, 78, 34, 23, 56, 90, 17, 52, 67, 81, 18};
 * selectionSort.sort(arr); // Outputs the sorted array
 * 
 * This method solves the problem of sorting an array with a predictable performance of O(n^2) regardless of the initial order of the array.
 */

public class selectionSort {
    public static int[] sort(int[] arr){
        for (int i  = 0; i < arr.length; i++){
            int min = i;
            for (int j = i; j < arr.length; j++){
                if (arr[j] <= arr[min]){
                    min = j;
                }
            }
            swap(arr, i, min);
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
        int[] arr = {92, 78, 34, 17, 56, 90, 17, 52, 67, 81, 18};
        sort(arr);
    }
}
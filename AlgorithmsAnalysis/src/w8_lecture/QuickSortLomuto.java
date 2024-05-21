package w8_lecture;

import java.util.Arrays;

public class QuickSortLomuto {
    public static int partition(int[] arr, int left, int right){
        int p = arr[right];
        int i = left;

        for (int j = left; j < right; j++){
            if (arr[j] <= p){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            
                i++;
            }
        }

        arr[right] = arr[i];
        arr[i] = p;
        return i;
    }

    public static void quickSort(int[] arr, int left, int right){
        if (left < right){
            int p = partition(arr, left, right);
            quickSort(arr, left, p - 1);
            quickSort(arr, p + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 80, 10, 90, 40, 50, 70 };
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));
    }
}

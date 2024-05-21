package w8_lecture;

import java.util.Arrays;

public class QuickSortHare {
    static int partition(int[] arr, int l, int r) {
        int pivot = arr[l];
        int i = l, j = r;

        while (true) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i >= j) {
                return j;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
            i++;
        }
    }

    static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int p = partition(arr, left, right);
            quickSort(arr, left, p);
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

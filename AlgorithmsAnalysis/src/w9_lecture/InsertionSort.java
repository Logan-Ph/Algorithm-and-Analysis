package w9_lecture;

import java.util.Arrays;

public class InsertionSort {
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++){
            int key = array[i];
            int j = i-1;
            while (j>0 && array[j] >= key) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int[] array = { 5, 3, 1, 1, 2 };
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}

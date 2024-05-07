package w6_lecture;

import java.util.Arrays;

public class bubbleSort {

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arrray = { 3, 4, 1, 1, -1, 7, 4, 7, 9, 2 };
        sort(arrray);
        System.out.println(Arrays.toString(arrray));
    }
}

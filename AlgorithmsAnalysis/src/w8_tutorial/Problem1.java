package w8_tutorial;

import java.util.Random;

import w6_lecture.bubbleSort;
import w6_lecture.selectionSort;
import w8_lecture.MergeSort;
import w8_lecture.QuickSort;

public class Problem1 {
    public static void main(String[] args) {
        int[] array1 = new int[1000000];
        int[] array2 = new int[1000000];
        int[] array3 = new int[1000000];
        int[] array4 = new int[1000000];

        for (int i = 0; i < 1000000; i++) {
            Random random = new Random();
            int number = random.nextInt(1000);
            array1[i] = number;
            array2[i] = number;
        }

        long startTime = System.currentTimeMillis();
        MergeSort.mergeSort(array1, 0, array1.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("Merge Sort: " + (endTime - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        QuickSort.quickSort(array2, 0, array2.length - 1);
        endTime = System.currentTimeMillis();
        System.out.println("Quick Sort: " + (endTime - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        selectionSort.sort(array3);
        endTime = System.currentTimeMillis();
        System.out.println("Selection Sort: " + (endTime - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        bubbleSort.sort(array4);
        endTime = System.currentTimeMillis();
        System.out.println("Bubble Sort: " + (endTime - startTime) + " milliseconds");
    }
}

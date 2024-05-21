package w5_lecture;

import java.util.Arrays;
import java.util.Random;

/**
    * The RadixSort class implements the radix sort algorithm.
    * Radix sort is a non-comparative integer sorting algorithm that sorts data with integer keys by grouping the keys by individual digits
    * which share the same significant position and value (using a stable algorithm, typically counting sort or bucket sort).
    * It processes from the least significant digit to the most significant digit.
    * 
    * Usage:
    * - Suitable for sorting large sets of data where the keys are integers.
    * - It can outperform comparison-based sorting algorithms by avoiding direct comparisons between the main section of the keys.
    * 
    * Example:
    * int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
    * RadixSort.radixSort(arr); // Outputs the sorted array
    * 
    * This method solves the problem of efficiently sorting large sets of integer data with a time complexity of O(nk),
    * where n is the number of elements and k is the number of passes of the sorting algorithm (related to the number of digits in the largest number).
*/

public class RadixSort {
    public static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    public static int[] countSort(int[] arr, int expo) {
        int[] output = new int[arr.length];

        // because the number is only from 0 - 9
        int[] count = new int[10];

        // count the frequency of the array in term of digit
        for (int i = 0; i < arr.length; i++) {
            count[Math.floorDiv(arr[i], expo) % 10]++;
        }

        // calculate the cumulative frequencies
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[(count[Math.floorDiv(arr[i], expo) % 10 ]--) -1 ] = arr[i];
        }

        System.out.println(Arrays.toString(output));

        return output;
    }

    public static void radixSort(int[] arr) {
        int max = getMax(arr);

        for (int expo = 1; max / expo > 0; expo *= 10) {
            arr = countSort(arr, expo);
        }
    }

    public static void main(String[] args) {
        // int[] arr = new int[10];
        // for (int i = 0; i < 10; i++) {
        //     Random random = new Random();
        //     int number = random.nextInt(20);
        //     arr[i] = number;
        // }
        int[] arr = { 4, 11, 3, 9, 7, 3, 3, 0, 10, 1 };
        radixSort(arr);
    }
}

package w10_lecture;

import java.util.Arrays;

public class SearchInSortedList {
    static void sequentialSearching(int[] array, int key){
        for (int i =0; i < array.length; i++){
            if (array[i] == key){
                System.out.println("Found at index " + i);
                return;
            }
        }
    }

    static void preSortingSearching(int[] array, int key){
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        System.out.println(Arrays.toString(array));
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] > key){
                right = mid - 1;
            }else if (array[mid] < key){
                left = mid + 1;
            }else{
                System.out.println("Found at index: " + mid);
                return;
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2,3,5,1,3,2,6};
        sequentialSearching(array,  3);
        preSortingSearching(array,  3);
    }
}

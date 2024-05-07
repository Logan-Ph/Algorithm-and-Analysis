package searching;
import java.util.Arrays;

/**
 * The tranposeSequentialSearch class implements the transpose sequential search algorithm.
 * This algorithm is a variation of the linear search where, upon finding the target element, it is swapped with the element directly before it.
 * This slight modification can potentially improve the search time for frequently accessed elements, as they gradually move towards the front of the array.
 * 
 * Usage:
 * - The array does not need to be sorted.
 * - Call the search method with the array and the key as arguments.
 * 
 * Example:
 * int[] arr = {3, 4, 64, 2, 56, 7, 8, 3, 21, 3, 2, 46, 65, 12, 45, 62};
 * tranposeSequentialSearch.search(arr, 12); // Outputs "Key found" and modifies the array
 * 
 * This method solves the problem of searching for a specific element in an unsorted array while attempting to optimize future searches
 * for the same element by moving it closer to the front of the array each time it is found.
 */

public class tranposeSequentialSearch {

    public static void search(int[] arr, int key){
        int index = 0;
        while (index < arr.length && arr[index] != key) {
            index++;
        }

        if (arr[index] == key){
            System.out.println("Key found");
            if (index != 0 ){
                int temp = arr[index];
                arr[index] = arr[index-1];
                arr[index -1] = temp;
            }
        }else{
            System.out.println("Key not found");
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {3,4,64,2,56,7,8,3,21,3,2,46,65,12,45,62};
        search(arr, 12);
        search(arr, 12);
        search(arr, 12);
        search(arr, 12);
        search(arr, 12);
        search(arr, 12);
    }
}

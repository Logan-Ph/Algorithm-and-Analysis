package searching;

/**
 * The interpolationSearch class implements the interpolation search algorithm.
 * This algorithm is an improvement over binary search for instances where the values in a sorted array are uniformly distributed.
 * Interpolation search calculates the probable position of the target value using the formula:
 * 
 * mid = low + (high - low) * [(key - arr[low])/ (arr[high] - arr[low])]
 * 
 * where:
 * - arr is the array where elements are stored.
 * - key is the value to be searched in the array.
 * - low, high are the indices between which the key is searched.
 * - mid is the calculated middle index.
 * 
 * Usage:
 * - The array should be sorted and uniformly distributed for this algorithm to be efficient.
 * - Call the search method with the array and the key as arguments.
 * 
 * Example:
 * int[] arr = {10, 20, 30, 40, 50};
 * interpolationSearch.search(arr, 30); // Outputs "Key found"
 * 
 * This method solves the problem of searching for a specific element in a sorted array more efficiently than binary search in best-case scenarios.
 */

public class interpolationSearch {
    public static void search(int[] arr, int key) {
        int i = 0;
        int j = arr.length - 1;
        if (key < arr[i] || key > arr[j]) {
            System.out.println("Key not found");
            return;
        }

        boolean found = false;
        while (i <= j && !found) {
            int mid = i + (j - i) * (Math.floorDiv((key - arr[i]), (arr[j] - arr[i])));
            System.out.println("mid: " + mid);

            if (arr[mid] == key) {
                System.out.println("Key found");
                found = true;
            } else if (arr[mid] > key) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        if (!found) {
            System.out.println("Key not found");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 24, 56, 67, 78, 79, 89, 90, 95, 99 };
        search(arr, 67);
    }
}

package searching;

/**
 * The binarySearch class implements the binary search algorithm.
 * This algorithm efficiently searches for a target value within a sorted array by repeatedly dividing the search interval in half.
 * The key is compared to the middle element of the array; if they are not equal, the half in which the key cannot lie is eliminated,
 * and the search continues on the remaining half, again taking the middle element to compare with the key, until the key is found.
 * 
 * Usage:
 * - The array must be sorted prior to applying binary search.
 * - Call the search method with the array and the key as arguments.
 * 
 * Example:
 * int[] arr = {12, 21, 34, 38, 45, 49, 67, 69, 78, 79, 82, 87, 93, 97, 99};
 * binarySearch.search(arr, 21); // Outputs "Key found"
 * 
 * This method solves the problem of searching for a specific element in a sorted array more efficiently than a linear search,
 * reducing the time complexity to O(log n) from O(n).
 */

public class binarySearch {
    public static void search(int[] arr, int key){
        int i = 0;
        int j = arr.length;

        while (i < j) {
            int mid = (i+j)/2;

            if (arr[mid] == key){
                System.out.println("Key found");
                return;
            }else if (arr[mid] > key){
                j = mid - 1;
            }else {
                i = mid + 1;
            }
        }

        System.out.println("Key not found");
    }

    public static void main(String[] args) {
        int[] arr = {12, 21, 34, 38, 45, 49, 67, 69, 78, 79, 82, 87, 93, 97, 99};
        search(arr, 21);
    }
}

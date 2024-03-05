package w9_lecture;

/**
 * InterpolationSearch
 */
public class InterpolationSearch {

    public static int interpolationSearch(int[] array, int low, int high, int x) {
        int pos;

        if (low <= high && x >= array[low] && x <= array[high]) {
            pos = low + ((high - low) / (array[high] - array[low])) * (x - array[low]);
            if (array[pos] < x) {
                return interpolationSearch(array, pos + 1, high, x);
            } else if (array[pos] > x) {
                return interpolationSearch(array, low, pos - 1, x);
            } else {
                return pos;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 12, 13, 16, 18, 19, 20, 21,
                22, 23, 24, 33, 35, 42, 47 };

        int n = arr.length;

        // Element to be searched
        int x = 18;
        int index = interpolationSearch(arr, 0, n - 1, x);

        // If element was found
        if (index != -1)
            System.out.println("Element found at index "
                    + index);
        else
            System.out.println("Element not found.");
    }
}
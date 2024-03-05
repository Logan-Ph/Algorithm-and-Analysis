package w9_lecture;

public class QuickSelect {
    public static int partition(int[] arr, int l, int h) {
        int pivot = arr[h];
        int i = l - 1;
        for (int j = l; j < h; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[h];
        arr[h] = temp;
        return i + 1;
    }

    public static int kthSmallestElement(int[] arr, int l, int h, int k) {
        int partition = partition(arr, l, h);

        if (partition == k - 1) {
            return arr[partition];
        } else if (partition > k - 1) {
            return kthSmallestElement(arr, l, partition - 1, k);
        } else {
            return kthSmallestElement(arr, partition + 1, h, k);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] { 10, 4, 5, 8, 6, 11, 26 };

        int kPosition = 3;

        if (kPosition > array.length) {
            System.out.println("Index out of bound");
        } else {
            // find kth smallest value
            System.out.println(
                    "K-th smallest element in array : "
                            + kthSmallestElement(array, 0, array.length - 1,
                                    kPosition));
        }
    }
}

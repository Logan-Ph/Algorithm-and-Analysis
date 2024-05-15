package w9_lecture;

public class QuickSelect {
    public static int partition(int[] array, int l, int h){
        int pivot = array[h];
        int i = l-1;
        for (int j = l; j < h; j++){
            if (array[j] < pivot){
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        array[h] = array[i+1];
        array[i+1] = pivot;
        return i+1;
    }

    public static int kthSmallestElement(int[] array, int l, int h, int k){
        int p = partition(array, l, h);
        
        if (p == k-1) return array[p];
        else if (p < k-1) return kthSmallestElement(array, p+1, h, k);
        else return kthSmallestElement(array, l, p-1, k);
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

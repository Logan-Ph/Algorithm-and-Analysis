package w9_tutorial;

public class Problem2 {
    static int partition(int[] array, int low, int high){
        int pivot = array[high];
        int i = low - 1;
        for (int j = low ; j < high ; j++){
            if (array[j] < pivot){
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;
        return i+1;
    }

    static int kthSmallestElement(int[] array, int l, int h, int k){
        int partition = partition(array, l, h);
        if (partition == k-1){
            return array[partition];
        }else if (partition > k-1){
            return kthSmallestElement(array, l, partition-1, k);
        }else{
            return kthSmallestElement(array, partition+1, h, k);
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

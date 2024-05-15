package w10_lecture;

import java.util.Arrays;

public class ComputingMedian {
    public static int partition(int[] array, int low, int high){
        int i = low - 1;
        int pivot = array[high];
        for (int j = low; j < high; j++){
            if (array[j] < pivot){
                i++;
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        array[high] = array[i+1];
        array[i+1] = pivot;
        return i + 1;
    }

    public static int selectMedian(int[] array, int low, int high, int k){
        int partition = partition(array, low, high);
        if (k == partition){
            return array[partition];
        }else if (k > partition){
            return selectMedian(array, partition + 1, high, k);
        }else{
            return selectMedian(array, low, partition - 1, k);
        }
    }

    public static void selectMedianWithPresorting(int[] array){
        Arrays.sort(array);
        System.out.println("The median of the array is: " + array[array.length/2]);
    }

    public static void main(String[] args) {
        int[] array = new int[] { 10, 4, 5, 8, 6, 11, 26 };

        int kPosition = array.length/2;

        System.out.println("The median of the array is: " + selectMedian(array, 0, array.length-1, kPosition));
        selectMedianWithPresorting(array);
    }
}

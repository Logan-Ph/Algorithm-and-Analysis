package w6_tutorial;
import java.util.Arrays;

public class problem1 {
    static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 1; j < arr.length - i; j++){
                if (arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            int min = i;
            for (int j = i; j < arr.length; j++){
                if (arr[j] < arr[min]){
                    min = j;
                }
            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arrray1 = {3,4,1,1,-1,7,4,7,9,2};
        bubbleSort(arrray1);
        System.out.println("Bubble sort: ");
        System.out.println(Arrays.toString(arrray1));

        int[] arrray2 = {3,4,1,1,-1,7,4,7,9,2};
        selectionSort(arrray2);
        System.out.println("Selection sort: ");
        System.out.println(Arrays.toString(arrray2));

    }
}

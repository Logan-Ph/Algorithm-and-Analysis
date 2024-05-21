package w6_lecture;

import java.util.Arrays;

public class bubbleSortPractice {
    public static void sort(int[] arr){
        for (int i =0; i < arr.length; i++){
            for (int j = 1; j < arr.length - i; j++){
                if (arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arrray = {3,4,1,1,-1,7,4,7,9,2};
        sort(arrray);
        System.out.println(Arrays.toString(arrray));
    }
}

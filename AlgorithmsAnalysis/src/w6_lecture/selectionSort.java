package w6_lecture;

import java.util.Arrays;

public class selectionSort {

    public static void sort(int[] arrray){
        for(int i = 0; i < arrray.length; i++){
            int min = i;
            for (int j = i+1; j < arrray.length; j++){
                if (arrray[j] < arrray[min]){
                    min = j;
                }
            }
            int temp = arrray[i];
            arrray[i] = arrray[min];
            arrray[min] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arrray = {3,4,1,1,-1,7,4,7,9,2};
        sort(arrray);
        System.out.println(Arrays.toString(arrray));
    }
}

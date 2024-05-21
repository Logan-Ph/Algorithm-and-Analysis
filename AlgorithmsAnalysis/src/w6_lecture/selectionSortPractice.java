package w6_lecture;

import java.util.Arrays;

public class selectionSortPractice {
    public static void sort(int[] array){
        for (int i = 0; i < array.length; i++){
            int min = i;
            for (int j = i; j < array.length; j++){
                if (array[j] < array[min]){
                    min = j;
                }
            }

            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arrray = {3,4,1,1,-1,7,4,7,9,2};
        sort(arrray);
        System.out.println(Arrays.toString(arrray));
    }
}

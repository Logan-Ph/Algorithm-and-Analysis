package w10_lecture;

import java.util.Arrays;

public class UniquenessChecking {
    static void uniquenessChecking(int[] array){
        for (int i = 0; i < array.length-1; i++){
            for (int j = i+1; j< array.length; j++){
                if (array[i] == array[j]){
                    System.out.println("The array is not unique");
                    return;
                }
            }
        }
        System.out.println("The array is unique");
    }

    static void optimizedUniqenessChecking(int[] array){
        Arrays.sort(array);
        for (int i = 1; i < array.length; i++){
            if (array[i] == array[i-1]){
                System.out.println("The array is not unique");
                return;
            } 
        }
        System.out.println("The array is unique");
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,5,2,6,8,3,7,4,5};
        uniquenessChecking(array);
        optimizedUniqenessChecking(array);
    }
}

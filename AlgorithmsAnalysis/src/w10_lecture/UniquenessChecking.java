package w10_lecture;

import java.util.Arrays;

public class UniquenessChecking {
    static void uniquenessChecking(int[] array){
        for (int i =0; i < array.length-1; i++){
            for (int j = i+1; j < array.length ; j++){
                if (array[i] == array[j]){
                    System.out.println("There is a duplicate key: " + array[i]);
                    return;
                }
            }
        }
        System.out.println("There is no duplication");
    }

    static void optimizedUniqenessChecking(int[] array){
        Arrays.sort(array);
        for (int i = 1; i < array.length; i++){
            if (array[i-1] == array[i]){
                System.out.println("There is a duplicate key: " + array[i]);
                return;
            }
        }
        System.out.println("There is no duplication");
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,5,2,6,8,3,7,4,5};
        uniquenessChecking(array);
        optimizedUniqenessChecking(array);
    }
}

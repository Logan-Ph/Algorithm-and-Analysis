package w2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class problem2 {

    static void printUniqueElements1(int[] arr){
        ArrayList<Integer> unique = new ArrayList<>();
        for (int i: arr) {
            if(!unique.contains(i)){
                unique.add(i);
            }
        }
        for (int i = 0; i < unique.size(); i++) {
            System.out.print(unique.get(i) + " ");
        }
    }

    static void printUniqueElements2(int[] arr){
        HashSet<Integer> unique = new HashSet<>();
        for (int i : arr){
            unique.add(i);
        }

        for (int i : unique){
            System.out.print(i + " ");
        }
    }

    static void printUniqueElements3(int[] arr){
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-1 ; i++){
            if (arr[i] != arr[i+1]){
                System.out.print(arr[i] + " ");
            }
        }
        System.out.print(arr[arr.length-1]);
    }

    public static void main(String[] args) {
        int[] arr = {6,8,10,11,6,10,11,11};
        printUniqueElements1(arr);
        System.out.println();

        printUniqueElements2(arr);
        System.out.println();

        printUniqueElements3(arr);
    }
}

package w2;
import java.util.ArrayList;
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

    public static void main(String[] args) {
        int[] arr = {6,8,10,11,6,10};
        printUniqueElements1(arr);
    }
}

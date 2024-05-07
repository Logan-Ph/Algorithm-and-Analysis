package w5_tutorial;
import java.util.Arrays;
import java.util.Random;

public class Problem1 {

    static int[] countSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // calculate the frequency of the arr using bucket method
        // why max+1? This is because if arr[i] == 0 therfore it can be out of bounds (-1)
        int[] frequency = new int[max+1];
        for (int i = 0; i < arr.length; i++) {
            frequency[arr[i]] += 1;
        }

        // calculate the cumulative frequencies 
        for (int i = 1; i < frequency.length; i++){
            frequency[i] += frequency[i-1];
        }

        int[] newArr = new int[arr.length];
        for (int i = arr.length-1; i >=0 ; i--){
            newArr[--frequency[arr[i]]] = arr[i];
        }
        return null;
    }

    static void normalSort(int[] array){
        Arrays.sort(array);
    }

    public static void main(String[] args) {

        // why count sort can not be faster if the array length over 100 milion ?
        // this is because the time for memory allocation is longer than the time it require to sort
        // because count sort need to allocate new arr for culmative frequency and for finding the max number

        // normal sort (quick sort) is faster in this paticular case, because it require no addition memory for sorting -> better
        int[] array = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            Random random = new Random();
            int number = random.nextInt(1000);
            array[i] = number;
        }

        long startTime = System.currentTimeMillis();
        countSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("Count Sort: " + (endTime - startTime) + " milliseconds");
    
        startTime = System.currentTimeMillis();
        normalSort(array);
        endTime = System.currentTimeMillis();
        System.out.println("Normal Sort: " + (endTime - startTime) + " milliseconds");
    }
}

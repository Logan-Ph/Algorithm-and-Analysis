package w5_tutorial;
import java.util.Arrays;
import java.util.Random;

public class Problem1 {

    static int[] countSort(int[] array) {
        int maxNumber = array[0];

        for (int i = 1; i < array.length; i++) {
            maxNumber = Math.max(maxNumber, array[i]);
        }

        int[] countArray = new int[maxNumber + 1];
        for (int i = 0; i < array.length; i++) {
            countArray[array[i]] += 1;
        }

        for (int i = 1; i < countArray.length; i++){
            countArray[i] += countArray[i-1];
        }


        int[] outputArray = new int[array.length+1];
        for (int i = 0; i < array.length; i++){
            outputArray[countArray[array[i]]--] = array[i];
        }

        return null;
    }

    static void normalSort(int[] array){
        Arrays.sort(array);
    }

    public static void main(String[] args) {
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

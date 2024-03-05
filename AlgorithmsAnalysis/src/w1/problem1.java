package w1;

public class problem1 {
    static void problem1a(){
        int[] A = {7,6,9,3,2,5};
        int maxNum = A[0];
        for (int i = 1; i <A.length; i++){
            if (maxNum < A[i]){
                maxNum = A[i];
            }
        }
        System.out.println(maxNum);
    }

    static void problem1b(){
        int[] A = {7,6,9,3,2,5};
        int maxNum = Integer.MIN_VALUE;
        int secondMaxNum = Integer.MIN_VALUE;
        for (int value: A){
            if (value > maxNum){
                secondMaxNum = maxNum;
                maxNum = value;
            }
        }
        System.out.println(secondMaxNum);
    }

    public static void main(String[] args) {
        problem1b();
    }
}

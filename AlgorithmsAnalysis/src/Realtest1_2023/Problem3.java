package Realtest1_2023;

public class Problem3 {
    static int maxStrengthPower(int[] items){
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i : items){
            sum += i;
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) sum = 0;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxStrengthPower(new int[] {1,-3,4,2,-1,3,-2,1}));
    }
}

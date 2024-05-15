package w9_tutorial;

public class Problem3 {
    static double sqrt(double X) {
        double eps = 0.0000001;
        double min = 0;
        double max = X;

        // this is because the square root of a number is larger than itself
        if (X <  1) {
            max = 1;
        }

        while (max - min > eps) {
            double mid = (max + min) / 2.0;
            if (mid * mid > X){
                max = mid;
            }else {
                min = mid;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        double number = 0.5;
        System.out.println("The square root of " + number + " is approximately " +  sqrt(number));
    }
}

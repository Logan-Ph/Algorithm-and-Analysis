package w9_tutorial;

public class Problem3 {
    public static void main(String[] args) {
        double number = 3.0; // The number whose square root you want to find
        double guess = number / 2.0; // Start with a guess that's halfway the number
        double precision = 0.000001; // The precision you want (up to six digits after the decimal point)

        while (Math.abs(guess * guess - number) > precision) {
            guess = (guess + number / guess) / 2.0; // Update the guess using the Newton-Raphson method
        }

        System.out.println("The square root of " + number + " is approximately " + guess);
    }
}

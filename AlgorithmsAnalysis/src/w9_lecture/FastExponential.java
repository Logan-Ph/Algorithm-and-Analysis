package w9_lecture;

public class FastExponential {
    public static int fastExponentiation(int a, int b, int n){ // calculate a^b mod n
        if (b==0){
            return 1;
        }
        if (b%2 == 0) return fastExponentiation(a, b/2, n) * fastExponentiation(a, b/2, n) %n;
        return a* fastExponentiation(a, b-1, n) % n;
    }

    public static void main(String[] args) {
        System.out.println(fastExponentiation(2, 1000000000, 1000000007)); // 2^1000000000 mod 1000000007
    }
}

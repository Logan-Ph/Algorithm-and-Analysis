package w6_lecture;

public class stringMatch {
    public static int bruteForceStringMatch(String str1, String patternString) {
        for (int i = 0; i < str1.length(); i++) {
            int j = 0;
            while (patternString.charAt(j) == str1.charAt(i+j)) {
                j++;
                if (j == patternString.length()) return 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "AAAAAAAAAAAH";
        String pattern = "AAAH";
        System.out.println(bruteForceStringMatch(str, pattern));
    }
}

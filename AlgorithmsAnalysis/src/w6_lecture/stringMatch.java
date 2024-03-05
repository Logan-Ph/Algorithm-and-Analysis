package w6_lecture;

public class stringMatch {
    public static int bruteForceStringMatch(String str1, String patternString) {
        for (int i =0; i <str1.length(); i++){
            int j = 0;
            while (j < patternString.length() && str1.charAt(i+j) == patternString.charAt(j)) {
                j++;
            }
            if (j == patternString.length()){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "RMIT IS THE BEST UNIVERSITY";
        String pattern = "BEST";
        System.out.println(bruteForceStringMatch(str, pattern));
    }
}

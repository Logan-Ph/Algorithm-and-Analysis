package w6_lecture;

public class stringMatchingPractice {
    static boolean checkPattern(String pattern, String str){
        for (int i = 0; i < str.length(); i++){
            int j = 0;
            while (str.charAt(i+j) == pattern.charAt(j)) {
                j++;
                if (j == pattern.length()){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "RMIT IS THE BEST UNIVERSITY";
        String pattern = "UNIV";
        System.out.println(checkPattern(pattern, str));

    }
}

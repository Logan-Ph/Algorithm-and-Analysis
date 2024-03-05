package w3_Tutorial;
import java.util.Stack;

public class Problem4 {
    static boolean matchingParanthesis(String s){
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '(' || c=='{' || c=='['){
                stack.push(c);
            }else if (c == ')' || c=='}' || c==']'){
                if (stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "{{[[}}]]";
        System.out.println(matchingParanthesis(s));
    }
}

package w3_lecture;
import java.util.Stack;

public class matchingParanthesis {
    public static boolean isBalanced(String s){
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()){
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            if (c ==')' || c == ']' || c == '}'){
                if (stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "abc[d(ef)gh}i{j], abc(de}";
        System.out.println(isBalanced(s));
    }
}

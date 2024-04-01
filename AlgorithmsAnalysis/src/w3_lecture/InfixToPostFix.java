package w3_lecture;
import java.util.Stack;

public class InfixToPostFix {
    public static int precedence(char c){
        if (c == '+' || c == '-'){
            return 1;
        }
        else if (c == '*' || c == '/'){
            return 2;
        }
        else if (c == '^'){
            return 3;
        }
        return -1;
    }

    public static String infixToPostfix(String s){
        Stack<Character> stack = new Stack<>();
        String result = "";
        for (char c: s.toCharArray()){
            if (Character.isLetterOrDigit(c)){
                result  += c;
            }
            else if (c == '('){
                stack.push(c);
            }
            else if (c == ')'){
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.pop();
            }else{
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    result += stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "a-(b*c-d)/e";
        System.out.println(infixToPostfix(s));
    }
}

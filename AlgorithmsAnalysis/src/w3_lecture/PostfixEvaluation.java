package w3_lecture;
import java.util.Stack;

public class PostfixEvaluation {
    public static int evaluatePostfix(String s) {
        Stack<Integer> stack = new Stack<>();
        for (char c: s.toCharArray()){
            if (Character.isDigit(c)){
                stack.push(c - '0');
            }
            else{
                int a = stack.pop();
                int b = stack.pop();
                switch (c){
                    case '+':
                        stack.push(b + a);
                        break;
                    case '-':
                        stack.push(b - a);
                        break;
                    case '*':
                        stack.push(b * a);
                        break;
                    case '/':
                        stack.push(b / a);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String s = "234+*";
        System.out.println(evaluatePostfix(s));
    }
}

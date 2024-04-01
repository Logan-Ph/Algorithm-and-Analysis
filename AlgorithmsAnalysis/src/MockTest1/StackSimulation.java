package MockTest1;

import java.util.Arrays;

public class StackSimulation {
    public static String[] popAll(String[] stack){
        int n = stack.length;
        String[] newStack = new String[n];
        for (int i = 0; i < n; i++){
            newStack[i] = stack[n-i-1];
        }

        return newStack;
    }

    public static int minOperations(String[] targetStack, String[] currentStack){
        int numCharCommon = 0;
        int i = 0;
        while (i < targetStack.length && i < currentStack.length) {
            if (targetStack[i] == currentStack[i]){
                numCharCommon++;
                i++;
            }else{
                break;
            }
        }

        return (targetStack.length - numCharCommon) + (currentStack.length - numCharCommon);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(popAll(new String[] {"A","B","C"})));
        System.out.println(minOperations(new String[] {"A", "B", "C"}, new String[] {"A", "B", "C"}));
        System.out.println(minOperations(new String[] {"A", "B", "C"}, new String[] {"A", "B"}));
        System.out.println(minOperations(new String[] {"A", "B", "C"}, new String[] {"A", "B", "C", "D"}));
        System.out.println(minOperations(new String[] {"A", "B", "C"}, new String[] {"A", "C", "B"}));
    }
}

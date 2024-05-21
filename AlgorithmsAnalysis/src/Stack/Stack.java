package Stack;

public class Stack<T> {
    int capacity, size;
    T[] array;

    public Stack(int capacity){
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public boolean push(T data){
        if (size == capacity) return false;

        array[size] = data;
        size++;
        return true;
    }

    public T pop(){
        if (size == -1 ) return null;

        return array[--size];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public T peek(){
        return array[size-1];
    }

    public int size(){
        return size;
    }

    public static void main(String[] args) {
        String paranString = "{[({(}})]}";

        Stack<Character> stack = new Stack<>(10);

        for (char c : paranString.toCharArray()){
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                char top = stack.pop();
                if ((top == '(' && c != ')') || (top == '{' && c != '}') || (top == '[' && c != ']')){
                    System.out.println("False");
                    return;
                }
            }
        }

        System.out.println(stack.isEmpty());
    }
}


package Queue;

// this queue implementaiton only use rear, and front always zero
public class Queue1<T> {
    int size,rear;
    T[] array;

    public Queue1(int size){
        this.size = size;
        array = (T[]) new Object[size];
    }

    public boolean enQueue(T data){
        if (rear == size) return false;
        
        array[rear++] = data;
        return true;
    }

    public T deQueue(){
        if (rear == 0) return null;

        rear--;
        T temp = array[0];
        for (int i = 0; i < rear; i++){
            array[i] = array[i+1];
        }
    
        return temp;
    }

    public boolean isEmpty(){
        return rear == 0;
    }

    public T peakFront(){
        return array[0];
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < rear; i++){
            st.append(array[i] + " ");
        }
        return st.toString();
    }

    public static void main(String[] args) {
        Queue1<Integer> queue = new Queue1<>(4);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);

        System.out.println(queue);

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());

    }
}

package Queue;

public class Queue2<T> {
    int size, rear, front, capacity;
    T[] array;

    public Queue2(int capacity){
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public boolean enQueue(T data){
        if (size == capacity) return false;

        array[rear] = data;
        size++;
        rear = (rear + 1) % capacity;
        return true;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public T deQueue(){
        if (isEmpty()) return null;

        T temp = array[front];
        front = (front + 1) % capacity;
        size--;
        return temp;
    }

    public T peakFront(){
        return array[rear];
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        for (int i = front, j = 0; j < size; j++, i = (i+1)%capacity ){
            st.append(array[i] + " ");
        }
        return st.toString();
    }

    public static void main(String[] args) {
        Queue2<Integer> queue = new Queue2<>(4);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);

        System.out.println(queue);

        System.out.println(queue.deQueue());

        queue.enQueue(5);
        System.out.println(queue);
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());

        queue.enQueue(6);
        queue.enQueue(7);
        System.out.println(queue);

    }
}

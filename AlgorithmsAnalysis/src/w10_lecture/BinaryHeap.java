package w10_lecture;

import java.util.Random;

public class BinaryHeap {
    int MAX_SIZE = 100;
    int[] heap;
    int size;

    public BinaryHeap() {
        heap = new int[MAX_SIZE];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void buildHeap(int[] arr) {
        size = arr.length;
        for (int i = 0; i < size; i++) {
            heap[i] = arr[i];
        }

        for (int i = 0; i < size / 2; i++) {
            heapify(i);
        }
    }

    public void heapify(int nodeIdx) {
        int current = nodeIdx;
        int leftChild = nodeIdx * 2 + 1;
        int rightChild = nodeIdx * 2 + 2;

        if (leftChild < size && heap[leftChild] > heap[current]) {
            current = leftChild;
        }

        if (rightChild < size && heap[rightChild] > heap[current]) {
            current = rightChild;
        }

        if (nodeIdx == current) {
            return;
        }

        int temp = heap[nodeIdx];
        heap[nodeIdx] = heap[current];
        heap[current] = temp;

        heapify(current);
    }

    public int extractMax() {
        int temp = heap[0];

        heap[0] = heap[size - 1];

        size--;

        heapify(0);

        return temp;
    }

    public void insert(int n) {
        heap[size++] = n;

        int current = size - 1;
        int parent = (current - 1) / 2;

        while (current > 0 & heap[parent] < heap[current]) {
            int temp = heap[parent];
            heap[parent] = heap[current];
            heap[current] = temp;

            current = parent;
            parent = (current - 1) / 2;
        }
    }
}

class Test {
    public static void main(String[] args) {
        int SIZE = 10;
        int[] numbers = new int[SIZE];
        Random rnd = new Random(SIZE);
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = rnd.nextInt(20);
        }

        // array content before sort
        System.out.println("Before sorting:");
        for (int i = 0; i < SIZE; i++) {
            System.out.println(numbers[i]);
        }

        // heap sort
        BinaryHeap heap = new BinaryHeap();
        heap.buildHeap(numbers);
        int n = SIZE - 1;
        while (!heap.isEmpty()) {
            numbers[n] = heap.extractMax();
            n--;
        }

        // after sort
        System.out.println("=====Heap Sort Result=====");
        for (int i = 0; i < SIZE; i++) {
            System.out.println(numbers[i]);
        }
        System.out.println("==========");

        // insert random values into the heap
        for (int i = 0; i < 10; i++) {
            int t = rnd.nextInt(20);
            System.out.println("Insert: " + t);
            heap.insert(t);
        }

        // extract max continously
        System.out.println("Extraction Order");
        while (!heap.isEmpty()) {
            System.out.println(heap.extractMax());
        }
    }
}

package w10_lecture;

public class Heap {
    static void MaxHeapify(int arr[], int N, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
 
        // If left child is larger than root
        if (l < N && arr[l] > arr[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < N && arr[r] > arr[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            MaxHeapify(arr, N, largest);
        }
    }

    static void MinHeapify(int arr[], int N, int i)
    {
        int smallest = i; // Initialize smallest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
 
        // If left child is larger than root
        if (l < N && arr[l] < arr[smallest])
            smallest = l;
 
        // If right child is larger than smallest so far
        if (r < N && arr[r] < arr[smallest])
            smallest = r;
 
        // If smallest is not root
        if (smallest != i) {
            int swap = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = swap;
 
            // Recursively heapify the affected sub-tree
            MinHeapify(arr, N, smallest);
        }
    }
 
    // Function to build a Max-Heap from the Array
    static void buildMaxHeap(int arr[], int N)
    {
        // Index of last non-leaf node
        int startIdx = (N / 2) - 1;
 
        // Perform reverse level order traversal
        // from last non-leaf node and heapify
        // each node
        for (int i = startIdx; i >= 0; i--) {
            MaxHeapify(arr, N, i);
        }
    }

    static void buildMinHeap(int arr[], int N)
    {
        // Index of last non-leaf node
        int startIdx = (N / 2) - 1;
 
        // Perform reverse level order traversal
        // from last non-leaf node and heapify
        // each node
        for (int i = startIdx; i >= 0; i--) {
            MinHeapify(arr, N, i);
        }
    }
    
    // A utility function to print the array
    // representation of Heap
    static void printHeap(int arr[], int N)
    {
        System.out.println(
            "Array representation of Heap is:");
 
        for (int i = 0; i < N; ++i)
            System.out.print(arr[i] + " ");
 
        System.out.println();
    }
 
    // Driver Code
    public static void main(String args[])
    {
        // Binary Tree Representation
        // of input array
        //            1
        //         /      \
        //       3        5
        //     /   \       / \
        //  4       6  13 10
        // / \    /  \
        // 9  8  15   17
        int arr1[] = {12, 11, 13, 5, 6, 7};
        int arr2[] = {12, 11, 13, 5, 6, 7};
        int N1 = arr1.length;
        int N2 = arr2.length;
       
        buildMaxHeap(arr1, N1);
        buildMinHeap(arr2, N2);
        printHeap(arr1, N1);
        printHeap(arr2, N2);
    }  
}
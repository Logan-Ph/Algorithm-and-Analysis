package w6_tutorial;

import Queue.Queue1;

public class problem2 {
    public static void main(String[] args) {
        MatrixGraph g = new MatrixGraph(6);
        g.setNodeLabel(0, "A");
        g.setNodeLabel(1, "B");
        g.setNodeLabel(2, "C");
        g.setNodeLabel(3, "D");
        g.setNodeLabel(4, "E");
        g.setNodeLabel(5, "F");
        g.addEdge(0, 1);  // A-B
        g.addEdge(0, 2);  // A-C
        g.addEdge(0, 3);  // A-D
        g.addEdge(1, 2);  // B-C
        g.addEdge(1, 4);  // B-E
        g.addEdge(2, 3);  // C-D
        g.addEdge(2, 4);  // C-E
        g.addEdge(2, 5);  // C-F
        g.addEdge(3, 5);  // D-F
        g.DFS();
        g.BFS();
    }
}

class MatrixGraph{
    int[][] matrix;

    String[] nodeLabels;

    int size;

    public MatrixGraph(int nodes){
        size = nodes;
        matrix = new int[size][size];

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                matrix[i][j] = 0;
            }
        }

        nodeLabels = new String[size];
    }

    public void setNodeLabel(int nodeIdx, String label){
        nodeLabels[nodeIdx] = label;
    }

    public void addEdge(int node1, int node2){
        matrix[node1][node2] = 1;
        matrix[node2][node1] = 1;
    }

    public void removeNode(int node1, int node2){
        matrix[node1][node2] = 0;
        matrix[node2][node1] = 0;
    }

    public void DFS(){
        System.out.println("Depth-First Search/Traversal");
        boolean[] visited = new boolean[size];
        DFSR(0, visited);
    }

    public void DFSR(int nodeIndex, boolean[] visited){
        if (visited[nodeIndex]) return;

        System.out.println("Visit: " + nodeLabels[nodeIndex]);
        visited[nodeIndex] = true;

        for (int i = 0; i < size; i++){
            if (matrix[nodeIndex][i] == 1){
                DFSR(i, visited);
            }
        }
    }

    public void BFS(){
        System.out.println("Breadth-First Search/Traversal");
        Queue1<Integer> queue1 = new Queue1<>(size);
        boolean[] visited = new boolean[size];

        queue1.enQueue(0);
        visited[0] = true;
        while (!queue1.isEmpty()) {
            int nodeIndex = queue1.deQueue();
            System.out.println("Visit: " + nodeLabels[nodeIndex]);

            for (int i = 0; i < size; i++){
                if (matrix[nodeIndex][i] == 1 && !visited[i]){
                    queue1.enQueue(i);
                    visited[i] = true;
                }
            }
        }
    }    
}
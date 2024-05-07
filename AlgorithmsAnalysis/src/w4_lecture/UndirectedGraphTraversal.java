package w4_lecture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class UndirectedGraphTraversal {
    public static HashMap<String, ArrayList<String>> buildGraph(String[][] edges) {
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        for (String[] edge : edges) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }

            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1], new ArrayList<>());
            }

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    public static void depthFirstSearch(HashMap<String, ArrayList<String>> graph, Set<String> visited,
            String startNode) {

        if (visited.contains(startNode))
            return;
            
        System.out.print(startNode + " ");
        visited.add(startNode);
        for (String neighbor : graph.get(startNode)) {
            depthFirstSearch(graph, visited, neighbor);
        }
    }

    public static void breadthFirstSearch(HashMap<String, ArrayList<String>> graph, String startNode) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(startNode);
        visited.add(startNode);
        while (!queue.isEmpty()) {
            String currentNode = queue.poll();
            System.out.print(currentNode + " ");
            for (String neightbor : graph.get(currentNode)) {
                if (!visited.contains(neightbor)) {
                    visited.add(neightbor);
                    queue.add(neightbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        String[][] edges = {
                { "a", "b" },
                { "a", "d" },
                { "a", "c" },
                { "b", "c" },
                { "c", "d" },
                { "e", "b" },
                { "e", "c" },
                { "f", "c" },
                { "f", "d" }
        };

        HashMap<String, ArrayList<String>> graph = buildGraph(edges);
        System.out.println(graph);
        System.out.println("Breadth First Search");
        breadthFirstSearch(graph, "a");
        System.out.println();
        System.out.println("Depth First Search");
        depthFirstSearch(graph, new HashSet<>(), "a");
    }
}

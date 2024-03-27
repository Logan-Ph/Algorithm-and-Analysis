package w4_Tutorial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Problem3 {
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

    public static void depthFirstSearch(HashMap<String, ArrayList<String>> graph, Set<String> visisted, String startNode) {
        System.out.println(startNode);
        visisted.add(startNode);
        for (String neighbor : graph.get(startNode)) {
            if (!visisted.contains(neighbor)) {
                visisted.add(neighbor);
                depthFirstSearch(graph, visisted, neighbor);
            }
        }
    }

    public static void breadthFirstSearch(HashMap<String, ArrayList<String>> graph, String startNode) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(startNode);
        visited.add(startNode);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.println(current);
            for (String neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

    }

    public static boolean hasPathDFS(HashMap<String, ArrayList<String>> graph, String src, String dst,
            Set<String> visited, Queue<String> rightPath) {
        if (src.equals(dst)) {
            return true;
        }

        if (visited.contains(src)) {
            rightPath.remove(src);
            return false;
        }

        visited.add(src);
        for (String neighbor : graph.get(src)) {
            if (hasPathDFS(graph, neighbor, dst, visited, rightPath)) {
                rightPath.add(neighbor);
                return true;
            }
        }

        return false;
    }

    public static boolean hashPathBFS(HashMap<String, ArrayList<String>> graph, String src, String dst) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(src);
        visited.add(src);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(dst)) {
                return true;
            }

            for (String neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String[][] edges = {
                { "A", "F" },
                { "A", "B" },
                { "F", "E" },
                { "E", "B" },
                { "B", "C" },
                { "E", "D" },
                { "C", "D" }
        };

        HashMap<String, ArrayList<String>> graph = buildGraph(edges);
        System.out.println(graph);
        // System.out.println("Depth First Search: ");
        // depthFirstSearch(graph, new HashSet<>(), "A");
        // System.out.println("Beadth First Search");
        // breadthFirstSearch(graph, "A");
        // System.out.println("Has path from A to D");
        // Queue<String> rightPath = new LinkedList<>();
        // System.out.println(hasPathDFS(graph, "B", "D", new HashSet<>(), rightPath));
        // rightPath.add("B");
        // System.out.println(rightPath);

        System.out.println(hashPathBFS(graph, "B", "D"));
    }
}

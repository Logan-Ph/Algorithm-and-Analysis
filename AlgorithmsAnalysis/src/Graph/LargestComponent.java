package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LargestComponent {
    public static int largestComponent(HashMap<String, ArrayList<String>> graph) {
        int largest = 0;
        HashSet<String> visited = new HashSet<>();
        for (String node : graph.keySet()) {
            int size = explore(graph, node, visited) ;
            largest = Math.max(largest, size);
        }
        return largest;
    }

    public static int explore(HashMap<String, ArrayList<String>> graph, String current, HashSet<String> visited) {
        if (visited.contains(current))
            return 0;
        visited.add(current);
        int size = 1;
        for (String neighbor : graph.get(current)) {
            size += explore(graph, neighbor, visited);
        }
        return size;
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        graph.put("0", new ArrayList<String>(Arrays.asList("8", "1", "5")));
        graph.put("1", new ArrayList<String>(Arrays.asList("0")));
        graph.put("5", new ArrayList<String>(Arrays.asList("0", "8")));
        graph.put("8", new ArrayList<String>(Arrays.asList("0", "5")));
        graph.put("2", new ArrayList<String>(Arrays.asList("3", "4")));
        graph.put("3", new ArrayList<String>(Arrays.asList("2", "4")));
        graph.put("4", new ArrayList<String>(Arrays.asList("3", "2")));
        System.out.println(largestComponent(graph));
    }
}

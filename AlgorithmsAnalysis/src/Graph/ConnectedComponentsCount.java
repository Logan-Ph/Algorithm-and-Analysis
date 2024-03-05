package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ConnectedComponentsCount {

    public static int connectComponentsCount(HashMap<String , ArrayList<String>> graph){
        int count = 0;
        HashSet<String> visited = new HashSet<>();
        for (String node : graph.keySet()) {
            if (explore(graph, node, visited)){
                count++;
            };
        }
        return count;
    }

    public static boolean explore(HashMap<String, ArrayList<String>> graph, String current, HashSet<String> visited){
        if (visited.contains(current)) return false;
        visited.add(current);
        for (String neighbor : graph.get(current)) {
            explore(graph, neighbor, visited);
        }
        return true;
    }

    public static void main(String[] args) {
        HashMap<String,ArrayList<String>> graph = new HashMap<>();
        graph.put("0", new ArrayList<String>(Arrays.asList("8","1","5")));
        graph.put("1", new ArrayList<String>(Arrays.asList("0")));
        graph.put("5", new ArrayList<String>(Arrays.asList("0","8")));
        graph.put("8", new ArrayList<String>(Arrays.asList("0","5")));
        graph.put("2", new ArrayList<String>(Arrays.asList("3", "4")));
        graph.put("3", new ArrayList<String>(Arrays.asList("2", "4")));
        graph.put("4", new ArrayList<String>(Arrays.asList("3","2")));
        System.out.println(connectComponentsCount(graph));
    }
}

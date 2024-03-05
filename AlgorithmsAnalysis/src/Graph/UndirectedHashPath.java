package Graph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UndirectedHashPath {

    public static boolean undirectedPath(String[][] edges, String src, String dst) {
        HashMap<String, ArrayList<String>> graph = buildGraph(edges);
        return hasPath(graph, src, dst, new HashSet<String>());
    }

    public static HashMap<String, ArrayList<String>> buildGraph(String[][] edges) {
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        for (String[] edge : edges) {
            String a = edge[0];
            String b = edge[1];
            if (!graph.containsKey(a)) {
                graph.put(a, new ArrayList<>());
            }
            if (!graph.containsKey(b)) {
                graph.put(b, new ArrayList<>());
            }
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        return graph;
    }

    public static boolean hasPath(HashMap<String, ArrayList<String>> graph, String src, String dst,
            Set<String> visited) {
        if (src.equals(dst)) {
            return true;
        }
        if (visited.contains(src)) {
            return false;
        }

        visited.add(src);

        for (String neighbor : graph.get(src)) {
            if (hasPath(graph, neighbor, dst, visited)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[][] edges = {
                { "i", "j" },
                { "k", "i" },
                { "m", "k" },
                { "k", "l" },
                { "o", "n" }
        };

        System.out.println(undirectedPath(edges, "i", "m"));
    }
}

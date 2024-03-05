package Graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class HasPath {

    static boolean hashPathDepthFirstSearch(HashMap<String,ArrayList<String>> graph, String src, String dst){
        if (src.equals(dst)){
            return true;
        }

        for (String neighbor: graph.get(src)){
            if (hashPathDepthFirstSearch(graph, neighbor, dst)){
                return true;
            }
        }

        return false;
    }

    static boolean hasPathBreadthFirstSearch(HashMap<String,ArrayList<String>> graph, String src, String dst){
        ArrayList<String> queue = new ArrayList<>();
        queue.add(src);
        while (!queue.isEmpty()){
            String currentNode = queue.remove(0);
            if (currentNode.equals(dst)){
                return true;
            }
            for (String neighbor : graph.get(currentNode)){
                queue.add(neighbor);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HashMap<String,ArrayList<String>> graph = new HashMap<>();
        graph.put("f", new ArrayList<String>(Arrays.asList("g","i")));
        graph.put("g", new ArrayList<String>(Arrays.asList("h")));
        graph.put("h", new ArrayList<String>(Arrays.asList(new String[]{})));
        graph.put("i", new ArrayList<String>(Arrays.asList("g","k")));
        graph.put("j", new ArrayList<String>(Arrays.asList("i")));
        graph.put("k", new ArrayList<String>(Arrays.asList(new String[]{})));
        System.out.println(hasPathBreadthFirstSearch(graph, "f", "k"));
    }
}

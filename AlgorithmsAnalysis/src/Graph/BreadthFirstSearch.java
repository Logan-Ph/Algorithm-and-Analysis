package Graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class BreadthFirstSearch {
    static void breadthFirstSearchIterative(HashMap<String,ArrayList<String>> graph, String startNode){
        Queue<String> queue = new LinkedList<>();
        queue.add(startNode);
        while (!queue.isEmpty()) {
            String currentNode = queue.poll();
            System.out.println(currentNode);
            for (String neighbor : graph.get(currentNode)){
                queue.add(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String,ArrayList<String>> graph = new HashMap<>();
        graph.put("a", new ArrayList<String>(Arrays.asList("c","b")));
        graph.put("b", new ArrayList<String>(Arrays.asList("d")));
        graph.put("c", new ArrayList<String>(Arrays.asList("e")));
        graph.put("d", new ArrayList<String>(Arrays.asList("f")));
        graph.put("e", new ArrayList<String>(Arrays.asList(new String[]{})));
        graph.put("f", new ArrayList<String>(Arrays.asList(new String[]{})));
        breadthFirstSearchIterative(graph, "a");
    }
}

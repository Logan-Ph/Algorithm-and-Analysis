package Graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class DepthFirstSearch {

    static void depthFirstSearchIterative(HashMap<String,ArrayList<String>> graph, String startNode){
        Stack<String> stack = new Stack<>();
        stack.push(startNode);
        while (!stack.isEmpty()) {
            String currentNode = stack.pop();
            System.out.println(currentNode);
            for (String neighbor : graph.get(currentNode)){
                stack.push(neighbor);
            }
        }
    }

    static void depthFirstSearchRecursively(HashMap<String,ArrayList<String>> graph, String startNode){
        System.out.println(startNode);
        for (String neighbor : graph.get(startNode)){
            depthFirstSearchRecursively(graph, neighbor);
        }
    }

    public static void main(String[] args) {
        HashMap<String,ArrayList<String>> graph = new HashMap<>();
        // graph.put("a", new ArrayList<String>(Arrays.asList("c","b")));
        // graph.put("b", new ArrayList<String>(Arrays.asList("d")));
        // graph.put("c", new ArrayList<String>(Arrays.asList("e")));
        // graph.put("d", new ArrayList<String>(Arrays.asList("f")));
        // graph.put("e", new ArrayList<String>(Arrays.asList(new String[]{})));
        // graph.put("f", new ArrayList<String>(Arrays.asList(new String[]{})));

        graph.put("1", new ArrayList<String>(Arrays.asList(new String[]{})));
        graph.put("2", new ArrayList<String>(Arrays.asList("1", "3")));
        graph.put("3", new ArrayList<String>(Arrays.asList("4")));
        graph.put("4", new ArrayList<String>(Arrays.asList("1")));
        
        depthFirstSearchRecursively(graph, "4");
    }
}

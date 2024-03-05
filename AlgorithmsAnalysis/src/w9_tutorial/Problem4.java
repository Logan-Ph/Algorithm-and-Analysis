package w9_tutorial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Problem4 {
    public static List<String> findOrder(String[] courses, int[][] prerequisites){
        Map<String,Integer> courseToIndex = new HashMap<>();
        for (int i = 0; i < courses.length; i++){
            courseToIndex.put(courses[i], i);
        }

        System.out.println(courseToIndex);

        List<String> order = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < courses.length; i++){
            if (!visited.contains(i)){
                dfs(i, prerequisites, visited, order, courses);
            }
        }
        
        return order;
    }

    static void dfs(int courseIndex, int[][] prerequisites, HashSet<Integer> visited, List<String> order, String[] courses){
        visited.add(courseIndex);

        for (int i = 0; i < prerequisites[courseIndex].length; i++) {
            if (prerequisites[courseIndex][i] == 1 && !visited.contains(i)) {
                dfs(i, prerequisites, visited, order, courses);
            }
        }

        order.add(courses[courseIndex]);
    }

    public static void main(String[] args) {
        String[] courses = {"Course0", "Course1", "Course2", "Course3"};
        int[][] prerequisites = {
            {0, 0, 0, 0},
            {1, 0, 1, 0},
            {0, 0, 0, 1},
            {1, 0, 0, 0}
        };

        System.out.println(findOrder(courses, prerequisites));
    }
}

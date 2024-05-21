package w9_tutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import Queue.Queue1;

public class Problem4 {
    public static List<String> findOrder(String[] courses, int[][] prerequisites) {
        Map<String, Integer> courseToIndex = new HashMap<>();
        for (int i = 0; i < courses.length; i++) {
            courseToIndex.put(courses[i], i);
        }

        List<String> order = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < courses.length; i++) {
            if (!visited.contains(i)) {
                dfs(i, prerequisites, visited, order, courses);
            }
        }

        return order;
    }

    static void dfs(int courseIndex, int[][] prerequisites, HashSet<Integer> visited, List<String> order,
            String[] courses) {
        visited.add(courseIndex);

        for (int i = 0; i < prerequisites[courseIndex].length; i++) {
            if (prerequisites[courseIndex][i] == 1 && !visited.contains(i)) {
                dfs(i, prerequisites, visited, order, courses);
            }
        }

        order.add(courses[courseIndex]);
    }

    static String[] topoSort(String[] courseNames, int[][] requires) {
        int n = courseNames.length;
        String[] res = new String[n];
        Course[] courses = new Course[n];
        Queue1<Course> queue = new Queue1<>(n);

        for (int i = 0; i < n; i++){
            courses[i] = new Course(courseNames[i], i);
            for (int j = 0; j < n; j++){
                if (requires[i][j] == 1) courses[i].increaseDegree();
            }
        }

        for (int i = 0; i < n; i++){
            if (courses[i].isSource()){
                queue.enQueue(courses[i]);
                courses[i].visited = true;
            }
        }

        int p = 0;
        
        while (!queue.isEmpty()) {
            Course u = queue.deQueue();
            int source = u.index;
            res[p++] = u.name;

            for (int target = 0; target < n; target++){
                if (requires[target][source] == 0 || courses[target].visited) continue;

                courses[target].decreaseDegree();
                if (courses[target].isSource()){
                    queue.enQueue(courses[target]);
                    courses[target].visited = true;
                }
            }
        }

        if (p < n){
            System.out.println("Cannot take all the course");
        }
        return res;
    }

    public static void main(String[] args) {
        String[] courses = { "Course0", "Course1", "Course2", "Course3" };
        int[][] prerequisites = {
                { 0, 0, 0, 0 },
                { 1, 0, 1, 0 },
                { 0, 0, 0, 1 },
                { 1, 0, 0, 0 }
        };

        System.out.println(findOrder(courses, prerequisites));

        int[][] requires = new int[][] {
                { 0, 0, 0, 0 },
                { 1, 0, 1, 0 },
                { 0, 0, 0, 0 },
                { 1, 0, 0, 0 }
        };

        String[] learningOrder = topoSort(courses, requires);
        System.out.println(Arrays.toString(learningOrder));
    }
}

class Course {
    String name;
    int index;
    int inDegree;
    boolean visited;

    public Course(String name, int index) {
        this.name = name;
        this.index = index;
        this.inDegree = 0;
        this.visited = false;
    }

    public void increaseDegree() {
        inDegree++;
    }

    public void decreaseDegree() {
        inDegree--;
    }

    public boolean isSource() {
        return inDegree == 0;
    }
}
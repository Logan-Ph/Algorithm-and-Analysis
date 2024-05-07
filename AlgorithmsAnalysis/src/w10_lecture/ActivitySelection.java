package w10_lecture;

import java.util.Arrays;

public class ActivitySelection {

    private static boolean isValidSubset(int[][] arr, boolean[] selected_states) {
        for (int i = 0; i < arr.length; i++) {
            if (selected_states[i]) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (selected_states[j] && !(arr[i][1] < arr[j][0] || arr[j][1] < arr[i][0])) {
                        return false; // There is an overlap
                    }
                }
            }
        }
        return true; // No overlaps found
    }

    public static void generateSubset(int[][] arr, boolean[] selected_states, int curr_idx){
        if (curr_idx == arr.length){
            if (isValidSubset(arr, selected_states)) {
                for (int i = 0; i < arr.length; i++){
                    if (selected_states[i]){
                        System.out.print( "{" + arr[i][0] + ", " + arr[i][1] + "} ");
                    }
                }
                System.out.println();
            }
            return;
        }

        selected_states[curr_idx] = true;
        generateSubset(arr, selected_states, curr_idx + 1);
    
        selected_states[curr_idx] = false;
        generateSubset(arr, selected_states, curr_idx + 1);
    }

    public static void selectActivities(int[][] activities){
        Arrays.sort(activities, (a1,a2) -> Integer.compare(a1[1], a2[1]));

        int lastFinishTime = Integer.MIN_VALUE;
        for(int i = 0; i < activities.length; i++){
            if (activities[i][0] > lastFinishTime){
                System.out.print( "{" + activities[i][0] + ", " + activities[i][1] + "} ");
                lastFinishTime = activities[i][1];
            }
        }
    }

    public static void main(String[] args) {
        int[][] activities = new int[][] {{3,4},{0,6},{8,9},{4,5},{1,2}};
        generateSubset(activities, new boolean[activities.length], 0);
        selectActivities(activities);
    }
}

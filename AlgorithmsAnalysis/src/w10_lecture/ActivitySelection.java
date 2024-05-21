package w10_lecture;

import java.util.Arrays;

public class ActivitySelection {
    public static boolean isValidSubset(int[][] activities, boolean[] selected_states) {
        for (int i = 0; i < activities.length; i++) {
            if (selected_states[i]) {
                for (int j = i + 1; j < activities.length; j++) {
                    if (selected_states[j]
                            && !(activities[i][1] < activities[j][0] || activities[j][1] < activities[i][0])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void generateSubset(int[][] activities, boolean[] selected_states, int curr_idx) {
        if (curr_idx == activities.length) {
            if (isValidSubset(activities, selected_states)) {
                for (int i = 0; i < activities.length; i++) {
                    if (selected_states[i]) {
                        System.out.print("{" + activities[i][0] + ", " + activities[i][1] + "} ");
                    }
                }
                System.out.println();
            }
            return;
        }

        selected_states[curr_idx] = true;
        generateSubset(activities, selected_states, curr_idx + 1);
        selected_states[curr_idx] = false;
        generateSubset(activities, selected_states, curr_idx + 1);
    }

    public static void selectActivities(int[][] activities) {
        Arrays.sort(activities, (a1, a2) -> Integer.compare(a1[1], a2[1]));

        int lastFinishTime = Integer.MIN_VALUE;
        for (int i = 0; i < activities.length; i++) {
            if (activities[i][0] > lastFinishTime) {
                System.out.print("{" + activities[i][0] + ", " + activities[i][1] + "} ");
                lastFinishTime = activities[i][1];
            }
        }
    }

    public static void main(String[] args) {
        Task[] tasks = new Task[] {
                new Task(3, 4),
                new Task(0, 6),
                new Task(8, 9),
                new Task(4, 5),
                new Task(1, 2),
        };

        MergeSort sort = new MergeSort();
        sort.mergeSort(tasks);

        Task current = tasks[0];
        for (int i = 1 ; i < tasks.length; i++){
            if (tasks[i].start < current.end){
                continue;
            }
            current = tasks[i];
            System.out.print(tasks[i]);
        }
    }
}

class Task {
    int start;
    int end;

    public Task(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString(){
        return "{ " + start + " " + end + " } ";
    }
}

class MergeSort {
    public void mergeSort(Task[] arr) {
        if (arr.length <= 1)
            return;
        int n = arr.length;
        int mid = n / 2;

        Task[] sub1 = new Task[mid];
        for (int i = 0; i < mid; i++) {
            sub1[i] = arr[i];
        }

        Task[] sub2 = new Task[n - mid];
        for (int i = mid; i < n; i++) {
            sub2[i - mid] = arr[i];
        }

        mergeSort(sub1);
        mergeSort(sub2);

        merge(sub1, sub2, arr);
    }

    public void merge(Task[] sub1, Task[] sub2, Task[] dest){
        int p1 =0,  p2 = 0,  d = 0;

        while (p1 < sub1.length && p2 < sub2.length && d < dest.length) {
            if (sub1[p1].end < sub2[p2].end){
                dest[d] = sub1[p1];
                p1++;
            }else{
                dest[d] = sub2[p2];
                p2++;
            }
            d++;
        }

        while (p1 < sub1.length) {
            dest[d++] = sub1[p1++];
        }

        while (p2 < sub2.length) {
            dest[d++] = sub2[p2++];
        }
    }
}
package w6_lecture;
/**
 * This class contains methods to generate all possible subsets of a given integer array.
 * It utilizes a recursive approach to explore each element's inclusion and exclusion in the subset.
 *
 * Methods:
 * - generate_Subset(int[] arr, boolean[] selected_states, int curr_idx): Recursively generates all subsets.
 *   It prints each subset when the end of the array is reached.
 * - main(String[] args): The entry point of the program which initializes the array and calls the generate_Subset method.
 */

public class generateSubset {

    /**
     * Recursively generates and prints all subsets of the given array.
     * Each element can either be included or excluded in the current subset being explored.
     *
     * @param arr The input array of integers for which subsets are to be generated.
     * @param selected_states An array of booleans representing the inclusion (true) or exclusion (false) of each element in the current subset.
     * @param curr_idx The current index in the array being processed.
     */
    public static void generate_Subset(int[] arr, boolean[] selected_states, int curr_idx){
        if (curr_idx == arr.length){
            for (int i = 0; i < arr.length; i++){
                if (selected_states[i]){
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }


        selected_states[curr_idx] = true;
        generate_Subset(arr, selected_states, curr_idx+1);

        selected_states[curr_idx] = false;
        generate_Subset(arr, selected_states, curr_idx+1);
    }

    public static void main(String[] args) {
        generate_Subset( new int[] {1,2,3,4}, new boolean[4], 0);
    }
}

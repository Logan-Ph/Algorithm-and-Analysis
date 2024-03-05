package w2;
import java.util.Arrays;

public class problem3 {
    static void findMinPlatforms(int[] arrivals, int[] departures){
        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int i = 0;
        int j = 0;
        int minPlatforms = 0;
        int platformsRequired = 0;
        while (i < arrivals.length && j < departures.length) {
            if (arrivals[i] < departures[j]){
                platformsRequired++;
                i++;
            } else {
                platformsRequired--;
                j++;
            }

            minPlatforms = Math.max(minPlatforms, platformsRequired);
        }
        System.out.println("Minimum platforms required: " + minPlatforms);
    }

    public static void main(String[] args) {
        int[] arrivals = {100,140,150,200,215,400};
        int[] departures = {110,300,220,230,315,600};
        findMinPlatforms(arrivals, departures);
    }   
}

package w3_Tutorial;
import java.util.LinkedList;
import java.util.Queue;

public class Problem3 {
    public static void main(String[] args) {
        QueueApplication.eventSimulation();
    }
}

class QueueApplication {
    static class Event {
        int arrival;
        int duration;

        public Event(int a, int d) {
            arrival = a;
            duration = d;
        }
    }

    static void eventSimulation() {
        Queue<Event> events = new LinkedList<>();
        events.add(new Event(0, 5));
        events.add(new Event(3, 3));
        events.add(new Event(4, 4));
        events.add(new Event(100, 4));

        int n = events.size();

        int nextAvailableTime = 0;
        int totalWaiting = 0;
        int maxWaitingTime = 0;

        while (!events.isEmpty()) {
            Event evt = events.peek();
            events.remove();
            nextAvailableTime = Math.max(nextAvailableTime, evt.arrival);
            int waitingTime = nextAvailableTime - evt.arrival;
            maxWaitingTime = Math.max(maxWaitingTime, waitingTime);
            totalWaiting += waitingTime;
            nextAvailableTime = nextAvailableTime + evt.duration;
        }

        System.out.printf("Max waiting time %d, total waiting time %d and average waiting time %.2f\n", maxWaitingTime,
                totalWaiting, 1.0 * totalWaiting / n);
    }

    public static void main(String[] args) {
        eventSimulation();
    }
}
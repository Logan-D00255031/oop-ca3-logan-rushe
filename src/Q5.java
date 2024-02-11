import java.util.ArrayDeque;
import java.util.Queue;

public class Q5 {
    public static void main(String[] args) {
        Q5 queue = new Q5();

        queue.takeoff("Flight-100"); // is queued
        queue.takeoff("Flight-220"); // is queued
        queue.land("Flight-320"); // is queued
        queue.next();
        queue.next();
        queue.next();

    }

    private final Queue<String> takeoffQueue = new ArrayDeque<>();
    private final Queue<String> landQueue = new ArrayDeque<>();

    public Q5() {

    }

    public void takeoff(String flightSymbol) {
        takeoffQueue.add(flightSymbol);
    }

    public void land(String flightSymbol) {
        landQueue.add(flightSymbol);
    }
    public void next() {
        if (!landQueue.isEmpty()) {
            System.out.println(landQueue.remove() + " Has landed.");
        }
        else {
            System.out.println(takeoffQueue.remove() + " Has taken off.");
        }
    }
}

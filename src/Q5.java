import java.util.ArrayDeque;

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

    private final ArrayDeque<String> takeoffQueue = new ArrayDeque<>();
    private final ArrayDeque<String> landQueue = new ArrayDeque<>();

    public Q5() {

    }

    public void takeoff(String flightSymbol) {
        takeoffQueue.push(flightSymbol);
    }

    public void land(String flightSymbol) {
        landQueue.push(flightSymbol);
    }
    public void next() {
        if (!landQueue.isEmpty()) {
            System.out.println(landQueue.removeLast() + " Has landed.");
        }
        else {
            System.out.println(takeoffQueue.removeLast() + " Has taken off.");
        }
    }
}

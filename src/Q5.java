import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        // Create flight queues
        Q5 queue = new Q5();
        // Create Scanner
        Scanner input = new Scanner(System.in);

        // Commands
        /*
        queue.takeoff("Flight-100"); // is queued
        queue.takeoff("Flight-220"); // is queued
        queue.land("Flight-320"); // is queued
        queue.next(); // next flight
        queue.next(); // next flight
        queue.next(); // next flight
         */

        boolean run = true;
        // Run loop
        while (run) {
            // Display commands
            System.out.println("Commands:\nTakeoff (String)flight\nLand (String)flight\nNext\nQuit");
            String choice = input.next();
            // If the command is "takeoff"
            if (choice.equalsIgnoreCase("takeoff")) {
                queue.takeoff(input.next());
            } // If the command is "land"
            else if (choice.equalsIgnoreCase("land")) {
                queue.land(input.next());
            } // If the command is "land"
            else if (choice.equalsIgnoreCase("next")) {
                queue.next();
            } // If the command is "quit"
            else if (choice.equalsIgnoreCase("quit")) {
                System.out.println("\nGoodbye.");
                // End run loop
                run = false;
            }
        }
    }

    private final Queue<String> takeoffQueue = new ArrayDeque<>();
    private final Queue<String> landQueue = new ArrayDeque<>();

    public Q5() {}

    // Adds a flight to the takeoff queue
    public void takeoff(String flightSymbol) {
        takeoffQueue.add(flightSymbol);
    }

    // Adds a flight to the landing queue
    public void land(String flightSymbol) {
        landQueue.add(flightSymbol);
    }

    public void next() {
        // If the landing queue is empty
        if (!landQueue.isEmpty()) {
            // Remove the next flight from the takeoff queue and display a message
            System.out.println(landQueue.remove() + " Has landed.");
        }
        else {
            // Remove the next flight from the landing queue and display a message
            System.out.println(takeoffQueue.remove() + " Has taken off.");
        }
    }
}

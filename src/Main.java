import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create stacks
        ArrayDeque<Integer> driveway = new ArrayDeque<>();
        ArrayDeque<Integer> street = new ArrayDeque<>();

        /*
        driveway.push(1);
        driveway.push(2);
        int x = driveway.remove();
        System.out.println(x);
        */

        // Create scanner
        Scanner input = new Scanner(System.in);
        // Display commands to user
        System.out.println("Enter an integer to represent a car to add to the driveway");
        System.out.println("Enter a negative integer to remove a car of the positive");
        System.out.println("Enter 0 to exit");

        boolean run = true;
        // Run loop
        while (run)
        {
            // Get integer from user
            int car = input.nextInt();
            // If it's zero, end the run loop
            if(car == 0) {run = false;}
            // If it's positive, push to the top of the driveway stack
            else if (car > 0) {
                driveway.push(car);
            } // If it's negative
            else {
                boolean remove = true;
                // Loop if remove is true and the car is in the driveway stack
                while (remove && driveway.contains(Math.abs(car))) {
                    // remove car from top of the driveway stack and push to the street stack
                    int currentCar = driveway.remove();
                    street.push(currentCar);
                    // if the absolute of the negative number is the same as the removed car
                    if (Math.abs(car) == currentCar) {
                        // End the loop
                        remove = false;
                        // remove that car from the street
                        street.remove();
                        // display all the cars that were removed
                        System.out.println("Before returning cars back to driveway:");
                        System.out.println(driveway);
                        System.out.println(street);
                        System.out.println();
                        // Loop until the street stack is empty
                        while (!street.isEmpty()) {
                            // remove car from top of the street stack and push to the driveway stack
                            currentCar = street.remove();
                            driveway.push(currentCar);
                        }
                    }
                }
            }
            // Display cars in driveway stack
            System.out.println("Current cars in driveway:");
            System.out.println(driveway);
            //System.out.println(street);
        }
    }
}
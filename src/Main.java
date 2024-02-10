import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayDeque<Integer> driveway = new ArrayDeque<>();
        ArrayDeque<Integer> street = new ArrayDeque<>();

        /*
        driveway.push(1);
        driveway.push(2);
        int x = driveway.remove();
        System.out.println(x);
        */

        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer to represent a car to add to the driveway");
        System.out.println("Enter a negative integer to remove a car of the positive");
        System.out.println("Enter 0 to exit");

        boolean run = true;
        while (run)
        {
            int car = input.nextInt();
            if(car == 0) {run = false;}
            else if (car > 0) {
                driveway.push(car);
            } else {
                boolean remove = true;
                while (remove) {
                    int currentCar = driveway.remove();
                    street.push(currentCar);
                    if (Math.abs(car) == currentCar) {
                        remove = false;
                        street.remove();
                        System.out.println("Before returning cars back to driveway:");
                        System.out.println(driveway);
                        System.out.println(street);
                        System.out.println();
                        while (!street.isEmpty()) {
                            currentCar = street.remove();
                            driveway.push(currentCar);
                        }
                    }
                }
            }
            System.out.println("Current cars in driveway:");
            System.out.println(driveway);
            //System.out.println(street);

            //int[][] test = new int[10][10];
        }
    }
}
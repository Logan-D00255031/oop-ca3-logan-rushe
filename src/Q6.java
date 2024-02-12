import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        Queue<Block> blocks = new ArrayDeque<>();
        Scanner input = new Scanner(System.in);
        boolean run = true;
        while (run) {
            // Display stocks
            System.out.println("Current Shares (First - Last): " + blocks);
            System.out.println("Commands:\nBuy (int)amount (double)price\nSell (int)amount (double)price\nQuit");
            String choice = input.next();
            // If the command is "buy"
            if (choice.equalsIgnoreCase("buy")) {
                // Store variables
                int amount = input.nextInt();
                double price = input.nextDouble();
                // Add the new block to the queue
                blocks.add(new Block(amount, price));
                System.out.println();
            } // If the command is "sell"
            else if (choice.equalsIgnoreCase("sell")) {
                // Store variables
                int amount = input.nextInt();
                double price = input.nextDouble();
                double profit = 0;
                //System.out.println(blocks);
                // Look at the next block on the stack
                Block block = blocks.peek();
                // Loop until amount left to sell is 0 or the stack is empty
                while (amount > 0 && !blocks.isEmpty()) {
                    //System.out.println(block);
                    // Amount is the same as shares in current block
                    if (block.getShares() == amount) {
                        //System.out.println(1);
                        // Get total block cost
                        double total = block.getPrice() * block.getShares();
                        // Calculate profit
                        profit += (amount * price) - total;
                        // Set the amount to 0
                        amount = 0;
                        // Remove the next block on the stack
                        blocks.remove();
                    } // Amount is the less than shares in current block
                    else if (block.getShares() > amount) {
                        //System.out.println(2);
                        // Get the difference in shares
                        int diff = block.getShares() - amount;
                        // Get the cost of the shares that will be sold
                        double total = block.getPrice() * amount;
                        // Calculate profit
                        profit += (amount * price) - total;
                        // Set the amount to 0
                        amount = 0;
                        // Set the blocks shares to the difference
                        block.setShares(diff);
                    } // Amount is the greater than shares in current block
                    else {
                        //System.out.println(3);
                        // Get total block cost
                        double total = block.getPrice() * block.getShares();
                        // Calculate profit
                        profit += (block.getShares() * price) - total;
                        // Remove the next block on the stack
                        blocks.remove();
                        // Remove the amount of shares in the block from the amount
                        amount -= block.getShares();
                        // Look at the next block on the stack
                        block = blocks.peek();
                    }
                    //System.out.println(amount);
                }
                // Display the profit
                System.out.printf("Profit: %.2f\n\n", profit);
            } // If the command is "quit"
            else if (choice.equalsIgnoreCase("quit")) {
                System.out.println("\nGoodbye.");
                // End run loop
                run = false;
            }
        }
    }
}

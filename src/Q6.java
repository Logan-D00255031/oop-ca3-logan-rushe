import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        Deque<Block> blocks = new ArrayDeque<>();
        Scanner input = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("Current Shares (First - Last): " + blocks);
            System.out.println("Commands:\nBuy (int)amount (double)price\nSell (int)amount (double)price\nQuit");
            String choice = input.next();
            if (choice.equalsIgnoreCase("buy")) {
                int amount = input.nextInt();
                double price = input.nextDouble();
                blocks.add(new Block(amount, price));
                System.out.println();
            } else if (choice.equalsIgnoreCase("sell")) {
                int amount = input.nextInt();
                double price = input.nextDouble();
                double profit = 0;
                //System.out.println(blocks);
                Block block = blocks.peek();
                while (amount > 0 && !blocks.isEmpty()) {
                    //System.out.println(block);
                    // Amount is the same as shares in current block
                    if (block.getShares() == amount) {
                        //System.out.println(1);
                        double total = block.getPrice() * block.getShares();
                        profit += (amount * price) - total;
                        amount = 0;
                        blocks.remove();
                    } // Amount is the less than shares in current block
                    else if (block.getShares() > amount) {
                        //System.out.println(2);
                        int diff = block.getShares() - amount;
                        double total = block.getPrice() * amount;
                        profit += (amount * price) - total;
                        amount = 0;
                        block.setShares(diff);
                    } // Amount is the greater than shares in current block
                    else {
                        //System.out.println(3);
                        double total = block.getPrice() * block.getShares();
                        profit += (block.getShares() * price) - total;
                        blocks.remove();
                        amount -= block.getShares();
                        block = blocks.peek();
                    }
                    //System.out.println(amount);
                }
                System.out.printf("Profit: %.2f\n\n", profit);
            } else if (choice.equalsIgnoreCase("quit")) {
                System.out.println("\nGoodbye.");
                run = false;
            }
        }
    }
}

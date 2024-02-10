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
            System.out.println("1: Buy\n2: Sell");
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> {
                    blocks.add(buy());
                    System.out.println();
                }
                case 2 -> sell(blocks);
                default -> {
                    System.out.println("\nGoodbye.");
                    run = false;
                }
            }
        }
    }

    static Block buy() {
        Scanner input = new Scanner(System.in);
        System.out.println("How many?");
        int amount = input.nextInt();
        System.out.println("Buy price?");
        int price = input.nextInt();
        return new Block(amount, price);
    }

    static void sell(Deque blocks) {
        Scanner input = new Scanner(System.in);
        int profit = 0;
        System.out.println("How many?");
        int amount = input.nextInt();
        System.out.println("Sell price?");
        int price = input.nextInt();
        //System.out.println(blocks);
        Block block = (Block) blocks.peek();
        while (amount > 0 && !blocks.isEmpty()) {
            //System.out.println(block);
            if (block.getShares() == amount) {
                //System.out.println(1);
                int total = block.getPrice() * block.getShares();
                profit += (amount * price) - total;
                amount = 0;
                blocks.remove();
            } else if (block.getShares() > amount) {
                //System.out.println(2);
                int diff = block.getShares() - amount;
                int total = block.getPrice() * amount;
                profit += (amount * price) - total;
                amount = 0;
                block.setShares(diff);
            } else {
                //System.out.println(3);
                int total = block.getPrice() * block.getShares();
                profit += (block.getShares() * price) - total;
                blocks.remove();
                amount -= block.getShares();
                block = (Block) blocks.peek();
            }
            //System.out.println(amount);
        }
        System.out.println("Profit: " + profit);
        System.out.println();
    }
}

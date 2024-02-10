import java.util.*;

public class Q7 {
    public static void main(String[] args) {
        Map<String, Queue<Block>> queueMap = new HashMap<>();
        Scanner input = new Scanner(System.in);
        boolean run = true;
        while (run) {
            for (Map.Entry<String, Queue<Block>> company : queueMap.entrySet()) {
                System.out.println("Company: " + company.getKey());
                System.out.println("Current Shares (First - Last): " + company.getValue());
            }
            System.out.println("Commands:\nBuy (String)symbol (int)amount (double)price\nSell (String)symbol (int)amount (double)price\nQuit");
            String choice = input.next();
            if (choice.equalsIgnoreCase("buy")) {
                String company = input.next();
                int amount = input.nextInt();
                double price = input.nextDouble();
                if (queueMap.containsKey(company)) {
                    queueMap.get(company).add(new Block(amount, price));
                } else {
                    queueMap.put(company, new ArrayDeque<>());
                    queueMap.get(company).add(new Block(amount, price));
                    System.out.println(queueMap.get(company));
                }
                System.out.println();
            } else if (choice.equalsIgnoreCase("sell")) {
                String company = input.next();
                int amount = input.nextInt();
                double price = input.nextDouble();
                double profit = 0;
                if (queueMap.containsKey(company)) {
                    Queue<Block> blocks = queueMap.get(company);
                    Block block = blocks.peek();
                    while (amount > 0 && !blocks.isEmpty()) {
                        //System.out.println(blocks);
                        //System.out.println(block);
                        // Amount is the same as shares in current block
                        if (block.getShares() == amount) {
                            System.out.println(1);
                            double total = block.getPrice() * block.getShares();
                            profit += (amount * price) - total;
                            amount = 0;
                            blocks.remove();
                        } // Amount is the less than shares in current block
                        else if (block.getShares() > amount) {
                            System.out.println(2);
                            int diff = block.getShares() - amount;
                            double total = block.getPrice() * amount;
                            profit += (amount * price) - total;
                            amount = 0;
                            block.setShares(diff);
                        } // Amount is the greater than shares in current block
                        else {
                            System.out.println(3);
                            double total = block.getPrice() * block.getShares();
                            profit += (block.getShares() * price) - total;
                            blocks.remove();
                            amount -= block.getShares();
                            block = blocks.peek();
                        }
                        //System.out.println(amount);
                    }
                    System.out.printf("Profit: %.2f\n\n", profit);
                } else {
                    System.out.println("ERROR: No company found under that name.");
                }
            } else if (choice.equalsIgnoreCase("quit")) {
                System.out.println("\nGoodbye.");
                run = false;
            }
        }
    }
}

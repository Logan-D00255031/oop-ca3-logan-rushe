import java.util.Objects;

public class Block {
    private int shares;
    private final double price;

    public Block(int shares, double price) {
        this.shares = shares;
        this.price = price;
    }

    public int getShares() {
        return shares;
    }

    public double getPrice() {
        return price;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return shares == block.shares && price == block.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shares, price);
    }

    @Override
    public String toString() {
        return "Block{" +
                "shares = " + shares +
                ", price = " + price +
                '}';
    }
}

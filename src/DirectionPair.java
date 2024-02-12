import java.util.Objects;

public class DirectionPair extends Pair {
    private DIRECTION direction;

    public DirectionPair(int x, int y, DIRECTION direction) {
        super(x, y);
        this.direction = direction;
    }

    public DirectionPair(int x, int y) {
        super(x, y);
        this.direction = null;
    }

    public DIRECTION getDirection() {
        return direction;
    }

    public void setDirection(DIRECTION direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "DirectionPair{" + super.toString() +
                ", direction=" + direction +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DirectionPair that = (DirectionPair) o;
        return super.getX() == that.getX() && super.getY() == that.getY() && direction == that.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), super.getX(), super.getY(), direction);
    }
}

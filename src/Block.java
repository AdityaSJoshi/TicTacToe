import java.util.Objects;

public class Block {

    private Location location;
    private Side side;

    public Block (Location location, Side side) {
        this.location = location;
        this.side = side;
    }

    public Location getLocation () {
        return location;
    }

    public void setLocation (Location location) {
        this.location = location;
    }

    public Side getSide () {
        return side;
    }

    public void setSide (Side side) {
        this.side = side;
    }

    public void display() {
        System.out.print(side.getSide());
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return Objects.equals(location, block.location) &&
                side == block.side;
    }

    @Override
    public int hashCode () {

        return Objects.hash(location, side);
    }
}

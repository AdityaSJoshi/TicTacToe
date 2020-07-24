public abstract class Player {

    private Side side;

    public Side getSide () {
        return side;
    }

    public void setSide (Side side) {
        this.side = side;
    }

    abstract Block getMove (final Board board);
}

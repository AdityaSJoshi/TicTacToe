
//AI player which just returns 1st empty block as it's move
public class AIPlayer extends Player {

    public AIPlayer (Side side) {
        this.setSide(side);
    }

    @Override
    Block getMove (final Board board) {
        Block block = board.getEmptyBlocks().get(0);
        return new Block(block.getLocation(), this.getSide());
    }
}

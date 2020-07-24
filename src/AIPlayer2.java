import java.util.List;
import java.util.Random;

//AI Player which picks one of the empty boxes randomly
public class AIPlayer2 extends Player {
    private static Random random = new Random();

    public AIPlayer2 (Side side) {
        setSide(side);
    }

    @Override
    Block getMove (Board board) {
        List<Block> emptyBlocks = board.getEmptyBlocks();
        Block block = emptyBlocks.get(random.nextInt(emptyBlocks.size()));

        return new Block(block.getLocation(), getSide());
    }
}

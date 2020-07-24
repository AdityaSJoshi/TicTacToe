import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Board {

    private Block[][] blocks;
    private List<Block> emptyBlocks;

    public Board () {
        blocks = new Block[3][3];
        emptyBlocks = new ArrayList<>();

        for(int row =0; row<3; row++) {
            for(int col =0; col<3; col++) {
                Block block = new Block(new Location(row+1, col+1), Side.UNASSIGNED);
                blocks[row][col] = block;
                emptyBlocks.add(block);
            }
        }
    }

    public Block[][] getBlocks () {
        return blocks;
    }

    public List<Block> getEmptyBlocks() {
        return emptyBlocks;
    }

    public Side getSide(Location location) {
        return getBlock(location).getSide();
    }

    public void addMove(Block block) {
        Location location = block.getLocation();
        emptyBlocks.remove(new Block(location, Side.UNASSIGNED));

        getBlock(location).setSide(block.getSide());
    }

    public void display() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col< 3; col++) {
                blocks[row][col].display();
            }
            System.out.println();
        }
    }

    private Block getBlock(Location location) {
        return blocks[location.getRow()-1][location.getColumn()-1];
    }

}

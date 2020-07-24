import java.util.ArrayList;
import java.util.List;
//sort of wrapper class which persists moves in a db
public class MoveSaver {

    private List<Block> moves;

    public MoveSaver () {
        this.moves = new ArrayList<>();
    }

    public void saveMove(Block block) {
        moves.add(block);
    }

    public List<Block> getMoves() {
        return moves;
    }

    public Block getLastMove() {
        if(moves.size()> 0){
            return moves.get(moves.size()-1);
        }
        return null;
    }

}

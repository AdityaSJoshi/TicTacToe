public class MoveValidator {

    public boolean isValidMove(Board board, Block block) {
        return isValidLocation(block.getLocation()) && board.getSide(block.getLocation()) == Side.UNASSIGNED;
    }

    public boolean isValidLocation(Location location) {
        int row = location.getRow();
        int column = location.getColumn();

        if(row < 0 || row > 3 || column < 0 || column > 3) {
            return false;
        }
        return true;
    }
}

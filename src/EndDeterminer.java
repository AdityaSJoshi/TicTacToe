public class EndDeterminer {

    public boolean isGameOver(Board board, Block lastBlock) {
        return getWinnerSide(board, lastBlock) != Side.UNASSIGNED || board.getEmptyBlocks().size() == 0;
    }

    public Side getWinnerSide(Board board, Block lastBlock) {
        Side winnerSide = Side.UNASSIGNED;
        if( lastBlock != null && (isRowComplete(board, lastBlock) || isColumnComplete(board, lastBlock) || isDiagonalComplete(board, lastBlock))) {
            winnerSide = lastBlock.getSide();
        }
        return winnerSide;
    }

    private boolean isRowComplete(Board board, Block lastBlock) {
        int row = lastBlock.getLocation().getRow();

        Side rowBlock0 = board.getSide(new Location(row, 1));
        Side rowBlock1 = board.getSide(new Location(row, 2));
        Side rowBlock2 = board.getSide(new Location(row, 3));

        return rowBlock0.equals(rowBlock1) && rowBlock0.equals(rowBlock2);
    }

    private boolean isColumnComplete(Board board, Block lastBlock) {
        int column = lastBlock.getLocation().getColumn();

        Side columnBlock0 = board.getSide(new Location(1, column));
        Side columnBlock1 = board.getSide(new Location(2, column));
        Side columnBlock2 = board.getSide(new Location(3, column));

        return columnBlock0.equals(columnBlock1) && columnBlock0.equals(columnBlock2);
    }

    private boolean isDiagonalComplete(Board board, Block lastBlock) {
        Location location1 = lastBlock.getLocation();
        if (location1.getRow()+location1.getColumn()==4) {
            Side upColumn0 = board.getSide(new Location(3,1));
            Side upColumn1 = board.getSide(new Location(2,2));
            Side upColumn2 = board.getSide(new Location(1,3));

            if (upColumn0.equals(upColumn1) && upColumn0.equals(upColumn2)){
                return true;
            }
        }
        if (location1.getRow() == location1.getColumn()) {
            Side downColumn0 = board.getSide(new Location(1,1));
            Side downColumn1 = board.getSide(new Location(2,2));
            Side downColumn2 = board.getSide(new Location(3,3));

            if (downColumn0.equals(downColumn1) && downColumn0.equals(downColumn2)) {
                return true;
            }
        }
        return false;
    }
}

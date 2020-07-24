import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private MoveSaver moveSaver;
    private TurnCoordinator turnCoordinator;
    private MoveValidator moveValidator;
    private EndDeterminer endDeterminer;

    public Game (Board board, List<Player> players, MoveSaver moveSaver, TurnCoordinator turnCoordinator, MoveValidator moveValidator, EndDeterminer endDeterminer) {
        this.board = board;
        this.players = players;
        this.moveSaver = moveSaver;
        this.turnCoordinator = turnCoordinator;
        this.moveValidator = moveValidator;
        this.endDeterminer = endDeterminer;
    }

    public Game (List<Player> players, MoveSaver moveSaver) {
        board = new Board();
        this.players = players;
        this.moveSaver = moveSaver;
        turnCoordinator = new TurnCoordinator(this.players);
        moveValidator = new MoveValidator();
        endDeterminer = new EndDeterminer();
    }

    public void play() {
        board.display();
        while (!endDeterminer.isGameOver(board, moveSaver.getLastMove())) {
            Player currentPlayer = turnCoordinator.getCurrentPlayer();
            Block move = currentPlayer.getMove(board);
            while (!moveValidator.isValidMove(board,move)) {
                move = currentPlayer.getMove(board);
            }
            board.addMove(move);
            moveSaver.saveMove(move);
            turnCoordinator.changeTurn();
            board.display();
        }
    }

    public Side getWinnerSide() {
        return endDeterminer.getWinnerSide(board, moveSaver.getLastMove());
    }

    public Player getWinner() {
        Side winnerSide = endDeterminer.getWinnerSide(board, moveSaver.getLastMove());
        if (winnerSide == Side.UNASSIGNED)  {
            return null;
        }
        else {
            for(Player player: players) {
                if( player.getSide() == winnerSide) {
                    return player;
                }
            }
            return null;
        }
    }

}

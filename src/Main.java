import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Board board = new Board();

        Player humanPlayer = new HumanPlayer(Side.UNASSIGNED);
        Player aiPlayer = new AIPlayer2(Side.UNASSIGNED);
        List<Player> players = new ArrayList<>(); players.add(humanPlayer); players.add(aiPlayer);

        SideAllocator sideAllocator = new SideAllocator();
        sideAllocator.allocateSides(players);

        MoveSaver moveSaver = new MoveSaver();
        TurnCoordinator turnCoordinator = new TurnCoordinator(players, 0);
        MoveValidator moveValidator = new MoveValidator();
        EndDeterminer endDeterminer = new EndDeterminer();

        Game game = new Game(board, players, moveSaver, turnCoordinator, moveValidator, endDeterminer);

        game.play();
        System.out.println("Winner is "+ game.getWinnerSide().getSide());

    }
}

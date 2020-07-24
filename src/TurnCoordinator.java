import java.util.List;

public class TurnCoordinator {

    private List<Player> players;

    private int currentPlayerIndex;

    public TurnCoordinator (List<Player> players, int currentPlayerIndex) {
        this.players = players;
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public TurnCoordinator (List<Player> players) {
        this(players, 0);
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public void changeTurn () {
        currentPlayerIndex = (currentPlayerIndex+1) % players.size();
    }
}

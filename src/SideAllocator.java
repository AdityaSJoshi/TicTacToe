import java.util.List;
import java.util.Random;

public class SideAllocator {

    private static Random random = new Random();

    public void allocateSides (List<Player> players) {
        int firstPlayerIndex = random.nextInt(players.size());  //either 0 or 1
        int secondPlayerIndex = 1 - firstPlayerIndex;
        players.get(firstPlayerIndex).setSide(Side.CROSS);
        players.get(secondPlayerIndex).setSide(Side.OVAL);
    }
}

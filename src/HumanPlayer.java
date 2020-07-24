import java.util.Scanner;

public class HumanPlayer extends Player  {

    private Scanner scanner;

    public HumanPlayer (Side side) {
        scanner = new Scanner(System.in);
        setSide(side);
    }

    @Override
    Block getMove (final Board board) {
        System.out.println("Please enter row number from 1 to 3");
        int row = scanner.nextInt();
        System.out.println("Please enter column number from 1 to 3");
        int column = scanner.nextInt();

        return new Block(new Location(row, column), getSide());
    }
}

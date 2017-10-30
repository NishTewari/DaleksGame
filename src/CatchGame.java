
import java.awt.Color;

/**
 * This class manages the interactions between the different pieces of the game:
 * the Board, the Daleks, and the Doctor. It determines when the game is over
 * and whether the Doctor won or lost.
 */
public class CatchGame {

    /**
     * Instance variables go up here Make sure to create a Board, 3 Daleks, and
     * a Doctor
     */
    Board b = new Board(12, 12);
    Doctor D = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));
    Dalek b1 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
    Dalek b2 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
    Dalek b3 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));

    /**
     * The constructor for the game. Use it to initialize your game variables.
     * (create people, set positions, etc.)
     */
    public CatchGame() {
        //Doctor    
        b.putPeg(Color.GREEN, D.getRow(), D.getCol());

        //Daleks
        b.putPeg(Color.BLACK, b1.getRow(), b1.getCol());
        b.putPeg(Color.BLACK, b2.getRow(), b2.getCol());
        b.putPeg(Color.BLACK, b3.getRow(), b3.getCol());
    }

    /**
     * The playGame method begins and controls a game: deals with when the user
     * selects a square, when the Daleks move, when the game is won/lost.
     */
    public void playGame() {
        //Keep playing until the doctor gets capture 
        //or the daleks have crashed 
        while (true) {

            //Click 
            Coordinate click = b.getClick();
            int clickRow = click.getRow();
            int clickCol = click.getCol();

            //Move Doctor According to the click 
            b.removePeg(D.getRow(), D.getCol());
            D.move(clickRow, clickCol);
            b.putPeg(Color.GREEN, D.getRow(), D.getCol());

            //Remove the Pegs of the Daleks from current position 
            b.removePeg(b1.getRow(), b1.getCol());
            b.removePeg(b2.getRow(), b2.getCol());
            b.removePeg(b3.getRow(), b3.getCol());

            //Have the Daleks move towards the doctor only if they have not crashed
            b1.advanceTowards(D);
            b2.advanceTowards(D);
            b3.advanceTowards(D);

            //Put a Peg for the daleks of their New Position
            b.putPeg(Color.BLACK, b1.getRow(), b1.getCol());
            b.putPeg(Color.BLACK, b2.getRow(), b2.getCol());
            b.putPeg(Color.BLACK, b3.getRow(), b3.getCol());

            //CHECK IF DALEKS HAVE CRASHED
            //Check crash with b1 and b2, Put Red peg if they crash
            if (b1.crash(b2)) {
                b.putPeg(Color.RED, b1.getRow(), b1.getCol());
            }
            //Check crash with b1 and b3, Put Red peg if they crash
            if (b1.crash(b3)) {
                b.putPeg(Color.RED, b1.getRow(), b1.getCol());

            }
            //Check crash with b2 and b3, Put Red peg if they crash
            if (b2.crash(b3)) {
                b.putPeg(Color.RED, b3.getRow(), b3.getCol());

            }

            //If all the daleks have crashed, you WIN
            if (b1.crash(b2) && b1.crash(b3) && b2.crash(b3)) {
                b.displayMessage("You WIN!");
                break;
            }

            //If the Doctor is Captured then Game Over!, you LOSE
            if (D.capture(b1) || D.capture(b2) || D.capture(b3)) {
                b.displayMessage(" YOU LOST!");
                break;
            }

        }
    }
}

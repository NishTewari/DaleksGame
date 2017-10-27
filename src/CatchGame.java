
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
        Doctor doc = new Doctor(D.getRow(), D.getCol());

        //Keep playing until the doctor gets capture 
        //or the daleks have crashed 
        while (D.isCaptured() == false || (b1.hasCrashed() == false && b2.hasCrashed() == false
                && b3.hasCrashed() == false)) {

            //Click 
            Coordinate click = b.getClick();
            int clickRow = click.getRow();
            int clickCol = click.getCol();

            //If the Doctor is Captured then Game Over!, you lose
            if (D.isCaptured() == true) {
                b.displayMessage(" YOU LOST!");
                break;
            }
            //If all the daleks have crashed, you win
            if (b1.hasCrashed() == true && b2.hasCrashed() == true
                    && b3.hasCrashed() == true) {
                b.displayMessage(" You Win!");
            }

            if (click.getRow() == D.getRow() - 1) {
                doc.move(D.getRow() + 1, D.getCol());

            }
        }

    }

}


import java.awt.Color;


/** This class manages the interactions between the different pieces of
 *  the game: the Board, the Daleks, and the Doctor. It determines when
 *  the game is over and whether the Doctor won or lost.
 */
public class CatchGame {

    /**
     * Instance variables go up here
     * Make sure to create a Board, 3 Daleks, and a Doctor
     */
    Board b = new Board(12,12);
    Doctor D = new Doctor(4,9);
    Dalek b1 = new Dalek(8,0);
    Dalek b2 = new Dalek(5,7);
    Dalek b3 = new Dalek(2,9);
    

    /**
     * The constructor for the game. 
     * Use it to initialize your game variables.
     * (create people, set positions, etc.)
     */
    public CatchGame(){
    //Doctor    
    b.putPeg(Color.GREEN,4,9);
    
    //Daleks
    b.putPeg(Color.BLACK, 8, 0);
    b.putPeg(Color.BLACK, 5, 7);
    b.putPeg(Color.BLACK, 2, 9);
    }
    
    /**
     * The playGame method begins and controls a game: deals with when the user
     * selects a square, when the Daleks move, when the game is won/lost.
     */
    public void playGame() {
        //Keep playing until the doctor gets capture 
        //or the daleks have crashed 
    while(true){
        
        
    }
    }

}

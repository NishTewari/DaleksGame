
/** This class creates a game and starts the game play.
 */
public class MainGame {
  
    
    
    public static void main(String args[]) {
        Board b = new Board(12,12);
        Doctor D = new Doctor(9,1); 
        CatchGame game = new CatchGame();
        game.playGame();
    }

}

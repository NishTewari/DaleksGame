
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tewan2657
 */
public class BoardExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board b = new Board(12, 12);
        b.putPeg(Color.GRAY, 3, 5);
        b.putPeg(Color.CYAN, 1, 2);

        //Remove a Peg
        b.removePeg(3, 5);

        //Message
        b.displayMessage("Hello Everyone");
        
        while (true){   
        //receive a click from the user 
        Coordinate click = b.getClick();
        int clickRow = click.getRow();
        int clickCol = click.getCol();
        //Put a peg at the click
        
            b.putPeg(Color.BLACK, clickRow, clickCol);
        }
    }
}


/**
 * This class models the Doctor in the game. A Doctor has a position and can
 * move to a new position.
 */
public class Doctor {

    //Instance  Variables
    private int row, col;
    private boolean isCaptured;

    /**
     * Initializes the variables for a Doctor.
     *
     * @param theRow The row this Doctor starts at.
     * @param theCol The column this Doctor starts at.
     */
    public Doctor(int theRow, int theCol) {
        this.row = theRow;
        this.col = theCol;

    }

    /**
     * Move the Doctor. If the player clicks on one of the squares immediately
     * surrounding the Doctor, the peg is moved to that location. Clicking on
     * the Doctor does not move the peg, but instead allows the Doctor to wait
     * in place for a turn. Clicking on any other square causes the Doctor to
     * teleport to a random square (perhaps by using a �sonic screwdriver�).
     * Teleportation is completely random.
     *
     * @param newRow The row the player clicked on.
     * @param newCol The column the player clicked on.
     */
    public void move(int newRow, int newCol) {
        //VERTICAL MOVEMENT 
        //Move Downwards  
        if (newRow == this.row + 1) {
            this.row++;

            //Move Upwards
        } else if (newRow == this.row - 1) {
            this.row--;

        }
        //HORIZONTAL MOVEMENT 
        //Move towards the right    
        if (newCol == this.col + 1) {
            this.col++;

            //Move towards the left 
        } else if (newCol == this.col - 1) {
            this.col--;
        }

        //TELEPORTATION
        if (newRow > this.row + 1 || newRow < this.row - 1 || newCol > this.col + 1 || newCol < this.col - 1) {
            this.row = (int) (Math.random() * 12);
            this.col = (int) (Math.random() * 12);
        }


    }

    /**
     * Returns the row of this Doctor.
     *
     * @return This Doctor's row.
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Returns the column of this Doctor.
     *
     * @return This Doctor's column.
     */
    public int getCol() {
        return this.col;

    }

    /**
     *
     * @param a the dalek used to check if doctor is at the same location as
     * dalek
     * @return true is doctor is captured, otherwise its false
     */
    public boolean capture(Dalek a) {
        if (this.row == a.getRow() && this.col == a.getCol()) {
            return isCaptured = true;
        } else {
           return isCaptured = false;
        }
    }

    /**
     * Returns Whether or not the Doctor has been Captured
     *
     * @return True if Doctor has been captured, False otherwise
     */
    public boolean isCaptured() {
        return isCaptured;
    }
}

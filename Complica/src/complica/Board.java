/*
 * Board.java
 */

package complica;

/**
 *Creates a board array to store game information
 * @author davidpeterson
 */
public class Board {
    static final int x = 4;
    static final int y = 7;
    private int[][] gameBoard = new int[x][y];

    /**
     * default constructor
     */
    public Board(){
        initGameBoard();
    }

    /**
     * method to add coordinate to array
     * @param xCoord column of array
     * @param yCoord row of array
     * @param value value to place in array
     */
    public void setCoord(int xCoord, int yCoord, int value){
        gameBoard[x][y] = value;
    }

    /**
     * method to get value from array coordinates
     * @param xCoord column position
     * @param yCoord row position
     * @return the value in the array at those coordinates
     */
    public int getCoord(int xCoord, int yCoord){
       return gameBoard[xCoord][yCoord];
    }

    //initialize the board, set all values of array to 0
    private void initGameBoard() {
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
               gameBoard[i][j] = 0;
            }
        }
    }
    /**
     * add a piece into the board array at specified column
     * @param p the player/value to add
     * @param col the column to be added
     * @return returns -1 if the column must wrap
     */
    public int addPiece(int p, int col){
        for(int i = 6; i >= 0; i--){
            if(gameBoard[col][i] == 0){
                gameBoard[col][i] = p;
                return i;
            }
        }
        for(int i = 6; i > 0; i--){
            int j = i-1;
            int temp = gameBoard[col][j];
            gameBoard[col][i] = temp;
        }
        gameBoard[col][0] = p;
        return -1;
    }

    /**
     * clears array, resets to 0
     */
    public void resetBoardArray(){
        for(int i = 0; i<7;i++){
            for(int j = 0; j<4; j++){
                gameBoard[j][i]= 0;
            }
        }

    }

    /**
     * determines if there is a winner, makes sure there are not two winners...
     * @return t/f if there is a winner
     */
    public int checkWinner(){
        final int p1Win = 1;
        final int p2Win = 2;
        final int tie = 0;
        final int noWinner = -1;
        boolean p1Four = false;
        boolean p2Four = false;


        for(int i = 0; i<7;i++){
            for(int j = 0; j<4; j++){
                System.out.print(gameBoard[j][i]);
            }
            System.out.println();
        }
        System.out.println();

        p1Four = checkFour(1);
        p2Four = checkFour(2);

        if((p1Four==true)&&(p2Four==true)){
            return tie;
        }
        else if((p1Four==false)&&(p2Four==true)){
            return p2Win;
        }
        else if((p1Four==true)&&(p2Four==false)){
            return p1Win;
        }
        else{
            return noWinner;
        }
    }

    //determines if a player has four pieces in a row
    private boolean checkFour(int p){
        boolean hasFour = false;
        for(int i = 0; i<4; i++){
            for(int j = 0; j<7; j++){
                //check vertical
                if(j+3<7){
                     if((gameBoard[i][j]==p) && (gameBoard[i][j+1]==p) &&
                        (gameBoard[i][j+2]==p) && (gameBoard[i][j+3]==p)){
                         hasFour = true;
                         return hasFour;
                    }
                }
                //check horizontal
                if(i+3<4){
                     if((gameBoard[i][j]==p) && (gameBoard[i+1][j]==p) &&
                        (gameBoard[i+2][j]==p) && (gameBoard[i+3][j]==p)){
                         hasFour = true;
                         return hasFour;
                    }
                }
                //check down diagonal
                if(i==0 && j+3<7){
                     if((gameBoard[i][j]==p) && (gameBoard[i+1][j+1]==p) &&
                        (gameBoard[i+2][j+2]==p)&&(gameBoard[i+3][j+3]==p)){
                         hasFour = true;
                         return hasFour;
                    }
                }
                //check up diagonal
                if(i==0 && j-3>=0){
                     if((gameBoard[i][j]==p) && (gameBoard[i+1][j-1]==p) &&
                        (gameBoard[i+2][j-2]==p)&&(gameBoard[i+3][j-3]==p)){
                         hasFour = true;
                         return hasFour;
                    }
                }
            }        
        }

        return false;
    }

    /**
     * converts the board to a string. For debugging...
     * @return the string representation of the board
     */
    @Override
    public String toString(){
        String string = "";
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
               string += gameBoard[i][j];
            }
            string += " | ";
        }
        return string;
    }
}

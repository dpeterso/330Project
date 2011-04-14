/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package complica;

/**
 *
 * @author davidpeterson
 */
public class Board {
    static final int x = 4;
    static final int y = 7;
    private int[][] gameBoard = new int[x][y];

    public Board(){
        initGameBoard();
    }

    public void setCoord(int xCoord, int yCoord, int value){
        gameBoard[x][y] = value;
    }

    public int getCoord(int xCoord, int yCoord){
       return gameBoard[xCoord][yCoord];
    }

    private void initGameBoard() {
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
               gameBoard[i][j] = 0;
            }
        }
    }
    public int addPiece(int p, int col){
        for(int i = 6; i >= 0; i--){
            if(gameBoard[col][i] == 0){
                gameBoard[col][i] = p;
                return i;
            }
        }

        return -1;
    }

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

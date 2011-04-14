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
        for(int i = 6; i > 0; i--){
            int j = i-1;
            int temp = gameBoard[col][j];
            gameBoard[col][i] = temp;
        }
        gameBoard[col][0] = p;
        return -1;
    }

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

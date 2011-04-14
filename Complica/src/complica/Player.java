/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package complica;

import java.util.*;

/**
 *
 * @author Jack
 */
public class Player {
    
    public Player(){
        name= "";
        hasWon = false;
        wins = 0;
        losses = 0;
        turnDone = false;
    }

    public Player(String pName){
        name= pName;
        hasWon = false;
        wins = 0;
        losses = 0;
        turnDone = false;
    }

    public Player(String pName, boolean pHasWon, int pWins, int pLosses,
            boolean pTurnDone) {
        name = pName;
        hasWon = pHasWon;
        wins = pWins;
        losses = pLosses;
        turnDone = pTurnDone;
    }

    public void lose(){
        losses++;
    }

    public void win(){
        wins++;
    }
    
    public boolean isHasWon() {
        return hasWon;
    }

    public void setHasWon(boolean pHasWon) {
        hasWon = pHasWon;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int pLosses) {
        losses = pLosses;
    }

    public String getName() {
        return name;
    }

    public void setName(String pName) {
        name = pName;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int pWins) {
        wins = pWins;
    }

    public boolean isTurnDone() {
        return turnDone;
    }

    public void setTurnDone(boolean pTurnDone) {
        turnDone = pTurnDone;
    }



    @Override
    public String toString() {
        return "Player{" + "/n name= " + name + "/n hasWon =" + hasWon
                + "/n wins= " + wins + "/n losses= " + losses + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if ((this.name == null) ? (other.name != null) :
            !this.name.equals(other.name)) {
            return false;
        }
        if (this.hasWon != other.hasWon) {
            return false;
        }
        if (this.wins != other.wins) {
            return false;
        }
        if (this.losses != other.losses) {
            return false;
        }
        return true;
    }
    
    @Override
    public Player clone() {
        Player dup = new Player(name, hasWon, wins, losses, turnDone);
        return dup;
    }


    //returns "1" if player is greater than other
    //returns "0" if player equals other
    //returns "-1" if player is worse than other
    public int compareTo(Player other){
        final int BETTER = 1;
        final int EQUALS =0;
        final int WORSE = -1;

        if((wins - losses)>(other.getWins()-other.getLosses())){
            return BETTER;
        }
        else if((wins - losses)<(other.getWins()-other.getLosses())){
            return WORSE;
        }
        else{
            return EQUALS;
        }
    }

    private String name;
    private boolean hasWon;
    private int wins;
    private int losses;
    private boolean turnDone;
}

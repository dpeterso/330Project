/*
 * Player.java
 */

package complica;

/**
 * This class maintains player information such as player name, wins/losses
 * @author Jack
 */
public class Player {
    
    /**
     * default constructor, sets name to ""
     */
    public Player(){
        name= "";
        hasWon = false;
        wins = 0;
        losses = 0;
        turnDone = false;
    }

    /**
     * non-default constuctor, sets name to pName
     * @param pName the name to set
     */
    public Player(String pName){
        name= pName;
        hasWon = false;
        wins = 0;
        losses = 0;
        turnDone = false;
    }

    /**
     * non-default constructor, sets all variables.
     * @param pName player name to be set
     * @param pHasWon whether or not player has won
     * @param pWins player wins
     * @param pLosses player losses
     * @param pTurnDone turn done?
     */
    public Player(String pName, boolean pHasWon, int pWins, int pLosses,
            boolean pTurnDone) {
        name = pName;
        hasWon = pHasWon;
        wins = pWins;
        losses = pLosses;
        turnDone = pTurnDone;
    }

    /**
     * increments losses
     */
    public void lose(){
        losses++;
    }

    /**
     * increments wins
     */
    public void win(){
        wins++;
    }
    
    /**
     * getter for haswon?
     * @return hasWon
     */
    public boolean isHasWon() {
        return hasWon;
    }

    /**
     * setter for has won
     * @param pHasWon value to set
     */
    public void setHasWon(boolean pHasWon) {
        hasWon = pHasWon;
    }

    /**
     * getter for num losses
     * @return number of losses
     */
    public int getLosses() {
        return losses;
    }

    /**
     * setter for num losses
     * @param pLosses losses to set
     */
    public void setLosses(int pLosses) {
        losses = pLosses;
    }

    /**
     * getter for name
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * setter for name
     * @param pName the player name
     */
    public void setName(String pName) {
        name = pName;
    }

    /**
     * getter for wins
     * @return number of player wins
     */
    public int getWins() {
        return wins;
    }

    /**
     * setter for wins
     * @param pWins number of player wins
     */
    public void setWins(int pWins) {
        wins = pWins;
    }

    /**
     * getter for turnDone
     * @return is done true/false
     */
    public boolean isTurnDone() {
        return turnDone;
    }

    /**
     * setter for turn done
     * @param pTurnDone t/f value to set
     */
    public void setTurnDone(boolean pTurnDone) {
        turnDone = pTurnDone;
    }



    /**
     * to string method, converts player to string
     * @return string representation of player
     */
    @Override
    public String toString() {
        return "Player{" + "/n name= " + name + "/n hasWon =" + hasWon
                + "/n wins= " + wins + "/n losses= " + losses + '}';
    }

    /**
     * determines if one player equals another exactly
     * @param obj the player to compare
     * @return t/f depending on equality
     */
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
    
    /**
     * creates a copy of a player object
     * @return the newly created copy
     */
    @Override
    public Player clone() {
        Player dup = new Player(name, hasWon, wins, losses, turnDone);
        return dup;
    }


    //returns "1" if player is greater than other
    //returns "0" if player equals other
    //returns "-1" if player is worse than other
    /**
     * compares two player objects
     * @param other
     * @return 1 if greater than other, 0 if equals other, -1 if worse than othr
     */
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

    private String name; //player name
    private boolean hasWon; //hasWon t/f
    private int wins; //number of player wins
    private int losses; //number of player losses
    private boolean turnDone; // still players turn? t/f
}

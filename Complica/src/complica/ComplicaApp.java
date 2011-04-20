/*
 * ComplicaApp.java
 *
 * This program allows for two players to play the game of complica.  It
 * initiates a GUI of the board that allows the players to click on the row
 * they want to place a piece. A player wins when they are the only player with
 * 4 pieces in a row, either vertically or diagnoally.  This program keeps track
 * of wins and losses and  determines who goes first based on who has more
 * losses.
 */

package complica;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class ComplicaApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new ComplicaView(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of ComplicaApp
     */
    public static ComplicaApp getApplication() {
        return Application.getInstance(ComplicaApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(ComplicaApp.class, args);
    }
}

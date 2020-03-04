package ca.utoronto.utm.jugpuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Action Listener for Jug Puzzle GUI Controller, restart the game whenever the restart button is pressed upon.
 * 
 * @author csc207student
 *
 */
public class RestartActionListener implements ActionListener{

	/**
	 * Restart the game/Make a new frame, when the restart button is pressed upon.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JugPuzzleGUIController game = new JugPuzzleGUIController();
		game.main(null);
	}

}

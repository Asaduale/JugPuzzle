package ca.utoronto.utm.jugpuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Action Listener for Jug Puzzle GUI controller, applies to the quit button. Quit/Close the game when the quit button is 
 * pressed upon.
 * 
 * @author csc207student
 *
 */
public class QuitActionListener implements ActionListener{

	/**
	 * Quit the game when the quit buttons is pressed upon.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
		
	}
	
	

}

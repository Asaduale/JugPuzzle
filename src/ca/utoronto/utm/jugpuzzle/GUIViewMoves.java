package ca.utoronto.utm.jugpuzzle;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

/**
 * We extend JLabel as a view on a Jug Puzzle, observes and updates the amount of moves made.
 * @author csc207student
 *
 */

public class GUIViewMoves extends JLabel implements Observer {
	
	/**
	 * Observes and updates the amount of moves made.
	 */
	@Override
	public void update(Observable o, Object arg) {
		JugPuzzle jugs = (JugPuzzle)o;
		this.setText("Moves: " + jugs.getMoves() );	
	}
	
}

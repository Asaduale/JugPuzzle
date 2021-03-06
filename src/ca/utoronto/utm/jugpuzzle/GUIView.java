package ca.utoronto.utm.jugpuzzle;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;

/**
 * We extend JLabel as a view on a JugPuzzle
 * @author csc207student
 *
 */

public class GUIView extends JLabel implements Observer {
	
	@Override
	public void update(Observable o, Object arg) {
		JugPuzzle jug = (JugPuzzle)o;
		this.setText("Moves: " + jug.getMoves());
	}
	
}
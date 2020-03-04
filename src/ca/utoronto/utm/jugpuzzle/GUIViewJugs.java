package ca.utoronto.utm.jugpuzzle;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;

/**
 * We extend JLabel as a view on a JugPuzzle, observes and updates the amount inside of the jug.
 * 
 * @author csc207student
 *
 */

public class GUIViewJugs extends JLabel implements Observer {
	private int jugNumber;
	GUIViewJugs(int n){
		super();
		this.jugNumber = n;
	}
	
	/**
	 * Observes and updates the amount inside of the jug.
	 */
	@Override
	public void update(Observable o, Object arg) {
		JugPuzzle jug = (JugPuzzle)o;
		this.setText("" + jug.getJugAmount(this.jugNumber));
	}
	
}
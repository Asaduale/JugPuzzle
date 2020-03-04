package ca.utoronto.utm.jugpuzzle;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;

/**
 * We extend JLabel as a view on a JugPuzzle
 * @author csc207student
 *
 */

public class GUIViewTwo extends JLabel implements Observer {
	
	@Override
	public void update(Observable o, Object arg) {
		JugPuzzle jug = (JugPuzzle)o;
		this.setText(jug.getJugAmount(0) + "/8" + "          " + jug.getJugAmount(1) + "/5            " + jug.getJugAmount(2) + "/3");
	}
	
}
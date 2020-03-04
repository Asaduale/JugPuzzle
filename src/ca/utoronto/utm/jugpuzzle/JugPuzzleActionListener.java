package ca.utoronto.utm.jugpuzzle;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Interface with a single method, actionPerformed. Is notified of an event, a button click.
 * When a button is clicked this is the spill from and the next button is the spilled to.
 * Using the Jug Puzzle class, it will then make the move accordingly.
 *
 * @author csc207student
 *
 */
public class JugPuzzleActionListener implements ActionListener{
	
	private JugPuzzle model;
	private JButton jugFrom, jugTo;
	private JFrame frame = new JFrame("You win!!");
	
	
	/**
	 * Constructor for the action listener.
	 * @param model - Jug Puzzle
	 */
	public JugPuzzleActionListener(JugPuzzle model){
		this.model = model;
	}
	
	
	
	int gameState = 0;
	
	/**
	 * Whenever a button is clicked on the GUI the user can spill from and to according to the order of the buttons
	 * being clicked. When the game is solved, a prompt will halt the game, the user can either play again or quit.
	 * @param e - event object, button click.
	 */
	public void actionPerformed(ActionEvent e) {	
		// State check, if 0 then no button is clicked. Store this as the "from" button. Disable the button, makes the game
		// easier for the user to know what they clicked on.
		if (gameState == 0) {
			jugFrom = (JButton)e.getSource();
			jugFrom.setEnabled(false);
			gameState = 1;
		}
		// State check, if it's not zero then a button "from" was clicked, store the next click as the "to" and then make the move happen.
		// Re-enable both buttons.
		else {
			jugTo = (JButton)e.getSource();
			jugTo.setEnabled(false);
			model.move(Integer.parseInt(jugFrom.getActionCommand()), Integer.parseInt(jugTo.getActionCommand()));
			gameState = 0;
			jugFrom.setEnabled(true);
			jugTo.setEnabled(true);
		}
		// If the puzzle is solved, create a JOptionPane. The pane halts the game, asks the user if they want to
		// play again or quit. The pane also congratulates the user and displays the amount of moves it took them to solve the 
		// game.
		if (model.getIsPuzzleSolved()) {
			// Option Panel pop up, continue or quit.
		   int n = JOptionPane.showConfirmDialog(frame, ("Congrats you solved it in " + model.getMoves() + 
				   " moves!! Do you want to play a new game?" )
				    , null, JOptionPane.YES_NO_OPTION);
		   
		   if (n == JOptionPane.YES_OPTION) {
		          JugPuzzleGUIController game = new JugPuzzleGUIController();
		  		  game.main(null);
		          
		        }
		        else {
		           JOptionPane.showMessageDialog(null, "Thanks for playing!");
		           System.exit(0);
		        }
		}	
	}
}
		
				


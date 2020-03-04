package ca.utoronto.utm.jugpuzzle;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

/**
 * Jug Puzzle GUI ( Graphic User Interface ) allows the user to play off of the Jug Puzzle class.
 * The user can either click the buttons and play the Jug Puzzle game until they solved it or they can quit 
 * whenever they please. A restart option also exists whenever the user wants to play a new game. When the game
 * is completed the user can either play again or quit the game.
 * 
 * @author csc207student
 *
 */
public class JugPuzzleGUIController extends JPanel{
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
	
	/**
	 * Create and show the GUI.
	 */
		private static void createAndShowGUI() {
				// GUIView Moves
				GUIViewMoves guiViewMoves = new GUIViewMoves();
				
				// GUIView Jugs, center the jugs
				GUIViewJugs guiViewJug0 = new GUIViewJugs(0);
				guiViewJug0.setHorizontalAlignment(JLabel.CENTER);
				guiViewJug0.setVerticalAlignment(JLabel.CENTER);; 
			    
				GUIViewJugs guiViewJug1 = new GUIViewJugs(1); 
				guiViewJug1.setHorizontalAlignment(JLabel.CENTER);
				guiViewJug1.setVerticalAlignment(JLabel.CENTER);
			    
				GUIViewJugs guiViewJug2 = new GUIViewJugs(2); 
				guiViewJug2.setHorizontalAlignment(JLabel.CENTER);
				guiViewJug2.setVerticalAlignment(JLabel.CENTER);
			
				// Model
				JugPuzzle model = new JugPuzzle();

				// Hook the model to the view.
				model.addObserver(guiViewMoves);
				model.addObserver(guiViewJug0);
				model.addObserver(guiViewJug1);
				model.addObserver(guiViewJug2);
				
				// Create frame.
				JFrame frame = new JFrame("Jug Game!");
		
				// Close option.
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				// Create two panels, one for the moves and the other for the buttons.
				// Labels and buttons go on the grid panel and the moves and restart/quit buttons go on the other panel.
				JPanel movesAndButtons = new JPanel();
				JPanel grid = new JPanel();
				
				// A container.
				Container c = frame.getContentPane();
				
				// Layout for the grid.
				GridLayout topGrid = new GridLayout(2,3);
				grid.setLayout(topGrid);
				
				// Layout for the buttons and moves.
				movesAndButtons.setLayout(new BoxLayout(movesAndButtons, FlowLayout.CENTER));

				// Panels for buttons and moves.
				JPanel movesPanel = new JPanel(); // Moves panel, GUI View.
				JPanel quitRestartPanel = new JPanel(); // Quit and Restart panel.
	
				// Add panels to the layout.
				movesAndButtons.add(movesPanel, BorderLayout.SOUTH);
				movesAndButtons.add(quitRestartPanel, BorderLayout.NORTH);
				JButton restart, quit, eight, five, three;
			
			    // Initialize buttons,
				eight = new JButton("8");
			    five = new JButton("5");
			    three = new JButton("3");
			    restart = new JButton("Restart");
			    quit = new JButton("Quit");
			    
			    // Add to grid.
			    grid.add(guiViewJug0);
			    grid.add(guiViewJug1);
			    grid.add(guiViewJug2);
			    grid.add(eight);
			    grid.add(five);
			    grid.add(three);
				
				// Add to the panels.
			    movesPanel.add(guiViewMoves);
				quitRestartPanel.add(restart);
				quitRestartPanel.add(quit);
				
				// Add the container which adds to the frame.
				c.add(grid, BorderLayout.NORTH);
				c.add(movesAndButtons, BorderLayout.SOUTH);
				
				// ActionListeners 
				JugPuzzleActionListener e = new JugPuzzleActionListener(model);
				QuitActionListener end = new QuitActionListener();
				RestartActionListener fresh = new RestartActionListener();
				
				eight.addActionListener(e);
				eight.setActionCommand("0");
				
				five.addActionListener(e);
				five.setActionCommand("1");
				
				three.addActionListener(e);
				three.setActionCommand("2");
				
				restart.addActionListener(fresh);
				quit.addActionListener(end);
				
				// Pack and see frame
				frame.pack();
				frame.setSize(480, 150);
				frame.setResizable(false);
				frame.setVisible(true);	
			}
			}

	
	
	



	


/**
 * HomePage.java
 * Initial page for an object-oriented GUI
 * for playing Set.
 * 
 * Written for CSC-260 Project 2
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class HomePage extends JApplet {
	private static final long serialVersionUID = 1L;
	
	private final int APPLET_WIDTH = 700, APPLET_HEIGHT = 1000;
	private Drawing dwg;
	private Mode mode;
	
	/**
	 * Sets up the first two buttons, with which the user
	 * will choose a specific mode to play.
	 */
	public void init() {
		dwg = new Drawing();
		
		//Make JButton objects for the two modes of play
		JButton tutorialButton = new JButton("Tutorial");
		JButton solitaireButton = new JButton("Solitaire");
		
		//Add listeners to the two Modes subclass buttons
		tutorialButton.addActionListener(new TutorialButtonListener());
		solitaireButton.addActionListener(new SolitaireButtonListener());
		
		//The two buttons will be adjacent to one another, in one row of two
		JPanel modePanel = new JPanel(); //Holds the buttons horizontally
		JLabel setLabel = new JLabel("Choose Mode:");
		modePanel.setLayout(new FlowLayout());
		modePanel.add(setLabel);
		tutorialButton.setBackground(Color.green);
		solitaireButton.setBackground(Color.green);
		modePanel.add(tutorialButton);
		modePanel.add(solitaireButton);
		
		//Container objects enable control of the location of panels
		//contained within it.
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(modePanel, BorderLayout.CENTER);
		mode = null;
		setSize(APPLET_WIDTH, APPLET_HEIGHT);
	}
	
	private class TutorialButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton button = (JButton)event.getSource();
			JPanel panel = (JPanel)button.getParent();
			panel.remove(0);
			panel.remove(0);
			panel.repaint();
			panel.validate();
			Container cp = (Container)panel.getParent();
			cp.remove(0);
			cp.repaint();
			mode = new Tutorial(dwg, cp);
		}
	}
	
	private class SolitaireButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton button = (JButton)event.getSource();
			JPanel panel = (JPanel)button.getParent();
			panel.remove(0);
			panel.remove(0);
			panel.repaint();
			panel.validate();
			Container cp = (Container)panel.getParent();
			cp.remove(0);
			cp.repaint();
			mode = new Solitaire(dwg, cp);
		}
	}
}
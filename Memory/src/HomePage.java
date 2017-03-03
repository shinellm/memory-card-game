/**
 * HomePage.java
 * Initial page for an object-oriented GUI
 * for playing Set.
 * 
 * @author Rory Bennett
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class HomePage extends JApplet {
	private static final long serialVersionUID = 1L;
	
	private final int APPLET_WIDTH = 600, APPLET_HEIGHT = 600;
	private Drawing dwg;
	private Mode mode;
	private Container cp;
	private JPanel modePanel;
	private JLabel setLabel;

	
	/**
	 * Sets up the first two buttons, with which the user
	 * will choose a specific mode to play.
	 */
	public void init() {
		dwg = new Drawing();
		
		//Make JButton objects for the two modes of play
		JButton enterButton = new JButton("Enter");
		
		
		//Add listeners to the two Modes subclass buttons
		enterButton.addActionListener(new EnterButtonListener());
		
		
		//The two buttons will be adjacent to one another, in one row of two
		modePanel = new JPanel(); //Holds the buttons horizontally
		setLabel = new JLabel("Enter Name: ");
		modePanel.setLayout(new FlowLayout());
		modePanel.add(setLabel);
		enterButton.setBackground(Color.green);
		modePanel.add(enterButton);
		
		//Container objects enable control of the location of panels
		//contained within it.
		cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(modePanel, BorderLayout.CENTER);
		mode = null;
		setSize(APPLET_WIDTH, APPLET_HEIGHT);
		cp.repaint();
	}
	
	public void home(){
		cp.add(modePanel, BorderLayout.CENTER);
		cp.repaint();
		
		
	}
	
	private class EnterButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton button = (JButton)event.getSource();
			JPanel panel = (JPanel)button.getParent();
			panel.remove(0);
			panel.remove(0);
			panel.repaint();
			panel.validate();
			Container cp = (Container)panel.getParent();
			cp.remove(0);
			mode = new Solitaire(dwg, cp);
		}
	}
	
}

/**
 * HomePage.java
 * Initial page for an object-oriented GUI
 * for playing Memory.
 * 
 * @author Rory Bennett, edited by Elizabeth Ricci for Project 3
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class HomePage extends JApplet {
	private static final long serialVersionUID = 1L;
	//Size of Applet Increased to make room for more cards
	private final int APPLET_WIDTH = 1500, APPLET_HEIGHT = 750;
	private Drawing dwg;
	private Container cp;
	private JPanel modePanel;
	private JLabel setLabel;
	private JTextField textInput;

	
	/**
	 * Sets up the first two buttons, with which the user
	 * will choose a specific mode to play.
	 */
	public void init() {
		dwg = new Drawing();
		
		
		//Button name altered
		JButton enterButton = new JButton("Enter");
		textInput = new JTextField("Ex: 123");
		
		//Button Listner altered
		enterButton.addActionListener(new EnterButtonListener());
		
		
		//Button name and Text Input are new
		modePanel = new JPanel(); 
		setLabel = new JLabel("Enter 3 Character ID: ");
		modePanel.setLayout(new FlowLayout());
		modePanel.setBackground(Color.cyan);
		modePanel.add(setLabel);
		modePanel.add(textInput);
		enterButton.setBackground(Color.green);
		modePanel.add(enterButton);
		
		//Container objects enable control of the location of panels
		//contained within it.
		cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(modePanel, BorderLayout.CENTER);
		setSize(APPLET_WIDTH, APPLET_HEIGHT);
		cp.repaint();
	}
	
	public void home(){
		cp.add(modePanel, BorderLayout.CENTER);
		cp.repaint();
		
		
	}
	
	//New
	private class EnterButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String userId = textInput.getText();
			System.out.println(userId);
			JButton button = (JButton)event.getSource();
			JPanel panel = (JPanel)button.getParent();
			panel.remove(0);
			panel.remove(0);
			panel.repaint();
			panel.validate();
			Container cp = (Container)panel.getParent();
			cp.remove(0);
			new Solitaire(dwg, cp);
		}
	}
	
}

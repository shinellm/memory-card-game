
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Solitaire extends Mode {
	private static final long serialVersionUID = 1L;
	private Command cmd;
	private Drawing d;
	private Container c;
	
	
	/**
	 * Constructor 
	 * @param cp the container object 
	 * @param dwg	the drawing object
	 */
	public Solitaire(Drawing dwg, Container cp) {
		super(dwg, cp);
		cmd = new Command();
		d = dwg;
		c = cp;
	
		//Make JButton objects 
		JButton flipButton = new JButton("Turn Over Cards");
		JButton removeButton = new JButton("Remove Pair");
		JButton restartButton = new JButton("Restart Game");
		JButton quitButton = new JButton("Quit Game");
		
				
		//Add listeners to buttons
		flipButton.addActionListener(new FlipButtonListener());
		removeButton.addActionListener(new RemoveButtonListener());
		restartButton.addActionListener(new RestartButtonListener());
		quitButton.addActionListener(new QuitButtonListener());
		
		
		JPanel optionPanel = new JPanel();
		//optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.PAGE_AXIS));
		optionPanel.setLayout(new FlowLayout());
		flipButton.setBackground(Color.yellow);
		removeButton.setBackground(Color.yellow);
		restartButton.setBackground(Color.yellow);
		quitButton.setBackground(Color.yellow);
		
		optionPanel.add(flipButton);
	//	optionPanel.add(Box.createRigidArea(new Dimension(0,5)));
		optionPanel.add(removeButton);
		//optionPanel.add(Box.createRigidArea(new Dimension(0,5)));
		optionPanel.add(restartButton);
		optionPanel.add(quitButton);
		optionPanel.setBackground(Color.white);
		
		c.add(optionPanel, BorderLayout.NORTH);
		c.repaint();
		c.validate();
		
	}
	
	private class FlipButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			cmd = new SelectTwoCardsCmd();
			cmd.executeClick(d);
			c.repaint();
		}
	}
	
	private class RemoveButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			cmd = new RemovePairCmd();
			cmd.executeClick(d);
			c.repaint();
		}
	}
	
	private class RestartButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			cmd = new RestartCmd();
			cmd.executeClick(d);
			c.repaint();
		}
	}
		
	private class QuitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			cmd = new QuitCmd();
			cmd.executeClick(d);
			c.repaint();
		}
	}
	
}

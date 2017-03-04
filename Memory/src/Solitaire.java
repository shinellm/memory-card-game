
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
		JButton removeButton = new JButton("Remove Pair");
		
				
		//Add listeners to buttons
		removeButton.addActionListener(new RemoveButtonListener());
		
		
		JPanel optionPanel = new JPanel();
		optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.PAGE_AXIS));
		removeButton.setBackground(Color.cyan);
		
		optionPanel.add(removeButton);
		optionPanel.add(Box.createRigidArea(new Dimension(0,5)));
		
		optionPanel.setBackground(Color.white);
		
		c.add(optionPanel, BorderLayout.NORTH);
		c.repaint();
		c.validate();
		
	}
	
	
	private class RemoveButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			//cmd = new RemoveCmd();
			cmd.executeClick(d);
			c.repaint();
		}
	}
		
	
}

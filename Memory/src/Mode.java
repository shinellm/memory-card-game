import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Mode extends JApplet{
	private static final long serialVersionUID = 1L;
	private Drawing dwg;
	private Container cp;
	private Command cmd;
	private Deck deck;
	
	
	public static final int canvasX = 20;		//The x-coordinate for the canvas panel, on which the cards are draw
	public static final int canvasY = 20;		//The y-coordinate for the canvas panel, on which the cards are draw
	
	/**
	 * Default constructor.
	 * 
	 *  @param dwg a drawing object
	 *  @param cp a container object
	 */
	public Mode(Drawing d, Container c){
		dwg = d;
		cp = c;
		cmd = new Command();
		
		CanvasPanel canvasPanel = new CanvasPanel();
		canvasPanel.setBackground(Color.cyan);
		cp.add(canvasPanel, BorderLayout.CENTER);
		cp.repaint();
		cp.validate();
		
		//Create Deck
		deck = Deck.getUniqueInstance();
		//Initialize deck 
		deck.shuffle();
		
		//Add 72 cards
		for (int i = 0; i < 72; i++) {
			  Card card = deck.deal();
			  dwg.addCard(i, card);
		}
		
	
	}


	
	/** 
	   * CanvasPanel is the class upon which we actually draw.  It listens
	   * for mouse events and calls the appropriate method of the current
	   * command. (From Project 1)
	   */ 
	  private class CanvasPanel extends JPanel implements MouseListener,
	      MouseMotionListener {
	    private static final long serialVersionUID = 0;
	    
	    /**
	     * Constructor just needs to set up the CanvasPanel as a listener.
	     */
	    public CanvasPanel() {
	    		addMouseListener(this);
	    		addMouseMotionListener(this);
	    }

	    /**
	     * Paint the whole drawing
	     * @page the Graphics object to draw on
	     */
	    public void paintComponent(Graphics page) {
	      super.paintComponent(page); // execute the paint method of JPanel
	      dwg.draw(page); // have the drawing draw itself
	    }

	    /**
	     * When the mouse is clicked, call the executeClick method of the
	     * current command.
	     */
	    public void mouseClicked(MouseEvent event) {
		
	    }

	    // We don't care about the other mouse events.
	    public void mouseDragged(MouseEvent event) { }
	    public void mousePressed(MouseEvent event) { }
	    public void mouseReleased(MouseEvent event) { }
	    public void mouseEntered(MouseEvent event) { }
	    public void mouseExited(MouseEvent event) { }
	    public void mouseMoved(MouseEvent event) { }
	  }
}

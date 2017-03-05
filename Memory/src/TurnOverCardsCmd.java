
import java.awt.*;
import java.util.ArrayList;

/**
 * TurnOverCardsCmd.java
 * Command class to perform a turn over cards command.
 * 
 * @author Shinell Manwaring
 * @see Command
 */

public class TurnOverCardsCmd extends Command {
	private ArrayList<Card> pair = new ArrayList<Card>(); // the index of the two cards selected
	
	/**
	 * When the "TurnOverCards" button is clicked, if the selected pair of cards are not a proper match
	 * return the cards to the face down position. 
	 * 
	 * @param dwg the drawing 
	 */
	public void executeClick(Drawing dwg) {	}
	
}
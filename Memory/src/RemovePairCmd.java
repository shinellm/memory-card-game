
import java.awt.*;
import java.util.ArrayList;

/**
 * TurnOverCardsCmd.java
 * Command class to perform a remove cards command.
 * 
 * @author Shinell Manwaring
 * @see Command
 */

public class RemovePairCmd extends Command {
	private ArrayList<Card> pair = new ArrayList<Card>(); // the index of the two cards selected
	
	/**
	 * When the "RemoveCards" button is clicked, if the selected pair of cards are a proper match
	 * remove the selected cards and replace them with blank cards. 
	 * 
	 * @param dwg the drawing 
	 */
	public void executeClick(Drawing dwg) {	}
	
}
import java.awt.*;
import java.util.ArrayList;

/**
 * SelectTwoCardsCmd.java
 * Command class to highlight cards, store their index as they're selected, and
 * validate if they are a pair.
 * 
 * @author Shinell Manwaring
 * @see Command
 */

public class SelectTwoCardsCmd extends Command {
	private ArrayList<Card> twoCards = new ArrayList<Card>(); // the index of the two cards selected
	
	public void executeClick(Drawing dwg) {	}

	/**
	 * When a card is selected, the card's index is stored in the
	 * the array. The card itself is also highlighted on the table. Once there are three
	 * card index's in the array, the selected cards are then checked to determine if they are
	 * a pair. If they are a pair, they are removed from the table and replaced
	 * with blank cards. If they are not a pair, they are unselected.
	 * 
	 * @param p the coordinates of the click
	 * @param dwg the drawing 
	 */
	public void addToSet(Drawing dwg, Point p) {
	
	}
}


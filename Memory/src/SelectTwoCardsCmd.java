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
	public void selectPair(Drawing dwg, Point p) {
		if (dwg.getSelectedCards().isEmpty()) { //Are there two cards already selected?

			int i = dwg.searchTable(p); // Find the index of the card containing p.
			Card c = dwg.getCard(i); // Find the card at index i.
			Deck deck = Deck.getUniqueInstance();

			if (c != null) { // Was there a Card containing p?
				if (twoCards.isEmpty()) {
					twoCards.add(c); // Save this card for when there's another click
					c.setFaceUp(true); // Turn the selected card so that it is face up
				}
				else {
					twoCards.add(c);
					c.setFaceUp(true); // Turn the selected card so that it is face up

					// We have two cards in our ArrayList.
					for (int j = 0; j < 2; j++) {
						dwg.addToSelectArray(twoCards.get(j), j);
					}
					// Now we clear the ArrayList and can select 2 more cards.
					twoCards.clear();
				}
			}
		}
	}
}


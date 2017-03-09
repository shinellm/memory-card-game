/**
 * Drawing.java
 * Holds and draws all graphical objects
 * in the Applet
 * 
 * @Rory Bennett
 */
import java.awt.*;
import java.util.ArrayList;

public class Drawing {
	private ArrayList<Card> onTable = new ArrayList<Card>();
	private ArrayList<Card> selectedCards = new ArrayList<Card>();
	private int num_removed;
	private int num_cards;
	private final int CARDS_PER_ROW = 8;
	private final int NUM_ROWS = 9;
	private final int CARDS_ON_TABLE = 72;

	public Drawing () {
		num_removed = 0;
		num_cards = 0;
	}

	/**
	 * Adds a card at the index in the array, or the location
	 * on the "table."
	 * 
	 * @param: card the Card to be inserted
	 * @param: index the index at which the Card is to be inserted
	 */
	public void addCard(int index, Card card) {
		onTable.add(index, card);
		num_cards += 1;
	}

	/**
	 * Removes a card from the ArrayList at the specified index
	 * 
	 * @param: index the index in the ArrayList at which the 
	 * card-to-be-removed is located.
	 */
	public void removeCard(int index) {
		onTable.get(index).setInPlay(false);
		num_cards = num_cards - 1;
		num_removed += 1;
	}

	/**
	 * Replaces the card at the specified index
	 */
	public void replaceCard(int index, Card card) {
		onTable.remove(index);
		onTable.add(index, card);
	}

	/**
	 * Adds the specified card to the array at the given
	 * index in the array to indicate that it has been selected
	 * 
	 * @param: card the card that has been selected
	 * @param: index the index in selectedCards at which to add the card
	 */
	public void addToSelectArray(Card card, int index) {
		selectedCards.add(index, card);
	}

	/**
	 * Given a Card object, this method
	 * searches through the Drawing's arraylist-
	 * representation of cards on the table to find
	 * the index of the matching card.
	 * 
	 * @param: p the Point at which the actionEvent occurred,
	 * assuming the click in the canvas was meant for a Card object.
	 * @return: the index of the Card if it is found,
	 * @return: -1 otherwise
	 */
	public int searchTable(Point p) {
		Deck deck = Deck.getUniqueInstance();
		for (int i = 0; i < CARDS_ON_TABLE; i++) {
			if (onTable.get(i).containsPoint(p) == true) {
				return i;
			}
		}
		return -1;
	}

	public void dumpSelectedCards() {
		selectedCards.clear();
	}

	//getter methods
	/**
	 * Returns the Card at the specified index in the
	 * table ArrayList. Used to get each card in the 
	 * Drawing's ArrayList, to then see if one of them 
	 * contains the point at which a click on the canvas
	 * in Solitaire mode occurred.
	 */
	public Card getCard(int index) {
		return onTable.get(index);
	}

	/**
	 * Returns the onTable Card ArrayList
	 */
	public ArrayList<Card> getTable() {
		return onTable;
	}

	public ArrayList<Card> getSelectedCards() {
		return selectedCards;
	}

	public int getSelectSize() {
		return selectedCards.size();
	}

	public boolean isAMatch() {
		return selectedCards.get(0).isEqual(selectedCards.get(1));
	}

	/**
	 * Draws (or redraws) each Card, based on the latest changes 
	 * per the shapes' attributes/params.
	 * 
	 * @param: page the graphical component upon which everythin
	 * is to be drawn.
	 * @param: startX The playing field's upper-left corner's x-coordinate
	 * @param: startY The playing field's upper-left corner's y-coordinate
	 */
	public void draw(Graphics page) {
		int relative;
		for (int i = 0; i < CARDS_ON_TABLE; i++) {
			relative = (i + 15) % CARDS_PER_ROW;
			if (relative == 7) {
				onTable.get(i).draw(page, Mode.canvasX, Mode.canvasY + (Card.HEIGHT*(i/CARDS_PER_ROW))
						+ (i/CARDS_PER_ROW)*10);
			} else { 
				onTable.get(i).draw(page, (relative+1)*Card.WIDTH + Card.WIDTH * (relative + 2) - 20,
						Mode.canvasY + Card.HEIGHT*(i/CARDS_PER_ROW) + (i/CARDS_PER_ROW)*10);
			} 
		}
	}
}


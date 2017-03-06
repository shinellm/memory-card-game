/**
 * Drawing.java
 * Holds and draws all graphical objects
 * in the Applet
 * 
 * @Rory Bennett
 */
import java.awt.*;
import java.util.ArrayList;

import javax.smartcardio.Card;

public class Drawing {
	private ArrayList<Card> onTable = new ArrayList<Card>();
	private ArrayList<Card> selectedCards = new ArrayList<Card>();
	private int num_removed;
	
	private final int CARDS_PER_ROW = 8;
	private final int NUM_ROWS = 9;
	private final int CARDS_ON_TABLE = 72;
	
	public Drawing () {
		num_removed = 0;
		Deck deck = Deck.getUniqueInstance();
		for (int i = 0; i < CARDS_ON_TABLE;i++) {
			onTable.add(i, deck.getAtIndex(i));
		}
	}
	
	/**
	 * Adds the specified card to the array a the given
	 * index in the array to indicate that it has been selected
	 * 
	 * @param: card the card that has been selected
	 * @param: index the index in selectedCards at which to add the card
	 */
	public void addToSelectArray(Card card, int index) {
		selectCards.add(indx, card);
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
	
	/**
	 * Given a Card, this method searches through
	 * this Drawing's table ArrayList and compares
	 * the four fields values with those of each 
	 * card in the ArrayList.
	 * 
	 * @param: card a card, the index for which the
	 * table ArrayList is being searched.
	 * @return: the index of the Card if it appears 
	 * on the table, -1 otherwise.
	 */
	public int compareForIndex(Card card) {
		for (int i = 0; i < num_cards; i++) {
			if ((card.getCount() == onTable.get(i).getCount())
				&& (card.getShape() == onTable.get(i).getShape())
				&& (card.getColor() == onTable.get(i).getColor())
				&& (card.getShading() == onTable.get(i).getShading())) {
				return i;
			}
		}
		return -1;
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

	/**
	 * Compares the contents of two cards
	 * @param: card1 the first Card to be compared
	 * @param: card2 the second Card to be compared
	 * @return: true if the two Cards' four fields
	 * all hold the same values, false otherwise
	 */
	public boolean compareCards(Card card1, Card card2) {
		if (card1.getColor() == card2.getColor()) {
			if (card1.getShape() == card2.getShape()) {
				if (card1.getCount() == card2.getCount()) {
					if (card1.getShading() == card2.getShading()) {
						return true;
					}
				}
			}
		}
		return false;
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
				onTable.get(i).draw(page, Mode.canvasX + 10, Mode.canvasY + 10 + (90*(i/CARDS_PER_ROW)));
			} else { 
				onTable.get(i).draw(page, Mode.canvasX + 10 + (60 * (i + 1)), Mode.canvasY + 10 + (90*(i/CARDS_PER_ROW)));
			} 
		}
	}
}


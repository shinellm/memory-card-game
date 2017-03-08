/**
 * Deck.java
 * Represents a Deck of cards for the game
 * of Set
 * 
 * @author Rory Bennett
 */

import java.util.ArrayList;
import java.util.Random;
import java.net.URL;
import images.*;

public class Deck {
	private ArrayList <Card> arr = new ArrayList<Card>();
	public static final int TOTAL_CARDS = 72;
	
	private static Deck uniqueInstance = null;	//The Singleton deck
	
	private int currCardPointer = 0;	//The index of the ArrayList of cards, representing the top card
										//on the deck.
	private Deck() {
		ArrayList<URL> urls = InternationalLibrary.getUniqueInstance().getURLs();
		for (int i = 0; i < InternationalLibrary.TOTAL_IMAGES; i++) {
			Card card1 = new Card(ImageLibrary.getURL(i, urls));
			Card card2 = new Card(ImageLibrary.getURL(i,
					urls));
			arr.add(i, card1);
			arr.add(i + 1, card2);
		}
	}
	
	/**
	 * Shuffles the deck using a pseudo random
	 * number generator
	 */
	public void shuffle() {
		currCardPointer = 0;
		Random randomno = new Random();
		int topCard = TOTAL_CARDS;
		for (int i = TOTAL_CARDS - 1; i >= 0; i--) {
			swap(randomno.nextInt(topCard), i);
			topCard = topCard - 1;
		}
	}
	
	/**
	 * Returns the current pointer Card, but
	 * additionally moves the pointer forward
	 * 
	 * @return: the current pointer Card
	 */
	public Card deal() {
		Card card = getPointer();
		currCardPointer += 1;
		return card;
	}
	
	/**
	 * Switches the two indices given as arguments, so that the deck 
	 * array can then swap the indices' values.
	 * 
	 * @param first this index within the deck gets swapped with int second.
	 * @param second this index within the deck gets swapped with int first.
	 */
	private void swap(int first, int second) {
		Card exchangeSecond = uniqueInstance.getAtIndex(second);
		Card exchangeFirst = uniqueInstance.getAtIndex(first);
		setAtIndex(first, exchangeSecond);
		setAtIndex(second, exchangeFirst);
	}
	
	/**
	 * The instantiator/getter of the Singleton
	 * deck. If this is the first time this method
	 * is being called, then the deck will be 
	 * instantiated; otherwise, it is simply returned
	 * 
	 * @return: the Singleton deck.
	 */
	public static Deck getUniqueInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Deck();
		}
		
		return uniqueInstance;
	}
	
	public Card getAtIndex(int index) {
		return arr.get(index);
	}
	
	public void setAtIndex(int index, Card card) {
		arr.set(index, card);
	}
	
	/**
	 * Returns the Card being pointed to
	 * by the currCardPointer variable
	 * 
	 * @return: the pointer card
	 */
	public Card getPointer() {
		Card pointer = arr.get(currCardPointer);
		return pointer;
	}

	/**
	 * Returns the value of currCardPointer
	 */
	public int getPointerIndex() {
		return currCardPointer;
	}
	
	/**
	 * Determines whether the deck is empty or not
	 * 
	 * @return: true if the pointer points past the 
	 * last card in the deck, false otherwise.
	 */
	public boolean isEmpty() {
		if (currCardPointer == TOTAL_CARDS) {
			return true;
		}
		return false;
	}
}

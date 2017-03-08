
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
	public void executeClick(Drawing dwg) {	
		pair = dwg.getSelectedCards(); //Get the Cards that were selected
		if (dwg.isAMatch()) { //Do the selected cards match?
			for (int j = 0; j < 2; j++) {
				pair.get(j).setFaceUp(false); //Turn the selected cards so they are faced down
				//dwg.removeCard(index);
				pair.get(j).setInPlay(false); //The selected cards are removed from play
			}
			// Clear the SelectedCards array in the drawing class
		}
		else {
			// Display a prompt saying the cards do not match and to press the TurnOverCards Button
			}
		pair.clear(); //clear the array of cards selected
	}
}

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
	public void executeClick(Drawing dwg) {
		System.out.println("Array: " + dwg.getSelectedCards().size());
		
		if(dwg.getSelectSize() == 2){ //Are there cards selected?
			pair = dwg.getSelectedCards();  //Get the Cards that were selected
			
			if (dwg.isAMatch() != true) { //Do the selected cards match?
				
				System.out.println("Pair?: " + dwg.isAMatch());
				for (int j = 0; j < 2; j++) {
					pair.get(j).setFaceUp(false); //Turn the selected cards so they are faced down
				}
				// Clear the SelectedCards array in the drawing class
				dwg.dumpSelectedCards();
			}
			else {
				//Display a prompt telling the user to remove the selected cards
			}
			pair.clear(); //clear the array of cards selected
		}
		
		//There's a problem with how i get the selected cards
		System.out.println("Array at end: " + dwg.getSelectedCards().size());
		
	}
}
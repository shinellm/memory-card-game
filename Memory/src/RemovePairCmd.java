
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * RemovePairCmd.java
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
		if(dwg.getSelectSize() == 2){ //Are there cards selected?
			pair = dwg.getSelectedCards();  //Get the Cards that were selected

			if (dwg.isAMatch()) { //Do the selected cards match?
				
				for (int j = 0; j < 2; j++) {
					pair.get(j).setFaceUp(false); //Turn the selected cards so they are faced down
					Point point = new Point(pair.get(j).getX(),pair.get(j).getY());
					int index = dwg.searchTable(point);
					dwg.removeCard(index);
				}
				dwg.dumpSelectedCards(); // Clear the SelectedCards array in the drawing class
				dwg.incrementNumRemoved(); // Increment the score for number of pairs selected
			}
			else {
				// Display a prompt saying the cards do not match and to press the TurnOverCards Button
				JOptionPane.showMessageDialog(null,"The selected cards do not match. Press the 'Turn Over Cards' Button.");
			}
		}
	}
}
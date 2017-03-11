
import javax.swing.JOptionPane;

import highscore.HighScoreManager;

/**
 * TurnOverCardsCmd.java
 * Command class to add and retrieve the high scores for the current user.
 * 
 * @author Shinell Manwaring
 * @see Command
 */

public class HighScoresCmd extends Command {
	private int score;
	
	/**
	 * When the user completes the game, add the user's current score to their
	 * previous high scores. If this is their first time playing, a profile will be created
	 * for the user. Display up to 10 of the user's high scores.
	 * 
	 * @param dwg the drawing 
	 */
	public void executeClick(Drawing dwg) {	
	HighScoreManager hm = new HighScoreManager();
	if ((dwg.getNumTurned()) == 0) {
		score = 0;
	}
	else{
		score = ((dwg.getNumRemoved())/(dwg.getNumTurned()))*100;
	}
	
    hm.addScore(dwg.getUserID(),score);
    
    // Display the top 10 score for the specified player and display a prompt saying the game has ended and to press the Quit or Restart Button
	JOptionPane.showMessageDialog(null,"Game Over... Press the 'Quit' or 'Restart' Button.\n" + hm.getHighscoreString(dwg.getUserID()));
	}	
}
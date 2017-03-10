package highscore;

import java.util.*;
import java.io.*;

/**
 * HighScoreManager.java
 * A part of the highscore package, which manages all high scores and can add or load them from a
 * specified source file.
 * 
 * @author Shaddix
 * @see <a href="http://forum.codecall.net/topic/50071-making-a-simple-high-score-system">http://forum.codecall.net/topic/50071-making-a-simple-high-score-system</a>
 */

public class HighScoreManager {
	private ArrayList<Score> scores; //The array list of types Score that holds the user data
	private static final int max = 10; //The max number of scores to be retrieved

	// The name of the file where the highscores will be saved
	private static final String HIGHSCORE_FILE = "scores.dat";

	//Initialising an in and outputStream for working with the file
	ObjectOutputStream outputStream = null;
	ObjectInputStream inputStream = null;

	/**
	 * Initializes the scores-arraylist
	 */
	public HighScoreManager() {
		scores = new ArrayList<Score>();
	}

	/**
	 * Retrieves the scores from the files where the highscores are saved, sorts the scores from
	 * largest to smallest, and returns them as an arraylist of scores
	 */
	public ArrayList<Score> getScores() {
		loadScoreFile();
		sort();
		return scores;
	}

	/**
	 * Sorts the scores from largest to smallest
	 */
	private void sort() {
		HighScoreComparator comparator = new HighScoreComparator();
		Collections.sort(scores, comparator);
	}

	/**
	 * Add the scores to the file where the highscores will be saved
	 */
	public void addScore(String name, int score) {
		loadScoreFile();
		scores.add(new Score(name, score));
		updateScoreFile();
	}

	/**
	 * Looks through the file where the highscores are saved
	 */
	public void loadScoreFile() {
		try {
			inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
			scores = (ArrayList<Score>) inputStream.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("[Laad] FNF Error: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("[Laad] IO Error: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("[Laad] CNF Error: " + e.getMessage());
		} finally {
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException e) {
				System.out.println("[Laad] IO Error: " + e.getMessage());
			}
		}
	}

	/**
	 * Updates the file where the highscores are saved
	 */
	public void updateScoreFile() {
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
			outputStream.writeObject(scores);
		} catch (FileNotFoundException e) {
			System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
		} catch (IOException e) {
			System.out.println("[Update] IO Error: " + e.getMessage());
		} finally {
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException e) {
				System.out.println("[Update] Error: " + e.getMessage());
			}
		}
	}

	/**
	 * Retrieves the highscores associates with a specified name of type String. It then
	 * returns a string of the top 10 sores associated with that specific name.
	 */
	public String getHighscoreString(String name) {
		String highscoreString = "";

		ArrayList<Score> scores;
		scores = getScores();

		int display = 0;

		for (int i = 0; i < scores.size(); i++) {
				if ((display < max) && (name.equals(scores.get(i).getNaam()))) {
					System.out.println(scores.get(i).getNaam());
					highscoreString += (display + 1) + ".\t" + scores.get(i).getNaam() + "\t\t" + scores.get(i).getScore() + "\n";
					display++;
				}
			}
		return highscoreString;
	}
}
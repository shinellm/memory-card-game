package highscore;

import java.io.Serializable;

/**
 * Score.java
 * A part of the highscore package, which creates a score profile given
 * a name and a score to add under that name.
 * 
 * @author Shaddix
 * @see <a href="http://forum.codecall.net/topic/50071-making-a-simple-high-score-system">http://forum.codecall.net/topic/50071-making-a-simple-high-score-system</a>
 */

public class Score  implements Serializable {
    private int score; //The score achieved by the user
    private String naam; //The name of the user

	/**
	 * Returns the score.
	 */
    public int getScore() {
        return score;
    }

	/**
	 * Returns the name.
	 */
    public String getNaam() {
        return naam;
    }

	/**
	 * Creates a score profile.
	 */
    public Score(String naam, int score) {
        this.score = score;
        this.naam = naam;
    }
}
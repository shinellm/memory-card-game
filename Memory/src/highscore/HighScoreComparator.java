package highscore;

import java.util.Comparator;

/**
 * HighScoreComparator.java
 * A part of the highscore package, which compares scores.
 * 
 * @author Shaddix
 * @see <a href="http://forum.codecall.net/topic/50071-making-a-simple-high-score-system">http://forum.codecall.net/topic/50071-making-a-simple-high-score-system</a>
 */

public class HighScoreComparator implements Comparator<Score> {
    
	/**
	 * Returns a comparison of two scores. This method returns -1 if the first score is
	 * larger than the second score, returns +1 if the second score is large than the first score
	 * and returns 0 if both scores are equal.
	 */
	public int compare(Score score1, Score score2) {

            int sc1 = score1.getScore();
            int sc2 = score2.getScore();

            if (sc1 > sc2){
                return -1;
            }else if (sc1 < sc2){
                return +1;
            }else{
                return 0;
            }
        }
}
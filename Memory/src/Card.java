/**
 * Card.java
 * Represents a single Set card in the deck,
 * attributes and all
 * 
 * @author Rory Bennett
 */
import java.awt.*;
import java.net.URL;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Card{
	private URL imageLink;
	private boolean faceUp;
	private boolean inPlay;

	private int x;		//The x-coordinate of a Card's upper-left corner
	private int y;		//The y-coordinate of a Card's upper-left corner

	public static final int WIDTH = 50;
	public static final int HEIGHT = 70;

	public Card(URL url) {
		imageLink = url;
		faceUp = false;
		inPlay = false;
	}

	/**
	 * Draws a white rectangle, given the x- and y-coordinate
	 * parameters, and the set width and height instance variables.
	 * Then uses its other instance variables, determined at the 
	 * instantiation of the Deck object in which it is held, to 
	 * draw the shapes, the coordinates of which will be based
	 * off of this Card's own coordinates.
	 * 
	 * @param: page the page on which this Card is to be drawn
	 * @param: x_coor the x-coordinate of this Card
	 * @param: y_coor the y-coordinate of this Card
	 */
	public void draw(Graphics page, int x_coor, int y_coor) {
		x = x_coor;					//Sets the x-coordinate of this Card
		y = y_coor;					//Sets the y-coordinate of this Card
		Color savedColor = page.getColor();
		page.setColor(Color.white);
		page.fillRect(x, y, WIDTH, HEIGHT);

		if (highlighted == true) {
			page.setColor(Color.red);
			page.drawRect(x,  y, WIDTH, HEIGHT);
			page.drawRect(x - 1,  y - 1, WIDTH + 2, HEIGHT + 2);
			page.drawRect(x - 2,  y - 2, WIDTH + 4, HEIGHT + 4);
		} else {
			page.setColor(Color.black);
			page.drawRect(x,  y, WIDTH, HEIGHT);
		}

		take_Color(page);
		page.setColor(savedColor);
	}

	/**
	 * Return true if the Rect contains Point p, false otherwise.
	 * 
	 * @param p point tested for containment
	 */
	public boolean containsPoint(Point p) {
		return (p.x >= x && p.x <= (x + WIDTH)
				&& p.y >= y && p.y <= (y + HEIGHT));
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public boolean getFaceUp() {
		return faceUp;
	}
	
	public boolean getInPlay() {
		return inPlay;
	}
	
	public void setInPlay(boolean status) {
		inPlay = status;
	}
	
	public void setFaceUp(boolean face) {
		faceUp = face;
	}
}

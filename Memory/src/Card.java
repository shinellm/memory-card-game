/**
 * Card.java
 * Represents a single Memory card in the deck,
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
	private boolean faceUp;		//instance variables that determine three different ways in which
	private boolean inPlay;		//a card can be drawn.

	private int x;		//The x-coordinate of a Card's upper-left corner
	private int y;		//The y-coordinate of a Card's upper-left corner

	//No need for so many static instance variables, as in the last project, because the focus is solely on the card's
	//image
	public static final int WIDTH = 65;
	public static final int HEIGHT = 85;
	
	public static final int IMAGE_WIDTH = 55;
	public static final int IMAGE_HEIGHT = 75;

	//Now the Card only takes an image URL as a parameter
	public Card(URL url) {
		imageLink = url;
		faceUp = false;
		inPlay = true;
	}

	/**
	 * Draws a rectangle, given the x- and y-coordinate
	 * parameters, and the set width and height instance variables.
	 * Then uses its other instance variables, determined at the 
	 * instantiation of the Deck object in which it is held, to 
	 * decide whether to draw the image, or draw the back of the card
	 * or draw the card so that it is now invisible
	 * 
	 * @param: page the page on which this Card is to be drawn
	 * @param: x_coor the x-coordinate of this Card
	 * @param: y_coor the y-coordinate of this Card
	 */
	public void draw(Graphics page, int x_coor, int y_coor) {
		x = x_coor;                    //Sets the x-coordinate of this Card
		y = y_coor;                    //Sets the y-coordinate of this Card
		Color savedColor = page.getColor();

		if (inPlay == false) {
			page.setColor(Color.black);
			page.drawRect(x, y, WIDTH, HEIGHT);
		} else if (faceUp == false) {
			page.setColor(Color.red);
			page.fillRect(x_coor, y, WIDTH, HEIGHT);
			page.setColor(Color.black);
			page.drawRect(x_coor, y, WIDTH, HEIGHT);
		} else {
			BufferedImage image;
			try {
				image = ImageIO.read(imageLink);	//In case the URL is misspelled or corrupted
				page.drawImage(image, x + ((WIDTH - IMAGE_WIDTH) / 2), y + ((HEIGHT - IMAGE_HEIGHT) / 2),
						IMAGE_WIDTH, IMAGE_HEIGHT, page.getColor(), null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
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

	//New getters and setters corresponding to the new instance variables
	public boolean getFaceUp() {
		return faceUp;
	}
	
	public boolean getInPlay() {
		return inPlay;
	}
	
	public URL getURL() {
		return imageLink;
	}
	
	public void setInPlay(boolean status) {
		inPlay = status;
	}
	
	public void setFaceUp(boolean face) {
		faceUp = face;
	}
	
	/**
	 * Compares the URLs for this card and another,
	 * and determines whether or not they are equal.
	 * 
	 * @param: card the Card object to be compared to 
	 * this Card object.
	 * @return: true if they are equal, false otherwise.
	 */
	public boolean isEqual(Card card) {
		return imageLink.equals(card.getURL());
	}

	/**
	 * Determines whether or not two Cards have different locations
	 *
	 * @param card the card to which this is being compared
	 * @return true card shares a different location, false otherwise
	 */
	public boolean locatedElsewhere(Card card) {
		return (x != card.getX() || y != card.getY());
	}
}

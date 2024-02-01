import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

public class Box {

	private int x_coordinate;			
	private int y_coordinate;
	private Color color;
	private Color yellow = new Color (255, 220, 108);
	private Color green = new Color(160,195,90,255);
	private Color blue = new Color(176,196,240,255);
	private Color purple = new Color(187,129,197,255);

	public Box(){
		this(0, 0, Color.WHITE);
	}

	public Box(int x_coordinate, int y_coordinate, Color color){
		this.x_coordinate = x_coordinate;						// Initial coordinates for the Shape.
		this.y_coordinate = y_coordinate; 
		this.setColor(color);
	}

	// method: getX
	// description:  This method will return the x-coordinate of the top left hand corner of the the image.
	// return: int - the x-coordinate of the top left hand corner of the the image.
	public int getX(){
		return x_coordinate;
	}

	// method: getY
	// description:  This method will return the y-coordinate of the top left hand corner of the the image.
	// return: int - the y-coordinate of the top left hand corner of the the image.
	public int getY(){
		return y_coordinate;
	}

	public void setX(int x_coordinate) {
		this.x_coordinate = x_coordinate;
	}

	public void setY(int y_coordinate) {
		this.y_coordinate = y_coordinate;
	}


	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public boolean match(Word wordOne, Word wordTwo, Word wordThree, Word wordFour) {
		return (wordOne.getDifficulty() == wordTwo.getDifficulty() 
				&& wordOne.getDifficulty() == wordThree.getDifficulty() 
				&& wordOne.getDifficulty() == wordFour.getDifficulty());
	}

	public void draw(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(getColor());
		g2.fillRect(getX(), getY(), 100, 75);
		g2.setColor(Color.BLACK);
		g2.drawString("words", getX()+30, getY()+45);
	}

}

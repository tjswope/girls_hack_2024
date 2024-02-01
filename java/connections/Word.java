import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

public class Word {
	private int x_coordinate;			
	private int y_coordinate;
	private Color color;
	private String word;
	private int difficulty;
	
	public Word(){
		this(0, 0, Color.BLACK, 0, "example");
	}

	public Word(int x_coordinate, int y_coordinate, Color color, int difficulty, String word){
		this.x_coordinate = x_coordinate;						// Initial coordinates for the Shape.
		this.y_coordinate = y_coordinate; 
		this.setColor(color);
		this.difficulty = difficulty;
		this.word = word;
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
	
	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	public void draw(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.drawString("words", getX()+30, getY()+45);
	}
}

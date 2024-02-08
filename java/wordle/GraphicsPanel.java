import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;

public class GraphicsPanel extends JPanel implements KeyListener{
	//declare the variables you want to use here 
	String answer; //this String is the word the player is attempting to guess

	String[] wordlist; //this array holds the list of 5 letter words allowed within wordle.

	String[] guesses = {"", "", "", "", "", ""}; //this array holds the guesses the player has entered as Strings.

	private int xAdjust = 0; //this int variable helps keep track of where the player is typing when they enter letters. It is 
	// used to move the cursor to the right after a letter is typed, or to the left when they delete.

	private int yAdjust = 0; //this int variable helps keep track of where the player is typing when they enter words. It is
	// used to move the cursor to a lower line after they enter a guess.

	private char [][] board = new char[6][5]; //this is the grid of char variables that is displayed in the console. It is also
	// used as a framework for the grid displayed with the Graphics.

	private Color [][] tileColors = {{Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE} ,   //this is the grid of
			{Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},   //Color objects that 
			{Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE} ,  //controls the color of
			{Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE} ,  //each tile on the
			{Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE} ,  //grid. When the game
			{Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE}};  //begins, all tiles
	//are white.

	// default constructor																			
	// the constructor should also initialize any of the variables you declared above
	public GraphicsPanel() {

		//set the variables to their starting values here
		wordlist = getWordlist(); //Fills the wordlist array with the list of words using the function getWordList()
		//written in the Graphics panel (scroll down to see it).

		answer = wordlist[(int)Math.random()*2314]; //sets the word the player is
		//attempting to guess to a random
		// word in the wordle library list.

		//these lines are settings for the panel 
		setPreferredSize(new Dimension(720,780));  //sets the dimensions of the window where the game is displayed
		this.setFocusable(true);

		//this registers GraphicsPanel as the component that is listening to the key events, don't remove it
		this.addKeyListener(this);


	}

	//add your draw methods here
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(new ImageIcon("src/assets/white_bg.png").getImage(), 0, 0, 720, 780, getFocusCycleRootAncestor());
		//draws an image as the background of the game panel. Graphics appear in the order that they are written,
		//so we draw the background first, keeping it behind any other graphics drawn on top of it. To change the 
		//background, place a new image in the assets folder and adjust the name in the ImageIcon URL here.

		g2.setFont(new Font("Arial", 1, 80)); //sets the size and font for all letters on the game board

		for(int i = 0; i<6; i++) { //uses a nested for loop to create a grid for the game board
			for(int j = 0; j<5; j++) {
				g2.setColor(Color.GRAY);
				g2.drawRect(50+110*j, 100+110*i, 100, 100); //draws the outline of each tile

				g2.setColor(tileColors[i][j]);
				g2.fillRect(50+110*j, 100+110*i, 100, 100); //fills each tile with its currently assigned color

				g2.setColor(Color.BLACK); //sets the color to black for the letter tiles' font.

				g2.drawString(Character.toString(Character.toUpperCase(board[i][j])), 75+j*110, 175+i*110); 
				//draws the chars in board[][] as upper case Strings inside each tile.
			}
		}


		g2.setColor(Color.BLACK);
		g2.drawString("WORDLE", 140, 80); //Draws game title
	}


	@Override
	// triggers when a key is typed 
	// method: keyTyped()
	// description: This method is called when a key is pressed and released. It basically combines the keyPressed and
	//              keyReleased functions.  You can determine which key is typed using the KeyEvent object
	public void keyTyped(KeyEvent e) {
		//gets character data and stores in char c

		char c = e.getKeyChar();
		System.out.println("The key you pressed was " + c ); //this statement is printed in the console every time the	
		//player types a key.

		if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE && xAdjust > 0) { //this statement allows players to delete letters before
			xAdjust--;												  //they have entered them as a guess. It changes the current
			board[yAdjust][xAdjust]= ' ';							 //tile to an empty char, and moves the cursor back one space.
		}
		else if(c == KeyEvent.VK_ENTER && xAdjust == 5) { //this statement enters and evaluates a player's guessed word.
			for(char a : board[yAdjust]) {					
				guesses[yAdjust]+=Character.toString(a); //here, the individual chars are concatenated into a word in the form of	
			}											 //a string.
		}
		else if(Character.isLetter(c) && xAdjust < 5) { //as long as the key typed by the player is a letter (not punctuation
			board[yAdjust][xAdjust]= c;					//or a number), it is entered in the game board at the current position.
			xAdjust++; //the cursor is brought to the next tile to the right.
		}

		this.repaint(); //calls the paint function again to update the changes made after the key was typed to the paint component.


		for (int i = 0; i < board.length; i++) { //here, the game board is printed to the console every time a key is typed.
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}

	//method: getWordList()
	//parameters: none
	//return: String [] - returns the list of words in hte wordle library txt file as an array of Strings.
	//description: This method reads the wordle library txt file and creates a String array with each word
	//			  as its own element. If a file is not found, an empty array is returned.
	public String[] getWordlist() {
		List<String> lines = new ArrayList<String>();
		try {
			Scanner sc = new Scanner(new File("src/wordle-La.txt"));
			while (sc.hasNextLine()) {
				lines.add(sc.nextLine());
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String[] arr = lines.toArray(new String[0]);
		return arr;
	}

	@Override
	// triggers once when a key is pressed, it retriggers when it is released then repressed
	// method: keyPressed()
	// description: This method is called when a key is pressed. You can determine which key is pressed using the 
	//		KeyEvent object.  For example if(e.getKeyCode() == KeyEvent.VK_LEFT) would test to see if
	//		the left key was pressed.
	// parameters: KeyEvent e
	public void keyPressed(KeyEvent e) {
		//add code here if you would like something to happen when the player presses a key. "Pressing" a key only 
		//includes pushing down on the key. "Typing" a key involves both pressing and releasing the key.

	}

	@Override
	// triggers once when a key is released
	// method: keyReleased()
	// description: This method is called when a key is released. You can determine which key is released using the 
	//		KeyEvent object.  For example if(e.getKeyCode() == KeyEvent.VK_LEFT) would test to see if
	//		the left key was released.
	// parameters: KeyEvent e

	public void keyReleased(KeyEvent e) {
		//add code here if you would like something to happen when the player releases a key. "Releasing" a key  
		//only includes the key springing back up after being typed. "Typing" a key involves both pressing and 
		//releasing the key.
	}

}

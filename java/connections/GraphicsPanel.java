import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

//LM TEam 1  Sharks
// Eliza Liebo, Melanie Richards, Jordan Levinson, Casey Forman
import javax.swing.*;

import java.util.ArrayList;
import java.util.Scanner;
public class GraphicsPanel extends JPanel implements MouseListener{
	//declare the variables you want to use here 
	String answer;
	char userGuess;
	String guessedChars;
	String [ ] words;
	int index;
	String message = "";
	int randomIndex;
	int count;
	private Box board [][];


	Scanner s = new Scanner(System.in);

	// default constructor
	// the constructor should also initialize any of the variables you declared above
	public GraphicsPanel() {

		setPreferredSize(new Dimension(300, 300));
		this.setFocusable(true);			
		this.addMouseListener(this);
		
		board = new Box[4][4];
		int y = 125;
        for (int i = 0; i < 4; i++) {
        	int x = 90;
            for (int j = 0; j < 4; j++) {
                board[i][j] = new Box(); 
            	board[i][j].setX(x);
            	board[i][j].setY(y);
            	x+=110;
            	}
            y+=80;
         }
    


		randomIndex = (int)(Math.random() * 20);


		//these lines are settings for the panel 
		setPreferredSize(new Dimension(600,600));  
		this.setFocusable(true);

		//this registers GraphicsPanel as the component that is listening to the key events, don't remove it
		this.addMouseListener(this);
	}


	//add your draw methods here
	public void paintComponent(Graphics g){

		// this code loads an image so that you can later paint it onto your component.

		// this would load a picture named x.png that should be saved in a folder

		// named images, which should be located in your src folder.

		// these images were downloaded from imageicon.com.  you can download other

		// images from this website to use instead of these.

		Graphics2D g2 = (Graphics2D) g;
		

		ClassLoader cldr = this.getClass().getClassLoader();
		
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j].draw(g2);
            	}
         }
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
	//		String imagePath = "background2.png";
	//
	//		URL imageURL = cldr.getResource(imagePath);
	//
	//		ImageIcon background2 = new ImageIcon(imageURL);
	//
	//		Image scaled = background2.getImage().getScaledInstance(background2.getIconWidth() / 2,
	//
	//				background2.getIconHeight() / 2, background2.getImage().SCALE_SMOOTH);
	//
	//		background2 = new ImageIcon(scaled);
	//
	//		background2.paintIcon(this, g2, 0, 0);
	//
	//
	//		ClassLoader cldr2 = this.getClass().getClassLoader();
	//
	//		String imagePath2 = "newShark.PNG";
	//
	//		URL imageURL2 = cldr.getResource(imagePath2);
	//
	//		ImageIcon newShark = new ImageIcon(imageURL2);
	//
	//		Image scaled2 = newShark.getImage().getScaledInstance(newShark.getIconWidth() / 4,
	//
	//				newShark.getIconHeight() / 4, newShark.getImage().SCALE_SMOOTH);
	//
	//		newShark = new ImageIcon(scaled2);
	//
	//
	//
	//
	//		g2.setColor(Color.BLUE);
	//		g2.setFont(new Font("Copperplate", 1, 25));
	//		g2.drawString(message, 50, 50);
	//		g2.setColor(Color.BLUE);
	//
	//		g2.setFont(new Font("Copperplate", 1, 25));
	//
	//		g2.drawString(message, 50, 50);
	//
	//		int x = 0; 
	//
	//		g2.drawString("Secret Word: ", 50, 100);
	//
	//		x=20;
	//
	//		for(int i = 0; i < answer.length(); i ++) {
	//
	//			g2.drawString( ""+ answer.charAt(i),230 + x , 100);
	//
	//			x+=20;
	//
	//
	//
	//		}
	//		g2.drawString("INCORRECT GUESSES: " + guessedChars, 50, 150);
	//
	//
	//		g2.setColor(Color.BLACK);
	//		if (count == 0) {
	//			g2.setStroke(new BasicStroke(5));
	//			g2.drawOval(400, 150, 80, 80);
	//			g2.drawLine(440, 230, 440, 330);
	//			g2.drawLine(440, 260, 500, 260);
	//			g2.drawLine(440, 260, 380, 260);
	//			g2.drawLine(440, 330, 380, 390);
	//			g2.drawLine(440, 330, 500, 390);
	//			g2.drawLine(425, 175, 425, 190);
	//			g2.drawLine(447, 175, 447, 190);
	//			g2.drawOval(430, 200, 14, 14);
	//			newShark.paintIcon(this, g2, 85, 200);
	//		}
	//		if (count == 1) {
	//			g2.setStroke(new BasicStroke(5));
	//			g2.drawOval(400, 150, 80, 80);
	//			g2.drawLine(440, 230, 440, 330);
	//			g2.drawLine(440, 260, 500, 260);
	//			g2.drawLine(440, 330, 380, 390);
	//			g2.drawLine(440, 330, 500, 390);
	//			g2.drawLine(425, 175, 425, 190);
	//			g2.drawLine(447, 175, 447, 190);
	//			g2.drawOval(430, 200, 14, 14);
	//			newShark.paintIcon(this, g2, 175, 200);
	//		}
	//		if (count == 2) {
	//			g2.setStroke(new BasicStroke(5));
	//			g2.drawOval(400, 150, 80, 80);
	//			g2.drawLine(440, 230, 440, 330);
	//			g2.drawLine(440, 260, 500, 260);
	//			g2.drawLine(440, 330, 500, 390);
	//			g2.drawLine(425, 175, 425, 190);
	//			g2.drawLine(447, 175, 447, 190);
	//			g2.drawOval(430, 200, 14, 14);
	//			newShark.paintIcon(this, g2, 175, 330);
	//		}
	//		if (count == 3) {
	//			g2.setStroke(new BasicStroke(5));
	//			g2.drawOval(400, 150, 80, 80);
	//			g2.drawLine(440, 230, 440, 330);
	//			g2.drawLine(440, 260, 500, 260);
	//			g2.drawLine(425, 175, 425, 190);
	//			g2.drawLine(447, 175, 447, 190);
	//			g2.drawOval(430, 200, 14, 14);
	//			newShark.paintIcon(this, g2, 250, 330);
	//		}
	//		if (count == 4) {
	//			g2.setStroke(new BasicStroke(5));
	//			g2.drawOval(400, 150, 80, 80);
	//			g2.drawLine(440, 230, 440, 330);
	//			g2.drawLine(425, 175, 425, 190);
	//			g2.drawLine(447, 175, 447, 190);
	//			g2.drawOval(430, 200, 14, 14);
	//			newShark.paintIcon(this, g2,250, 200);
	//		}
	//		if (count == 5) {
	//			g2.setStroke(new BasicStroke(5));
	//			g2.drawOval(400, 150, 80, 80);
	//			g2.drawLine(425, 175, 425, 190);
	//			g2.drawLine(447, 175, 447, 190);
	//			g2.drawOval(430, 200, 14, 14);
	//			newShark.paintIcon(this, g2, 220, 270);
	//		}
	//		if (count >= 6) {
	//			g2.setColor(Color.WHITE);
	//			g2.fillRect(300, 460, 25, 25);
	//			g2.setColor(Color.WHITE);
	//			g2.fillOval(295, 395, 150, 100);
	//			g2.setColor(Color.BLUE);
	//			g2.drawString("YOU LOSE", 302, 450);
	//			g2.setColor(Color.WHITE);
	//			g2.drawString("click space to try again", 50, 50);
	//			g2.setColor(Color.WHITE);
	//			g2.drawString("the correct word was: " + words [randomIndex], 100, 340);
	//			newShark.paintIcon(this, g2, 200, 160);		
	//
	//		}
	//		if (words [randomIndex].equals(answer)) {
	//			g2.setColor(Color.WHITE);
	//			g2.fillRect(300, 460, 25, 25);
	//			g2.setColor(Color.WHITE);
	//			g2.fillOval(295, 395, 150, 100);
	//			g2.setColor(Color.BLUE);
	//			g2.drawString("YOU WIN!", 307, 450);
	//			g2.setColor(Color.WHITE);
	//			g2.drawString("click space to play again", 50, 50);	
	//
	//		}
	//	}


	//	@Override
	//	// triggers when a key is typed 
	//	// method: keyTyped()
	//	// description: This method is called when a key is pressed and released. It basically combines the keyPressed and
	//	//              keyReleased functions.  You can determine which key is typed using the KeyEvent object
	//	public void keyTyped(KeyEvent e) {
	//		//gets character data and stores in char c
	//		userGuess = e.getKeyChar();
	//
	//		//this could be a way to store the user's letter guess from the key typed
	//
	//		if (words[randomIndex].contains(""+userGuess)) {
	//			index = words[randomIndex].indexOf(userGuess);
	//			answer = answer.substring(0,index) + userGuess + answer.substring(index+1) ;
	//		} else {
	//			count++;
	//			guessedChars += userGuess;
	//
	//		}
	//
	//
	//
	//
	//		this.repaint();
	//
	//	}
	//	@Override
	//	// triggers once when a key is pressed, it retriggers when it is released then repressed
	//	// method: keyPressed()
	//	// description: This method is called when a key is pressed. You can determine which key is pressed using the 
	//	//		KeyEvent object.  For example if(e.getKeyCode() == KeyEvent.VK_LEFT) would test to see if
	//	//		the left key was pressed.
	//	// parameters: KeyEvent e
	//	public void keyPressed(MouseEvent e) {
	//		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
	//			count = -1;
	//			randomIndex = (int)(Math.random() * 20);
	//			guessedChars = "";
	//			answer = "_____";
	//		}
	//
	//
	//		this.repaint();
	//
	//
	//	}
	//
	//	@Override
	//	// triggers once when a key is released
	//	// method: keyReleased()
	//	// description: This method is called when a key is released. You can determine which key is released using the 
	//	//		KeyEvent object.  For example if(e.getKeyCode() == KeyEvent.VK_LEFT) would test to see if
	//	//		the left key was released.
	//	// parameters: KeyEvent e
	//
	//	public void keyReleased(KeyEvent e) {
	//
	//	}
	//
	//}

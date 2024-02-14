//add school name, group number, and individual names

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GraphicsMain extends JFrame {

	//sets up the area to draw
	public static void main(String[] args) {
		GraphicsMain window = new GraphicsMain();
        JPanel p = new JPanel();
        p.add(new GraphicsPanel());  //  add a class that extends JPanel
        window.setTitle("Girls Hackathon");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setContentPane(p);
        
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
	}
}

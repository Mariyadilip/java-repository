package gui.jframe;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Start1 {

	public static void main(String[] args) {
		
		//Jframe - A GUI window to add components to
		
		JFrame jframe = new JFrame(); //creates a frame
		jframe.setTitle("JFRAME"); //sets the title for the frame
		jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //closes the frame when hit the X button
		//jframe.setDefaultCloseOperation(jframe.HIDE_ON_CLOSE); //This is the default behaviour;
		jframe.setResizable(false); //prevent the frame from resizing
		jframe.setSize(400, 400); //set the x-dimensions and y-dimensions of the frame
		jframe.setVisible(true); //makes frame visible
		
		ImageIcon image = new ImageIcon("Myphoto.jpg"); //creates an image icon
		jframe.setIconImage(image.getImage());
		jframe.getContentPane().setBackground(new Color(0, 167, 45));
		//jframe.getContentPane().setBackground(new Color(0xffc2ad)); //hexadecimal
	}
}

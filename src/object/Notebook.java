package object;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Notebook extends Objects {
	
	
	public static int notebookX = 350;
	public static int notebookY = 120;
	public static boolean nearNotebook = false;
	
	public static BufferedImage interact;
	public static boolean interactWithObject = false;
	
	public static boolean objectFound = false;

	/*
	 * Draws the notebook object to the MainFrame frame in the form of an in-game item.
	 */
	
	public Notebook() {
		
		name = "Notebook";
		
		
		try {
			
			notebookImage = ImageIO.read(getClass().getResourceAsStream("/objects/notebook.png"));
			
			
		} catch (IOException e) {
			
			System.out.println("Cannot find necessary images. Please try again.");
			
		}
		
	}
	
}



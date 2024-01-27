package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import game.MainFrame;

public class Objects {
	
	public BufferedImage notebookImage;
	
	public String name;
	public boolean collision = false;
	public int worldX, worldY;
	
	
	public static boolean nearGreen, nearRed, nearYellow, nearBlue = false;
	
	/*
	 * Draws relevant objects to the MainFrame frame in the form of in-game items.
	 */
	public void draw(Graphics2D g2, MainFrame gp) {
		
		if (!Notebook.objectFound) {
			

			if (MainFrame.isIntro && MainFrame.isStage1Level1 == false) {
				
				g2.drawImage(notebookImage, Notebook.notebookX, Notebook.notebookY, gp.tileSize, gp.tileSize, null);
				
				
			}
					
			
		} else {
			
			
			
		}
		
		
	}
	
	
	

}

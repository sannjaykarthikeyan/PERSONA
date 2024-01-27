package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.BOSS_Abbadon;
import entity.Prologue;
import logic.CollisionDetector;
import entity.NPC_Tyler;
import entity.NPC_Jennie;
import entity.Player;
import object.Objects;
import system.KeyHandler;

public class Stage2Level2 extends Prologue {

	
	public static int dialogueCount2_1 = 0;
	
	public Stage2Level2(MainFrame gp) {

		super(gp);

	}


	/*
	 * Presents Stage 2, Level 2 of the PERSONA game
	 * Draws releveant NPCs, Objects, user dialogue, and other interactive elements to the MainFrame JPanel
	 */
	public void draw(Graphics2D g2) {
		
		g2.drawImage(Prologue.jennieImg, NPC_Jennie.Jennie_X, NPC_Jennie.Jennie_Y, 120, 120, null);
		g2.drawImage(Prologue.tylerImg, NPC_Tyler.Tyler_X - 150, NPC_Tyler.Tyler_Y, 100, 100, null);


		if (!CollisionDetector.modifyBlockBounds2_2) {

			g2.drawImage(NPC_Jennie.blue, 345, 250, 60, 60, null);

		}
		
		if (Objects.nearBlue) {

			Color h = new Color(0, 0, 0, 150);
			g2.setColor(h);
			g2.fillRoundRect(0, 0, 1000, 1000, 35, 35);

			g2.drawImage(NPC_Jennie.foundItem, 250, 150, 255, 265, null);

			if (KeyHandler.yPressed) {

				Player.canHeal = true;
				Objects.nearBlue = false;
				CollisionDetector.modifyBlockBounds2_2 = true;

			}

			if (KeyHandler.nPressed) {

				Player.canHeal = false;
				Objects.nearBlue = false;
				CollisionDetector.modifyBlockBounds2_2 = true;

			}
		}
		
		
	}

}

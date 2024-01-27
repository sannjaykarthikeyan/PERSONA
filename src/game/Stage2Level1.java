package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.BOSS_Abbadon;
import entity.Prologue;
import entity.NPC_Tyler;
import entity.NPC_Jennie;
import entity.Player;
import system.KeyHandler;

public class Stage2Level1 extends Prologue {

	
	public static int dialogueCount2_1 = 0;
	
	public Stage2Level1(MainFrame gp) {

		super(gp);

	}


	/*
	 * Presents Stage 2, Level 1 of the PERSONA game
	 * Draws releveant NPCs, Objects, user dialogue, and other interactive elements to the MainFrame JPanel
	 */
	public void draw(Graphics2D g2) {

		if (MainFrame.isStage2Level1) {

			g2.drawImage(Prologue.jennieImg, NPC_Jennie.Jennie_X, NPC_Jennie.Jennie_Y, 120, 120, null);
			g2.drawImage(Prologue.tylerImg, NPC_Tyler.Tyler_X, NPC_Tyler.Tyler_Y, 100, 100, null);

			if (MainFrame.numSeconds >= 0) {

				if (KeyHandler.mPressed) {
					dialogueCount2_1++;
					KeyHandler.mPressed = false;

				}

				if (dialogueCount2_1 == 0) {

					Player.inCutscene = true;

					Color c = new Color(0, 0, 0, 210);
					g2.setColor(c);
					g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);
					g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));
					c = new Color(255, 255, 255);

					g2.setColor(c);
					g2.setStroke(new BasicStroke(5));

					g2.drawString("Nothing here...", dialogueBoxPosX + 30, dialogueBoxPosY + 65);

				}

				if (dialogueCount2_1 == 1) {

					Color c = new Color(0, 0, 0, 210);
					g2.setColor(c);
					g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);

					c = new Color(255, 255, 255);

					g2.setColor(c);
					g2.setStroke(new BasicStroke(5));

					g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));
					g2.drawString("Yo " + Player.plrFirstName + "... Let's move on ASAP.", dialogueBoxPosX + 30, dialogueBoxPosY + 65);

				
					try {
						NPC_Tyler.tylerShocked = ImageIO.read(getClass().getResourceAsStream("/faces/tylerShocked.png"));
						NPC_Tyler.talkTyler = ImageIO.read(getClass().getResourceAsStream("/dialogueNames/tyler.png"));

					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("Cannot find necessary images. Please try again.");
					}

					g2.drawImage(NPC_Tyler.talkTyler, 30, 340, 180, 110, null);

					g2.drawImage(NPC_Tyler.tylerShocked, 500, 95, 225, 325, null);

				} else if (dialogueCount1_1 >= 3) {

					Player.inCutscene = false;

				}

			}

		}
	}

}

package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.BOSS_Abbadon;
import entity.BOSS_Tyler;
import entity.Prologue;
import entity.NPC_Tyler;
import entity.NPC_Jennie;
import entity.Player;
import object.Objects;
import system.KeyHandler;

public class Epilogue extends Prologue {

	public static int dialogueCount5_1 = 0;

	public Epilogue(MainFrame gp) {

		super(gp);

	}

	/*
	 * Presents Epilogue Level of the PERSONA game
	 * Draws releveant NPCs, Objects, user dialogue, and other interactive elements to the MainFrame JPanel
	 */
	public void draw(Graphics2D g2) {

		if (MainFrame.numSeconds >= 0) {

			if (KeyHandler.mPressed) {
				dialogueCount5_1++;
				KeyHandler.mPressed = false;

			}

			if (dialogueCount5_1 == 0) {

				Color h = new Color(0, 0, 0);
				g2.setColor(h);
				g2.fillRoundRect(0, 0, 1000, 1000, 35, 35);

				Color c = new Color(0, 0, 0, 210);
				g2.setColor(c);
				g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);
				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));
				c = new Color(255, 255, 255);

				g2.setColor(c);
				g2.setStroke(new BasicStroke(5));

				g2.drawString("Where am I?", dialogueBoxPosX + 30, dialogueBoxPosY + 65);

			}

			if (dialogueCount5_1 == 1) {

				Color h = new Color(0, 0, 0);
				g2.setColor(h);
				g2.fillRoundRect(0, 0, 1000, 1000, 35, 35);

				Color c = new Color(0, 0, 0, 210);
				g2.setColor(c);
				g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);

				c = new Color(255, 255, 255);

				g2.setColor(c);
				g2.setStroke(new BasicStroke(5));

				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));
				g2.drawString("I think we won..", dialogueBoxPosX + 30, dialogueBoxPosY + 65);

				g2.drawImage(NPC_Tyler.talkTyler, 30, 340, 180, 110, null);

				g2.drawImage(NPC_Tyler.tylerShocked, 500, 95, 225, 325, null);

			}

			if (dialogueCount5_1 == 2) {

				Color c = new Color(0, 0, 0, 210);
				g2.setColor(c);
				g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);

				c = new Color(255, 255, 255);

				g2.setColor(c);
				g2.setStroke(new BasicStroke(5));

				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));
				g2.drawString("We're back! We're finally back!", dialogueBoxPosX + 30, dialogueBoxPosY + 65);

				g2.drawImage(NPC_Jennie.talkJennie, 30, 340, 180, 110, null);

				g2.drawImage(NPC_Jennie.jennieHappy, 500, 95, 225, 325, null);

			}

			if (dialogueCount5_1 == 3) {

				Color c = new Color(0, 0, 0, 210);
				g2.setColor(c);
				g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);
				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));
				c = new Color(255, 255, 255);

				g2.setColor(c);
				g2.setStroke(new BasicStroke(5));

				g2.drawString("Wait, where were we again?", dialogueBoxPosX + 30, dialogueBoxPosY + 65);

				g2.drawString("Whatever, it's good to be back!", dialogueBoxPosX + 30, dialogueBoxPosY + 105);

				g2.drawImage(NPC_Tyler.talkTyler, 30, 340, 180, 110, null);

				g2.drawImage(NPC_Tyler.tylerHappy, 500, 95, 225, 325, null);

			}
			if (dialogueCount5_1 == 4) {

				Color c = new Color(0, 0, 0, 210);
				g2.setColor(c);
				g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);

				c = new Color(255, 255, 255);

				g2.setColor(c);
				g2.setStroke(new BasicStroke(5));

				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));

				g2.drawString("Do they not remember what happened?", dialogueBoxPosX + 30, dialogueBoxPosY + 65);

				g2.drawString("Have I escaped my fate?", dialogueBoxPosX + 30, dialogueBoxPosY + 105);

			}
			if (dialogueCount5_1 == 5) {

				Color c = new Color(0, 0, 0, 210);
				g2.setColor(c);
				g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);

				c = new Color(255, 255, 255);

				g2.setColor(c);
				g2.setStroke(new BasicStroke(5));

				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));

				g2.drawString("Well, whatever.", dialogueBoxPosX + 30, dialogueBoxPosY + 65);

				g2.drawString("All's well that ends well...", dialogueBoxPosX + 30, dialogueBoxPosY + 105);

			}

			else if (dialogueCount5_1 >= 6) {

				g2.drawImage(MainFrame.epilogue, 0, 0, 768, 576, null);

			}
		}
	}

}

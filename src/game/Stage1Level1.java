package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import entity.Prologue;
import logic.CollisionDetector;
import entity.NPC_Tyler;
import entity.NPC_Jennie;
import entity.Player;
import object.Notebook;
import object.Objects;
import system.KeyHandler;
import system.WriteTextFile;

public class Stage1Level1 extends Prologue {

//	static boolean chk1 = true;
	public Stage1Level1(MainFrame gp) {

		super(gp);
//		if (chk1) {
		// GamePanel.scenes.delete(0);

//			chk1 = false;			
		// }

	}


	/*
	 * Presents Stage 1, Level 1 of the PERSONA game
	 * Draws releveant NPCs, Objects, user dialogue, and other interactive elements to the MainFrame JPanel
	 */
	public void draw(Graphics2D g2) {

		g2.drawImage(Prologue.jennieImg, NPC_Jennie.Jennie_X, NPC_Jennie.Jennie_Y, 120, 120, null);
		g2.drawImage(Prologue.tylerImg, NPC_Tyler.Tyler_X, NPC_Tyler.Tyler_Y, 100, 100, null);

		if (!CollisionDetector.modifyBlockBounds1_1) {

			g2.drawImage(NPC_Jennie.green, 200, 250, 60, 60, null);

		}

		if (Objects.nearGreen) {

			Color h = new Color(0, 0, 0, 150);
			g2.setColor(h);
			g2.fillRoundRect(0, 0, 1000, 1000, 35, 35);

			g2.drawImage(NPC_Jennie.foundItem, 250, 150, 255, 265, null);

			if (KeyHandler.yPressed) {

				Player.canHeal = true;
				Objects.nearGreen = false;
				CollisionDetector.modifyBlockBounds1_1 = true;

			}

			if (KeyHandler.nPressed) {

				Player.canHeal = false;
				Objects.nearGreen = false;
				CollisionDetector.modifyBlockBounds1_1 = true;

			}
		}

		if (MainFrame.numSeconds >= 2) {

			if (KeyHandler.mPressed) {
				dialogueCount1_1++;
				KeyHandler.mPressed = false;

			}

			if (dialogueCount1_1 == 0) {

				Player.inCutscene = true;

				Color c = new Color(0, 0, 0, 210);
				g2.setColor(c);
				g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);
				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));
				c = new Color(255, 255, 255);

				g2.setColor(c);
				g2.setStroke(new BasicStroke(5));

				g2.drawString("What is this place?", dialogueBoxPosX + 30, dialogueBoxPosY + 65);

			}

			if (dialogueCount1_1 == 1) {

				Player.inCutscene = true;

				try {
					protagView = ImageIO.read(getClass().getResourceAsStream("/approachToTalk/protagView.png"));
					g2.drawImage(protagView, 470, -120, 350, 570, null);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Cannot find necessary images. Please try again.");
				}

				Color c = new Color(0, 0, 0, 210);
				g2.setColor(c);
				g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);

				c = new Color(255, 255, 255);

				g2.setColor(c);
				g2.setStroke(new BasicStroke(5));

				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));
				g2.drawString("Did I take a wrong turn?", dialogueBoxPosX + 30, dialogueBoxPosY + 65);

			} else if (dialogueCount1_1 == 2) {

				Player.inCutscene = true;

				Color c = new Color(0, 0, 0, 210);
				g2.setColor(c);
				g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);

				c = new Color(255, 255, 255);

				g2.setColor(c);
				g2.setStroke(new BasicStroke(5));

				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));
				g2.drawString("AHHH!", dialogueBoxPosX + 30, dialogueBoxPosY + 65);

				try {
					NPC_Jennie.jennieShocked = ImageIO.read(getClass().getResourceAsStream("/faces/jennieShocked.png"));
					NPC_Jennie.talkJennie = ImageIO.read(getClass().getResourceAsStream("/dialogueNames/jennie.png"));

				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Cannot find necessary images. Please try again.");
				}

				g2.drawImage(NPC_Jennie.talkJennie, 30, 340, 180, 110, null);

				g2.drawImage(NPC_Jennie.jennieShocked, 500, 95, 225, 325, null);

			} else if (dialogueCount1_1 == 3) {

				Player.inCutscene = true;

				Color c = new Color(0, 0, 0, 210);
				g2.setColor(c);
				g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);

				c = new Color(255, 255, 255);

				g2.setColor(c);
				g2.setStroke(new BasicStroke(5));

				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));
				g2.drawString("Yo.. This is some wacky back to school", dialogueBoxPosX + 30, dialogueBoxPosY + 65);

				g2.drawString("celebration.", dialogueBoxPosX + 30, dialogueBoxPosY + 105);

				try {
					NPC_Tyler.tylerShocked = ImageIO.read(getClass().getResourceAsStream("/faces/tylerShocked.png"));
					NPC_Tyler.talkTyler = ImageIO.read(getClass().getResourceAsStream("/dialogueNames/tyler.png"));

				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Cannot find necessary images. Please try again.");
				}

				g2.drawImage(NPC_Tyler.talkTyler, 30, 340, 180, 110, null);

				g2.drawImage(NPC_Tyler.tylerShocked, 500, 95, 225, 325, null);

			} else if (dialogueCount1_1 == 4) {

				Player.inCutscene = true;

				Color c = new Color(0, 0, 0, 210);
				g2.setColor(c);
				g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);

				c = new Color(255, 255, 255);

				g2.setColor(c);
				g2.setStroke(new BasicStroke(5));

				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));
				g2.drawString(Player.plrFirstName + "...Why do you have a sword ", dialogueBoxPosX + 30,
						dialogueBoxPosY + 65);

				g2.drawString("in your hand? ", dialogueBoxPosX + 30, dialogueBoxPosY + 105);

				try {
					NPC_Jennie.jennieShocked = ImageIO
							.read(getClass().getResourceAsStream("/faces/jennieConfused.png"));
					NPC_Jennie.talkJennie = ImageIO.read(getClass().getResourceAsStream("/dialogueNames/jennie.png"));

				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Cannot find necessary images. Please try again.");
				}

				g2.drawImage(NPC_Jennie.talkJennie, 30, 340, 180, 110, null);

				g2.drawImage(NPC_Jennie.jennieShocked, 500, 95, 225, 325, null);

			} else if (dialogueCount1_1 == 5) {

				Player.inCutscene = true;

				Color c = new Color(0, 0, 0, 210);
				g2.setColor(c);
				g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);

				c = new Color(255, 255, 255);

				g2.setColor(c);
				g2.setStroke(new BasicStroke(5));

				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));
				g2.drawString("I swear I never held these daggers", dialogueBoxPosX + 30, dialogueBoxPosY + 65);

				g2.drawString("with me.", dialogueBoxPosX + 30, dialogueBoxPosY + 105);

				try {
					NPC_Tyler.tylerShocked = ImageIO.read(getClass().getResourceAsStream("/faces/tylerShocked.png"));
					NPC_Tyler.talkTyler = ImageIO.read(getClass().getResourceAsStream("/dialogueNames/tyler.png"));

				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Cannot find necessary images. Please try again.");
				}

				g2.drawImage(NPC_Tyler.tylerShocked, 500, 95, 225, 325, null);

				g2.drawImage(NPC_Tyler.talkTyler, 30, 340, 180, 110, null);

			} else if (dialogueCount1_1 == 6) {

				Player.inCutscene = true;

				Color c = new Color(0, 0, 0, 210);
				g2.setColor(c);
				g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);
				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));
				c = new Color(255, 255, 255);

				g2.setColor(c);
				g2.setStroke(new BasicStroke(5));

				g2.drawString("It's only the three of us here...", dialogueBoxPosX + 30, dialogueBoxPosY + 65);

			} else if (dialogueCount1_1 == 7) {

				Player.inCutscene = true;

				Color c = new Color(0, 0, 0, 210);
				g2.setColor(c);
				g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);
				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));
				c = new Color(255, 255, 255);

				g2.setColor(c);
				g2.setStroke(new BasicStroke(5));

				g2.drawString("How do we escape?", dialogueBoxPosX + 30, dialogueBoxPosY + 65);

			} else if (dialogueCount1_1 >= 8) {

				Player.inCutscene = false;

			}

		}

	}

}

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
import entity.NPC_Elizabeth;
import entity.NPC_Tyler;
import entity.NPC_Jennie;
import entity.Player;
import object.Objects;
import system.KeyHandler;

public class Stage3Level1 extends Prologue {

	public static int dialogueCount3_1 = 0;

	public Stage3Level1(MainFrame gp) {

		super(gp);

	}

	/*
	 * Presents Stage 3, Level 1 of the PERSONA game
	 * Draws relevant NPCs, Objects, user dialogue, and other interactive elements to the MainFrame JPanel
	 */
	public void draw(Graphics2D g2) {

		if (MainFrame.numSeconds >= 0) {

			if (KeyHandler.mPressed) {
				dialogueCount3_1++;
				KeyHandler.mPressed = false;

			}

			if (dialogueCount3_1 == 0) {

				Player.inCutscene = true;

				Color c = new Color(0, 0, 0, 210);
				g2.setColor(c);
				g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);
				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));
				c = new Color(255, 255, 255);

				g2.setColor(c);
				g2.setStroke(new BasicStroke(5));

				g2.drawString("Where are we?", dialogueBoxPosX + 30, dialogueBoxPosY + 65);

			}

			if (dialogueCount3_1 == 1) {

				Color c = new Color(0, 0, 0, 210);
				g2.setColor(c);
				g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);

				c = new Color(255, 255, 255);

				g2.setColor(c);
				g2.setStroke(new BasicStroke(5));

				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));
				g2.drawString("Congratulations for making it", dialogueBoxPosX + 30, dialogueBoxPosY + 65);
				g2.drawString("this far, " + Player.plrFirstName, dialogueBoxPosX + 30, dialogueBoxPosY + 105);

				try {
					NPC_Elizabeth.talkElizabeth = ImageIO
							.read(getClass().getResourceAsStream("/dialogueNames/elizabeth.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Cannot find necessary images. Please try again.");
				}

				g2.drawImage(NPC_Elizabeth.talkElizabeth, 30, 340, 180, 110, null);

				g2.drawImage(NPC_Jennie.elizabeth, 500, 115, 225, 325, null);

			}

			if (dialogueCount3_1 == 2) {

				Player.inCutscene = true;

				Color c = new Color(0, 0, 0, 210);
				g2.setColor(c);
				g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);

				c = new Color(255, 255, 255);

				g2.setColor(c);
				g2.setStroke(new BasicStroke(5));

				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));
				g2.drawString("...Where are we?", dialogueBoxPosX + 30, dialogueBoxPosY + 65);

				g2.drawString("Who are you?", dialogueBoxPosX + 30, dialogueBoxPosY + 105);

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

			}

			if (dialogueCount3_1 == 3) {

				Player.inCutscene = true;

				Color c = new Color(0, 0, 0, 210);
				g2.setColor(c);
				g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);
				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));
				c = new Color(255, 255, 255);

				g2.setColor(c);
				g2.setStroke(new BasicStroke(5));
				g2.drawString("Oh right, I saw her on my way to school!", dialogueBoxPosX + 30, dialogueBoxPosY + 65);

			}
			if (dialogueCount3_1 == 4) {

				Color c = new Color(0, 0, 0, 210);
				g2.setColor(c);
				g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);

				c = new Color(255, 255, 255);

				g2.setColor(c);
				g2.setStroke(new BasicStroke(5));

				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));
				g2.drawString("You have stood victorious against the trial", dialogueBoxPosX + 30,
						dialogueBoxPosY + 65);

				g2.drawString("bestowed upon you.", dialogueBoxPosX + 30, dialogueBoxPosY + 105);

				try {
					NPC_Elizabeth.talkElizabeth = ImageIO
							.read(getClass().getResourceAsStream("/dialogueNames/elizabeth.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Cannot find necessary images. Please try again.");
				}

				g2.drawImage(NPC_Elizabeth.talkElizabeth, 30, 340, 180, 110, null);

				g2.drawImage(NPC_Jennie.elizabeth, 500, 115, 225, 325, null);

			}
			if (dialogueCount3_1 == 5) {

				Color c = new Color(0, 0, 0, 210);
				g2.setColor(c);
				g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);

				c = new Color(255, 255, 255);

				g2.setColor(c);
				g2.setStroke(new BasicStroke(5));

				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));
				g2.drawString("Please, accept this as a reward.", dialogueBoxPosX + 30, dialogueBoxPosY + 65);

				try {
					NPC_Elizabeth.talkElizabeth = ImageIO
							.read(getClass().getResourceAsStream("/dialogueNames/elizabeth.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Cannot find necessary images. Please try again.");
				}

				g2.drawImage(NPC_Elizabeth.talkElizabeth, 30, 340, 180, 110, null);

				g2.drawImage(NPC_Jennie.elizabeth, 500, 115, 225, 325, null);

			}
			if (dialogueCount3_1 == 6) {

				Color c = new Color(0, 0, 0, 210);
				g2.setColor(c);
				g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);

				c = new Color(255, 255, 255);

				g2.setColor(c);
				g2.setStroke(new BasicStroke(5));

				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));
				g2.drawString("Elizabeth gave you BLUE POTION x1.", dialogueBoxPosX + 30, dialogueBoxPosY + 65);

			}
			if (dialogueCount3_1 == 7) {

				Color c = new Color(0, 0, 0, 210);
				g2.setColor(c);
				g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);

				c = new Color(255, 255, 255);

				g2.setColor(c);
				g2.setStroke(new BasicStroke(5));

				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));
				g2.drawString("You may use it to heal in battle.", dialogueBoxPosX + 30, dialogueBoxPosY + 65);

			}
			if (dialogueCount3_1 == 8) {

				Color c = new Color(0, 0, 0, 210);
				g2.setColor(c);
				g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);

				c = new Color(255, 255, 255);

				g2.setColor(c);
				g2.setStroke(new BasicStroke(5));

				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));
				g2.drawString("However, your journey is not yet complete.", dialogueBoxPosX + 30, dialogueBoxPosY + 65);

				try {
					NPC_Elizabeth.talkElizabeth = ImageIO
							.read(getClass().getResourceAsStream("/dialogueNames/elizabeth.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Cannot find necessary images. Please try again.");
				}

				g2.drawImage(NPC_Elizabeth.talkElizabeth, 30, 340, 180, 110, null);

				g2.drawImage(NPC_Jennie.elizabeth, 500, 115, 225, 325, null);

			}
			if (dialogueCount3_1 == 9) {

				Color c = new Color(0, 0, 0, 210);
				g2.setColor(c);
				g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);

				c = new Color(255, 255, 255);

				g2.setColor(c);
				g2.setStroke(new BasicStroke(5));

				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));
				g2.drawString("Your final battle will be with me.", dialogueBoxPosX + 30, dialogueBoxPosY + 65);

				try {
					NPC_Elizabeth.talkElizabeth = ImageIO
							.read(getClass().getResourceAsStream("/dialogueNames/elizabeth.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Cannot find necessary images. Please try again.");
				}

				g2.drawImage(NPC_Elizabeth.talkElizabeth, 30, 340, 180, 110, null);

				g2.drawImage(NPC_Jennie.elizabeth, 500, 115, 225, 325, null);

			}
			if (dialogueCount3_1 == 10) {

				Player.inCutscene = true;

				Color c = new Color(0, 0, 0, 210);
				g2.setColor(c);
				g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);

				c = new Color(255, 255, 255);

				g2.setColor(c);
				g2.setStroke(new BasicStroke(5));

				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));
				g2.drawString("You're the one who put us up to this?", dialogueBoxPosX + 30, dialogueBoxPosY + 65);

				g2.drawString("Who are you?", dialogueBoxPosX + 30, dialogueBoxPosY + 105);

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

			}

			else if (dialogueCount3_1 >= 11) {

				MainFrame.isFinalBoss = true;
				MainFrame.isStage3Level1 = false;
				MainFrame.scenes.header = MainFrame.scenes.header.getNext();

			}
		}

	}

}

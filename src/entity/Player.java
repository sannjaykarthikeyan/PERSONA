package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.MainFrame;
import system.KeyHandler;

public class Player extends Prologue {

	public static int num = 0;

	MainFrame gp;
	public static int x;
	public static int y;
	KeyHandler keyH;

	public static int HP = 300;
	public static int MP = 300;
	
	public static boolean canHeal = false;

	public static boolean inCutscene = false;

	public static String plrFirstName = "FIRSTNAME";

	public static String plrLastName = "LASTNAME";

	public static int level = 1;

	
	
	public Player(MainFrame gp, KeyHandler keyH) {

		super(gp);

		this.gp = gp;
		this.keyH = keyH;

		setDefaultValues();
		getPlayerImage();

	}

	public void setDefaultValues() {

		x = 215;
		y = 270;
		speed = 4;
		direction = "down";

	}

	/*
	 * Imports image data for the player to be drawn on the screen
	 */
	public void getPlayerImage() {

		try {

			up1 = ImageIO.read(getClass().getResourceAsStream("/protag/up1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/protag/up2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/protag/down1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/protag/down2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/protag/left1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/protag/left2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/protag/right1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/protag/right2.png"));
			idle1 = ImageIO.read(getClass().getResourceAsStream("/protag/idle1.png"));
			idle2 = ImageIO.read(getClass().getResourceAsStream("/protag/idle2.png"));

		} catch (IOException e) {

			System.out.println("Cannot find necessary images. Please try again.");

		}

	}

	/*
	 * Handles idle animations for player
	 * Animates the player's movement as they move up, down, left/right across the ap
	 */
	public void update() {

		if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true
				|| keyH.rightPressed == true) {

			if (keyH.upPressed == true) {
				direction = "up";
				Player.y -= speed;

			} else if (keyH.downPressed == true) {
				direction = "down";
				Player.y += speed;

			} else if (keyH.leftPressed == true) {
				direction = "left";
				Player.x -= speed;

			} else if (keyH.rightPressed == true) {
				direction = "right";
				Player.x += speed;

			}

			spriteCounter++;
			if (spriteCounter > 12) {

				if (spriteNum == 1) {

					spriteNum = 2;

				}

				else if (spriteNum == 2) {

					spriteNum = 1;

				}
				spriteCounter = 0;

			}

			// IDLE ANIMATIONS FOR PROTAGONIST
		} else {

			direction = "idle";

			spriteCounter++;
			if (spriteCounter > 12) {

				if (spriteNum == 1) {

					spriteNum = 2;

				}

				else if (spriteNum == 2) {

					spriteNum = 1;

				}
				spriteCounter = 0;

			}

		}

	}

	public void draw(Graphics2D g2) {

		BufferedImage image = null;
		switch (direction) {

		case "up":

			if (spriteNum == 1) {

				image = up1;

			}

			if (spriteNum == 2) {

				image = up2;

			}
			break;

		case "down":

			if (spriteNum == 1) {

				image = down1;

			}

			if (spriteNum == 2) {

				image = down2;

			}
			break;

		case "left":

			if (spriteNum == 1) {

				image = left1;

			}

			if (spriteNum == 2) {

				image = left2;

			}

			break;

		case "right":

			if (spriteNum == 1) {

				image = right1;

			}

			if (spriteNum == 2) {

				image = right2;

			}

			break;

		case "idle":

			if (spriteNum == 1) {

				image = idle1;

			}

			if (spriteNum == 2) {

				image = idle2;

			}

			break;

		}
		
		if (!MainFrame.isEpilogue && !MainFrame.isStage3Level1 && Player.HP >= 0) {
			

			if (Prologue.startBossFight && Prologue.partyTurn == 0) {

				g2.drawImage(image, 10, 310, 250, 250, null);

				KeyHandler.downPressed = false;

				KeyHandler.leftPressed = false;

				KeyHandler.upPressed = false;

				KeyHandler.rightPressed = false;

			} else if (Prologue.startBossFight && Prologue.partyTurn == 1) {

			} else if (Prologue.startBossFight && Prologue.partyTurn == 2) {
				
			}else if (Prologue.startBossFight && Prologue.partyTurn == 3) {
				

				g2.drawImage(image, 120, 300, 260, 260, null);
				
				
			

			} else {

				g2.drawImage(image, x, y, 100, 100, null);

			}


			
		}
	}

}

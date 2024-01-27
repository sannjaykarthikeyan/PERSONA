package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import game.MainFrame;

public class NPC_Elizabeth extends Prologue {

	public static int Elizabeth_X = 371;
	public static int Elizabeth_Y = 200;
	public static BufferedImage approach_Elizabeth;
	public static BufferedImage talkElizabeth;
	public static boolean nearElizabeth = false;

	public NPC_Elizabeth(MainFrame gp) {

		super(gp);
		direction = "down";
		speed = 8;
		getImage();
		setAction();

	}

	// dialogue for NPC 1: Jennie
	public static int dialogueOptionJennie = 0;
	public String[] dialogueJennie = new String[10];

	public void setDialogueJennie() {

		dialogueJennie[0] = "Hey there, " + Player.plrFirstName + "!/nReady for your first day of school?";

	}


	/*
	 * Imports image data for the entity to be drawn on the screen
	 */
	public void getImage() {

		try {

			idleElizabeth1 = ImageIO.read(getClass().getResourceAsStream("/elizabeth/idle1.png"));
			idleElizabeth2 = ImageIO.read(getClass().getResourceAsStream("/elizabeth/idle2.png"));

			approach_Elizabeth = ImageIO.read(getClass().getResourceAsStream("/approachToTalk/talkToJennie.png"));

		} catch (IOException e) {

			System.out.println("CANNOT ACCESS IMAGE.");

		}

	}

	/*
	 * Handles idle animations for entity
	 * Animates the entity's movement as they move up, down, left/right across the ap
	 */
	
	public void setAction() {

		actionLockCounter++;

		if (actionLockCounter == 300) {

			Random random = new Random();
			int i = random.nextInt(100) + 1;

			if (i <= 25) {

				direction = "up";
				Elizabeth_Y -= speed;

			}
			if (i > 25 && i <= 50) {

				direction = "down";

				Elizabeth_Y += speed;

			}
			if (i > 50 && i <= 75) {

				direction = "left";
				Elizabeth_X -= speed;

			}
			if (i > 75 && i <= 100) {

				direction = "right";
				Elizabeth_X += speed;

			}

			actionLockCounter = 0;

		}

	}

}

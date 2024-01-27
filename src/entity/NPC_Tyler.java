package entity;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import game.MainFrame;

public class NPC_Tyler extends Prologue {

	public static int MP = 200;
	public static int Tyler_X = 631;
	public static int Tyler_Y = 258;
	public static BufferedImage approach_Tyler;
	public static BufferedImage talkTyler;
	public static boolean nearTyler = false;

	public static int HP = 150;

	public static BufferedImage tylerShocked;

	public static BufferedImage tylerHappy;

	public NPC_Tyler(MainFrame gp) {

		super(gp);
		direction = "down";
		speed = 8;
		getImage();
		setAction();

	}

	/*
	 * Imports image data for the entity to be drawn on the screen
	 */
	
	public void getImage() {

		try {

			approach_Tyler = ImageIO.read(getClass().getResourceAsStream("/approachToTalk/talkToJennie.png"));

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

		if (actionLockCounter == 180) {

			Random random = new Random();
			int i = random.nextInt(100) + 1;

			if (i <= 25) {

				direction = "up";
				Tyler_Y -= speed;

			}
			if (i > 25 && i <= 50) {

				direction = "down";

				Tyler_Y += speed;

			}
			if (i > 50 && i <= 75) {

				direction = "left";
				Tyler_X -= speed;

			}
			if (i > 75 && i <= 100) {

				direction = "right";
				Tyler_X += speed;

			}

			actionLockCounter = 0;

		}

	}

}

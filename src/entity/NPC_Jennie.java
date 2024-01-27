package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import game.MainFrame;

public class NPC_Jennie extends Prologue {

	public static int MP = 200;
	public static int dialogueOptionJennie = 0;
	public static int Jennie_X = 450;
	public static int Jennie_Y = 340;
	public static BufferedImage approach_Jennie;
	public static BufferedImage talkJennie;

	public static BufferedImage elizabeth;
	
	public static BufferedImage jennieHappy;

	public static BufferedImage areYouReady;

	public static BufferedImage foundItem;

	public static int HP = 150;

	public static BufferedImage jennieShocked;

	public static BufferedImage protagPersonasList;

	public static BufferedImage jenniePersonasList;

	public static BufferedImage tylerPersonasList;
	
	public static BufferedImage green, yellow, red40, blue, results;

	public static boolean nearJennie = false;

	public NPC_Jennie(MainFrame gp) {

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

			up1 = ImageIO.read(getClass().getResourceAsStream("/jennie/up1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/jennie/up2.png"));
		//	down1 = ImageIO.read(getClass().getResourceAsStream("/jennie/down1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/jennie/down2.png"));

			foundItem = ImageIO.read(getClass().getResourceAsStream("/jennie/down2.png"));
			areYouReady = ImageIO.read(getClass().getResourceAsStream("/jennie/areYouReady.png"));

			idleTyler1 = ImageIO.read(getClass().getResourceAsStream("/tyler/idle1.png"));
			idleTyler2 = ImageIO.read(getClass().getResourceAsStream("/tyler/idle2.png"));

			idleElizabeth1 = ImageIO.read(getClass().getResourceAsStream("/elizabeth/idle1.png"));
			idleElizabeth2 = ImageIO.read(getClass().getResourceAsStream("/elizabeth/idle2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/jennie/right1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/jennie/right2.png"));

			idleJennie1 = ImageIO.read(getClass().getResourceAsStream("/jennie/idle1.png"));
			idleJennie2 = ImageIO.read(getClass().getResourceAsStream("/jennie/idle2.png"));

			abbadonIdle1 = ImageIO.read(getClass().getResourceAsStream("/bosses/abbadonIdle1.png"));
			abbadonIdle2 = ImageIO.read(getClass().getResourceAsStream("/bosses/abbadonIdle2.png"));

			approach_Jennie = ImageIO.read(getClass().getResourceAsStream("/approachToTalk/talkToJennie.png"));

			tedIdle1 = ImageIO.read(getClass().getResourceAsStream("/bosses/tedIdle1.png"));
			tedIdle2 = ImageIO.read(getClass().getResourceAsStream("/bosses/tedIdle2.png"));

			protagPersonasList = ImageIO.read(getClass().getResourceAsStream("/battleHUD/protagPersonaMenu.png"));
			jenniePersonasList = ImageIO.read(getClass().getResourceAsStream("/battleHUD/jenniePersonaMenu.png"));
			tylerPersonasList = ImageIO.read(getClass().getResourceAsStream("/battleHUD/tylerPersonaMenu.png"));
			
			green = ImageIO.read(getClass().getResourceAsStream("/objects/green.png"));
			yellow = ImageIO.read(getClass().getResourceAsStream("/objects/yellow.png"));
			red40 = ImageIO.read(getClass().getResourceAsStream("/objects/red40.png"));
			blue = ImageIO.read(getClass().getResourceAsStream("/objects/blue.png"));
			
			results = ImageIO.read(getClass().getResourceAsStream("/jennie/resultsScreen.png"));
			
			elizabeth = ImageIO.read(getClass().getResourceAsStream("/faces/elizabeth.png"));
			 
			
			
		} catch (IOException e) {

			System.out.println("Cannot find necessary images. Please try again.");

		}

	}

	/*
	 * Handles idle animations for entity
	 * Animates the entity's movement as they move up, down, left/right across the ap
	 */
	public void setAction() {

		actionLockCounter++;

		if (actionLockCounter == 120) {

			Random random = new Random();
			int i = random.nextInt(100) + 1;

			if (i <= 25) {

				direction = "up";
				Jennie_Y -= speed;

			}
			if (i > 25 && i <= 50) {

				direction = "down";

				Jennie_Y += speed;

			}
			if (i > 50 && i <= 75) {

				direction = "left";
				Jennie_X -= speed;

			}
			if (i > 75 && i <= 100) {

				direction = "right";
				Jennie_X += speed;

			}

			actionLockCounter = 0;

		}

	}

}

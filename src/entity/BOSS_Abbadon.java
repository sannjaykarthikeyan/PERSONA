package entity;

import java.io.IOException;

import javax.imageio.ImageIO;

import game.MainFrame;

public class BOSS_Abbadon extends Prologue {

	public static int Abbadon_X = 371;
	public static int Abbadon_Y = 200;

	public static boolean bossTurn = false;

	public static int HP = 300;

	public BOSS_Abbadon(MainFrame gp) {
		super(gp);
		getImage();

	}

	/*
	 * Imports image data for the entity to be drawn on the screen
	 */
	public void getImage() {

		try {

			abbadonIdle1 = ImageIO.read(getClass().getResourceAsStream("/bosses/abbadonIdle1.png"));
			abbadonIdle2 = ImageIO.read(getClass().getResourceAsStream("/bosses/abbadonIdle2.png"));

		} catch (IOException e) {

			System.out.println("Cannot find necessary images. Please try again.");

		}

	}

}

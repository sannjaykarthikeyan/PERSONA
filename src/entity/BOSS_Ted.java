package entity;

import java.io.IOException;

import javax.imageio.ImageIO;

import game.MainFrame;

public class BOSS_Ted extends Prologue {

	public static int Ted_X = 370;
	public static int Ted_Y = 200;

	public static boolean bossTurn = false;

	public static int HP = 100;

	public BOSS_Ted(MainFrame gp) {

		super(gp);

		getImage();

	}

	/*
	 * Imports image data for the entity to be drawn on the screen
	 */
	public void getImage() {

		try {

			tedIdle1 = ImageIO.read(getClass().getResourceAsStream("/bosses/tedIdle1.png"));
			tedIdle2 = ImageIO.read(getClass().getResourceAsStream("/bosses/tedIdle2.png"));

		} catch (IOException e) {

			System.out.println("Cannot find necessary images. Please try again.");

		}

	}

}

package entity;

import java.io.IOException;

import javax.imageio.ImageIO;

import game.MainFrame;

public class BOSS_Elizabeth extends Prologue {

	public static int Elizabeth_X = 370;
	public static int Elizabeth_Y = 200;

	public static boolean bossTurn = false;

	public static int HP = 500;

	public BOSS_Elizabeth(MainFrame gp) {

		super(gp);

		getImage();

	}

	/*
	 * Imports image data for the entity to be drawn on the screen
	 */
	public void getImage() {

	}

}

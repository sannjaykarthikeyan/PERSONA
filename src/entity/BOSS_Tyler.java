package entity;

import java.io.IOException;

import javax.imageio.ImageIO;

import game.MainFrame;

public class BOSS_Tyler extends Prologue {

	public static int Tyler_X = 470;
	public static int Tyler_Y = 200;

	public static boolean bossTurn = false;

	public static int HP = 300;

	public BOSS_Tyler(MainFrame gp) {

		super(gp);

		getImage();

	}

	/*
	 * Imports image data for the entity to be drawn on the screen
	 */
	public void getImage() {

	}

}

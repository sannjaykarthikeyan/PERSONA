package system;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entity.Prologue;
import entity.NPC_Elizabeth;
import entity.NPC_Jennie;
import game.Stage1Level1;
import game.Stage1Level2;
import game.Stage1Level3;
import menus.PauseMenu;

public class KeyHandler implements KeyListener {

	public static boolean upPressed;
	public static boolean downPressed;
	public static boolean leftPressed;
	public static boolean rightPressed;

	public static boolean tPressed;
	public static boolean mPressed;

	public static boolean yPressed = false;
	public static boolean nPressed = false;
	public static boolean zPressed;

	public static boolean vPressed;

	public static boolean onePressed;
	public static boolean twoPressed;
	public static boolean pPressed;
	public static boolean threePressed;
	
	public static boolean xPressed;
	public static boolean jPressed;
	public static boolean kPressed;
	public static boolean lPressed;
	
	public static boolean cPressed;
	

	@Override
	/*
	 * Detects if a key is typed by the user
	 */
	public void keyTyped(KeyEvent e) {

	}

	@Override
	/*
	 * Detects if a key is pressed by the user
	 */
	public void keyPressed(KeyEvent e) {

		int code = e.getKeyCode();

		if (code == KeyEvent.VK_X) {
			
			xPressed = true;
			
		}
		
		
		if (code == KeyEvent.VK_J) {
			
			jPressed = true;
			
		}
		
		if (code == KeyEvent.VK_C) {
			
			cPressed = true;
			
		}
		
		if (code == KeyEvent.VK_K) {
			
			kPressed = true;
			
		}
		
		if (code == KeyEvent.VK_L) {
			
			lPressed = true;
			
		}
		
		
		if (code == KeyEvent.VK_P) {

			pPressed = true;
			if (pPressed && !Stage1Level1.isBossFight && !Stage1Level2.isBossFight && !Stage1Level3.isBossFight) {

				PauseMenu.main();

			}

		}

		if (code == KeyEvent.VK_W) {

			upPressed = true;

		}

		if (code == KeyEvent.VK_V) {

			vPressed = true;

		}

		if (code == KeyEvent.VK_T) {

			tPressed = true;

		}

		if (code == KeyEvent.VK_M) {

			mPressed = true;

		}

		if (code == KeyEvent.VK_Z) {

			zPressed = true;

		}

		if (code == KeyEvent.VK_A) {

			leftPressed = true;

		}

		if (code == KeyEvent.VK_S) {

			downPressed = true;

		}

		if (code == KeyEvent.VK_D) {

			rightPressed = true;

		}

		if (code == KeyEvent.VK_1) {

			onePressed = true;

		}

		if (code == KeyEvent.VK_2) {

			twoPressed = true;

		}

		if (code == KeyEvent.VK_3) {

			threePressed = true;

		}

		if (code == KeyEvent.VK_Y) {

			yPressed = true;

		}

		if (code == KeyEvent.VK_N) {

			nPressed = true;

		}

	}

	@Override
	/*
	 * Detects if a key that was previously pressed by the user is now released
	 */
	public void keyReleased(KeyEvent e) {

		int code = e.getKeyCode();

		if (code == KeyEvent.VK_W) {

			upPressed = false;

		}

		if (code == KeyEvent.VK_A) {

			leftPressed = false;

		}

		if (code == KeyEvent.VK_S) {

			downPressed = false;

		}

		if (code == KeyEvent.VK_D) {

			rightPressed = false;

		}

		if (code == KeyEvent.VK_Y) {

			yPressed = false;

		}

		if (code == KeyEvent.VK_N) {

			nPressed = false;

		}

		if (code == KeyEvent.VK_Z) {

			zPressed = false;

		}

		if (code == KeyEvent.VK_V) {

			vPressed = false;

		}

	}

}

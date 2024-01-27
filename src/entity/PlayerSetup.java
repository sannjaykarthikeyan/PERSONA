package entity;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import game.MainFrame;

public class PlayerSetup {

	/*
	 * Creates a JPanel for game content (i.e. scenes, objects) to be updated. This
	 * method is called if the game is started besides creating a new game (i.e.
	 * loading a previous game)
	 */
	public static void gameStart() {

		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);

		MainFrame gamePanel = new MainFrame();
		window.add(gamePanel);

		window.pack();

		window.setLocationRelativeTo(null);
		window.setVisible(true);

		gamePanel.setupGame();
		gamePanel.startGameThread();

	}

	public static void main() {

		gameStart();

	}

}

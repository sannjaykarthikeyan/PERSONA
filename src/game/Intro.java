package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Intro {
	static boolean chk1 = true;
	public static boolean returnToMenu = false;
	public static JFrame window = new JFrame();

	/*
	 * Creates a JPanel for game content (i.e. scenes, objects) to be updated.
	 */
	public static void gameStart() {

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);

		window.setTitle("PERSONA");

		MainFrame gamePanel = new MainFrame();
		window.add(gamePanel);

		window.pack();

		window.setLocationRelativeTo(null);

		window.setVisible(true);

		gamePanel.setupGame();
		gamePanel.startGameThread();

	}

}

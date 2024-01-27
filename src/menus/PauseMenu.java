package menus;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import game.MainFrame;
import game.Intro;
import java.awt.Color;
import java.awt.Font;

public class PauseMenu extends JFrame {

	static int menuChoice = 0;

	public static PauseMenu frame = new PauseMenu();

	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {

				try {
					frame.setVisible(true);
				} catch (Exception e) {
					System.out.println("Cannot find necessary images. Please try again.");
				}
			}
		});
	}

	/*
	 * Pauses the game for the user to select between the following options.
	 * Save Game: Allows user to save game
	 * Load game: Allows user to load existing game data
	 * Controls: Allows user to view Controls
	 * Exit Game: Exits game without saving user progress
	 */
	public PauseMenu() {

		this.setSize(450, 450);
		this.setLocationRelativeTo(null);
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		getContentPane().setLayout(null);

		JButton controls = new JButton("CONTROLS");
		controls.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 25));
		controls.setBackground(new Color(255, 0, 0));
		controls.setForeground(new Color(255, 255, 255));
		controls.setBounds(75, 25, 300, 50);
		getContentPane().add(controls);

		controls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == controls) {

					Controls.main();

				}

			}

		});

		JButton saveGame = new JButton("SAVE GAME");
		saveGame.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 25));
		saveGame.setForeground(new Color(255, 255, 255));
		saveGame.setBackground(new Color(255, 0, 0));
		saveGame.setBounds(75, 125, 300, 50);
		getContentPane().add(saveGame);

		saveGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == saveGame) {

					SaveMenu.main();

				}

			}

		});

		JButton returnToMenu = new JButton("EXIT GAME");
		returnToMenu.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 25));
		returnToMenu.setForeground(new Color(255, 255, 255));
		returnToMenu.setBackground(new Color(255, 0, 0));
		returnToMenu.setBounds(75, 325, 300, 50);
		getContentPane().add(returnToMenu);

		JButton loadSave = new JButton("LOAD");
		loadSave.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 25));
		loadSave.setBackground(new Color(255, 0, 0));
		loadSave.setForeground(new Color(255, 255, 255));
		loadSave.setBounds(75, 225, 300, 50);
		getContentPane().add(loadSave);

		returnToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == returnToMenu) {

					System.exit(0);

				}

			}

		});

		loadSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == loadSave) {

					LoadMenu.main();

				}

			}

		});

		JLabel background1 = new JLabel("bkg1");
		background1.setBounds(0, 0, 500, 500);
		background1.setIcon(new ImageIcon("bkg/backdrop.png"));
		getContentPane().add(background1);

	}
}

package menus;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import game.Intro;
import system.SoundPlayer;

import javax.swing.JButton;

import java.util.Random;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Color;
import java.awt.Font;

public class Client extends JFrame {

	static int menuChoice = 0;
	public static LocalDateTime date = LocalDateTime.now();
	public static DateTimeFormatter obj = DateTimeFormatter.ofPattern("HH:MM:SSS");

	public static String formattedDate = Client.date.format(obj);

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				Random random = new Random();

				menuChoice = random.nextInt(3);

				try {

					Client frame = new Client();
					frame.setVisible(true);

				} catch (Exception e) {
					System.out.println("Cannot find necessary images. Please try again.");
				}
			}
		});
	}

	/*
	 * Client class containing title page and main menu for user to start game, load
	 * game, or view controls.
	 */
	public Client() {

		this.setSize(1280, 720);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		JLabel background1 = new JLabel("bkg1");
		background1.setBounds(0, 0, 1280, 720);
		background1.setIcon(new ImageIcon("bkg/test.png"));
		getContentPane().add(background1);

		JButton goToMenu = new JButton("MAIN MENU");
		goToMenu.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 17));
		goToMenu.setBackground(new Color(255, 0, 0));
		goToMenu.setForeground(new Color(255, 255, 255));
		goToMenu.setBounds(575, 500, 150, 50);
		getContentPane().add(goToMenu);

		JButton controls = new JButton("CONTROLS");
		controls.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 27));
		controls.setForeground(new Color(0, 0, 0));
		controls.setBackground(new Color(255, 255, 255));
		controls.setBounds(910, 590, 300, 60);
		getContentPane().add(controls);
		controls.setVisible(false);

		JButton newGame = new JButton("NEW GAME");
		newGame.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 27));
		newGame.setForeground(new Color(255, 255, 255));
		newGame.setBackground(new Color(255, 0, 0));
		newGame.setVisible(false);

		newGame.setBounds(860, 410, 350, 60);
		getContentPane().add(newGame);

		JButton loadSave = new JButton("LOAD GAME");
		loadSave.setBackground(new Color(0, 0, 0));
		loadSave.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 27));
		loadSave.setForeground(new Color(255, 0, 0));
		loadSave.setBounds(860, 500, 350, 60);
		getContentPane().add(loadSave);
		loadSave.setVisible(false);

		goToMenu.setVisible(true);

		goToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == goToMenu) {

					goToMenu.setVisible(false);
					controls.setVisible(true);
					newGame.setVisible(true);
					loadSave.setVisible(true);

					JLabel background = new JLabel("bkg");
					background.setBounds(0, 0, 1280, 720);

					getContentPane().add(background);
					background.setVisible(true);
					background1.setVisible(false);

					if (menuChoice == 0) {

						background.setIcon(new ImageIcon("mainMenus/menu1.png"));

					} else if (menuChoice == 1) {

						background.setIcon(new ImageIcon("mainMenus/menu2.png"));

					} else {

						background.setIcon(new ImageIcon("mainMenus/menu3.png"));

					}

				}

			}

		});

		getContentPane().setLayout(null);

		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == newGame) {

					WelcomeWindow.main();

				}

			}

		});

		controls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == controls) {

					Controls.main();

				}

			}

		});

		loadSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == loadSave) {

					LoadMenu.main();
					Intro.gameStart();

				}

			}

		});

	}
}

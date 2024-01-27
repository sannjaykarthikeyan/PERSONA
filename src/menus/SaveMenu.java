package menus;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import entity.Player;
import game.MainFrame;
import game.Intro;
import system.WriteTextFile;
import java.awt.Color;
import java.awt.Font;

public class SaveMenu extends JFrame {

	static int menuChoice = 0;

	public static SaveMenu frame = new SaveMenu();

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
	 * Saves game data (player level, last saved, player HP, player MP) into 3 slots
	 * Each slot overwrites an existing text file with save data for future access.
	 */
	public SaveMenu() {

		
		this.setSize(450, 450);
		this.setLocationRelativeTo(null);
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		getContentPane().setLayout(null);

		JButton save1 = new JButton("Save to Slot #1");
		save1.setFont(new Font("Verdana", Font.BOLD, 27));
		save1.setBackground(new Color(255, 0, 0));
		save1.setForeground(new Color(255, 255, 255));
		save1.setBounds(46, 36, 350, 75);
		getContentPane().add(save1);

		JButton save2 = new JButton("Save to Slot #2");
		save2.setFont(new Font("Verdana", Font.BOLD, 27));
		save2.setBackground(new Color(255, 0, 0));
		save2.setForeground(new Color(255, 255, 255));
		save2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		save2.setBounds(46, 155, 350, 75);
		getContentPane().add(save2);

		JButton save3 = new JButton("Save to Slot #3");
		save3.setFont(new Font("Verdana", Font.BOLD, 27));
		save3.setForeground(new Color(255, 255, 255));
		save3.setBackground(new Color(255, 0, 0));
		save3.setBounds(46, 289, 350, 75);
		getContentPane().add(save3);

		JLabel gameData1 = new JLabel("Game Data Saved");
		gameData1.setFont(new Font("Verdana", Font.BOLD, 11));
		gameData1.setForeground(new Color(255, 255, 255));
		gameData1.setBounds(165, 375, 161, 14);
		getContentPane().add(gameData1);
		gameData1.setVisible(false);

		JLabel gameData2 = new JLabel("Game Data Saved");
		gameData2.setFont(new Font("Verdana", Font.BOLD, 11));
		gameData2.setForeground(new Color(255, 255, 255));
		gameData2.setBounds(165, 241, 161, 14);
		getContentPane().add(gameData2);
		gameData2.setVisible(false);

		JLabel gameData3 = new JLabel("Game Data Saved");
		gameData3.setFont(new Font("Verdana", Font.BOLD, 11));
		gameData3.setForeground(new Color(255, 255, 255));
		gameData3.setBounds(165, 116, 161, 14);
		getContentPane().add(gameData3);
		gameData3.setVisible(false);

		save1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == save1) {

					WriteTextFile.write("save1.txt", "PLRLVL" + Player.level + "\n" + LocalDate.now() + "\n" + "PLRHP"
							+ Player.HP + "\n" + "PLRMP" + Player.MP + "\n" + Client.formattedDate, false);
					gameData3.setVisible(true);
				}

			}

		});

		save2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == save2) {

					WriteTextFile.write("save2.txt", "PLRLVL" + Player.level + "\n" + LocalDate.now() + "\n" + "PLRHP"
							+ Player.HP + "\n" + "PLRMP" + Player.MP + "\n" + Client.formattedDate, false);
					gameData2.setVisible(true);

				}

			}

		});

		save3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == save3) {

					WriteTextFile.write("save3.txt", "PLRLVL" + Player.level + "\n" + LocalDate.now() + "\n" + "PLRHP"
							+ Player.HP + "\n" + "PLRMP" + Player.MP + "\n" + Client.formattedDate, false);
					gameData1.setVisible(true);
				}

			}

		});

		JLabel background1 = new JLabel("bkg1");
		background1.setBounds(0, 0, 500, 500);
		background1.setIcon(new ImageIcon("bkg/backdrop.png"));
		getContentPane().add(background1);

	}
}

package menus;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import entity.Player;
import game.MainFrame;
import game.Intro;
import game.Stage1Level2;
import system.ReadTextFile;
import system.WriteTextFile;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

public class LoadMenu extends JFrame {

	public static LoadMenu frame = new LoadMenu();
	private JTextField getLvlSave;

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
	 * Loads game data (player level, last saved, player HP, player MP) into 3 slots
	 * Each slot overwrites an existing text file with save data for future access.
	 */
	
	public LoadMenu() {
		getContentPane().setBackground(new Color(0, 0, 0));

		this.setSize(650, 650);
		this.setLocationRelativeTo(null);
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		getContentPane().setLayout(null);

		JButton load1 = new JButton();
		load1.setBackground(new Color(255, 0, 0));
		load1.setForeground(new Color(255, 255, 255));
		load1.setFont(new Font("Verdana", Font.BOLD, 27));
		load1.setText("Load 1");
		load1.setBounds(145, 35, 350, 75);
		getContentPane().add(load1);

		JButton load2 = new JButton("Load 2");
		load2.setFont(new Font("Verdana", Font.BOLD, 27));
		load2.setForeground(new Color(255, 255, 255));
		load2.setBackground(new Color(255, 0, 0));
		load2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		load2.setBounds(145, 155, 350, 75);
		getContentPane().add(load2);

		JButton load3 = new JButton("Load 3");
		load3.setFont(new Font("Verdana", Font.BOLD, 27));
		load3.setForeground(new Color(255, 255, 255));
		load3.setBackground(new Color(255, 0, 0));
		load3.setBounds(145, 289, 350, 75);
		getContentPane().add(load3);

		JLabel gameData1 = new JLabel("Game Data Loaded");
		gameData1.setForeground(new Color(255, 255, 255));
		gameData1.setBackground(new Color(255, 255, 255));
		gameData1.setFont(new Font("Verdana", Font.BOLD, 11));
		gameData1.setBounds(275, 375, 161, 14);
		getContentPane().add(gameData1);
		gameData1.setVisible(false);

		JLabel gameData2 = new JLabel("Game Data Loaded");
		gameData2.setFont(new Font("Verdana", Font.BOLD, 11));
		gameData2.setForeground(new Color(255, 255, 255));
		gameData2.setBounds(275, 241, 161, 14);
		getContentPane().add(gameData2);
		gameData2.setVisible(false);

		JLabel gameData3 = new JLabel("Game Data Loaded");
		gameData3.setForeground(new Color(255, 255, 255));
		gameData3.setFont(new Font("Verdana", Font.BOLD, 11));
		gameData3.setBackground(new Color(255, 255, 255));
		gameData3.setBounds(275, 121, 161, 14);
		getContentPane().add(gameData3);
		gameData3.setVisible(false);

		load1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == load1) {

					FileReader file;
					BufferedReader buffer;
					String input;

					try // attempt to read from input stream
					{
						file = new FileReader("save1.txt");
						buffer = new BufferedReader(file);

						while ((input = buffer.readLine()) != null) {
							System.out.println(input);

							if (input.contains("PLRLVL")) {

								Player.level = Integer.parseInt(input.replaceAll("PLRLVL", ""));

							}

							if (input.contains("PLRHP")) {

								Player.HP = Integer.parseInt(input.replaceAll("PLRHP", ""));

							}

							if (input.contains("PLRMP")) {

								Player.MP = Integer.parseInt(input.replaceAll("PLRMP", ""));

							}
						}

					}
					// catch the error an print an error message
					// catch the error an print an error message
					catch (IOException err) {
						System.out.println("error");
					}

					load1.setVisible(true);
					load2.setVisible(true);
					load3.setVisible(true);
				}
			}

		});

		load2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == load2) {

					FileReader file;
					BufferedReader buffer;
					String input;

					try // attempt to read from input stream
					{
						file = new FileReader("save1.txt");
						buffer = new BufferedReader(file);

						while ((input = buffer.readLine()) != null) {
							System.out.println(input);

							if (input.contains("PLRLVL")) {

								Player.level = Integer.parseInt(input.replaceAll("PLRLVL", ""));

							}

							if (input.contains("PLRHP")) {

								Player.HP = Integer.parseInt(input.replaceAll("PLRHP", ""));

							}

							if (input.contains("PLRMP")) {

								Player.MP = Integer.parseInt(input.replaceAll("PLRMP", ""));

							}
						}

					}
					// catch the error an print an error message
					// catch the error an print an error message
					catch (IOException err) {
						System.out.println("error");
					}

				}

				load1.setVisible(true);
				load2.setVisible(true);
				load3.setVisible(true);

			}

		});

		load3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == load3) {

					FileReader file;
					BufferedReader buffer;
					String input;

					try // attempt to read from input stream
					{
						file = new FileReader("save1.txt");
						buffer = new BufferedReader(file);

						while ((input = buffer.readLine()) != null) {
							System.out.println(input);

							if (input.contains("PLRLVL")) {

								Player.level = Integer.parseInt(input.replaceAll("PLRLVL", ""));

							}

							if (input.contains("PLRHP")) {

								Player.HP = Integer.parseInt(input.replaceAll("PLRHP", ""));

							}

							if (input.contains("PLRMP")) {

								Player.MP = Integer.parseInt(input.replaceAll("PLRMP", ""));

							}

						}

					} catch (IOException error) {
						System.out.println("error");
					}

					load1.setVisible(true);
					load2.setVisible(true);
					load3.setVisible(true);

				}

			}

		});

		JButton lastPlayed = new JButton("Load Last Played Save");
		lastPlayed.setForeground(new Color(255, 255, 255));
		lastPlayed.setBackground(new Color(255, 0, 0));
		lastPlayed.setFont(new Font("Verdana", Font.BOLD, 11));
		lastPlayed.setBounds(208, 487, 250, 30);
		getContentPane().add(lastPlayed);

		lastPlayed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == lastPlayed) {

					load1.setVisible(true);
					load2.setVisible(true);
					load3.setVisible(true);

					FileReader file;
					BufferedReader buffer;
					String input;

					try // attempt to read from input stream
					{
						int[] times = new int[3];
						int[] levels = new int[3];

						for (int i = 0; i < 3; i++) {

							file = new FileReader("save" + (i + 1) + ".txt");
							buffer = new BufferedReader(file);

							while ((input = buffer.readLine()) != null) {

								if (input.contains("PLRLVL")) {

									levels[i] = Integer.parseInt(input.replaceAll("PLRLVL", ""));

								}

								if (input.contains(":")) {

									times[i] = Integer.parseInt(input.replaceAll(":", ""));

								}

							}

						}

						int min, temp;
						for (int index = 0; index < times.length - 1; index++) {

							min = index;
							for (int scan = index + 1; scan < times.length; scan++) {

								if (times[scan] < times[min]) {

									min = scan;
								}
								temp = times[min];
								times[min] = times[index];
								times[index] = temp;

							}

						}

						System.out.println(Arrays.toString(times));
						System.out.println(Arrays.toString(levels));

						String lastTime = String.valueOf(times[times.length - 1]);
						lastTime = lastTime.replaceAll(":", "");
						System.out.println("LAST TIME: " + lastTime);

						FileReader file1;
						BufferedReader buffer1;
						String input1;

						for (int x = 0; x < 3; x++) {

							file1 = new FileReader("save" + (x + 1) + ".txt");
							buffer1 = new BufferedReader(file1);

							int tempLevel = 0;
							int tempHP = 0;
							int tempMP = 0;

							while ((input1 = buffer1.readLine()) != null) {

								if (input1.contains("PLRLVL")) {

									tempLevel = Integer.parseInt(input1.replaceAll("PLRLVL", ""));
									System.out.println("TRUELVL");
								}

								if (input1.contains("PLRHP")) {

									tempHP = Integer.parseInt(input1.replaceAll("PLRHP", ""));
									System.out.println("TRUEHP");
								}

								if (input1.contains("PLRMP")) {

									tempMP = Integer.parseInt(input1.replaceAll("PLRMP", ""));
									System.out.println("TRUEMP");
								}

								if (input1.contains(":")) {

									input1 = input1.replaceAll(":", "");

									if (input1.contains(lastTime)) {

										Player.level = tempLevel;
										Player.HP = tempHP;
										Player.MP = tempMP;

										if (x == 0) {

											load2.setVisible(false);
											load3.setVisible(false);

										} else if (x == 1) {

											load1.setVisible(false);
											load3.setVisible(false);

										} else if (x == 2) {

											load1.setVisible(false);
											load2.setVisible(false);

										}

									}

								}
							}

						}

					} catch (IOException error) {
						System.out.println("error");
					}

				}

			}

		});

		JButton highestLvl = new JButton("Load Save with Highest Level");
		highestLvl.setForeground(new Color(255, 255, 255));
		highestLvl.setBackground(new Color(255, 0, 0));
		highestLvl.setFont(new Font("Verdana", Font.BOLD, 11));
		highestLvl.setBounds(208, 446, 250, 30);
		getContentPane().add(highestLvl);

		highestLvl.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == highestLvl) {

					load1.setVisible(true);
					load2.setVisible(true);
					load3.setVisible(true);

					FileReader file;
					BufferedReader buffer;
					String input;

					try // attempt to read from input stream
					{
						int[] times = new int[3];
						int[] levels = new int[3];

						for (int i = 0; i < 3; i++) {

							file = new FileReader("save" + (i + 1) + ".txt");
							buffer = new BufferedReader(file);

							while ((input = buffer.readLine()) != null) {

								if (input.contains("PLRLVL")) {

									levels[i] = Integer.parseInt(input.replaceAll("PLRLVL", ""));

								}

							}

						}

						int min, temp;
						for (int index = 0; index < levels.length - 1; index++) {

							min = index;
							for (int scan = index + 1; scan < levels.length; scan++) {

								if (levels[scan] < levels[min]) {

									min = scan;
								}
								temp = levels[min];
								levels[min] = levels[index];
								levels[index] = temp;

							}

						}

						System.out.println(Arrays.toString(levels));

						FileReader file1;
						BufferedReader buffer1;
						String input1;

						for (int x = 0; x < 3; x++) {

							file1 = new FileReader("save" + (x + 1) + ".txt");
							buffer1 = new BufferedReader(file1);

							int tempLevel = 0;
							int tempHP = 100;
							int tempMP = 100;

							while ((input1 = buffer1.readLine()) != null) {

								if (input1.contains("PLRLVL")) {

									System.out.println("TRUELVL");

									if (Integer
											.parseInt(input1.replaceAll("PLRLVL", "")) == levels[levels.length - 1]) {

										if (x == 0) {

											load2.setVisible(false);
											load3.setVisible(false);

										} else if (x == 1) {

											load1.setVisible(false);
											load3.setVisible(false);

										} else if (x == 2) {

											load1.setVisible(false);
											load2.setVisible(false);

										}

										Player.level = Integer.parseInt(input1.replaceAll("PLRLVL", ""));

									}

									if (input1.contains("PLRHP")) {

										Player.HP = Integer.parseInt(input1.replaceAll("PLRHP", ""));
										System.out.println("TRUEHP");
									}

									if (input1.contains("PLRMP")) {

										Player.MP = Integer.parseInt(input1.replaceAll("PLRMP", ""));
										System.out.println("TRUEMP");
									}

								}

							}

						}

					} catch (IOException error) {
						System.out.println("error");
					}

				}
			}

		});

		JLabel lblNewLabel = new JLabel("Enter a Level Number to Retrieve an Existing Save: ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 535, 409, 59);
		getContentPane().add(lblNewLabel);

		getLvlSave = new JTextField();
		getLvlSave.setBounds(414, 556, 86, 20);
		getContentPane().add(getLvlSave);
		getLvlSave.setColumns(10);

		JButton enterField = new JButton("ENTER");
		enterField.setForeground(new Color(255, 255, 255));
		enterField.setBackground(new Color(255, 0, 0));
		enterField.setFont(new Font("Verdana", Font.BOLD, 11));
		enterField.setBounds(510, 554, 89, 23);
		getContentPane().add(enterField);

		enterField.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == enterField) {

					FileReader file;
					BufferedReader buffer;
					String input;

					int usr = 0;
					try {

						usr = Integer.parseInt(getLvlSave.getText());

					} catch (Exception error) {
						System.out.println("Number not entered.");

					}

					try // attempt to read from input stream
					{
						int[] times = new int[3];
						int[] levels = new int[3];

						for (int i = 0; i < 3; i++) {

							file = new FileReader("save" + (i + 1) + ".txt");
							buffer = new BufferedReader(file);

							while ((input = buffer.readLine()) != null) {

								if (input.contains("PLRLVL")) {

									levels[i] = Integer.parseInt(input.replaceAll("PLRLVL", ""));

								}

							}

						}

						int min, temp;
						for (int index = 0; index < levels.length - 1; index++) {

							min = index;
							for (int scan = index + 1; scan < levels.length; scan++) {

								if (levels[scan] < levels[min]) {

									min = scan;
								}
								temp = levels[min];
								levels[min] = levels[index];
								levels[index] = temp;

							}

						}

						System.out.println(Arrays.toString(levels));

						FileReader file1;
						BufferedReader buffer1;
						String input1;

						boolean levelExists = false;
						
						
						boolean found = false;
						int location = -1;
						int first = 0, last  = levels.length - 1, mid = 0;
						int midItem = 0;
						
						while ((!found) && (first <= last)) {
							
							mid = (first+last ) / 2;
							
							midItem = levels[mid];
							found = usr == midItem;
							if (usr < midItem) {
								
								last = mid - 1;
								
								
							} if (usr > midItem) {
								
								first = mid + 1;
								
							}
							
							if (found ) {
								location = mid;
								levelExists = true;
								System.out.println("this level exists.");
								
							}
							
						}
						
						
						
						
						
						if (levelExists) {
							
							for (int x = 0; x < 3; x++) {

								file1 = new FileReader("save" + (x + 1) + ".txt");
								buffer1 = new BufferedReader(file1);

								int tempLevel = 0;
								int tempHP = 100;
								int tempMP = 100;

								while ((input1 = buffer1.readLine()) != null) {

									if (input1.contains("PLRLVL")) {

										System.out.println("TRUELVL");

										if (Integer.parseInt(input1.replaceAll("PLRLVL", "")) == usr) {

											if (x == 0) {

												load2.setVisible(false);
												load3.setVisible(false);

											} else if (x == 1) {

												load1.setVisible(false);
												load3.setVisible(false);

											} else if (x == 2) {

												load1.setVisible(false);
												load2.setVisible(false);

											}

											Player.level = Integer.parseInt(input1.replaceAll("PLRLVL", ""));

										}

										if (input1.contains("PLRHP")) {

											Player.HP = Integer.parseInt(input1.replaceAll("PLRHP", ""));
											System.out.println("TRUEHP");
										}

										if (input1.contains("PLRMP")) {

											Player.MP = Integer.parseInt(input1.replaceAll("PLRMP", ""));
											System.out.println("TRUEMP");
										}

									}

								}

							}
							
							
						} else {
							
							lblNewLabel.setText("No save contains this level.");
						}

					} catch (IOException error) {
						System.out.println("error");
					}

				}
			}

		});

		JLabel background1 = new JLabel("bkg1");
		background1.setBounds(0, 0, 650, 650);
		background1.setIcon(new ImageIcon("bkg/loadMenu.png"));
		getContentPane().add(background1);

	}

}

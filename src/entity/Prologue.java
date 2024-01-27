package entity;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import java.io.IOException;

import javax.imageio.ImageIO;

import game.Epilogue;
import game.MainFrame;
import game.Stage1Level1;
import game.Stage1Level2;
import game.Stage1Level3;
import game.Stage2Level1;
import game.Stage2Level2;
import game.Stage2Level3;
import game.Stage3Level1;
import logic.CollisionDetector;
import game.FinalBoss;
import object.Notebook;
import system.KeyHandler;
import system.WriteTextFile;

public class Prologue {

	MainFrame gp;
	public static int worldX;
	public static int worldY;
	public int speed;
	public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, idle1, idle2;

	public BufferedImage idleJennie1, idleJennie2;
	public static BufferedImage idleElizabeth1;
	public static BufferedImage idleElizabeth2;

	public static BufferedImage idleTyler1;
	public static BufferedImage idleTyler2;

	public static BufferedImage abbadonIdle1;
	public static BufferedImage abbadonIdle2;

	public static BufferedImage tedIdle1;
	public static BufferedImage tedIdle2;

	public static int dialogueCount1_1 = 0;
	public static int dialogueCount1_2 = 0;
	public static int dialogueCount1_3 = 0;

	public static boolean isBossFight = false;
	public static int partyTurn = 0;
	public static boolean startBossFight = false;
	public static boolean defeatedBoss = false;

	public String direction;
	public int spriteCounter = 0;
	public int spriteNum = 1;
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
	public boolean collisionOn = false;
	public int actionLockCounter = 0;

	public int dialogueBoxPosX = 10;
	public int dialogueBoxPosY = 415;
	public int dialogueBoxWidth = 750;
	public int dialogueBoxHeight = 150;

	public static boolean action_Attack = false;
	public static boolean checker = false;
	boolean guardCheck = false;

	public static boolean talkToJennie = false;
	public static boolean talkToElizabeth = false;

	public static boolean replyToJennie = false;
	public static boolean replyToElizabeth = false;

	public static boolean talkToTyler = false;
	public static boolean replyToTyler = false;

	public static boolean lvlUpChk = true;

	public static boolean resultsScreen = true;

	public static BufferedImage jennieImg = null;
	public BufferedImage protagView = null;
	public static BufferedImage elizabethImg = null;
	public static BufferedImage tylerImg = null;
	public static BufferedImage abbadonImg = null;
	public static BufferedImage attack = null;
	public static BufferedImage itemguard = null;
	public static BufferedImage persona = null;

	public static BufferedImage tedImg = null;

	public static int chk1 = 0;
	public static int chk2 = 0;
	public static int chk3 = 0;

	/*
	 * Presents Prologue level of the PERSONA game
	 * Draws releveant NPCs, Objects, user dialogue, and other interactive elements to the MainFrame JPanel
	 */
	public Prologue(MainFrame gp) {

		this.gp = gp;

	}

	public void update() {

		spriteCounter++;
		if (spriteCounter > 12) {

			if (spriteNum == 1) {

				spriteNum = 2;

			}

			else if (spriteNum == 2) {

				spriteNum = 1;

			}
			spriteCounter = 0;

		} else {

			direction = "idle";

			spriteCounter++;
			if (spriteCounter > 12) {

				if (spriteNum == 1) {

					spriteNum = 2;

				}

				else if (spriteNum == 2) {

					spriteNum = 1;

				}
				spriteCounter = 0;
			}

		}

	}

	public void draw(Graphics2D g2) {

		switch (direction) {
		case "idle":

			if (spriteNum == 1) {

				jennieImg = idleJennie1;
				elizabethImg = NPC_Elizabeth.idleElizabeth1;
				tylerImg = idleTyler1;
				abbadonImg = abbadonIdle1;
				tedImg = tedIdle1;

			}

			if (spriteNum == 2) {

				jennieImg = idleJennie2;

				elizabethImg = NPC_Elizabeth.idleElizabeth2;
				tylerImg = idleTyler2;
				abbadonImg = abbadonIdle2;
				tedImg = tedIdle2;

			}

			break;

		}

		if (MainFrame.isEpilogue) {

			Epilogue myEpilogue = new Epilogue(null);
			myEpilogue.draw(g2);

		}

		if (MainFrame.isFinalBoss) {

			FinalBoss theBoss = new FinalBoss(null);
			theBoss.draw(g2);

		}

		if (MainFrame.isStage3Level1) {

			Stage3Level1 stage3Level1 = new Stage3Level1(null);
			stage3Level1.draw(g2);

		}

		if (MainFrame.isStage2Level3) {

			Stage2Level3 stage2Level3 = new Stage2Level3(null);
			stage2Level3.draw(g2);

		}

		if (MainFrame.isStage2Level2) {

			Stage2Level2 stage2Level2 = new Stage2Level2(null);
			stage2Level2.draw(g2);

		}

		if (MainFrame.isStage2Level1) {

			Stage2Level1 stage2Level1 = new Stage2Level1(null);
			stage2Level1.draw(g2);

		}

		if (MainFrame.isStage1Level3) {

			Stage1Level3 stage1Level3 = new Stage1Level3(null);
			stage1Level3.draw(g2);

		}

		if (MainFrame.isStage1Level2) {

			Stage1Level2 stage1Level2 = new Stage1Level2(null);
			stage1Level2.draw(g2);

		}

		if (MainFrame.isStage1Level1) {

			Stage1Level1 stage1Level1 = new Stage1Level1(null);
			stage1Level1.draw(g2);

		}

		if (MainFrame.isIntro) {

			g2.drawImage(jennieImg, NPC_Jennie.Jennie_X, NPC_Jennie.Jennie_Y, 120, 120, null);
			g2.drawImage(elizabethImg, NPC_Elizabeth.Elizabeth_X, NPC_Elizabeth.Elizabeth_Y, 100, 100, null);
			g2.drawImage(tylerImg, NPC_Tyler.Tyler_X, NPC_Tyler.Tyler_Y, 100, 100, null);

			if (NPC_Tyler.nearTyler) {

				if (KeyHandler.tPressed && NPC_Tyler.nearTyler) {

					Prologue.talkToTyler = true;

					if (KeyHandler.mPressed) {

						Prologue.replyToJennie = false;
						Prologue.replyToElizabeth = false;
						Prologue.replyToTyler = true;
					}

				} else {

					Prologue.talkToTyler = false;

				}

				if (talkToTyler) {

					try {
						NPC_Tyler.talkTyler = ImageIO.read(getClass().getResourceAsStream("/dialogueNames/tyler.png"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("Cannot find necessary images. Please try again.");
					}

					talkToJennie = false;
					talkToElizabeth = false;

					Color c = new Color(0, 0, 0, 210);
					g2.setColor(c);
					g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);

					c = new Color(255, 255, 255);

					g2.setColor(c);
					g2.setStroke(new BasicStroke(5));
					g2.drawRoundRect(dialogueBoxPosX + 5, dialogueBoxPosY + 5, dialogueBoxWidth - 10,
							dialogueBoxHeight - 10, 25, 25);

					g2.drawImage(NPC_Tyler.talkTyler, 30, 340, 180, 110, null);

					if (KeyHandler.onePressed == true && talkToJennie == false && talkToElizabeth == false) {

						replyToElizabeth = false;
						replyToJennie = false;
						replyToTyler = false;

						try {

							protagView = ImageIO.read(getClass().getResourceAsStream("/approachToTalk/protagView.png"));
							g2.drawImage(protagView, 0, 0, 0, 0, null);
							g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));
							g2.drawString("Alright, see ya!", dialogueBoxPosX + 30, dialogueBoxPosY + 65);

						} catch (IOException e) {
							// TODO Auto-generated catch block
							System.out.println("Cannot find necessary images. Please try again.");
						}

						try {
							NPC_Tyler.tylerHappy = ImageIO
									.read(getClass().getResourceAsStream("/faces/tylerHappy.png"));

						} catch (IOException e) {
							// TODO Auto-generated catch block
							System.out.println("Cannot find necessary images. Please try again.");
						}

						g2.drawImage(NPC_Tyler.tylerHappy, 500, 95, 225, 325, null);

					} else {

						g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));
						g2.drawString("Yo.", dialogueBoxPosX + 30, dialogueBoxPosY + 65);

						try {
							NPC_Tyler.tylerHappy = ImageIO
									.read(getClass().getResourceAsStream("/faces/tylerHappy.png"));

						} catch (IOException e) {
							// TODO Auto-generated catch block
							System.out.println("Cannot find necessary images. Please try again.");
						}

						g2.drawImage(NPC_Tyler.tylerHappy, 500, 95, 225, 325, null);

					}

					if (replyToTyler) {

						Color h = new Color(0, 0, 0, 150);
						g2.setColor(h);
						g2.fillRoundRect(0, 0, 1000, 1000, 35, 35);

						try {

							protagView = ImageIO.read(getClass().getResourceAsStream("/approachToTalk/protagView.png"));

							g2.drawImage(protagView, 470, -120, 350, 570, null);

							BufferedImage elizabeth_intro = ImageIO
									.read(getClass().getResourceAsStream("/dialogueChoices/tylerIntro.png"));

							g2.drawImage(elizabeth_intro, 350, 90, 320, 370, null);

						} catch (IOException e) {
							// TODO Auto-generated catch block
							System.out.println("Cannot find necessary images. Please try again.");
						}

					}

				} else {

					try {

						NPC_Tyler.approach_Tyler = ImageIO
								.read(getClass().getResourceAsStream("/approachToTalk/talkToTyler.png"));
						g2.drawImage(NPC_Tyler.approach_Tyler, NPC_Elizabeth.Elizabeth_X + 45,
								NPC_Elizabeth.Elizabeth_Y, 254, 75, null);

					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("Cannot find necessary images. Please try again.");
					}

				}

			} else {

				if (!NPC_Jennie.nearJennie && !NPC_Elizabeth.nearElizabeth && !NPC_Tyler.nearTyler
						&& !Notebook.nearNotebook) {

					KeyHandler.onePressed = false;

					KeyHandler.twoPressed = false;

					KeyHandler.mPressed = false;
					KeyHandler.tPressed = false;

				}
			}

			if (NPC_Elizabeth.nearElizabeth) {

				if (KeyHandler.tPressed && NPC_Elizabeth.nearElizabeth) {

					Prologue.talkToElizabeth = true;

					if (KeyHandler.mPressed) {

						Prologue.replyToJennie = false;
						Prologue.replyToElizabeth = true;
						Prologue.replyToTyler = false;

					}

				} else {

					Prologue.talkToElizabeth = false;

				}

				if (talkToElizabeth) {

					try {
						NPC_Elizabeth.talkElizabeth = ImageIO
								.read(getClass().getResourceAsStream("/dialogueNames/elizabeth.png"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("Cannot find necessary images. Please try again.");
					}

					talkToJennie = false;

					Color c = new Color(0, 0, 0, 210);
					g2.setColor(c);
					g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);

					c = new Color(255, 255, 255);

					g2.drawImage(NPC_Elizabeth.talkElizabeth, 30, 340, 180, 110, null);

					g2.setColor(c);
					g2.setStroke(new BasicStroke(5));
					g2.drawRoundRect(dialogueBoxPosX + 5, dialogueBoxPosY + 5, dialogueBoxWidth - 10,
							dialogueBoxHeight - 10, 25, 25);

					if (KeyHandler.onePressed == true && talkToJennie == false) {

						replyToElizabeth = false;

						try {

							protagView = ImageIO.read(getClass().getResourceAsStream("/approachToTalk/protagView.png"));
							g2.drawImage(protagView, 0, 0, 0, 0, null);
							g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));
							g2.drawString("...Head on forth.", dialogueBoxPosX + 30, dialogueBoxPosY + 65);

						} catch (IOException e) {
							// TODO Auto-generated catch block
							System.out.println("Cannot find necessary images. Please try again.");
						}

					} else {

						g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));
						g2.drawString("Greetings.", dialogueBoxPosX + 30, dialogueBoxPosY + 65);

					}

					if (replyToElizabeth) {

						Color h = new Color(0, 0, 0, 150);
						g2.setColor(h);
						g2.fillRoundRect(0, 0, 1000, 1000, 35, 35);

						try {

							protagView = ImageIO.read(getClass().getResourceAsStream("/approachToTalk/protagView.png"));

							g2.drawImage(protagView, 470, -120, 350, 570, null);

							BufferedImage elizabeth_intro = ImageIO
									.read(getClass().getResourceAsStream("/dialogueChoices/elizabeth_intro.png"));

							g2.drawImage(elizabeth_intro, 350, 90, 320, 370, null);

						} catch (IOException e) {
							// TODO Auto-generated catch block
							System.out.println("Cannot find necessary images. Please try again.");
						}

					}

				} else {

					try {

						NPC_Elizabeth.approach_Elizabeth = ImageIO
								.read(getClass().getResourceAsStream("/approachToTalk/talkToElizabeth.png"));
						g2.drawImage(NPC_Elizabeth.approach_Elizabeth, NPC_Elizabeth.Elizabeth_X + 45,
								NPC_Elizabeth.Elizabeth_Y, 254, 75, null);

					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("Cannot find necessary images. Please try again.");
					}

				}

			} else {

				if (!NPC_Jennie.nearJennie && !NPC_Elizabeth.nearElizabeth && !NPC_Tyler.nearTyler
						&& !Notebook.nearNotebook) {

					KeyHandler.onePressed = false;

					KeyHandler.twoPressed = false;

					KeyHandler.mPressed = false;
					KeyHandler.tPressed = false;

				}

			}

			if (NPC_Jennie.nearJennie) {

				if (KeyHandler.tPressed && NPC_Jennie.nearJennie) {

					Prologue.talkToJennie = true;

					if (KeyHandler.mPressed) {

						Prologue.replyToJennie = true;

						Prologue.replyToElizabeth = false;

						Prologue.replyToTyler = false;

					}

				} else {

					Prologue.talkToJennie = false;

				}

				try {
					NPC_Jennie.talkJennie = ImageIO.read(getClass().getResourceAsStream("/dialogueNames/jennie.png"));

				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Cannot find necessary images. Please try again.");
				}

				try {
					NPC_Jennie.approach_Jennie = ImageIO
							.read(getClass().getResourceAsStream("/approachToTalk/talkToJennie.png"));

				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Cannot find necessary images. Please try again.");
				}

				if (talkToJennie) {

					Color c = new Color(0, 0, 0, 210);
					g2.setColor(c);
					g2.fillRoundRect(dialogueBoxPosX, dialogueBoxPosY, dialogueBoxWidth, dialogueBoxHeight, 35, 35);

					c = new Color(255, 255, 255);

					g2.setColor(c);
					g2.setStroke(new BasicStroke(5));
					g2.drawRoundRect(dialogueBoxPosX + 5, dialogueBoxPosY + 5, dialogueBoxWidth - 10,
							dialogueBoxHeight - 10, 25, 25);

					// store in list
					if (NPC_Jennie.dialogueOptionJennie == 0) {

						g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 34));

						if (KeyHandler.onePressed == false && KeyHandler.twoPressed == false) {

							g2.drawString("Hey there, " + Player.plrFirstName + ". Ready for school?",
									dialogueBoxPosX + 30, dialogueBoxPosY + 65);

							try {
								NPC_Jennie.jennieHappy = ImageIO
										.read(getClass().getResourceAsStream("/faces/jennieHappy.png"));

							} catch (IOException e) {
								// TODO Auto-generated catch block
								System.out.println("Cannot find necessary images. Please try again.");
							}

							g2.drawImage(NPC_Jennie.jennieHappy, 500, 95, 225, 325, null);

						}

						if (KeyHandler.onePressed == true) {

							replyToJennie = false;

							try {

								protagView = ImageIO
										.read(getClass().getResourceAsStream("/approachToTalk/protagView.png"));
								g2.drawImage(protagView, 0, 0, 0, 0, null);
								g2.drawString("Okay, see you there!", dialogueBoxPosX + 30, dialogueBoxPosY + 65);

								try {
									NPC_Jennie.jennieHappy = ImageIO
											.read(getClass().getResourceAsStream("/faces/jennieHappy.png"));

								} catch (IOException e) {
									// TODO Auto-generated catch block
									System.out.println("Cannot find necessary images. Please try again.");
								}

								g2.drawImage(NPC_Jennie.jennieHappy, 500, 95, 225, 325, null);

							} catch (IOException e) {
								// TODO Auto-generated catch block
								System.out.println("Cannot find necessary images. Please try again.");
							}

						}

						if (KeyHandler.twoPressed == true) {

							replyToJennie = false;

							try {

								protagView = ImageIO
										.read(getClass().getResourceAsStream("/approachToTalk/protagView.png"));
								g2.drawImage(protagView, 0, 0, 0, 0, null);
								g2.drawString("In that case, I think walking with me", dialogueBoxPosX + 30,
										dialogueBoxPosY + 65);
								g2.drawString("would raise your spirits!", dialogueBoxPosX + 30, dialogueBoxPosY + 105);

								try {
									NPC_Jennie.jennieHappy = ImageIO
											.read(getClass().getResourceAsStream("/faces/jennieHappy.png"));

								} catch (IOException e) {
									// TODO Auto-generated catch block
									System.out.println("Cannot find necessary images. Please try again.");
								}

								g2.drawImage(NPC_Jennie.jennieHappy, 500, 95, 225, 325, null);

							} catch (IOException e) {
								// TODO Auto-generated catch block
								System.out.println("Cannot find necessary images. Please try again.");
							}

						}

						if (replyToJennie) {

							Color h = new Color(0, 0, 0, 150);
							g2.setColor(h);
							g2.fillRoundRect(0, 0, 1000, 1000, 35, 35);

							try {

								protagView = ImageIO
										.read(getClass().getResourceAsStream("/approachToTalk/protagView.png"));

								g2.drawImage(protagView, 470, -120, 350, 570, null);

								BufferedImage jennie_intro = ImageIO
										.read(getClass().getResourceAsStream("/dialogueChoices/jennie_intro.png"));

								g2.drawImage(jennie_intro, 350, 90, 320, 370, null);

							} catch (IOException e) {

								System.out.println("Cannot find necessary images. Please try again.");

							}

						}

					}

					try {

						NPC_Jennie.approach_Jennie = ImageIO
								.read(getClass().getResourceAsStream("/approachToTalk/blankImage.png"));

					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("Cannot find necessary images. Please try again.");
					}

					g2.drawImage(NPC_Jennie.talkJennie, 30, 340, 180, 110, null);

				}

				g2.drawImage(NPC_Jennie.approach_Jennie, NPC_Jennie.Jennie_X + 25, NPC_Jennie.Jennie_Y, 254, 75, null);

			} else {

				if (!NPC_Jennie.nearJennie && !NPC_Elizabeth.nearElizabeth && !NPC_Tyler.nearTyler
						&& !Notebook.nearNotebook) {

					KeyHandler.onePressed = false;
					KeyHandler.twoPressed = false;

					KeyHandler.mPressed = false;
					KeyHandler.tPressed = false;

				}

				try {
					NPC_Jennie.approach_Jennie = ImageIO
							.read(getClass().getResourceAsStream("/approachToTalk/blankImage.png"));
					g2.drawImage(NPC_Jennie.approach_Jennie, NPC_Jennie.Jennie_X - 80, NPC_Jennie.Jennie_Y, gp.tileSize,
							gp.tileSize, null);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Cannot find necessary images. Please try again.");
				}

			}

			if (Notebook.nearNotebook) {

				if (KeyHandler.tPressed && Notebook.nearNotebook) {

					Notebook.interactWithObject = true;

				} else {

					Notebook.interactWithObject = true;

				}

				System.out.println("NEAR NOTEBK");

				if (Notebook.interactWithObject) {

					if (!Notebook.objectFound) {

						Color h = new Color(0, 0, 0, 150);
						g2.setColor(h);
						g2.fillRoundRect(0, 0, 1000, 1000, 35, 35);

						g2.drawImage(NPC_Jennie.foundItem, 250, 150, 255, 265, null);

					}

					if (KeyHandler.yPressed) {

						WriteTextFile.write("items.txt", "Notebook     Miscellanious     0     0", true);
						KeyHandler.yPressed = false;// THIS MIGHT INTERFERE WITH SOMETHING
						Notebook.objectFound = true;

					}

					if (KeyHandler.nPressed) {

						Notebook.objectFound = true;

					}

				}

			} else {

				if (!NPC_Jennie.nearJennie && !NPC_Elizabeth.nearElizabeth && !NPC_Tyler.nearTyler
						&& !Notebook.nearNotebook) {

					KeyHandler.onePressed = false;
					KeyHandler.twoPressed = false;

					KeyHandler.mPressed = false;
					KeyHandler.tPressed = false;

				}

			}

		}

	}

}

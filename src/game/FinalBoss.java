package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.BOSS_Abbadon;
import entity.BOSS_Elizabeth;
import entity.BOSS_Tyler;
import entity.Prologue;
import logic.CollisionDetector;
import entity.NPC_Tyler;
import entity.NPC_Jennie;
import entity.Player;
import object.Objects;
import system.KeyHandler;

public class FinalBoss extends Prologue {

	public FinalBoss(MainFrame gp) {

		super(gp);

	}

	/*
	 * Presents Final Boss Level of the PERSONA game
	 * Graphics2D g2
	 * Draws relevant NPCs, Objects, user dialogue, and other interactive elements to the MainFrame JPanel
	 */
	public void draw(Graphics2D g2) {

		Prologue.startBossFight = true;

		if (startBossFight && partyTurn == 1) {

			try {
				Prologue.attack = ImageIO.read(getClass().getResourceAsStream("/battleHUD/attack.png"));
				g2.drawImage(attack, 225, 400, 250, 50, null);

				Prologue.itemguard = ImageIO.read(getClass().getResourceAsStream("/battleHUD/itemguard.png"));
				g2.drawImage(itemguard, 100, 270, 250, 75, null);

				Prologue.persona = ImageIO.read(getClass().getResourceAsStream("/battleHUD/persona.png"));
				g2.drawImage(Prologue.persona, 225, 450, 250, 75, null);
				g2.drawImage(Prologue.elizabethImg, 430, 50, 330, 300, null);

				g2.drawImage(Prologue.jennieImg, 120, 280, 270, 270, null);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Color c = new Color(255, 255, 255);

			g2.setColor(c);
			g2.setStroke(new BasicStroke(5));
			g2.setFont(g2.getFont().deriveFont(Font.BOLD, 25));
			g2.setFont(new Font("Candara", Font.BOLD, 50));
			g2.drawString("HP: " + BOSS_Elizabeth.HP, 550, 450);

			g2.setFont(new Font("Candara", Font.BOLD, 25));
			g2.drawString(("PROTAG: " + Player.HP + "/" + Player.MP), 300, 560);

			g2.drawString(("JENNIE: " + NPC_Jennie.HP + "/" + NPC_Jennie.MP), 500, 560);

			g2.drawString(("TYLER: " + NPC_Tyler.HP + "/" + NPC_Tyler.MP), 500, 530);

		} else if (startBossFight && partyTurn == 2) {

			try {
				Prologue.attack = ImageIO.read(getClass().getResourceAsStream("/battleHUD/attack.png"));
				g2.drawImage(attack, 225, 400, 250, 50, null);

				Prologue.itemguard = ImageIO.read(getClass().getResourceAsStream("/battleHUD/itemguard.png"));
				g2.drawImage(itemguard, 100, 270, 250, 75, null);

				Prologue.persona = ImageIO.read(getClass().getResourceAsStream("/battleHUD/persona.png"));
				g2.drawImage(persona, 225, 450, 250, 75, null);
				g2.drawImage(Prologue.elizabethImg, 430, 50, 330, 300, null);

				g2.drawImage(tylerImg, 120, 280, 270, 270, null);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Color c = new Color(255, 255, 255);

			g2.setColor(c);
			g2.setStroke(new BasicStroke(5));
			g2.setFont(g2.getFont().deriveFont(Font.BOLD, 25));

			g2.setFont(new Font("Candara", Font.BOLD, 50));
			g2.drawString("HP: " + BOSS_Elizabeth.HP, 550, 450);

			g2.setFont(new Font("Candara", Font.BOLD, 25));
			g2.drawString(("PROTAG: " + Player.HP + "/" + Player.MP), 300, 560);

			g2.drawString(("JENNIE: " + NPC_Jennie.HP + "/" + NPC_Jennie.MP), 500, 560);

			g2.drawString(("TYLER: " + NPC_Tyler.HP + "/" + NPC_Tyler.MP), 500, 530);

		} else if (startBossFight && partyTurn == 0) {

			try {
				Prologue.attack = ImageIO.read(getClass().getResourceAsStream("/battleHUD/attack.png"));
				g2.drawImage(attack, 225, 400, 250, 50, null);

				Prologue.itemguard = ImageIO.read(getClass().getResourceAsStream("/battleHUD/itemguard.png"));
				g2.drawImage(itemguard, 100, 270, 250, 75, null);

				Prologue.persona = ImageIO.read(getClass().getResourceAsStream("/battleHUD/persona.png"));
				g2.drawImage(persona, 225, 450, 250, 75, null);
				g2.drawImage(Prologue.elizabethImg, 430, 50, 330, 300, null);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Color c = new Color(255, 255, 255);

			g2.setColor(c);
			g2.setStroke(new BasicStroke(5));

			g2.setFont(new Font("Candara", Font.BOLD, 50));
			g2.drawString("HP: " + BOSS_Elizabeth.HP, 550, 450);

			g2.setFont(new Font("Candara", Font.BOLD, 25));
			g2.drawString(("PROTAG: " + Player.HP + "/" + Player.MP), 300, 560);

			g2.drawString(("JENNIE: " + NPC_Jennie.HP + "/" + NPC_Jennie.MP), 500, 560);

			g2.drawString(("TYLER: " + NPC_Tyler.HP + "/" + NPC_Tyler.MP), 500, 530);

		} else if (startBossFight && partyTurn == 3) {

			g2.drawImage(Prologue.tylerImg, 10, 280, 270, 270, null);

			g2.drawImage(Prologue.jennieImg, 150, 280, 270, 270, null);

			g2.drawImage(Prologue.elizabethImg, 430, 50, 330, 300, null);

			Color c = new Color(255, 255, 255);

			g2.setColor(c);
			g2.setStroke(new BasicStroke(5));
			g2.setFont(g2.getFont().deriveFont(Font.BOLD, 25));

			g2.setFont(new Font("Candara", Font.BOLD, 50));
			g2.drawString("HP: " + BOSS_Elizabeth.HP, 550, 450);

			g2.setFont(new Font("Candara", Font.BOLD, 25));
			g2.drawString(("PROTAG: " + Player.HP + "/" + Player.MP), 300, 560);

			g2.drawString(("JENNIE: " + NPC_Jennie.HP + "/" + NPC_Jennie.MP), 500, 560);

			g2.drawString(("TYLER: " + NPC_Tyler.HP + "/" + NPC_Tyler.MP), 500, 530);

		}

		if (startBossFight) {

			if (partyTurn == 0) {

				if (KeyHandler.cPressed && Player.canHeal) {

					Player.MP += 20;
					NPC_Jennie.MP += 15;
					NPC_Tyler.MP += 15;

					Player.HP += 20;
					NPC_Jennie.HP += 15;
					NPC_Tyler.HP += 15;

					Player.canHeal = false;

					g2.drawString(("ALREADY HEALED"), 450, 500);

				} else if (KeyHandler.cPressed && !Player.canHeal) {

					g2.drawString(("CANNOT HEAL (NO ITEMS)"), 450, 500);

				}

				if (KeyHandler.xPressed) {

					g2.drawImage(NPC_Jennie.protagPersonasList, 50, 50, 400, 350, null);

					if (KeyHandler.jPressed) {

						BOSS_Elizabeth.HP -= 75;

						Player.MP -= 35;

						KeyHandler.xPressed = false;

						KeyHandler.jPressed = false;
						partyTurn = 1;

					}

					if (KeyHandler.kPressed) {

						BOSS_Elizabeth.HP -= 60;

						Player.MP -= 30;
						KeyHandler.xPressed = false;

						KeyHandler.kPressed = false;

						partyTurn = 1;

					}

					if (KeyHandler.lPressed) {

						BOSS_Elizabeth.HP -= 45;
						Player.MP -= 25;
						KeyHandler.xPressed = false;
						KeyHandler.lPressed = false;

						partyTurn = 1;

					}

				}

				if (KeyHandler.zPressed) {

					if (chk1 == 0) {

						BOSS_Elizabeth.HP -= 30;
						chk1++;

					}

					MainFrame.numSeconds = 0;

					KeyHandler.zPressed = false;

					action_Attack = true;

					// if v is pressed and player hasn't attacked
				} else if (KeyHandler.vPressed && chk1 == 0) {

					partyTurn = 1;

					KeyHandler.vPressed = false;

				}

				if (MainFrame.numSeconds < 2 && action_Attack) {

					KeyHandler.zPressed = false;

				} else if (MainFrame.numSeconds >= 2 && action_Attack) {

					KeyHandler.zPressed = false;

					action_Attack = false;
					partyTurn = 1;

				}

			}
			if (partyTurn == 1) {

				if (KeyHandler.xPressed) {

					g2.drawImage(NPC_Jennie.jenniePersonasList, 50, 50, 400, 350, null);

					if (KeyHandler.kPressed) {

						BOSS_Elizabeth.HP -= 60;

						Player.MP -= 30;
						KeyHandler.xPressed = false;

						partyTurn = 2;
						KeyHandler.kPressed = false;

					}

				}

				if (KeyHandler.zPressed) {

					if (chk2 == 0) {

						BOSS_Elizabeth.HP -= 25;
						chk2++;

					}

					MainFrame.numSeconds = 0;

					System.out.println("BOSS HP: " + BOSS_Abbadon.HP + "\nYU HP: " + Player.HP + "\nYOSUKE HP: "
							+ NPC_Tyler.HP + "\nJENNIE HP: " + NPC_Jennie.HP + "\npartyTurn: " + partyTurn);

					System.out.println("--------------------");

					KeyHandler.zPressed = false;

					action_Attack = true;

				}
				if (KeyHandler.vPressed && chk2 == 0) {

					partyTurn = 2;
					KeyHandler.vPressed = false;

				}

				if (MainFrame.numSeconds < 2 && action_Attack) {

					KeyHandler.zPressed = false;

				} else if (MainFrame.numSeconds >= 2 && action_Attack) {

					action_Attack = false;
					KeyHandler.zPressed = false;

					partyTurn = 2;

				}

			}

			if (partyTurn == 2) {

				if (KeyHandler.xPressed) {

					g2.drawImage(NPC_Jennie.tylerPersonasList, 50, 50, 400, 350, null);

					if (KeyHandler.lPressed) {

						BOSS_Elizabeth.HP -= 45;
						Player.MP -= 25;

						partyTurn = 3;

						KeyHandler.xPressed = false;

						KeyHandler.lPressed = false;

					}

				}

				if (KeyHandler.zPressed) {

					if (chk3 == 0) {

						BOSS_Elizabeth.HP -= 25;
						chk3++;

					}

					MainFrame.numSeconds = 0;

					System.out.println("BOSS HP: " + BOSS_Abbadon.HP + "\nYU HP: " + Player.HP + "\nYOSUKE HP: "
							+ NPC_Tyler.HP + "\nJENNIE HP: " + NPC_Jennie.HP + "\npartyTurn: " + partyTurn);

					System.out.println("--------------------");

					KeyHandler.zPressed = false;

					action_Attack = true;

				}
				if (KeyHandler.vPressed && chk3 == 0) {

					partyTurn = 3;
					KeyHandler.vPressed = false;

				}

				if (MainFrame.numSeconds < 2 && action_Attack) {

					KeyHandler.zPressed = false;

				} else if (MainFrame.numSeconds >= 2 && action_Attack) {
					KeyHandler.zPressed = false;

					action_Attack = false;
					partyTurn = 3;
					MainFrame.numSeconds = 0;
					checker = false;

				}

			}
			if (partyTurn == 3) {

				if (MainFrame.numSeconds < 4) {

					if (!checker) {

						Player.HP -= 30;
						NPC_Jennie.HP -= 30;
						NPC_Tyler.HP -= 30;
						chk1 = 0;
						chk2 = 0;
						chk3 = 0;

						checker = true;

					}

				} else if (MainFrame.numSeconds >= 4) {

					action_Attack = false;
					partyTurn = 0;

				}

			}

			if (BOSS_Elizabeth.HP <= 0) {

				if (MainFrame.numSeconds <= 5) {

					if (MainFrame.numSeconds > 2) {

						Color c = new Color(255, 255, 255);

						g2.setColor(c);
						g2.setStroke(new BasicStroke(5));

						g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 75));
						g2.drawString("YOU WON!", 150, 160);

						if (lvlUpChk) {

							Player.level += 4;
							lvlUpChk = false;

						}

					}

				} else if (MainFrame.numSeconds > 5) {

					if (!KeyHandler.yPressed && resultsScreen) {

						Color h = new Color(0, 0, 0, 150);
						g2.setColor(h);
						g2.fillRoundRect(0, 0, 1000, 1000, 35, 35);

						g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 25));

						Color c = new Color(255, 255, 255);

						g2.drawImage(NPC_Jennie.results, 0, 0, 768, 576, null);

						g2.drawString("Your level is: " + Player.level, 250 + 30, 150 + 75);

						g2.drawString("PARTY STATS", 250 + 30, 150 + 105);

						g2.drawString("YOUR HP: " + Player.HP, 250 + 30, 150 + 135);

						g2.drawString("JENNIE HP: " + NPC_Jennie.HP, 250 + 30, 150 + 155);

						g2.drawString("TYLER HP: " + NPC_Tyler.HP, 250 + 30, 150 + 180);

						g2.drawString("Click Y to Continue", 250 + 30, 150 + 205);

						lvlUpChk = true;

					} else {

						MainFrame.isFinalBoss = false;
						MainFrame.isEpilogue = true;

						KeyHandler.yPressed = false;
						resultsScreen = false;

						isBossFight = false;
						defeatedBoss = true;
						startBossFight = false;

						CollisionDetector.modifyBlockBounds1_2 = false;

					}

				}
			}

		}
	}

}

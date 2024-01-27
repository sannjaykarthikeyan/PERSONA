package game;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entity.BOSS_Abbadon;
import entity.Prologue;
import logic.CollisionDetector;
import logic.LinkedList;
import entity.NPC_Tyler;
import entity.NPC_Jennie;
import entity.Player;
import object.Objects;
import system.KeyHandler;

import system.SoundPlayer;

/*
 *  Draws releveant NPCs, Objects, user dialogue, and other interactive elements for the user to play the game
 *  Handles scene transitions and boss fights with a LinkedList containig all scene/game stage data.
 *  
 */
public class MainFrame extends JPanel implements Runnable {

	CollisionDetector tileM = new CollisionDetector(this);
	KeyHandler keyH = new KeyHandler();

	public static Image bkgIntro, stage1Level1, stage1Level2, stage1Level2Boss, stage1Level3, stage2Level1,
			stage2Level2, stage2Level3, stage3Level1, stage3Level2, epilogue, gameOver, backdrop;

	// SCREEN AND TILE SIZE
	final int originalTileSize = 16;
	final int scale = 3;
	public final int tileSize = originalTileSize * scale;
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol;
	final int screenHeight = tileSize * maxScreenRow;

	public static LinkedList scenes = new LinkedList();

	public Resources aSetter = new Resources(this);
	public Prologue npc[] = new Prologue[10];

	public NPC_Jennie jennie = new NPC_Jennie(this);
	public NPC_Tyler tyler = new NPC_Tyler(this);

	// TIME/GAME ENGINE
	static int count = 0;
	public static int numSeconds = 0;
	Thread gameThread;
	int FPS = 60;

	// boolean checker for what stage the player is currently on
	public static boolean isIntro = true;
	public static boolean isStage1Level1 = false;
	public static boolean isStage1Level2 = false;
	public static boolean isStage1Level3 = false;
	public static boolean isStage2Level1 = false;
	public static boolean isStage2Level2 = false;
	public static boolean isStage2Level3 = false;

	public static boolean isStage3Level1 = false;

	public static boolean isStage3Level2 = false;

	public static boolean isFinalBoss = false;

	public static boolean isEpilogue = false;

	public Objects obj[] = new Objects[10];

	// PLAYER LOGIC
	public Player player = new Player(this, keyH);
	static int playerSpeed = 4;

	public static int stageLevel = 0;

	public MainFrame() {

		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);

	}

	/*
	 * Loads all scenes and scene data into a LinkedList
	 */
	public void setupGame() {

		try {

			aSetter.setObject();

			aSetter.setNPC();

			bkgIntro = ImageIO.read(new File("bkg/intro.png"));
			stage1Level1 = ImageIO.read(new File("bkg/1_1.png"));
			stage1Level2 = ImageIO.read(new File("bkg/1_2.png"));
			stage1Level2Boss = ImageIO.read(new File("bkg/1_2boss.png"));
			stage1Level3 = ImageIO.read(new File("bkg/1_3.png"));

			stage2Level1 = ImageIO.read(new File("bkg/2_1.png"));

			stage2Level2 = ImageIO.read(new File("bkg/2_2.png"));
			stage2Level3 = ImageIO.read(new File("bkg/2_3.png"));
			stage3Level1 = ImageIO.read(new File("bkg/3_1.png"));
			stage3Level2 = ImageIO.read(new File("bkg/3_2.png"));
			epilogue = ImageIO.read(new File("bkg/epilogue.png"));
			gameOver = ImageIO.read(new File("bkg/gameOver.png"));
			backdrop = ImageIO.read(new File("bkg/backdrop.png"));

			scenes.insert(0, bkgIntro);
			scenes.insert(1, stage1Level1);
			scenes.insert(2, stage1Level2);
			scenes.insert(3, stage1Level3);
			scenes.insert(4, stage2Level1);
			scenes.insert(5, stage2Level2);
			scenes.insert(6, stage2Level3);
			scenes.insert(7, stage3Level1);
			scenes.insert(8, stage3Level2);
			scenes.insert(9, epilogue);

			scenes.insert(10, stage1Level2Boss);
		} catch (IOException e) {

			System.out.println("CAN'T FIND IMGS");

		}
	}

	/*
	 * Starts game thread (a loop that runs until paused due to pre-determined
	 * conditions, or the player has finished the game)
	 */
	public void startGameThread() {

		gameThread = new Thread(this);
		gameThread.start();

	}

	/*
	 * Runs game thread (a loop that runs until paused due to pre-determined
	 * conditions, or the player has finished the game)
	 */
	public void run() {

		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		int timer = 0;
		int drawCount = 0;

		// temporary booleans to ensure that the timer (seconds passed) does not remain
		// at 0
		boolean chk1 = true;
		boolean chk2 = true;
		boolean chk3 = true;
		boolean chk4 = true;
		boolean chk7 = true;

		while (gameThread != null) {

			if (isEpilogue) {

				isStage3Level1 = false;
				isStage3Level2 = false;
				isStage2Level3 = false;

			}

			if (isStage2Level3) {

				// entity.bossdefeated is true

				if (chk4) {

					numSeconds = 0;
					chk4 = false;
				}

				if (numSeconds <= 0) {

					Player.x = 305;
					Player.y = 285;

				}

			}

			if (isStage2Level2) {

				isStage2Level1 = false;

				NPC_Jennie.Jennie_X = 270;
				NPC_Jennie.Jennie_Y = 345;
				NPC_Tyler.Tyler_X = 530;
				NPC_Tyler.Tyler_Y = 125;

				if (chk3) {

					numSeconds = 0;
					chk3 = false;
				}

				if (numSeconds <= 0) {

					Player.x = 215;
					Player.y = 245;

				}

				if (Player.y >= 445 && isStage2Level2) {

					isStage2Level2 = false;
					isStage2Level3 = true;
					MainFrame.scenes.header = MainFrame.scenes.header.getNext();

				}

			}

			if (isStage2Level1) {

				if (Player.y >= 475) {

					MainFrame.scenes.header = MainFrame.scenes.header.getNext();

					isStage2Level1 = false;
					isStage2Level2 = true;

				}

				NPC_Jennie.Jennie_X = 230;
				NPC_Jennie.Jennie_Y = 225;
				NPC_Tyler.Tyler_X = 530;
				NPC_Tyler.Tyler_Y = 225;

				if (chk7) {

					numSeconds = 0;
					chk7 = false;
				}

				if (numSeconds <= 0) {

					Player.x = 330;
					Player.y = 225;

				}

			}

			if (isIntro) {

				if (Player.y <= -130) {

					Player.y = 200;

				}

				isStage1Level1 = false;
				isStage1Level2 = false;

				NPC_Jennie.Jennie_X = 450;
				NPC_Jennie.Jennie_Y = 340;
				NPC_Tyler.Tyler_X = 631;
				NPC_Tyler.Tyler_Y = 258;

			}

			if (isStage1Level3) {

				isStage1Level2 = false;
				isStage1Level1 = false;
				isIntro = false;

				if (chk1) {

					numSeconds = 0;
					chk1 = false;
				}

				if (numSeconds <= 0) {

					Player.x = 620;
					Player.y = 460;

				}

				NPC_Jennie.Jennie_X = 220;

				NPC_Jennie.Jennie_Y = 430;

				NPC_Tyler.Tyler_X = 500;

				NPC_Tyler.Tyler_Y = 450;

			}

			if (isStage1Level2) {

				isStage1Level3 = false;
				isStage2Level1 = false;

				BOSS_Abbadon.Abbadon_X = 275;

				BOSS_Abbadon.Abbadon_Y = 75;

				if (numSeconds <= 0) {

					Player.x = 620;
					Player.y = 460;

				}

				NPC_Jennie.Jennie_X = 220;

				NPC_Jennie.Jennie_Y = 430;

				NPC_Tyler.Tyler_X = 500;

				NPC_Tyler.Tyler_Y = 450;

				if (Player.y < 40 || Player.y >= 550) {

					Player.y = 445;

				}

				if (Player.x <= -80 || Player.x >= 720) {

					Player.x = 585;

				}

			}

			if (isStage1Level1) {

				if (Player.y >= 450) {

					Player.y = 320;

				}

				if (Player.x <= -100 || Player.x >= 700) {

					Player.x = 300;

				}

			}

			if (Player.x >= 760 && isIntro) {

				System.out.println("player out of bounds, move to next level");

				isIntro = false;

				isStage1Level1 = true;

				numSeconds = 0;

				Player.x = 310;
				Player.y = 340;

				NPC_Jennie.Jennie_X = 60;

				NPC_Jennie.Jennie_Y = 330;

				NPC_Tyler.Tyler_X = 655;

				NPC_Tyler.Tyler_Y = 350;
				scenes.header = scenes.header.getNext();

			}

			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;

			if (delta >= 1) {

				update();
				repaint();
				delta--;
				drawCount++;

			}

			if (timer >= 1000000000) {

				// System.out.println("FPS: " + drawCount);
				drawCount = 0;
				timer = 0;
				numSeconds++;
				// System.out.println("seconds passed: " + numSeconds);
				// System.out.println("seconds since character moved: " + Player.num);
				System.out.println("x and y: " + Player.x + " " + Player.y);

			}

		}

	}

	/*
	 * Updates positions of Player, NPCs, objects, and other interactive elements
	 * throughout gameplay.
	 */
	public void update() {
		int newPlayerX = Player.x;
		int newPlayerY = Player.y;

		if (tileM.checkCollision(Player.x, Player.y - playerSpeed, playerSpeed)) {
			// Collision from the top, adjust player position to be just below the colliding
			// area
			newPlayerY += playerSpeed;

			SoundPlayer.playSound("soundEffects/bumpintowall.wav");
		} else if (tileM.checkCollision(Player.x, Player.y + playerSpeed, playerSpeed)) {
			// Collision from the bottom, adjust player position to be just above the
			// colliding area
			newPlayerY -= playerSpeed;

			SoundPlayer.playSound("soundEffects/bumpintowall.wav");
		} else if (tileM.checkCollision(Player.x - playerSpeed, Player.y, playerSpeed)) {
			// Collision from the left, adjust player position to be just to the right of
			// the colliding area
			newPlayerX += playerSpeed;

			SoundPlayer.playSound("soundEffects/bumpintowall.wav");
		} else if (tileM.checkCollision(Player.x + playerSpeed, Player.y, playerSpeed)) {
			// Collision from the right, adjust player position to be just to the left of
			// the colliding area
			newPlayerX -= playerSpeed;
			SoundPlayer.playSound("soundEffects/bumpintowall.wav");
		} else {
			// No collision, update player position
			newPlayerX = Player.x;
			newPlayerY = Player.y;

		}

		Player.x = newPlayerX;
		Player.y = newPlayerY;

		if (!Player.inCutscene) {

			player.update();

		}

		jennie.setAction();
		jennie.update();

		tyler.setAction();
		tyler.update();

		for (int i = 0; i < npc.length; i++) {

			if (npc[i] != null) {

				npc[i].update();

			}

		}

	}

	/*
	 * Constantly draws all in-game interactive elements for the user to view and
	 * interact
	 * Ensures that no overlapping occurs (i.e. characters are displayed under Image backgrounds, therefore not being visible to the user)
	 */
	public void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		super.paintComponent(g);

		if (isIntro) {

			g2.drawImage((Image) scenes.header.getData(), 0, 0, getWidth(), getHeight(), this);

			
			
		}
		if (isStage1Level1) {

			g2.drawImage((Image) scenes.header.getData(), 0, 0, getWidth(), getHeight(), this);

		}

		if (isStage1Level2 && !Prologue.isBossFight) {

			g2.drawImage((Image) scenes.header.getData(), 0, 0, getWidth(), getHeight(), this);

		}
		if (isStage1Level2 && Prologue.startBossFight) {

			g2.drawImage(stage1Level2Boss, 0, 0, getWidth(), getHeight(), this);

		}
		if (isStage1Level3) {

			g2.drawImage((Image) scenes.header.getData(), 0, 0, getWidth(), getHeight(), this);

		}
		if (isStage1Level3 && Prologue.startBossFight) {

			g2.drawImage(stage1Level2Boss, 0, 0, getWidth(), getHeight(), this);

		}
		if (isStage2Level1) {

			g2.drawImage((Image) scenes.header.getData(), 0, 0, getWidth(), getHeight(), this);

		}

		if (isStage2Level2) {

			g2.drawImage((Image) scenes.header.getData(), 0, 0, getWidth(), getHeight(), this);

		}

		if (isStage2Level3) {

			g2.drawImage((Image) scenes.header.getData(), 0, 0, getWidth(), getHeight(), this);

		}

		if (isStage2Level3 && Prologue.isBossFight) {

			g2.drawImage(stage1Level2Boss, 0, 0, getWidth(), getHeight(), this);

		}

		if (isStage3Level1) {

			g2.drawImage((Image) scenes.header.getData(), 0, 0, getWidth(), getHeight(), this);

		}

		if (isEpilogue) {

			g2.drawImage(MainFrame.bkgIntro, 0, 0, getWidth(), getHeight(), null);

		}

		if (isFinalBoss) {

			g2.drawImage(stage3Level2, 0, 0, getWidth(), getHeight(), this);

		}

		for (int i = 0; i < npc.length; i++) {
			if (npc[i] != null) {

				npc[i].draw(g2);

			}

		}

		for (int i = 0; i < obj.length; i++) {

			if (obj[i] != null) {

				obj[i].draw(g2, this);

			}

		}

		if (Player.HP <= 0) {

			g2.drawImage((Image) gameOver, 0, 0, getWidth(), getHeight(), this);

		}

		player.draw(g2);

		g2.dispose();

	}
}

/** TileManager.java  applies collision checking for each stage in the game,
	ensuring that the player doesn't reach out of bounds.
	Collision checking for each stage was coded manually.
**/

package logic;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import entity.BOSS_Ted;
import entity.BOSS_Tyler;
import entity.Prologue;
import game.MainFrame;
import entity.NPC_Elizabeth;
import entity.NPC_Jennie;
import entity.NPC_Tyler;
import entity.Player;
import object.Notebook;
import object.Objects;

public class CollisionDetector {

	MainFrame gp;
	
	public BufferedImage image;
	public boolean collision = false;
	
	public static boolean modifyBlockBounds1_2 = true;
	public static boolean modifyBlockBounds1_1 = false;

	public static boolean modifyBlockBounds1_3 = false;
	public static boolean modifyBlockBounds2_2 = false;
	public static boolean modifyBlockBounds2_3 = true;

	public CollisionDetector(MainFrame gp) {

		this.gp = gp;

	}

	/*
	 * Checks collisions with players in pre-determined invisible boxes 
	 * If the user collides with such bounds, it either:
	 * - transports the user to another level
	 * - prevents the user from accessing a certain area
	 */
	public boolean checkCollision(int playerX, int playerY, int playerSpeed) {

		Rectangle playerBounds = new Rectangle(playerX, playerY + playerSpeed, gp.tileSize, gp.tileSize);

		if (MainFrame.isStage2Level3) {

			Rectangle blockBounds99 = new Rectangle(310, 190, 75, 75);

			if (playerBounds.intersects(blockBounds99) && modifyBlockBounds2_3  ) {

				Prologue.isBossFight = true;

				
			} 

			Rectangle blockBounds100 = new Rectangle(310, 30, 75, 75);

			if (playerBounds.intersects(blockBounds100)) {

				MainFrame.isStage2Level3 = false;
				MainFrame.isStage3Level1 = true;
				MainFrame.scenes.header = MainFrame.scenes.header.getNext();
				

			}

		}

		if (MainFrame.isStage2Level2) {

			Rectangle blockBounds99 = new Rectangle(345, 250, 48, 48);

			if (playerBounds.intersects(blockBounds99) && !modifyBlockBounds2_2) {

				Objects.nearBlue = true;
				Player.canHeal = true;
				

			} else {

				Objects.nearBlue = false;
				
			}

		}
		
		if (MainFrame.isStage1Level3) {

			Rectangle bossBounds = new Rectangle(300, 320, 48, 48);

			if (playerBounds.intersects(bossBounds)) {

				Prologue.isBossFight = true;

			} else {
				
				
				Prologue.isBossFight = false;
			}

			

		}

		

		if (MainFrame.isStage1Level2) {

			Rectangle blockBounds1 = new Rectangle(310, 270, 48, 48);

			Rectangle blockBounds2 = new Rectangle(310, 92, 100, 100);

			if (playerBounds.intersects(blockBounds2)) {

				System.out.println("HEAD TO THIRD STAGE");

				MainFrame.isStage1Level3 = true;
				MainFrame.isStage1Level2 = false;
			
				MainFrame.scenes.header = MainFrame.scenes.header.getNext();
			
			}

			if (blockBounds1.intersects(playerBounds) && modifyBlockBounds1_2) {

				System.out.println("initiate boss fight");

				Prologue.isBossFight = true;

				return true;

			}

		}

		if (MainFrame.isStage1Level1) {

			Rectangle blockBounds99 = new Rectangle(200, 250, 48, 48);

			if (playerBounds.intersects(blockBounds99) && !modifyBlockBounds1_1) {

				Objects.nearGreen = true;
				Player.canHeal = true;

			} else {

				Objects.nearGreen = false;
			}

			Rectangle blockBounds1 = new Rectangle(5, 160, 48, 48);
			Rectangle blockBounds2 = new Rectangle(600, 160, 48, 48);

			Rectangle blockBounds3 = new Rectangle(120, 120, 48, 48);

			Rectangle blockBounds4 = new Rectangle(200, 120, 48, 48);

			Rectangle blockBounds5 = new Rectangle(280, 120, 48, 48);

			Rectangle blockBounds6 = new Rectangle(360, 120, 48, 48);

			Rectangle blockBounds7 = new Rectangle(400, 120, 48, 48);

			Rectangle blockBounds8 = new Rectangle(450, 120, 48, 48);

			Rectangle blockBounds9 = new Rectangle(470, 120, 48, 48);

			Rectangle blockBounds10 = new Rectangle(670, 250, 48, 48);

			Rectangle blockBounds11 = new Rectangle(670, 270, 48, 48);

			Rectangle blockBounds12 = new Rectangle(670, 290, 48, 48);

			Rectangle blockBounds13 = new Rectangle(670, 310, 48, 48);

			Rectangle blockBounds14 = new Rectangle(670, 330, 48, 48);

			Rectangle blockBounds15 = new Rectangle(670, 350, 48, 48);

			Rectangle blockBounds16 = new Rectangle(600, 400, 48, 48);

			if (blockBounds1.intersects(playerBounds)) {

				System.out.println("COL WITH ENTRANCE 1");

				MainFrame.isStage1Level2 = true;
				MainFrame.isIntro = false;
				MainFrame.isStage1Level1 = false;

				MainFrame.numSeconds = 0;
				

				return true;
			}

			if (blockBounds2.intersects(playerBounds)) {

				MainFrame.isStage1Level2 = true;

				MainFrame.isIntro = false;
				MainFrame.isStage1Level1 = false;

				MainFrame.numSeconds = 0;

				return true;
			}

			if (blockBounds3.intersects(playerBounds) || blockBounds4.intersects(playerBounds)
					|| blockBounds5.intersects(playerBounds) || blockBounds6.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds7.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds8.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds9.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds10.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds11.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds12.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds13.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds14.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds15.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds16.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

		}

		if (MainFrame.isIntro) {

			// manually tweak this so that the player would have to come within x bounds of
			// the NPC to interact with them
			Rectangle yukikoBounds = new Rectangle(NPC_Jennie.Jennie_X - 80, NPC_Jennie.Jennie_Y + playerSpeed,
					gp.tileSize - 10, gp.tileSize - 10);

			Rectangle elizabethBounds = new Rectangle(NPC_Elizabeth.Elizabeth_X - 80,
					NPC_Elizabeth.Elizabeth_Y + playerSpeed, gp.tileSize - 10, gp.tileSize - 10);

			Rectangle yosukeBounds = new Rectangle(NPC_Tyler.Tyler_X - 80, NPC_Tyler.Tyler_Y + playerSpeed,
					gp.tileSize - 10, gp.tileSize - 10);

			Rectangle notebookBounds = new Rectangle(Notebook.notebookX + 20, Notebook.notebookY + playerSpeed,
					gp.tileSize - 10, gp.tileSize - 10);

			Rectangle blockBounds1 = new Rectangle(100, 0, gp.tileSize, gp.tileSize);

			Rectangle blockBounds2 = new Rectangle(100, 48, gp.tileSize, gp.tileSize);

			Rectangle blockBounds3 = new Rectangle(150, 48, gp.tileSize, gp.tileSize);

			Rectangle blockBounds4 = new Rectangle(200, 48, gp.tileSize, gp.tileSize);

			Rectangle blockBounds5 = new Rectangle(250, 48, gp.tileSize, gp.tileSize);

			Rectangle blockBounds6 = new Rectangle(250, 85, gp.tileSize, gp.tileSize);

			Rectangle blockBounds7 = new Rectangle(200, 90, gp.tileSize, gp.tileSize);

			Rectangle blockBounds8 = new Rectangle(150, 140, gp.tileSize, gp.tileSize);

			Rectangle blockBounds9 = new Rectangle(130, 200, gp.tileSize, gp.tileSize);

			Rectangle blockBounds10 = new Rectangle(70, 250, gp.tileSize, gp.tileSize);

			Rectangle blockBounds11 = new Rectangle(20, 300, gp.tileSize, gp.tileSize);

			Rectangle blockBounds12 = new Rectangle(-45, 350, gp.tileSize, gp.tileSize);

			Rectangle blockBounds13 = new Rectangle(5, 410, gp.tileSize, gp.tileSize);

			Rectangle blockBounds14 = new Rectangle(20, 410, gp.tileSize, gp.tileSize);

			Rectangle blockBounds15 = new Rectangle(65, 410, gp.tileSize, gp.tileSize);

			Rectangle blockBounds16 = new Rectangle(105, 410, gp.tileSize, gp.tileSize);

			Rectangle blockBounds17 = new Rectangle(160, 410, gp.tileSize, gp.tileSize);

			Rectangle blockBounds18 = new Rectangle(250, 410, gp.tileSize, gp.tileSize);

			Rectangle blockBounds19 = new Rectangle(230, 500, gp.tileSize, gp.tileSize);

			Rectangle blockBounds20 = new Rectangle(480, 40, gp.tileSize, gp.tileSize);

			Rectangle blockBounds21 = new Rectangle(430, 120, gp.tileSize, gp.tileSize);

			Rectangle blockBounds22 = new Rectangle(550, 160, gp.tileSize, gp.tileSize);

			Rectangle blockBounds23 = new Rectangle(600, 170, gp.tileSize, gp.tileSize);

			Rectangle blockBounds24 = new Rectangle(675, 160, gp.tileSize, gp.tileSize);

			Rectangle blockBounds25 = new Rectangle(550, 100, gp.tileSize, gp.tileSize);

			Rectangle blockBounds26 = new Rectangle(630, 100, gp.tileSize, gp.tileSize);

			Rectangle blockBounds27 = new Rectangle(485, 130, gp.tileSize, gp.tileSize);

			Rectangle blockBounds28 = new Rectangle(485, 90, gp.tileSize, gp.tileSize);

			Rectangle blockBounds29 = new Rectangle(560, 20, gp.tileSize, gp.tileSize);

			Rectangle blockBounds30 = new Rectangle(600, 15, gp.tileSize, gp.tileSize);

			Rectangle blockBounds31 = new Rectangle(650, 15, gp.tileSize, gp.tileSize);

			Rectangle blockBounds32 = new Rectangle(700, 15, gp.tileSize, gp.tileSize);

			Rectangle blockBounds33 = new Rectangle(500, 410, gp.tileSize, gp.tileSize);

			Rectangle blockBounds34 = new Rectangle(570, 410, gp.tileSize, gp.tileSize);

			Rectangle blockBounds35 = new Rectangle(630, 410, gp.tileSize, gp.tileSize);

			Rectangle blockBounds36 = new Rectangle(700, 410, gp.tileSize, gp.tileSize);

			Rectangle blockBounds37 = new Rectangle(450, 410, gp.tileSize, gp.tileSize);

			Rectangle blockBounds38 = new Rectangle(430, 460, gp.tileSize, gp.tileSize);

			Rectangle blockBounds39 = new Rectangle(330, 490, gp.tileSize, gp.tileSize);

			Rectangle blockBounds40 = new Rectangle(280, 490, gp.tileSize, gp.tileSize);

			// If player intersects with a block, return true (collision detected)
			if (blockBounds1.intersects(playerBounds) || blockBounds2.intersects(playerBounds)
					|| blockBounds3.intersects(playerBounds) || blockBounds4.intersects(playerBounds)) {
				// System.out.println("COL");
				return true;
			}

			if (blockBounds5.intersects(playerBounds)) {
				// System.out.println("COL");
				return true;
			}

			if (blockBounds6.intersects(playerBounds)) {
				// System.out.println("COL");
				return true;
			}

			if (blockBounds7.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds8.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds9.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds10.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds11.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds12.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds13.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds14.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds15.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds16.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds17.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds18.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}
			if (blockBounds19.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds20.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds21.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds22.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds23.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds24.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds25.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds26.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds27.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds28.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds29.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds30.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds31.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds32.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds34.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds35.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds36.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds37.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds38.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds39.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (blockBounds40.intersects(playerBounds)) {
				System.out.println("COL");
				return true;
			}

			if (playerBounds.intersects(yukikoBounds)) {
				// System.out.println("NPC_Yukiko INTERACTION");

				NPC_Jennie.nearJennie = true;

			} else {
				NPC_Jennie.nearJennie = false;

			}

			if (playerBounds.intersects(elizabethBounds)) {
				// System.out.println("NPC_Elizabeth INTERACTION");

				NPC_Elizabeth.nearElizabeth = true;

			} else {
				NPC_Elizabeth.nearElizabeth = false;

			}

			if (playerBounds.intersects(yosukeBounds)) {
				// System.out.println("NPC_Elizabeth INTERACTION");

				NPC_Tyler.nearTyler = true;

			} else {

				NPC_Tyler.nearTyler = false;

			}

			if (!Notebook.objectFound) {

				if (playerBounds.intersects(notebookBounds)) {

					Notebook.nearNotebook = true;

				} else {

					Notebook.nearNotebook = false;

				}

			} else {

			}

		}

		return false;
	}

}

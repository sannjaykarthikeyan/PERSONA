package game;

import entity.NPC_Jennie;
import object.Notebook;

public class Resources {

	MainFrame gp;

	public Resources(MainFrame gp) {

		this.gp = gp;

	}

	/*
	 * Places in-game interactive objects (i.e. notebook, healing potions) in the game map (MainFrame JPanel).
	 */
	public void setObject() {

		gp.obj[0] = new Notebook();
		gp.obj[0].worldX = 23 * gp.tileSize; // might need to change this
		gp.obj[0].worldY = 7 * gp.tileSize;

	}

	/*
	 * Places interactive NPCs in the game map (MainFrame JPanel)
	 */
	public void setNPC() {

		gp.npc[0] = new NPC_Jennie(gp);
		gp.npc[0].worldX = gp.tileSize * 21;
		gp.npc[0].worldY = gp.tileSize * 21;

	}

}

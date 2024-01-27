package menus;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Controls extends JFrame {

	static int menuChoice = 0;

	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {


				try {
					Controls frame = new Controls();
					frame.setVisible(true);
				} catch (Exception e) {
					System.out.println("Cannot find necessary images. Please try again.");
				}
			}
		});
	}

	/*
	 * Allows user to view the game's various controls.
	 * Works behind other existing JPanels (can be viewed while playing the game in the MainFrame game panel)
	 */
	public Controls() {

		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		JLabel background = new JLabel("bkg");
		background.setBounds(0, 0, 500, 500);
		background.setIcon(new ImageIcon("mainMenus/controls.png"));

		getContentPane().add(background);




		}

}

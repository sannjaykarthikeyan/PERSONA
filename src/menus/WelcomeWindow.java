package menus;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.SwingConstants;

import org.w3c.dom.html.HTMLFrameElement;

import entity.Player;
import game.MainFrame;
import game.Intro;
import system.WriteTextFile;

import java.awt.Color;
import javax.swing.JTextField;

public class WelcomeWindow extends JFrame {
	private JTextField txtFirstName;
	private JTextField txtLastName;

	static WelcomeWindow frame = new WelcomeWindow();

	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {

				try {
					frame.setVisible(true);
				} catch (Exception e) {

				}
			}
		});
	}

	
	/*
	 * Welcomes the user with a game description, prompting them to enter their 
	 * player character's name.
	 * Handles blank fields and improper input for name entering.
	 */
	public WelcomeWindow() {

		this.setSize(1280, 720);
		this.setLocationRelativeTo(null);
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		getContentPane().setLayout(null);

		txtLastName = new JTextField();
		txtLastName.setFont(new Font("MS Gothic", Font.BOLD | Font.ITALIC, 18));
		txtLastName.setBounds(300, 464, 560, 43);
		txtLastName.setColumns(10);
		txtLastName.setVisible(false);

		JLabel familyName = new JLabel("Last Name");
		familyName.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		familyName.setForeground(Color.WHITE);
		familyName.setBounds(300, 518, 553, 14);
		getContentPane().add(familyName);
		familyName.setVisible(false);

		JLabel surname = new JLabel("First Name");
		surname.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		surname.setForeground(Color.WHITE);
		surname.setBounds(300, 418, 553, 14);
		getContentPane().add(surname);
		surname.setVisible(false);
		getContentPane().add(txtLastName);

		txtFirstName = new JTextField();
		txtFirstName.setFont(new Font("MS Gothic", Font.BOLD | Font.ITALIC, 18));
		txtFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		txtFirstName.setToolTipText("First Name");
		txtFirstName.setBounds(300, 369, 560, 43);
		getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		txtFirstName.setVisible(false);

		JButton confirm = new JButton("CONFIRM");
		confirm.setBackground(new Color(255, 0, 0));
		confirm.setForeground(new Color(255, 255, 255));
		confirm.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		confirm.setBounds(1129, 596, 100, 50);
		getContentPane().add(confirm);
		confirm.setVisible(false);
		confirm.setEnabled(false);

		JLabel names = new JLabel("Enter your first and last name.");
		names.setForeground(Color.WHITE);
		names.setHorizontalAlignment(SwingConstants.CENTER);
		names.setFont(new Font("Serif", Font.BOLD, 37));
		names.setBounds(114, 225, 886, 100);
		getContentPane().add(names);
		names.setVisible(false);

		JLabel desc0 = new JLabel("");
		desc0.setForeground(Color.WHITE);
		desc0.setHorizontalAlignment(SwingConstants.CENTER);
		desc0.setFont(new Font("Serif", Font.BOLD, 37));

		desc0.setBounds(225, 225, 800, 100);
		getContentPane().add(desc0);
		desc0.setVisible(false);

		JLabel desc1 = new JLabel("You are a prisoner of an unfortunate fate.");
		desc1.setForeground(Color.WHITE);
		desc1.setHorizontalAlignment(SwingConstants.CENTER);
		desc1.setFont(new Font("Serif", Font.BOLD, 37));
		desc1.setBounds(220, 308, 835, 83);
		getContentPane().add(desc1);
		desc1.setVisible(false);

		JLabel desc2 = new JLabel("With the power of your allies, you may emerge victorious.");
		desc2.setForeground(Color.WHITE);
		desc2.setHorizontalAlignment(SwingConstants.CENTER);
		desc2.setFont(new Font("Serif", Font.BOLD, 37));
		desc2.setBounds(130, 390, 962, 83);
		getContentPane().add(desc2);
		desc2.setVisible(false);

		JLabel desc3 = new JLabel("May fortune smile upon you.");
		desc3.setForeground(Color.WHITE);
		desc3.setHorizontalAlignment(SwingConstants.CENTER);
		desc3.setFont(new Font("Serif", Font.BOLD, 37));
		desc3.setBounds(220, 474, 835, 83);
		getContentPane().add(desc3);
		desc3.setVisible(false);

		JLabel background = new JLabel("bkg");
		background.setBounds(0, 0, 1280, 720);
		background.setIcon(new ImageIcon("mainMenus/welcome.png"));

		getContentPane().add(background);

		JButton next1 = new JButton("NEXT");
		next1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 17));
		next1.setForeground(new Color(255, 255, 255));
		next1.setBackground(new Color(255, 0, 0));
		next1.setBounds(1129, 596, 100, 50);
		getContentPane().add(next1);

		JButton next2 = new JButton("NEXT");
		next2.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 17));
		next2.setBackground(new Color(255, 0, 0));
		next2.setForeground(new Color(255, 255, 255));
		next2.setBounds(1129, 596, 100, 50);
		getContentPane().add(next2);
		next2.setEnabled(false);
		next2.setVisible(false);

		next1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == next1) {

					next1.setVisible(false);
					next1.setEnabled(false);

					txtFirstName.setVisible(true);
					txtLastName.setVisible(true);
					names.setVisible(true);
					confirm.setVisible(true);
					confirm.setEnabled(true);
					surname.setVisible(true);
					familyName.setVisible(true);

				}

			}

		});

		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == confirm) {

					if (txtFirstName.getText().length() > 1 && txtLastName.getText().length() > 1) {

						Player.plrFirstName = txtFirstName.getText();
						Player.plrLastName = txtLastName.getText();
						confirm.setVisible(false);
						confirm.setEnabled(false);

						txtFirstName.setVisible(false);
						txtLastName.setVisible(false);
						names.setEnabled(false);
						names.setVisible(false);

						next2.setVisible(true);
						next2.setEnabled(true);
						desc0.setEnabled(true);

						desc0.setText("Welcome " + Player.plrFirstName + " " + Player.plrLastName + ".");

						desc0.setVisible(true);

						desc1.setVisible(true);
						desc2.setVisible(true);
						desc3.setVisible(true);

						surname.setVisible(false);
						familyName.setVisible(false);

					} else {

						names.setText("Fields are empty. Please enter a first and last name.");

					}

				}

			}

		});

		next2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == next2) {

					frame.toBack();
					frame.dispose();
					frame.setVisible(false);
					Intro.gameStart();

				}

			}

		});

	}
}

package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Font;

public class aboutView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aboutView window = new aboutView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public aboutView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 696, 419);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea about= new JTextArea("THIS GAME IS IMPLEMENTED BY TEAM NULL"
				+ "MOHAMED MOSTAFA&AHMED MESAMED&MOSAP MORGAN");
		about.setFont(new Font("Montserrat Black", Font.BOLD, 13));
		about.setWrapStyleWord(true);
		about.setLineWrap(true);
		about.setBounds(0, 0, 682, 382);
		frame.getContentPane().add(about);
		
	}
}

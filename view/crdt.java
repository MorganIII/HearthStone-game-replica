package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import javax.swing.JPanel;

public class crdt {

	private JFrame frame;

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					crdt window = new crdt();
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
	public crdt() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/Game of Thrones.ttf")));
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frame = new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		// makes game maximized -full screen- like PES or FIFA
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(10, 10, screenWidth, screenHeight);
		ImagePanel panel = new ImagePanel("image/BGs/plain.jpg");
		frame.setContentPane(panel);
		
		JTextArea txtrThisGameWas = new JTextArea();
		txtrThisGameWas.setEditable(false);
		txtrThisGameWas.setText("This  Game  Was  Developed  By  \r\n\r\n\r\nMohamed  Mostafa              Mosaab  Morgan                  Ahmed  Mesameh                    Abdullah  Saafan\r\n");
		txtrThisGameWas.setWrapStyleWord(true);
		txtrThisGameWas.setLineWrap(true);
		txtrThisGameWas.setFont(new Font("Game of Thrones", Font.PLAIN, 20));
		txtrThisGameWas.setForeground(Color.WHITE);
		txtrThisGameWas.setBounds(44, 11, 1296, 108);
		txtrThisGameWas.setOpaque(false);
		panel.add(txtrThisGameWas);
		
		ImagePanel D = new ImagePanel("image/win/E.PNG");
		D.setBounds(54, 137, 186, 207);
		panel.add(D);
		
		ImagePanel D2 = new ImagePanel("image/win/E.PNG");
		D2.setBounds(394, 137, 186, 207);
		panel.add(D2);
		
		ImagePanel D3 = new ImagePanel("image/win/E.PNG");
		D3.setBounds(723, 137, 186, 207);
		panel.add(D3);
		
		ImagePanel D4 = new ImagePanel("image/win/E.PNG");
		D4.setBounds(1083, 137, 186, 207);
		panel.add(D4);
		
		JTextArea abt1 = new JTextArea();
		abt1.setEditable(false);
		abt1.setText("46- Networking Student");
		abt1.setWrapStyleWord(true);
		abt1.setOpaque(false);
		abt1.setLineWrap(true);
		abt1.setForeground(Color.WHITE);
		abt1.setFont(new Font("Dialog", Font.PLAIN, 20));
		abt1.setBounds(44, 403, 229, 248);
		panel.add(abt1);
		
		JTextArea abt2 = new JTextArea();
		abt2.setEditable(false);
		abt2.setText("46- Networking Student");
		abt2.setWrapStyleWord(true);
		abt2.setOpaque(false);
		abt2.setLineWrap(true);
		abt2.setForeground(Color.WHITE);
		abt2.setFont(new Font("Dialog", Font.PLAIN, 20));
		abt2.setBounds(379, 403, 229, 248);
		panel.add(abt2);
		
		JTextArea abt3 = new JTextArea();
		abt3.setEditable(false);
		abt3.setText("46- Networking Student");
		abt3.setWrapStyleWord(true);
		abt3.setOpaque(false);
		abt3.setLineWrap(true);
		abt3.setForeground(Color.WHITE);
		abt3.setFont(new Font("Dialog", Font.PLAIN, 20));
		abt3.setBounds(709, 403, 229, 248);
		panel.add(abt3);
		
		JTextArea abt4 = new JTextArea();
		abt4.setEditable(false);
		abt4.setText("46- MET Student ");
		abt4.setWrapStyleWord(true);
		abt4.setOpaque(false);
		abt4.setLineWrap(true);
		abt4.setForeground(Color.WHITE);
		abt4.setFont(new Font("Dialog", Font.PLAIN, 20));
		abt4.setBounds(1061, 403, 229, 248);
		panel.add(abt4);
	}
}

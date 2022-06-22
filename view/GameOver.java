package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLayeredPane;
import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class GameOver {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameOver window = new GameOver();
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
	public GameOver() {
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
		ImagePanel panel = new ImagePanel("image/BGs/Win2.jpg");
		frame.setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Congratulations Mohammed");
		lblNewLabel.setOpaque(false);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Game of Thrones", Font.PLAIN, 40));
		lblNewLabel.setBounds(71, 75, 878, 89);
		panel.add(lblNewLabel);
		
		JLabel lblYouEarnedIt = new JLabel("You Earned It");
		lblYouEarnedIt.setForeground(Color.BLACK);
		lblYouEarnedIt.setVerticalAlignment(SwingConstants.TOP);
		lblYouEarnedIt.setOpaque(false);
		lblYouEarnedIt.setFont(new Font("Game of Thrones", Font.PLAIN, 40));
		lblYouEarnedIt.setBounds(71, 175, 588, 89);
		panel.add(lblYouEarnedIt);
		
		ImagePanel panel_1 = new ImagePanel("image/BGs/Field.png");
		panel_1.setBounds(1200, 734, 89, 23);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton crdt = new JButton("Credits");
		crdt.setBounds(0, 0, 89, 23);
		panel_1.add(crdt);
		crdt.setUI(new MyButtonUI());
		crdt.setOpaque(false);
		
		JLayeredPane card = new JLayeredPane();
		card.setLayout(null);
		card.setOpaque(false);
		card.setBounds(399, 256, 286, 395);
		panel.add(card);
		
		JLayeredPane Shower = new JLayeredPane();
		Shower.setBounds(0, 0, 286, 395);
		card.add(Shower);
		Shower.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel Hero = new JLabel("");
		Hero.setIcon(new ImageIcon("image/win/Hunter.png"));
		Shower.add(Hero);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		card.setLayer(layeredPane_1, 1);
		layeredPane_1.setBounds(225, 245, 44, 44);
		card.add(layeredPane_1);
		layeredPane_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel bld = new JLabel(new ImageIcon("image/images small/tool/n/15.png"));
		layeredPane_1.setLayer(bld, 1);
		layeredPane_1.add(bld);
		crdt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				crdt c =new crdt();
				c.getFrame().setVisible(true);
				frame.dispose();
				
			}
		});
		
//		ImagePanel panel_1 = new ImagePanel("image/BGs/credit2.jpg");
//		panel_1.setLayout(null);
//		panel_1.setOpaque(false);
//		panel_1.setBounds(964, 75, 373, 500);
//		panel.add(panel_1);
//		
//		JLabel lblThisGameWas = new JLabel("This Game Was Developed by");
//		lblThisGameWas.setVerticalAlignment(SwingConstants.TOP);
//		lblThisGameWas.setOpaque(false);
//		lblThisGameWas.setFont(new Font("Game of Thrones", Font.PLAIN, 20));
//		lblThisGameWas.setBounds(0, 11, 373, 48);
//		panel_1.add(lblThisGameWas);
//		
//		JLabel lblMohamedMostafa = new JLabel("Mohamed Mostafa");
//		lblMohamedMostafa.setVerticalAlignment(SwingConstants.TOP);
//		lblMohamedMostafa.setOpaque(false);
//		lblMohamedMostafa.setFont(new Font("Game of Thrones", Font.PLAIN, 20));
//		lblMohamedMostafa.setBounds(0, 70, 373, 45);
//		panel_1.add(lblMohamedMostafa);
//		
//		JLabel lblMosabMorgan = new JLabel("Mosab Morgan");
//		lblMosabMorgan.setVerticalAlignment(SwingConstants.TOP);
//		lblMosabMorgan.setOpaque(false);
//		lblMosabMorgan.setFont(new Font("Game of Thrones", Font.PLAIN, 20));
//		lblMosabMorgan.setBounds(0, 126, 373, 48);
//		panel_1.add(lblMosabMorgan);
//		
//		JLabel lblAhmedMesameh = new JLabel("Ahmed Mesameh");
//		lblAhmedMesameh.setVerticalAlignment(SwingConstants.TOP);
//		lblAhmedMesameh.setOpaque(false);
//		lblAhmedMesameh.setFont(new Font("Game of Thrones", Font.PLAIN, 20));
//		lblAhmedMesameh.setBounds(0, 185, 373, 48);
//		panel_1.add(lblAhmedMesameh);
//		
//		JLabel lblAbdullahSaafan = new JLabel("Abdullah Saafan");
//		lblAbdullahSaafan.setVerticalAlignment(SwingConstants.TOP);
//		lblAbdullahSaafan.setOpaque(false);
//		lblAbdullahSaafan.setFont(new Font("Game of Thrones", Font.PLAIN, 20));
//		lblAbdullahSaafan.setBounds(0, 244, 373, 48);
//		panel_1.add(lblAbdullahSaafan);
	}
}

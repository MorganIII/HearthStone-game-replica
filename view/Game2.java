package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.GridLayout;

public class Game2 {

	private JFrame frmHearthstone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game2 window = new Game2();
					window.frmHearthstone.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Game2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHearthstone = new JFrame();
		frmHearthstone.setResizable(false);
		frmHearthstone.setTitle("HearthStone");
		
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		//436 ,,  296 
		try {
			resize("image/B.jpg","image/B1.jpg",screenWidth,screenHeight);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JLabel img=new JLabel(new ImageIcon("image/BG.jpg"));
		frmHearthstone.setContentPane(img);
		frmHearthstone.setBounds(100, 100, screenWidth
				, screenHeight);
		frmHearthstone.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		GroupLayout groupLayout = new GroupLayout(frmHearthstone.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, screenWidth, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(0, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, screenHeight, Short.MAX_VALUE)
		);
		
		JPanel oppArea = new JPanel();
		oppArea.setBounds(60, 11, 1296, 310);
		oppArea.setOpaque(false);
		JPanel curArea = new JPanel();
		curArea.setBounds(59, 364, 1297, 347);
		curArea.setOpaque(false);
		
		
		JPanel curHero = new JPanel();
		curHero.setBackground(Color.BLUE);
		
		JPanel curField = new JPanel();
		//curField.setBackground(Color.MAGENTA);
		curField.setOpaque(false);
		JPanel curHand = new JPanel();
		//curHand.setBackground(Color.GREEN);
		curHand.setOpaque(false);
		JLabel label = new JLabel("new");
		curHand.add(label);
		JPanel show = new JPanel();
		show.setOpaque(false);
	//	show.setBackground(Color.WHITE);
		GroupLayout gl_curArea = new GroupLayout(curArea);
		gl_curArea.setHorizontalGroup(
			gl_curArea.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_curArea.createSequentialGroup()
					.addGap(25)
					.addComponent(show, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_curArea.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_curArea.createSequentialGroup()
							.addGap(240)
							.addComponent(curField, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_curArea.createSequentialGroup()
							.addGap(231)
							.addComponent(curHand, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_curArea.createSequentialGroup()
							.addGap(413)
							.addComponent(curHero, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
					.addGap(5))
		);
		gl_curArea.setVerticalGroup(
			gl_curArea.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_curArea.createSequentialGroup()
					.addGroup(gl_curArea.createParallelGroup(Alignment.LEADING)
						.addComponent(show, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
						.addGroup(gl_curArea.createSequentialGroup()
							.addGap(10)
							.addComponent(curField, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(curHero, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(curHand, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		curField.setLayout(new GridLayout(0, 7, 0, 0));
		
		JLabel showLbl = new JLabel("aa");
		GroupLayout gl_show = new GroupLayout(show);
		gl_show.setHorizontalGroup(
			gl_show.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_show.createSequentialGroup()
					.addComponent(showLbl)
					.addContainerGap(166, Short.MAX_VALUE))
		);
		gl_show.setVerticalGroup(
			gl_show.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_show.createSequentialGroup()
					.addComponent(showLbl)
					.addContainerGap(268, Short.MAX_VALUE))
		);
		show.setLayout(gl_show);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				showLbl.setIcon(new ImageIcon("image/lich king.jpeg"));;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				showLbl.setIcon(null);
			}
		});
		curHand.setLayout(new GridLayout(0, 10, 0, 0));
		curHand.add(label);
		curHand.add(lblNewLabel);
		curArea.setLayout(gl_curArea);
		
		JPanel oppHand = new JPanel();
		oppHand.setBackground(new Color(102, 102, 153));
		
		//oppHand.setOpaque(false);
		JPanel oppHero = new JPanel();
		oppHero.setBackground(Color.GRAY);
		FlowLayout flowLayout = (FlowLayout) oppHero.getLayout();
		
		JPanel oppField = new JPanel();
		
		//oppField.setBackground(Color.PINK);
		oppField.setOpaque(false);
		//the hands and fields are grid layout to easily add new cards into them!!!
		oppHand.setLayout(new GridLayout(0, 10, 0, 0));
		oppField.setLayout(new GridLayout(0, 7, 0, 0));
		GroupLayout gl_oppArea = new GroupLayout(oppArea);
		gl_oppArea.setHorizontalGroup(
			gl_oppArea.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_oppArea.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_oppArea.createParallelGroup(Alignment.TRAILING)
						.addComponent(oppField, GroupLayout.PREFERRED_SIZE, 419, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_oppArea.createSequentialGroup()
							.addComponent(oppHero, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addGap(738)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(oppHand, GroupLayout.PREFERRED_SIZE, 563, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(829, Short.MAX_VALUE))
		);
		gl_oppArea.setVerticalGroup(
			gl_oppArea.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_oppArea.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_oppArea.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_oppArea.createSequentialGroup()
							.addComponent(oppHand, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
							.addComponent(oppField, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(24))
						.addGroup(gl_oppArea.createSequentialGroup()
							.addComponent(oppHero, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(181, Short.MAX_VALUE))))
		);
		oppArea.setLayout(gl_oppArea);
		panel.setLayout(null);
		panel.add(curArea);
		panel.add(oppArea);
		frmHearthstone.getContentPane().setLayout(groupLayout);
	}
	 public static void resize(String inputImagePath,
	            String outputImagePath, int scaledWidth, int scaledHeight)
	            throws IOException {
	        // reads input image
	        File inputFile = new File(inputImagePath);
	        BufferedImage inputImage = ImageIO.read(inputFile);
	 
	        // creates output image
	        BufferedImage outputImage = new BufferedImage(scaledWidth,
	                scaledHeight, inputImage.getType());
	 
	        // scales the input image to the output image
	        Graphics2D g2d = outputImage.createGraphics();
	        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
	        g2d.dispose();
	 
	        // extracts extension of output file
	        String formatName = outputImagePath.substring(outputImagePath
	                .lastIndexOf(".") + 1);
	 
	        // writes to output file
	        ImageIO.write(outputImage, formatName, new File(outputImagePath));
	    }
}

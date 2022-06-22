package view;

import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.border.LineBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.FontFormatException;

import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

public class Game3 {

	private JFrame frame;
	private ImagePanel panel;
	private ImagePanel gameContainer;
	private JPanel oppArea;
	private JPanel curArea;
	private JPanel curField;
	private JPanel curHand;
	private JPanel oppHand;
	private JPanel show;
	private JLayeredPane card;
	private JLabel cardShow;
	private JLayeredPane oppHero;
	private JLayeredPane curHero;
	private JPanel imageShow;
	private JLabel EndTurnBut;
	private JLayeredPane oppHeroShow;
	private JLBLwithCard oppheroShowlbl;
	private JPanel curMana;
	private JLBLwithCard curHeroShowlbl;
	private JPanel curSpecial;
	private JPanel oppSpecial;
	private JLabel curSpecialShow;
	private JLabel oppSpecialShow;
	private JPanel tools;
	private JPanel attackPanel;
	private JPanel castPanel;
	private JLabel attack;
	private JLabel cast;
	private ImagePanel oppFieldCustomized;
	private ImagePanel curFieldCustomized;
	private JPanel oppDeckSmart;
	private JPanel oppSmart;
	private JPanel oppMana;
	private JLabel oppManaShow;
	private JLabel curManaShow;
	private JPanel curSmart;
	private JPanel oppDeck;
	private JPanel curDeckSmart;
	private JLayeredPane curHeroShow;
	private JLabel curDeckShow;
	private JPanel curDeck;
	private JLabel oppDeckShow;
	private JLabel endTurn;
	private JPanel oppField;
	private JLayeredPane Shower;
	private JLayeredPane layeredPane;
	private JLabel atk;
	private JLayeredPane layeredPane_1;
	private JLabel bld;
	private JLayeredPane layeredPane_2;
	private JLabel shld;
	private JLabel oppBld;
	private JLayeredPane layeredPane_4;
	private JLabel curBld;
	private JLabel oppDeckLeft;
	private JLabel curDeckLeft;
	private JLabel oppName;
	private ImagePanel panel_1;
	private JLabel curName;
	public JLabel getCurName() {
		return curName;
	}

	public void setCurName(JLabel curName) {
		this.curName = curName;
	}

	public JLabel getOppDeckLeft() {
		return oppDeckLeft;
	}

	public void setOppDeckLeft(JLabel oppDeckLeft) {
		this.oppDeckLeft = oppDeckLeft;
	}

	public JLabel getCurDeckLeft() {
		return curDeckLeft;
	}

	public void setCurDeckLeft(JLabel curDeckLeft) {
		this.curDeckLeft = curDeckLeft;
	}

	public JLabel getEndTurn() {
		return endTurn;
	}

	public void setEndTurn(JLabel endTurn) {
		this.endTurn = endTurn;
	}

	public JPanel getCurSmart() {
		return curSmart;
	}

	public void setCurSmart(JPanel curSmart) {
		this.curSmart = curSmart;
	}

	public JPanel getOppDeck() {
		return oppDeck;
	}

	public void setOppDeck(JPanel oppDeck) {
		this.oppDeck = oppDeck;
	}

	public JPanel getCurDeckSmart() {
		return curDeckSmart;
	}

	public void setCurDeckSmart(JPanel curDeckSmart) {
		this.curDeckSmart = curDeckSmart;
	}

	public JLayeredPane getCurHeroShow() {
		return curHeroShow;
	}

	public void setCurHeroShow(JLayeredPane curHeroShow) {
		this.curHeroShow = curHeroShow;
	}

	public JLabel getCurDeckShow() {
		return curDeckShow;
	}

	public void setCurDeckShow(JLabel curDeckShow) {
		this.curDeckShow = curDeckShow;
	}

	public JPanel getCurDeck() {
		return curDeck;
	}

	public void setCurDeck(JPanel curDeck) {
		this.curDeck = curDeck;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game3 window = new Game3();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Game3() {
		
		
		initialize();
	frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	/**
	 * 
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
		// method to get w and h of scrren
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		// makes game maximized -full screen- like PES or FIFA
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setBounds(10, 10, screenWidth, screenHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ImagePanel is a panel with a background
		panel = new ImagePanel("image/BGs/BG1.jpg");
		frame.setContentPane(panel);
		// layout null to freely move objects
		panel.setLayout(null);

		gameContainer = new ImagePanel("");
		panel.add(gameContainer);
		gameContainer.setLayout(null);
		// relative lengths and widths
		gameContainer.setBounds((int) (screenWidth * 2 / 10), 11, 819,
				700);
		oppArea = new JPanel();
		oppArea.setLayout(null);
		oppArea.setBounds(0, 0, 819, 349);
		gameContainer.add(oppArea);
		// setOpaque makes the panel transparent (‘‹‹‹›‹‹‹«›‹‹‹…)
		oppArea.setOpaque(false);

		oppFieldCustomized = new ImagePanel("image/BGs/Field.png");
		oppFieldCustomized.setBounds(125, 217, 573, 132);
		oppArea.add(oppFieldCustomized);
		oppFieldCustomized.setLayout(null);
		
		oppField = new JPanel();
		oppField.setOpaque(false);
		oppField.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		oppField.setBounds(0, 0, 573, 132);
		oppFieldCustomized.add(oppField);
		oppField.setLayout(new GridLayout(0, 7, 0, 0));
		curArea = new JPanel();
		curArea.setBounds(0, 350, 819,
				339);
		gameContainer.add(curArea);
		curArea.setOpaque(false);
		curArea.setLayout(null);

		curFieldCustomized = new ImagePanel("image/BGs/Field.png");
		curFieldCustomized.setBounds(125, 0, 573, 132);
		curArea.add(curFieldCustomized);
		curFieldCustomized.setLayout(null);

		curField = new JPanel();
		curField.setBounds(0, 0, 573, 132);
		curFieldCustomized.add(curField);
		curField.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		curField.setLayout(new GridLayout(0, 7, 0, 0));
		curField.setOpaque(false);

		curHand = new JPanel();
		
		curHand.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		curHand.setOpaque(false);
		curHand.setBounds(10, 196, 799, 132);
		curArea.add(curHand);
		curHand.setLayout(new GridLayout(0, 10, 0, 0));

		curSpecial = new JPanel();
		curSpecial.setOpaque(false);
		curSpecial.setBounds(708, 77, 111, 111);
		curArea.add(curSpecial);

		curSpecial.setLayout(new GridLayout(0, 1, 0, 0));

		curSpecialShow = new JLabel((ImageIcon)null);
		curSpecialShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cardShow.setIcon(new ImageIcon(curSpecialShow.getIcon().toString().replace("hPow", "Pow")));
			//System.out.println(oppSpecialShow.getIcon().toString());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cardShow.setIcon(null);
			}
		});
		curSpecial.add(curSpecialShow);
		// where we will put the attack and cast spell Jlabels
		tools = new JPanel();
		tools.setBounds(20, 57, 64, 128);
		curArea.add(tools);
		tools.setOpaque(false);
		tools.setLayout(new GridLayout(0, 1, 0, 0));
		attackPanel = new JPanel();
		tools.add(attackPanel);
		attackPanel.setOpaque(false);
		attackPanel.setLayout(new GridLayout(0, 1, 0, 0));
		attack = new JLabel(new ImageIcon("image/images small/tool/attack.png"));
		attackPanel.add(attack);
		attack.setEnabled(false);
		castPanel = new JPanel();
		tools.add(castPanel);

		cast = new JLabel(new ImageIcon("image/images small/tool/cast.png"));
		cast.setEnabled(false);
		castPanel.add(cast);
		castPanel.setOpaque(false);

		oppHand = new JPanel();
		oppHand.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		oppHand.setOpaque(false);
		oppHand.setBounds(10, 11, 781, 132);
		oppArea.add(oppHand);
		oppHand.setLayout(new GridLayout(0, 10, 0, 0));

		oppSpecial = new JPanel();
		oppSpecial.setOpaque(false);
		oppSpecial.setBounds(708, 158, 111, 111);
		oppArea.add(oppSpecial);
		oppSpecial.setLayout(new GridLayout(0, 1, 0, 0));

		oppSpecialShow = new JLabel((ImageIcon)null);
		oppSpecialShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cardShow.setIcon(new ImageIcon(oppSpecialShow.getIcon().toString().replace("hPow", "Pow")));
			//System.out.println(oppSpecialShow.getIcon().toString());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cardShow.setIcon(null);
			}
		});
		oppSpecial.add(oppSpecialShow);
		
	
		

		show = new JPanel();

		show.setBounds(10, 11, 259, 700);
		panel.add(show);
		show.setLayout(null);
		show.setOpaque(false);

		card = new JLayeredPane();
		card.setBounds(20, 180, 215, 309);
		show.add(card);
		
		Shower = new JLayeredPane();
		Shower.setBounds(0, 0, 215, 309);
		card.add(Shower);
		Shower.setLayout(null);
		//card.setLayout(new GridLayout(0, 1, 0, 0));
		cardShow = new JLabel("");
		cardShow.setBounds(0, 0, 215, 309);
		Shower.add(cardShow);
		card.setOpaque(false);
		card.setLayout(null);
		
		layeredPane = new JLayeredPane();
		card.setLayer(layeredPane, 1);
		layeredPane.setBounds(10, 255, 44, 44);
		card.add(layeredPane);
		layeredPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		atk = new JLabel(new ImageIcon());
		layeredPane.add(atk);
		
		layeredPane_1 = new JLayeredPane();
		card.setLayer(layeredPane_1, 1);
		layeredPane_1.setBounds(162, 255, 44, 44);
		card.add(layeredPane_1);
		layeredPane_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		bld = new JLabel(new ImageIcon(""));
		layeredPane_1.add(bld);
		
		layeredPane_2 = new JLayeredPane();
		card.setLayer(layeredPane_2, 1);
		layeredPane_2.setBounds(0, 200, 44, 44);
		card.add(layeredPane_2);
		layeredPane_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		shld = new JLabel((Icon) null);
		layeredPane_2.add(shld);
		oppDeckSmart = new JPanel();
		oppDeckSmart.setOpaque(false);
		oppDeckSmart.setBounds(20, 11, 159, 103);
		show.add(oppDeckSmart);
		oppDeckSmart.setLayout(null);

		oppDeck = new JPanel();
		oppDeck.setBounds(0, 0, 143, 103);
		oppDeckSmart.add(oppDeck);
		oppDeck.setLayout(new GridLayout(0, 1, 0, 0));
		oppDeck.setOpaque(false);
		oppDeckShow = new JLabel(new ImageIcon("image/images big/iconR.png"));
		oppDeck.add(oppDeckShow);

		oppSmart = new JPanel();
		oppSmart.setOpaque(false);
		oppSmart.setBounds(137, 0, 22, 103);
		oppDeckSmart.add(oppSmart);
		oppSmart.setLayout(new GridLayout(0, 6, 0, 0));

		curDeckSmart = new JPanel();
		curDeckSmart.setLayout(null);
		curDeckSmart.setOpaque(false);
		curDeckSmart.setBounds(20, 586, 159, 103);
		show.add(curDeckSmart);

		curDeck = new JPanel();
		curDeck.setOpaque(false);
		curDeck.setBounds(0, 0, 143, 103);
		curDeckSmart.add(curDeck);
		curDeck.setLayout(new GridLayout(0, 1, 0, 0));

		curDeckShow = new JLabel(new ImageIcon("image/images big/iconR.png"));
		curDeck.add(curDeckShow);

		 curSmart = new JPanel();
		curSmart.setOpaque(false);
		curSmart.setBounds(137, 0, 22, 103);
		curDeckSmart.add(curSmart);
		curSmart.setLayout(new GridLayout(0, 6, 0, 0));
		
		 oppDeckLeft = new JLabel("");
		 oppDeckLeft.setFont(new Font("Courier New", Font.PLAIN, 14));
		 oppDeckLeft.setForeground(Color.WHITE);
		oppDeckLeft.setBounds(30, 125, 120, 14);
		show.add(oppDeckLeft);
		
		 curDeckLeft = new JLabel("");
		 curDeckLeft.setFont(new Font("Courier New", Font.PLAIN, 14));
		 curDeckLeft.setForeground(Color.WHITE);
		curDeckLeft.setBounds(30, 561, 120, 14);
		show.add(curDeckLeft);

		oppHero = new JLayeredPane();
		oppHero.setBounds(1109, 11, 247, 250);
		oppHero.setLayout(null);
		panel.add(oppHero);
		oppHero.setOpaque(false);
		// A panel to show the remaining Mana crystals
		oppMana = new JPanel();
		oppMana.setBorder(new LineBorder(new Color(0, 0, 128), 3, true));
		oppMana.setOpaque(false);
		oppMana.setLocation(0, 0);
		oppMana.setSize(206, 20);
		oppHero.add(oppMana);
		oppMana.setLayout(new GridLayout(0, 10, 0, 0));

		oppHeroShow = new JLayeredPane();
		oppHeroShow.setOpaque(false);
		oppHeroShow.setBounds(20, 22, 165, 228);
		oppHero.add(oppHeroShow);
		oppHeroShow.setLayout(new GridLayout(0, 1, 0, 0));

		oppheroShowlbl = new JLBLwithCard(new ImageIcon("image/images big/Warlock.png"));
		oppHeroShow.add(oppheroShowlbl);

		 oppManaShow = new JLabel("10/10");
		oppManaShow.setForeground(Color.WHITE);
		// font setting
		oppManaShow.setFont(new Font("Courier New", Font.BOLD, 14));
		oppManaShow.setBounds(191, 22, 46, 14);
		oppHero.add(oppManaShow);
		
		JLayeredPane layeredPane_3 = new JLayeredPane();
		oppHero.setLayer(layeredPane_3, 1);
		layeredPane_3.setBounds(150, 155, 40, 40);
		oppHero.add(layeredPane_3);
		layeredPane_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		oppBld = new JLabel("");
		layeredPane_3.setLayer(oppBld, 1);
		layeredPane_3.add(oppBld);

		curHero = new JLayeredPane();
		curHero.setLayout(null);
		curHero.setOpaque(false);
		curHero.setBounds(1109, 450, 247, 250);
		panel.add(curHero);

		curHeroShow = new JLayeredPane();
		curHeroShow.setOpaque(false);
		curHeroShow.setBounds(20, 0, 165, 228);
		curHero.add(curHeroShow);
		curHeroShow.setLayout(new GridLayout(0, 1, 0, 0));

		curHeroShowlbl = new JLBLwithCard(new ImageIcon("image/images big/Mage.png"));
		curHeroShow.add(curHeroShowlbl);

		curMana = new JPanel();
		curMana.setBorder(new LineBorder(new Color(0, 0, 128), 3, true));
		curMana.setOpaque(false);
		curMana.setBounds(0, 230, 206, 20);
		curHero.add(curMana);
		curMana.setLayout(new GridLayout(0, 10, 0, 0));

		curManaShow = new JLabel("10/10");
		curManaShow.setForeground(Color.WHITE);
		curManaShow.setFont(new Font("Courier New", Font.BOLD, 14));
		curManaShow.setBounds(191, 214, 46, 14);
		curHero.add(curManaShow);
		
		layeredPane_4 = new JLayeredPane();
		curHero.setLayer(layeredPane_4, 1);
		layeredPane_4.setBounds(150, 133, 40, 40);
		curHero.add(layeredPane_4);
		layeredPane_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		curBld = new JLabel("");
		layeredPane_4.setLayer(curBld, 1);
		layeredPane_4.add(curBld);

		imageShow = new JPanel();
		imageShow.setBounds(1132, 337, 150, 50);
		panel.add(imageShow);
		imageShow.setOpaque(false);
		// for loop to add 10 mana crys for both curHero and oppHero as well as adding
		// 10
		// hidden cards for the opponent
//		for (int i = 0; i < 5; i++) {
//			oppSmart.add(new JLabel(new ImageIcon("image/images big/iconR1.png")));
//			curSmart.add(new JLabel(new ImageIcon("image/images big/iconR1.png")));
//		}
//		for (int i = 0; i < 10; i++) {
//
//			oppMana.add(new JLabel(new ImageIcon("image/images small/mana.png")));
//			curMana.add(new JLabel(new ImageIcon("image/images small/mana.png")));
//			JLabel ic = new JLabel(new ImageIcon("image/images small/icon.png"));
//			ic.addMouseListener(new MouseAdapter() {
//				public void mouseEntered(MouseEvent arg0) {
//					cardShow.setIcon(new ImageIcon("image/images big/icon.png"));
//				}
//
//				@Override
//				public void mouseExited(MouseEvent e) {
//					cardShow.setIcon(null);
//				}
//			});
//			oppHand.add(ic);
//
//		}

		imageShow.setLayout(new GridLayout(0, 1, 0, 0));

		endTurn = new JLabel(new ImageIcon("image/end turn/end3.png"));
		
		imageShow.add(endTurn);
		
		panel_1 = new ImagePanel("image/images small/tool/name.png");
		panel_1.setBounds(1146, 272, 150, 50);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		oppName = new JLabel("Mohammed");
		oppName.setBounds(0, -10, 150, 50);
		oppName.setHorizontalAlignment(SwingConstants.CENTER);
		oppName.setFont(new Font("Kristen ITC", Font.BOLD, 13));
		oppName.setForeground(Color.BLACK);
		panel_1.add(oppName);
		
		ImagePanel panel_1_1 = new ImagePanel("image/images small/tool/name.png");
		panel_1_1.setBounds(1146, 395, 150, 50);
		panel.add(panel_1_1);
		 panel_1_1.setLayout(null);
		
		 curName = new JLabel("Ahmed");
		 curName.setBounds(0, -10, 150, 50);
		 curName.setHorizontalAlignment(SwingConstants.CENTER);
		 curName.setForeground(Color.BLACK);
		 curName.setFont(new Font("Kristen ITC", Font.BOLD, 13));
		panel_1_1.add(curName);

	}

	public JLabel getOppName() {
		return oppName;
	}

	public void setOppName(JLabel oppName) {
		this.oppName = oppName;
	}

	public JLabel getOppBld() {
		return oppBld;
	}

	public void setOppBld(JLabel oppBld) {
		this.oppBld = oppBld;
	}

	public JLabel getCurBld() {
		return curBld;
	}

	public void setCurBld(JLabel curBld) {
		this.curBld = curBld;
	}

	public JLabel getShld() {
		return shld;
	}

	public void setShld(JLabel shld) {
		this.shld = shld;
	}

	public JLabel getAtk() {
		return atk;
	}

	public void setAtk(JLabel atk) {
		this.atk = atk;
	}

	public JLabel getBld() {
		return bld;
	}

	public void setBld(JLabel bld) {
		this.bld = bld;
	}

	public JLabel getOppDeckShow() {
		return oppDeckShow;
	}

	public void setOppDeckShow(JLabel oppDeckShow) {
		this.oppDeckShow = oppDeckShow;
	}

	public static void resize(String inputImagePath, String outputImagePath, int scaledWidth, int scaledHeight)
			throws IOException {
		// reads input image
		File inputFile = new File(inputImagePath);
		BufferedImage inputImage = ImageIO.read(inputFile);

		// creates output image
		BufferedImage outputImage = new BufferedImage(scaledWidth, scaledHeight, inputImage.getType());

		// scales the input image to the output image
		Graphics2D g2d = outputImage.createGraphics();
		g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
		g2d.dispose();

		// extracts extension of output file
		String formatName = outputImagePath.substring(outputImagePath.lastIndexOf(".") + 1);

		// writes to output file
		ImageIO.write(outputImage, formatName, new File(outputImagePath));
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public ImagePanel getPanel() {
		return panel;
	}

	public void setPanel(ImagePanel panel) {
		this.panel = panel;
	}

	public ImagePanel getGameContainer() {
		return gameContainer;
	}

	public void setGameContainer(ImagePanel gameContainer) {
		this.gameContainer = gameContainer;
	}

	public JPanel getOppArea() {
		return oppArea;
	}

	public void setOppArea(JPanel oppArea) {
		this.oppArea = oppArea;
	}

	public JPanel getOppField() {
		return oppField;
	}

	public void setOppField(JPanel oppField) {
		this.oppField = oppField;
	}

	public JPanel getCurArea() {
		return curArea;
	}

	public void setCurArea(JPanel curArea) {
		this.curArea = curArea;
	}

	public JPanel getCurField() {
		return curField;
	}

	public void setCurField(JPanel curField) {
		this.curField = curField;
	}

	public JPanel getCurHand() {
		return curHand;
	}

	public void setCurHand(JPanel curHand) {
		this.curHand = curHand;
	}

	public JPanel getOppHand() {
		return oppHand;
	}

	public void setOppHand(JPanel oppHand) {
		this.oppHand = oppHand;
	}

	public JPanel getShow() {
		return show;
	}

	public void setShow(JPanel show) {
		this.show = show;
	}

	public JLayeredPane getCard() {
		return card;
	}

	public void setCard(JLayeredPane card) {
		this.card = card;
	}

	public JLabel getCardShow() {
		return cardShow;
	}

	public void setCardShow(JLabel cardShow) {
		this.cardShow = cardShow;
	}

	public JLayeredPane getOppHero() {
		return oppHero;
	}

	public void setOppHero(JLayeredPane oppHero) {
		this.oppHero = oppHero;
	}

	public JLayeredPane getCurHero() {
		return curHero;
	}

	public void setCurHero(JLayeredPane curHero) {
		this.curHero = curHero;
	}

	public JPanel getImageShow() {
		return imageShow;
	}

	public void setImageShow(JPanel imageShow) {
		this.imageShow = imageShow;
	}
	public JLabel getEndTurnBut() {
		return EndTurnBut;
	}

	public void setEndTurnBut(JLabel endTurnBut) {
		EndTurnBut = endTurnBut;
	}

	public JLayeredPane getOppHeroShow() {
		return oppHeroShow;
	}

	public void setOppHeroShow(JLayeredPane oppHeroShow) {
		this.oppHeroShow = oppHeroShow;
	}

	public JLBLwithCard getOppheroShowlbl() {
		return oppheroShowlbl;
	}

	public void setOppheroShowlbl(JLBLwithCard oppheroShowlbl) {
		this.oppheroShowlbl = oppheroShowlbl;
	}

	public JPanel getCurMana() {
		return curMana;
	}

	public void setCurMana(JPanel curMana) {
		this.curMana = curMana;
	}

	public JLBLwithCard getCurHeroShowlbl() {
		return curHeroShowlbl;
	}

	public void setCurHeroShowlbl(JLBLwithCard curHeroShowlbl) {
		this.curHeroShowlbl = curHeroShowlbl;
	}

	public JPanel getCurSpecial() {
		return curSpecial;
	}

	public void setCurSpecial(JPanel curSpecial) {
		this.curSpecial = curSpecial;
	}

	public JPanel getOppSpecial() {
		return oppSpecial;
	}

	public void setOppSpecial(JPanel oppSpecial) {
		this.oppSpecial = oppSpecial;
	}

	public JLabel getCurSpecialShow() {
		return curSpecialShow;
	}

	public void setCurSpecialShow(JLabel curSpecialShow) {
		this.curSpecialShow = curSpecialShow;
	}

	public JLabel getOppSpecialShow() {
		return oppSpecialShow;
	}

	public void setOppSpecialShow(JLabel oppSpecialShow) {
		this.oppSpecialShow = oppSpecialShow;
	}

	public JPanel getTools() {
		return tools;
	}

	public void setTools(JPanel tools) {
		this.tools = tools;
	}

	public JPanel getAttackPanel() {
		return attackPanel;
	}

	public void setAttackPanel(JPanel attackPanel) {
		this.attackPanel = attackPanel;
	}

	public JPanel getCastPanel() {
		return castPanel;
	}

	public void setCastPanel(JPanel castPanel) {
		this.castPanel = castPanel;
	}

	public JLabel getAttack() {
		return attack;
	}

	public void setAttack(JLabel attack) {
		this.attack = attack;
	}

	public JLabel getCast() {
		return cast;
	}

	public void setCast(JLabel cast) {
		this.cast = cast;
	}

	public ImagePanel getOppFieldCustomized() {
		return oppFieldCustomized;
	}

	public void setOppFieldCustomized(ImagePanel oppFieldCustomized) {
		this.oppFieldCustomized = oppFieldCustomized;
	}

	public ImagePanel getCurFieldCustomized() {
		return curFieldCustomized;
	}

	public void setCurFieldCustomized(ImagePanel curFieldCustomized) {
		this.curFieldCustomized = curFieldCustomized;
	}

	public JPanel getOppDeckSmart() {
		return oppDeckSmart;
	}

	public void setOppDeckSmart(JPanel oppDeckSmart) {
		this.oppDeckSmart = oppDeckSmart;
	}

	public JPanel getOppSmart() {
		return oppSmart;
	}

	public void setOppSmart(JPanel oppSmart) {
		this.oppSmart = oppSmart;
	}

	public JPanel getOppMana() {
		return oppMana;
	}

	public void setOppMana(JPanel oppMana) {
		this.oppMana = oppMana;
	}

	public JLabel getOppManaShow() {
		return oppManaShow;
	}

	public void setOppManaShow(JLabel oppManaShow) {
		this.oppManaShow = oppManaShow;
	}

	public JLabel getCurManaShow() {
		return curManaShow;
	}

	public void setCurManaShow(JLabel curManaShow) {
		this.curManaShow = curManaShow;
	}
}

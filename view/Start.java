package view;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Dimension;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.CardLayout;
import javax.swing.JTextField;

import Controller.Controller;
import exceptions.FullHandException;
import model.heroes.Hero;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JList;

public class Start implements ActionListener,MouseListener{

	private JFrame frame;
	private static JTextField input;
	private static Start window;
	private static JPanel panel_1 ;
	private static Hero firstHero;
	private static Hero secondHero;
private static 	JButton choose;
private JLabel	Hunter;
private JLabel		Priest;
private JLabel		Warlock;
private JLabel		Paladin;
private JLabel	Mage;
private static boolean isChoosen=false;
private static String firstPlayerName;
private static String secondPlayerName;
private JPanel choosePnl;
private JLabel Choose;
private static boolean bothchosen;
private static  JButton play;
private static Controller controllerstart;
private ImagePanel extPnl;
private ImagePanel abtPnl;
private ImagePanel plyPnl;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start.window = new Start();
					//controllerstart=new Controller();

					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws UnsupportedAudioFileException 
	 * @throws LineUnavailableException 
	 * @throws IOException 
	 * @throws CloneNotSupportedException 
	 * @throws FullHandException 
	 */
	public Start() throws FullHandException, CloneNotSupportedException, IOException, LineUnavailableException, UnsupportedAudioFileException {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 * @throws UnsupportedAudioFileException 
	 * @throws LineUnavailableException 
	 * @throws IOException 
	 * @throws CloneNotSupportedException 
	 * @throws FullHandException 
	 */
	private void initialize() throws FullHandException, CloneNotSupportedException, IOException, LineUnavailableException, UnsupportedAudioFileException {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		frame = new JFrame();
		frame.setBounds(10, 10, screenWidth, screenHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		ImagePanel panel = new ImagePanel("image/BGs/BG2.jpg");
		frame.setContentPane(panel);
		
		plyPnl = new ImagePanel("image/BGs/Field.png");
		plyPnl.setBounds(1081, 721, 85, 21);
		panel.add(plyPnl);
		plyPnl.setLayout(null);
		play = new JButton("PLAY");
		play.setBounds(0, 0, 85, 21);
		plyPnl.add(play);
		play.setOpaque(false);
		play.setFont(new Font("SansSerif", Font.PLAIN, 13));
		play.setUI(new MyButtonUI());
		play.setEnabled(false);
		play.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				
					frame.dispose();
					new Controller();
				
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		
		abtPnl = new ImagePanel("image/BGs/Field.png");
		
		abtPnl.setBounds(1176, 721, 85, 21);
		panel.add(abtPnl);
		abtPnl.setLayout(null);
		
		JButton about = new JButton("About");
		about.setOpaque(false);
		about.setBounds(0, 0, 85, 21);
		abtPnl.add(about);
		about.setFont(new Font("SansSerif", Font.PLAIN, 13));
		about.setUI(new MyButtonUI());
		
		extPnl = new ImagePanel("image/BGs/Field.png");
		extPnl.setBounds(1271, 721, 85, 21);
		panel.add(extPnl);
		extPnl.setLayout(null);
		JButton exit = new JButton("Exit");
		exit.setBounds(0, 0, 85, 21);
		extPnl.add(exit);
		exit.setOpaque(false);
		exit.setFont(new Font("SansSerif", Font.PLAIN, 13));
		exit.setUI(new MyButtonUI());
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				
					frame.dispose();
				//	new Controller();
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		
		 panel_1 = new JPanel();
		panel_1.setBounds(29, 27, 1000, 100);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		Choose = new JLabel(new ImageIcon("image/logos/p1.png"));
		panel_1.setOpaque(false);
		panel_1.add(Choose);
		
		JPanel Heros = new JPanel();
		Heros.setBounds(29, 183, 1217, 241);
		panel.add(Heros);
		Heros.setOpaque(false);
		Heros.setLayout(new GridLayout(0, 5, 0, 0));
		 Hunter=new JLabel(new ImageIcon("image/logos/Hunter.png"));
		 Hunter.setText("Hunter");
		Priest=new JLabel(new ImageIcon("image/logos/Priest.png"));
		Priest.setText("Priest");
	 Warlock=new JLabel(new ImageIcon("image/logos/Warlock.png"));
	 Warlock.setText("Warlock");
		 Paladin=new JLabel(new ImageIcon("image/logos/Paladin.png"));
		 Paladin.setText("Paladin");
		 Mage =new JLabel(new ImageIcon("image/logos/Mage.png"));
		 Mage.setText("Mage");
		Heros.add(Hunter);
		Heros.add(Priest);
		Heros.add(Warlock);
		Heros.add(Paladin);
		Heros.add(Mage);
		Hunter.addMouseListener(this);
		Priest.addMouseListener(this);
		Warlock.addMouseListener(this);
		Paladin.addMouseListener(this);
		Mage.addMouseListener(this);
		
		JLabel inputlbl = new JLabel(new ImageIcon("image/BGs/Field.png"));
		inputlbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		inputlbl.setBounds(540, 497, 189, 38);
		panel.add(inputlbl);
		
		JPanel heroN = new JPanel();
		heroN.setBounds(29, 431, 1217, 56);
		panel.add(heroN);
		heroN.setOpaque(false);
		heroN.setLayout(new GridLayout(0, 5, 0, 0));
		heroN.add(new JLabel(new ImageIcon("image/logos/hunter1.png")));
		heroN.add(new JLabel(new ImageIcon("image/logos/priest1.png")));
		heroN.add(new JLabel(new ImageIcon("image/logos/warlock1.png")));
		heroN.add(new JLabel(new ImageIcon("image/logos/paladin1.png")));
		heroN.add(new JLabel(new ImageIcon("image/logos/mage1.png")));
		
		input = new JTextField();
		
		input.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
				if(input.getText().equals("Enter Your Name!"))
					input.setText("");
				
			}
		});
	
		input.setText("Enter Your Name!");
		inputlbl.add(input);
		
		input.setForeground(new Color(0, 0, 0));
		input.setFont(new Font("Courier New", Font.PLAIN, 16));
		input.setName("");
		input.setOpaque(false);
		input.setColumns(10);
		input.setBounds(0, 0, 189, 38);
		
		choosePnl = new ImagePanel("image/BGs/Field.png");
		choosePnl.setBounds(560, 546, 150, 38);
		panel.add(choosePnl);
		choosePnl.setLayout(null);
		
		choose = new JButton("Choose");
		choose.setFont(new Font("SansSerif", Font.PLAIN, 14));
		choose.setUI(new MyButtonUI());
		choose.setBounds(0, 0, 150, 38);
		choosePnl.add(choose);
		choose.setOpaque(false);
		choose.addActionListener(this);
		choose.setEnabled(false);
		
		ImagePanel Track = new ImagePanel("image/BGs/Track.png");
		Track.setOpaque(false);
		Track.setBounds(29, 533, 262, 165);
		panel.add(Track);
		Track.setLayout(null);
		
		JCheckBox enblTrack = new JCheckBox("Specific Music");
		enblTrack.setOpaque(false);
		enblTrack.setBounds(6, 7, 124, 23);
		Track.add(enblTrack);
		
		final DefaultListModel<String> l1 = new DefaultListModel<>();  
        l1.addElement("C");  
        l1.addElement("C++");  
        l1.addElement("Java");  
        l1.addElement("PHP");  
        final JList<String> Tracks = new JList<>(l1);  
		Tracks.setOpaque(false);
		Tracks.setBounds(22, 50, 214, 108);
		Track.add(Tracks);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		if(isChoosen==false) {
		firstPlayerName=input.getText();
		choose.setText("choose");
		}
		else if (isChoosen) {
			secondPlayerName=input.getText();
			System.out.println(secondPlayerName);
			play.setEnabled(true);
			choose.setEnabled(false);
			choose.setText("CLICK PLAY NOW!");
			input.setEnabled(false);

		}
		choose.setEnabled(false);
		Choose.setIcon(new ImageIcon("image/logos/p2.png"));
		isChoosen=true;
		input.setText("Enter Your Name!");
		panel_1.revalidate();
		panel_1.repaint();
		
		}
	

	public static String getFirstPlayerName() {
		return firstPlayerName;
	}

	public static void setFirstPlayerName(String firstPlayerName) {
		Start.firstPlayerName = firstPlayerName;
	}

	public static String getSecondPlayerName() {
		return secondPlayerName;
	}

	public static void setSecondPlayerName(String secondPlayerName) {
		Start.secondPlayerName = secondPlayerName;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		choose.setEnabled(true);
		if(isChoosen==false) {
		if(e.getSource()==Hunter) {
		try {
			firstHero=new model.heroes.Hunter();
			choose.setText("Choose Hunter");
		} catch (IOException | CloneNotSupportedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		}
		else if(e.getSource()==Mage) {
try {
	firstHero=new model.heroes.Mage();
	choose.setText("Choose Mage");
} catch (IOException | CloneNotSupportedException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
		}
		else if(e.getSource()==Priest) {
			try {
				firstHero=new model.heroes.Priest();
				choose.setText("Choose Priest");
			} catch (IOException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		else if(e.getSource()==Warlock) {
			try {
				firstHero=new model.heroes.Warlock();
				choose.setText("Choose Warlock");
			} catch (IOException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		else if(e.getSource()==Paladin) {
			try {
				firstHero=new model.heroes.Paladin();
				choose.setText("Choose Paladin");
			} catch (IOException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		}
		else if(isChoosen) {
			if(e.getSource()==Hunter) {
				try {
					secondHero=new model.heroes.Hunter();
					choose.setText("Choose Hunter");
				} catch (IOException | CloneNotSupportedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				}
				else if(e.getSource()==Mage) {
		try {
			secondHero=new model.heroes.Mage();
			choose.setText("Choose Mage");
		} catch (IOException | CloneNotSupportedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				}
				else if(e.getSource()==Priest) {
					try {
						secondHero=new model.heroes.Priest();
						choose.setText("Choose Priest");
					} catch (IOException | CloneNotSupportedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				else if(e.getSource()==Warlock) {
					try {
						secondHero=new model.heroes.Warlock();
						choose.setText("Choose Warlock");
					} catch (IOException | CloneNotSupportedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				else if(e.getSource()==Paladin) {
					try {
						secondHero=new model.heroes.Paladin();
						choose.setText("Choose Paladin");
					} catch (IOException | CloneNotSupportedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
			
		}
		frame.revalidate();
		frame.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		JLabel l=(JLabel) e.getSource();
playSound2("sounds/startsounds/"+(String)l.getText()+".wav");
		
	
	}
	@Override
	public void mouseExited(MouseEvent e) {
		JLabel l=(JLabel) e.getSource();
		
			playSound3("sounds/startsounds/"+(String)l.getText()+".wav");
	
	}

	public static Hero getFirstHero() {
		return firstHero;
	}

	public static void setFirstHero(Hero firstHero) {
		Start.firstHero = firstHero;
	}

	public static Hero getSecondHero() {
		return secondHero;
	}

	public static void setSecondHero(Hero secondHero) {
		Start.secondHero = secondHero;
	}

	public static JButton getPlay() {
		return play;
	}
	public static void playSound(String filepath) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		
		
		AudioInputStream audioInputStream=AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile());
		
		Clip clip=AudioSystem.getClip();
		clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY); 

	
}

public static void playSound2(String filepath) {
	
	try {
		AudioInputStream audioInputStream=AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile());
		
		Clip clip=AudioSystem.getClip();
		clip.open(audioInputStream);
        clip.start(); 

	} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}public static void playSound3(String filepath) {
	
	try {
		AudioInputStream audioInputStream=AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile());
		
		Clip clip=AudioSystem.getClip();
		clip.open(audioInputStream);
        clip.stop();

	} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}

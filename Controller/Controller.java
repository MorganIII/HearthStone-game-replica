package Controller;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.management.modelmbean.ModelMBean;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.Game;
import engine.GameListener;
import exceptions.FullHandException;
import model.cards.Card;
import model.cards.minions.Minion;
import model.cards.spells.Spell;
import model.heroes.Hero;
import model.heroes.Hunter;
import model.heroes.Mage;
import model.heroes.Priest;
import view.Game3;
import view.JLBLwithCard;
import view.Start;

public class Controller implements GameListener{
	private static String p1Name;
	private static String p2Name;
	private static String p1;
	private static String p2;
	private static Game3 view;
	private static Start start;
	private static Game Model;
	private static Hero currentHero;
	private static Hero opponentHero;
	private static ArrayList<JLBLwithCard> currHeroHand;
	private static ArrayList<JLBLwithCard> currHeroField;
	private static ArrayList<JLBLwithCard> oppHeroField;

	private static ListenToCurrentHand ListenToCurrentHand;
   private static listenForCastSpell ListenForCastSpell;
   private static listenForCurrentHeroField ListenForCurrentHeroField;
   private static listenForOpponentHeroField ListenForOpponentHeroField;
   private static ListenForAttack ListenForAttack;
   private static ListenForHeros ListenForHeros;
   private static ListenForUseHeroPower ListenForUseHeroPower;
	public static void main(String[] args) throws FullHandException, CloneNotSupportedException, IOException, LineUnavailableException, UnsupportedAudioFileException {
		new Controller();

	}

	public Controller() throws FullHandException, CloneNotSupportedException, IOException, LineUnavailableException, UnsupportedAudioFileException {
		
		playSound("tracks/VivaLaVida.wav");
		currHeroHand = new ArrayList<JLBLwithCard>();
		currHeroField = new ArrayList<JLBLwithCard>();
		oppHeroField = new ArrayList<JLBLwithCard>();
		view = new Game3();

		Model = new Game(start.getFirstHero(), start.getSecondHero());
		//Model = new Game(new Priest(),new Hunter());
		p1Name=start.getFirstPlayerName();
		p2Name=start.getSecondPlayerName();
		currentHero = Model.getCurrentHero();
		opponentHero = Model.getOpponent();
//	p1=currentHero.toString();
//		System.out.println(currentHero.toString());
	//p2=opponentHero.toString();
		ListenToCurrentHand = new ListenToCurrentHand();
		ListenForCastSpell=new listenForCastSpell();
		view.getCast().addMouseListener( ListenForCastSpell);
		ListenForAttack=new ListenForAttack();
		view.getAttack().addMouseListener( ListenForAttack);
		ListenForCurrentHeroField=new listenForCurrentHeroField();
		ListenForOpponentHeroField=new listenForOpponentHeroField();
		ListenForHeros =new ListenForHeros ();
		view.getCurHeroShowlbl().addMouseListener( ListenForHeros );
		view.getOppheroShowlbl().addMouseListener( ListenForHeros );
		ListenForUseHeroPower=new ListenForUseHeroPower();
		view.getCurSpecialShow().addMouseListener(ListenForUseHeroPower);
		
		updateAll();
		addHeroShowListener();
		addEndTurnListener();

	}

	// any update method should be called here
	public static void updateAll() {
		updateHeroPower();
		updateHeroImages();
		update_currHeroHand();
		update_OppHeroHand();
		update_currHeroField();
		update_opponentHeroField();
		refreshMana(view.getCurMana(), Model.getCurrentHero().getCurrentManaCrystals());
		refreshMana(view.getOppMana(), Model.getOpponent().getCurrentManaCrystals());
		refreshManaStatus(view.getCurManaShow(), Model.getCurrentHero().getCurrentManaCrystals(),
				Model.getCurrentHero().getTotalManaCrystals());
		refreshManaStatus(view.getOppManaShow(), Model.getOpponent().getCurrentManaCrystals(),
				Model.getOpponent().getTotalManaCrystals());
		updateDeck();
	//	view.getAttack().setEnabled(false);
		//view.getCast().setEnabled(false);

		view.getCastPanel().revalidate();
		view.getCastPanel().repaint();

		view.getAttackPanel().revalidate();
		view.getAttackPanel().repaint();
		/**
		listenForCurrentHeroField.setCurrHeroFieldMinionClicked(false);
		listenForCurrentHeroField.setCurrHeroFieldMinionChoosen(null);
		listenForOpponentHeroField.setOppHeroFieldMinionClicked(false);
		listenForOpponentHeroField.setOppHeroFieldMinionChoosen(null);
		Controller.ListenToCurrentHand.setSpellClicked(false);
		Controller.ListenToCurrentHand.setClickedSpell(null);
		ListenForHeros.setCurHeroClicked(false);
		ListenForHeros.setOppHeroClicked(false);
		**/
		// any update methods
		
		view.getFrame().revalidate();
		view.getFrame().repaint();
	//	System.out.println(Model.getCurrentHero().getField().size()+"  "+Model.getOpponent().getField().size());
	}

	// current hero hand update method
	public static void update_currHeroHand() {

		if (!view.getCurHand().equals(null))
			view.getCurHand().removeAll();

		currHeroHand.clear();

		for (int i = 0; i < Model.getCurrentHero().getHand().size(); i++) {
			JLBLwithCard card;

			Card c = Model.getCurrentHero().getHand().get(i);
			if(c.getName().equals("Shadow Word: Death")){
				card = new JLBLwithCard(new ImageIcon("image/images small/m/Shadow Word Death.png"));
				card.setImage("Shadow Word Death.png");
			}else {
			card = new JLBLwithCard(new ImageIcon("image/images small/m/" + c.getName() + ".png"));
			
			card.setImage(c.getName() + ".png");
			}
			card.setC(c);
			addCardListeners(view.getCardShow(), card,c,true);

			
				// System.out.println(1);
				card.addMouseListener(ListenToCurrentHand);
			

			/**
			 * public void mouseClicked(MouseEvent arg0) { if (!card.isClicked())
			 * card.setClicked(true); else card.setClicked(false); // TODO Here's the really
			 * pain in the A** } });
			 **/
			view.getCurHand().add(card);
			currHeroHand.add(card);
			

		}

		view.getCurHand().repaint();
		view.getCurHand().revalidate();;

		view.getFrame().revalidate();
		view.getFrame().repaint();

	}

	// update opp Hero Hand
	public static void update_OppHeroHand() {

		view.getOppHand().removeAll();

		for (int i = 0; i < Model.getOpponent().getHand().size(); i++) {
			JLBLwithCard card;

			Card c = Model.getOpponent().getHand().get(i);

			card = new JLBLwithCard(new ImageIcon("image/images small/m/icon.png"));
			card.setC(c);
			card.setImage("icon" + ".png");
			addCardListeners(view.getCardShow(), card,c,false);
			view.getOppHand().add(card);

		}

		view.getOppHand().repaint();
		view.getFrame().revalidate();
		view.getFrame().repaint();
		;
	}

//current hero field update method
	public static void update_currHeroField() {

		view.getCurField().removeAll();

		currHeroField.clear();

		for (int i = 0; i < Model.getCurrentHero().getField().size(); i++) {
			JLBLwithCard card;

			Card c = Model.getCurrentHero().getField().get(i);

			if(c.getName().equals("Shadow Word: Death")){
				card = new JLBLwithCard(new ImageIcon("image/images small/m/Shadow Word Death.png"));
				card.setImage("Shadow Word Death.png");
			}else {
			card = new JLBLwithCard(new ImageIcon("image/images small/m/" + c.getName() + ".png"));
			
			card.setImage(c.getName() + ".png");
			}
			card.setC(c);
			addCardListeners(view.getCardShow(), card,c,true);
			card.addMouseListener((MouseListener) ListenForCurrentHeroField);
			view.getCurField().add(card);
			currHeroField.add(card);
		
		}

		
		view.getFrame().revalidate();
		view.getFrame().repaint();
		;
		view.getCurField().revalidate();
		view.getCurField().repaint();

	}

//same as before
	// opponent hero field update
	public static void update_opponentHeroField() {
		view.getOppField().removeAll();
		oppHeroField.clear();

		for (int i = 0; i < Model.getOpponent().getField().size(); i++) {
			JLBLwithCard card;

			Card c = Model.getOpponent().getField().get(i);

			if(c.getName().equals("Shadow Word: Death")){
				card = new JLBLwithCard(new ImageIcon("image/images small/m/Shadow Word Death.png"));
				card.setImage("Shadow Word Death.png");
			}else {
			card = new JLBLwithCard(new ImageIcon("image/images small/m/" + c.getName() + ".png"));
			
			card.setImage(c.getName() + ".png");
			}
			card.setC(c);
			addCardListeners(view.getCardShow(), card,c,true);
			card.addMouseListener((MouseListener) ListenForOpponentHeroField);
			view.getOppField().add(card);
			oppHeroField.add(card);

		}

		view.getOppField().repaint();
		view.getFrame().revalidate();
		view.getFrame().repaint();
		view.getOppField().repaint();

	}

//method to show cards on left of the game
	public static void addCardListeners(JLabel show, JLBLwithCard j,Card c,boolean f) {
		j.addMouseListener(new MouseAdapter() {
			@Override

			public void mouseEntered(MouseEvent arg0) {
				show.setIcon(new ImageIcon("image/images big/m/" + j.getImage()));
				if(c instanceof Minion && f) {
					view.getBld().setIcon(new ImageIcon("image/images small/tool/n/"+((Minion )c).getCurrentHP()+".png"));
					view.getAtk().setIcon(new ImageIcon("image/images small/tool/n/"+((Minion )c).getAttack()+".png"));
					if(((Minion )c).isDivine())
					view.getShld().setIcon(new ImageIcon("image/images small/tool/armr.png"));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				show.setIcon(null);
				view.getAtk().setIcon(null);
				view.getBld().setIcon(null);
				view.getShld().setIcon(null);
			}
		});
	}

	public static void addEndTurnListener() {
		// TODO

		view.getEndTurn().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Model.endTurn();
playSound2("endturnsound/endturn.wav");
view.getAttack().setEnabled(false);
view.getCast().setEnabled(false);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}

				updateAll();
			}
		});

	}

	public static void addHeroShowListener() {
		view.getOppheroShowlbl().addMouseListener(new MouseAdapter() {
			@Override

			public void mouseEntered(MouseEvent arg0) {
				view.getCardShow().setIcon(new ImageIcon("image/images big/h/"+view.getOppheroShowlbl().getImage()));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				view.getCardShow().setIcon(null);
			}
		});
		view.getCurHeroShowlbl().addMouseListener(new MouseAdapter() {
			@Override

			public void mouseEntered(MouseEvent arg0) {
				view.getCardShow().setIcon(new ImageIcon("image/images big/h/"+view.getCurHeroShowlbl().getImage()));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				view.getCardShow().setIcon(null);
			}
		});
	}

//  A method to update the mana icon
	public static void refreshMana(JPanel j, int i) {
		j.removeAll();
		for (int k = 0; k < i; k++) {
			j.add(new JLabel(new ImageIcon("image/images small/tool/mana.png")));
		}
		view.getFrame().revalidate();
		view.getFrame().repaint();

	}

//  A method to update the mana status
	public static void refreshManaStatus(JLabel j, int c, int t) {
		j.setText(c + "/" + t);
	}

//method to update how remaining deck cards should look like
	public static void updateDeck() {
		if (Model.getOpponent().getDeck().size() == 0) {
			view.getOppSmart().removeAll();
			view.getOppDeckShow().setIcon(new ImageIcon("image/images big/m/end.png"));

		} else if (Model.getOpponent().getDeck().size() <= 5) {
			view.getOppSmart().removeAll();
			for (int i = 0; i < Model.getOpponent().getDeck().size(); i++) {
				view.getOppSmart().add(new JLabel(new ImageIcon("image/images big/m/iconR1.png")));
			}
			view.getOppDeckShow().setIcon(new ImageIcon("image/images big/m/iconR.png"));
		} else {
			view.getOppSmart().removeAll();

			for (int i = 0; i < 6; i++) {
				view.getOppSmart().add(new JLabel(new ImageIcon("image/images big/m/iconR1.png")));

			}
			view.getOppDeckShow().setIcon(new ImageIcon("image/images big/m/iconR.png"));
		}
		if (Model.getCurrentHero().getDeck().size() == 0) {
			view.getCurSmart().removeAll();
			view.getCurDeckShow().setIcon(new ImageIcon("image/images big/m/end.png"));

		} else if (Model.getCurrentHero().getDeck().size() <= 5) {
			view.getCurSmart().removeAll();
			for (int i = 0; i < Model.getCurrentHero().getDeck().size(); i++) {
				view.getCurSmart().add(new JLabel(new ImageIcon("image/images big/m/iconR1.png")));
			}
			view.getCurDeckShow().setIcon(new ImageIcon("image/images big/m/iconR.png"));
		} else {
			view.getCurSmart().removeAll();

			for (int i = 0; i < 6; i++) {
				view.getCurSmart().add(new JLabel(new ImageIcon("image/images big/m/iconR1.png")));

			}
			view.getCurDeckShow().setIcon(new ImageIcon("image/images big/m/iconR.png"));

		}
		view.getFrame().revalidate();
		view.getFrame().repaint();
	}
public static void updateHeroPower() {
	
	view.getCurSpecialShow().setIcon(new ImageIcon("image/images big/hPow/"+Model.getCurrentHero().getClass().getName().split("\\.")[2]+".png"));
	view.getOppSpecialShow().setIcon(new ImageIcon("image/images big/hPow/"+Model.getOpponent().getClass().getName().split("\\.")[2]+".png"));
	view.getFrame().revalidate();
	view.getFrame().repaint();
}
	public static void updateHeroImages() {
		view.getCurName().setText(start.getFirstHero().getName().equals(Model.getCurrentHero().getName())?p1Name:p2Name);
		view.getOppName().setText(start.getSecondHero().getName().equals(Model.getOpponent().getName())?p2Name:p1Name);
		view.getOppDeckLeft().setText(Model.getOpponent().getDeck().size()+" Cards Left");
		view.getCurDeckLeft().setText(Model.getCurrentHero().getDeck().size()+" Cards Left");
		view.getOppheroShowlbl().setImage(Model.getOpponent().getClass().getName().split("\\.")[2] + ".png");

		view.getOppheroShowlbl().setIcon(new ImageIcon("image/images small/h/" + view.getOppheroShowlbl().getImage()));

		view.getCurHeroShowlbl().setImage(Model.getCurrentHero().getClass().getName().split("\\.")[2] + ".png");
		view.getCurHeroShowlbl().setIcon(new ImageIcon("image/images small/h/" + view.getCurHeroShowlbl().getImage()));
		view.getOppBld().setIcon(new ImageIcon("image/images small/tool/n/"+Model.getOpponent().getCurrentHP()+".png"));
		view.getCurBld().setIcon(new ImageIcon("image/images small/tool/n/"+Model.getCurrentHero().getCurrentHP()+".png"));
		view.getFrame().revalidate();
		view.getFrame().repaint();
	}

	public static ArrayList<JLBLwithCard> getCurrHeroHand() {
		return currHeroHand;
	}

	public static void setCurrHeroHand(ArrayList<JLBLwithCard> currHeroHand) {
		Controller.currHeroHand = currHeroHand;
	}

	public static ArrayList<JLBLwithCard> getCurrHeroField() {
		return currHeroField;
	}

	public static void setCurrHeroField(ArrayList<JLBLwithCard> currHeroField) {
		Controller.currHeroField = currHeroField;
	}

	public static Game getModel() {
		return Model;
	}

	public static void setModel(Game model) {
		Model = model;
	}

	public static Game3 getView() {
		return view;
	}

	public static ArrayList<JLBLwithCard> getOppHeroField() {
		return oppHeroField;
	}

	public static void playSound(String filepath) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		
		
			AudioInputStream audioInputStream=AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile());
			
			Clip clip=AudioSystem.getClip();
			clip.open(audioInputStream);
	        clip.loop(Clip.LOOP_CONTINUOUSLY); 
	        if(filepath.contains("VivaLaVida.wav")) {
	        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);        
	        gainControl.setValue(20f * (float) Math.log10(0.1));
	        }
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
		
		
	}

public static void playSound3(String filepath) {
	
	try {
		AudioInputStream audioInputStream=AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile());
		
		Clip clip=AudioSystem.getClip();
		clip.open(audioInputStream);
        clip.stop();
        clip.close();

	} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

@Override
public void onGameOver() {

	
}
	

	

}

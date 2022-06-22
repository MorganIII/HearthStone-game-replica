package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import exceptions.FullFieldException;
import exceptions.NotEnoughManaException;
import exceptions.NotYourTurnException;
import model.cards.Card;
import model.cards.minions.Minion;
import model.cards.spells.Spell;

public class ListenToCurrentHand implements MouseListener {
private static boolean isSpellClicked=false;

private static Spell clickedSpell;
	@Override
	public void mouseClicked(MouseEvent e) {
		for(int i=0;i<Controller.getCurrHeroHand().size();i++) {
			if(e.getSource().equals(Controller.getCurrHeroHand().get(i))) {
				
			//	Card c=Controller.getModel().getCurrentHero().getHand().get(i);
			
				if(Controller.getModel().getCurrentHero().getHand().get(i) instanceof Spell) {
				
					Controller.getView().getCast().setEnabled(true);

					clickedSpell=(Spell) Controller.getModel().getCurrentHero().getHand().get(i);
					
				}
				else if(Controller.getModel().getCurrentHero().getHand().get(i) instanceof Minion ||Controller.getModel().getCurrentHero().getHand().get(i).getName().equals("Icehowl") ){
					
					
					try {
						Card b=(Minion) Controller.getModel().getCurrentHero().getHand().get(i);

						Controller.getModel().getCurrentHero().playMinion((Minion) Controller.getModel().getCurrentHero().getHand().get(i));
						Controller.update_currHeroHand();
						/**
						if(b.getName().equals("Argent Commander")) {
							Controller.playSound2("playminion/Argent Commander.wav");

						}
						**/
				Controller.playSound2("playminion/"+b.getName()+".wav");

		//		if()
						
						
						
					} catch (NotYourTurnException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotEnoughManaException e1) {
				
						Controller.playSound2("notenoughmana/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

					} catch (FullFieldException e1) {
						Controller.playSound2("fullfieldexception/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

						
					}
					
					
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
		
		
		
		
	
		Controller.updateAll();

		
		
		
		
		
	}
	
	
	
	





	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
Controller.playSound2("cardover/cardover.wav");		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Controller.playSound3("cardover/cardover.wav");		

	}









	public static boolean isSpellClicked() {
		return isSpellClicked;
	}









	public static void setSpellClicked(boolean isSpellClicked) {
		ListenToCurrentHand.isSpellClicked = isSpellClicked;
	}









	public static Spell getClickedSpell() {
		return clickedSpell;
	}









	public static void setClickedSpell(Spell clickedSpell) {
		ListenToCurrentHand.clickedSpell = clickedSpell;
	}

}

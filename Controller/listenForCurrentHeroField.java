package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.cards.minions.Minion;
import view.JLBLwithCard;

public class listenForCurrentHeroField implements MouseListener {
private static boolean currHeroFieldMinionClicked=false;
private static Minion currHeroFieldMinionChoosen;
	@Override
	public void mouseClicked(MouseEvent e) {
System.out.println(3);

if(!ListenToCurrentHand.isSpellClicked()) {
	Controller.getView().getAttack().setEnabled(true);
	}
		System.out.println(e.getSource());
		for(int i=0;i<Controller.getCurrHeroField().size();i++) {
			if(((JLBLwithCard)e.getSource()).equals(Controller.getCurrHeroField().get(i))) {
				currHeroFieldMinionClicked=true;
				currHeroFieldMinionChoosen= Controller.getModel().getCurrentHero().getField().get(i);
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


	public static boolean isCurrHeroFieldMinionClicked() {
		return currHeroFieldMinionClicked;
	}

	public static void setCurrHeroFieldMinionClicked(boolean currHeroFieldMinionClicked) {
		listenForCurrentHeroField.currHeroFieldMinionClicked = currHeroFieldMinionClicked;
	}

	public static Minion getCurrHeroFieldMinionChoosen() {
		return currHeroFieldMinionChoosen;
	}

	public static void setCurrHeroFieldMinionChoosen(Minion currHeroFieldMinionChoosen) {
		listenForCurrentHeroField.currHeroFieldMinionChoosen = currHeroFieldMinionChoosen;
	}

	
}

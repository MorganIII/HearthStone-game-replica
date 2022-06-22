package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.cards.minions.Minion;
import view.JLBLwithCard;

public class listenForOpponentHeroField implements MouseListener {
	private static boolean oppHeroFieldMinionClicked=false;
	private static Minion oppHeroFieldMinionChoosen;

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(4);
		
		if(!ListenToCurrentHand.isSpellClicked()) {
		Controller.getView().getAttack().setEnabled(true);
		}
		
		for(int i=0;i<Controller.getOppHeroField().size();i++) {
			if(((JLBLwithCard)e.getSource()).equals(Controller.getOppHeroField().get(i))) {
				oppHeroFieldMinionClicked=true;
				oppHeroFieldMinionChoosen= Controller.getModel().getOpponent().getField().get(i);
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





	public static boolean isOppHeroFieldMinionClicked() {
		return oppHeroFieldMinionClicked;
	}




	public static void setOppHeroFieldMinionClicked(boolean oppHeroFieldMinionClicked) {
		listenForOpponentHeroField.oppHeroFieldMinionClicked = oppHeroFieldMinionClicked;
	}




	public static Minion getOppHeroFieldMinionChoosen() {
		return oppHeroFieldMinionChoosen;
	}




	public static void setOppHeroFieldMinionChoosen(Minion oppHeroFieldMinionChoosen) {
		listenForOpponentHeroField.oppHeroFieldMinionChoosen = oppHeroFieldMinionChoosen;
	}





}

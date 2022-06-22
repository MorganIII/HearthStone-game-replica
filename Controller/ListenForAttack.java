package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import exceptions.CannotAttackException;
import exceptions.InvalidTargetException;
import exceptions.NotSummonedException;
import exceptions.NotYourTurnException;
import exceptions.TauntBypassException;

public class ListenForAttack implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		
		Controller.getView().getAttack().setEnabled(false);

		
		//minion attack minion
		if(listenForCurrentHeroField.isCurrHeroFieldMinionClicked()&&listenForOpponentHeroField.isOppHeroFieldMinionClicked()) {
			try {
				Controller.getModel().getCurrentHero().attackWithMinion(listenForCurrentHeroField.getCurrHeroFieldMinionChoosen(), listenForOpponentHeroField.getOppHeroFieldMinionChoosen());
				Controller.playSound2("minionattack/"+(String)listenForCurrentHeroField.getCurrHeroFieldMinionChoosen().getName()+".wav");

			} catch (CannotAttackException e1) {
				Controller.playSound2("cannotattack/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

				
			} catch (NotYourTurnException e1) {

			} catch (TauntBypassException e1) {
				Controller.playSound2("taunt/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");
				
			} catch (InvalidTargetException e1) {
				Controller.playSound2("invalidtarget/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

				
				
			} catch (NotSummonedException e1) {
				
				
			}
			
			
			
			
			
			
			
			
		}
		//minion attack hero
		else if (listenForCurrentHeroField.isCurrHeroFieldMinionClicked()&&ListenForHeros.isOppHeroClicked()) {
			System.out.print("hero");
			try {
			//do not forget to implement game over here
				Controller.getModel().getCurrentHero().attackWithMinion(listenForCurrentHeroField.getCurrHeroFieldMinionChoosen(), Controller.getModel().getOpponent());
			} catch (CannotAttackException e1) {
				Controller.playSound2("cannotattack/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

				
			} catch (NotYourTurnException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (TauntBypassException e1) {
		
				Controller.playSound2("taunt/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

			} catch (NotSummonedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvalidTargetException e1) {
				Controller.playSound2("invalidtarget/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

			}
			
		}
		
		
		
		else {
			
			///if he clicked attack button wrongly
			Controller.playSound2("invalidtarget/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

		}
		
		
		
		
		

		listenForCurrentHeroField.setCurrHeroFieldMinionClicked(false);
		listenForCurrentHeroField.setCurrHeroFieldMinionChoosen(null);
		listenForOpponentHeroField.setOppHeroFieldMinionClicked(false);
		listenForOpponentHeroField.setOppHeroFieldMinionChoosen(null);
		ListenToCurrentHand.setSpellClicked(false);
		ListenToCurrentHand.setClickedSpell(null);
		ListenForHeros.setCurHeroClicked(false);
		ListenForHeros.setOppHeroClicked(false);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}

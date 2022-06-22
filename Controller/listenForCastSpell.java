package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import exceptions.InvalidTargetException;
import exceptions.NotEnoughManaException;
import exceptions.NotYourTurnException;
import model.cards.spells.AOESpell;
import model.cards.spells.DivineSpirit;
import model.cards.spells.FieldSpell;
import model.cards.spells.KillCommand;
import model.cards.spells.LeechingSpell;
import model.cards.spells.MinionTargetSpell;
import model.cards.spells.Polymorph;
import model.cards.spells.Pyroblast;
import model.cards.spells.SealOfChampions;
import model.cards.spells.ShadowWordDeath;
import model.cards.spells.Spell;

public class listenForCastSpell  implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		
		Controller.getView().getCast().setEnabled(false);

		
	if(	 ListenToCurrentHand.isSpellClicked()|| listenForCurrentHeroField.isCurrHeroFieldMinionClicked()) {

Controller.playSound2("castspellsound/castspell.wav");		
		Spell s=ListenToCurrentHand.getClickedSpell();
		
		//for opponent hero or minion
		if (s.getName().equals("Kill Command")) {
			if(listenForOpponentHeroField.isOppHeroFieldMinionClicked()) {
				try {
					Controller.getModel().getCurrentHero().castSpell((KillCommand)s,listenForOpponentHeroField.getOppHeroFieldMinionChoosen());
				} catch (NotYourTurnException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotEnoughManaException e1) {
					Controller.playSound2("notenoughmana/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

				} catch (InvalidTargetException e1) {
					Controller.playSound2("invalidtarget/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

				}
			}
			else {
				try {
					Controller.getModel().getCurrentHero().castSpell((KillCommand)s,Controller.getModel().getOpponent());
				} catch (NotYourTurnException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotEnoughManaException e1) {
					Controller.playSound2("notenoughmana/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

				}
			}
		}
		//casted on opponent minion or hero
		else if (s.getName().equals("Pyroblast")) {
			if(listenForOpponentHeroField.isOppHeroFieldMinionClicked()) {
				try {
					Controller.getModel().getCurrentHero().castSpell((Pyroblast)s,listenForOpponentHeroField.getOppHeroFieldMinionChoosen());
				} catch (NotYourTurnException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotEnoughManaException e1) {
					Controller.playSound2("notenoughmana/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

				} catch (InvalidTargetException e1) {
					Controller.playSound2("invalidtarget/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

				}
			}
			else {
				try {
					Controller.getModel().getCurrentHero().castSpell((KillCommand)s,Controller.getModel().getOpponent());
				} catch (NotYourTurnException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotEnoughManaException e1) {
					Controller.playSound2("notenoughmana/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

				}
			}
		}
		
		else if(s instanceof FieldSpell) {
			try {
				Controller.getModel().getCurrentHero().castSpell((FieldSpell)s);
			} catch (NotYourTurnException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NotEnoughManaException e1) {
				Controller.playSound2("notenoughmana/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

			}
		}
			
			else if(s instanceof AOESpell ) {
				try {
					Controller.getModel().getCurrentHero().castSpell((AOESpell)s, Controller.getModel().getOpponent().getField());
				} catch (NotYourTurnException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotEnoughManaException e1) {
					Controller.playSound2("notenoughmana/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

				}
				
			}
			else if(s instanceof LeechingSpell) {
					try {
						Controller.getModel().getCurrentHero().castSpell((LeechingSpell)s, listenForOpponentHeroField.getOppHeroFieldMinionChoosen());
					} catch (NotYourTurnException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotEnoughManaException e1) {
						Controller.playSound2("notenoughmana/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

					}
				}
			else if(s instanceof MinionTargetSpell) {
				if(s instanceof DivineSpirit) {
					try {
						Controller.getModel().getCurrentHero().castSpell((MinionTargetSpell)s, listenForCurrentHeroField.getCurrHeroFieldMinionChoosen());
					} catch (NotYourTurnException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotEnoughManaException e1) {
						Controller.playSound2("notenoughmana/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

					} catch (InvalidTargetException e1) {
						Controller.playSound2("invalidtarget/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

					}
					
}
				

				else if (s instanceof Polymorph) {
					
						try {
							Controller.getModel().getCurrentHero().castSpell((Polymorph)s, listenForCurrentHeroField.getCurrHeroFieldMinionChoosen());
						} catch (NotYourTurnException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (NotEnoughManaException e1) {
							Controller.playSound2("notenoughmana/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

						} catch (InvalidTargetException e1) {
							Controller.playSound2("invalidtarget/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

						}
			}
				
				
				else if (s instanceof SealOfChampions) {
						try {
							Controller.getModel().getCurrentHero().castSpell((SealOfChampions)s, listenForCurrentHeroField.getCurrHeroFieldMinionChoosen());
						}catch (NotYourTurnException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (NotEnoughManaException e1) {
							Controller.playSound2("notenoughmana/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

						} catch (InvalidTargetException e1) {
							Controller.playSound2("invalidtarget/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

						}
		
				}
				

				else if(s instanceof ShadowWordDeath) {
										
		try {
			Controller.getModel().getCurrentHero().castSpell((ShadowWordDeath)s, listenForOpponentHeroField.getOppHeroFieldMinionChoosen());
		}catch (NotYourTurnException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NotEnoughManaException e1) {
			Controller.playSound2("notenoughmana/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

		} catch (InvalidTargetException e1) {
			Controller.playSound2("invalidtarget/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

		}
		
		
		
		
		
			}
			}	
		
		
		
	}
	
	
	
	else {
		//here if he clicks cast spell before choosing anything .. give him shit exception* da enta 8aby ebn metna****
		
	
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

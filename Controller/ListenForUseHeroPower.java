package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.NotEnoughManaException;
import exceptions.NotYourTurnException;
import model.heroes.Mage;
import model.heroes.Priest;
import model.heroes.Warlock;

public class ListenForUseHeroPower implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		Controller.getView().getAttack().setEnabled(false);
		Controller.getView().getCast().setEnabled(false);
		int i=identifyHero();
		//hunter
		if(i==1) {
			try {
				
				//do not forget game over here
				Controller.getModel().getCurrentHero().useHeroPower();
				
			} catch (NotEnoughManaException e1) {
				Controller.playSound2("notenoughmana/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");
				e1.printStackTrace();
			} catch (HeroPowerAlreadyUsedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NotYourTurnException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (FullHandException e1) {
				
				Controller.playSound2("fullhandexception/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

			} catch (FullFieldException e1) {
				Controller.playSound2("fullfieldexception/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

			} catch (CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	
	//mage(invoked on opponent minion or hero)
	else if(i==2) {
		//hero target
		if(ListenForHeros.isOppHeroClicked()) {
			Mage m=(Mage)Controller.getModel().getCurrentHero();
			
			try {
				m.useHeroPower(Controller.getModel().getOpponent());
				//do not forget game over
			} catch (NotEnoughManaException e1) {
				Controller.playSound2("notenoughmana/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");
				e1.printStackTrace();
			} catch (HeroPowerAlreadyUsedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NotYourTurnException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (FullHandException e1) {
				
				Controller.playSound2("fullhandexception/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

			} catch (FullFieldException e1) {
				Controller.playSound2("fullfieldexception/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

			} catch (CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		//minion target	
		else if(listenForOpponentHeroField.isOppHeroFieldMinionClicked()){
		
				Mage m=(Mage)Controller.getModel().getCurrentHero();

				try {
					m.useHeroPower(listenForOpponentHeroField.getOppHeroFieldMinionChoosen());
				} catch (NotEnoughManaException e1) {
					Controller.playSound2("notenoughmana/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");
					e1.printStackTrace();
				} catch (HeroPowerAlreadyUsedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotYourTurnException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FullHandException e1) {
					
					Controller.playSound2("fullhandexception/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

				} catch (FullFieldException e1) {
					Controller.playSound2("fullfieldexception/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

				} catch (CloneNotSupportedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
	}	
	
	}
		
		

		//paladin
		else if(i==3) {
		
				try {
					Controller.getModel().getCurrentHero().useHeroPower();
				} catch (NotEnoughManaException e1) {
					Controller.playSound2("notenoughmana/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");
					e1.printStackTrace();
				} catch (HeroPowerAlreadyUsedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotYourTurnException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FullHandException e1) {
					
					Controller.playSound2("fullhandexception/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

				} catch (FullFieldException e1) {
					Controller.playSound2("fullfieldexception/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

				} catch (CloneNotSupportedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
		
		
			}
		

		//priest(invoked on your current hero or your minion)
		
else if(i==4) {
	//invoke on current hero
	if(ListenForHeros.isCurHeroClicked()) {
		Priest p=(Priest) Controller.getModel().getCurrentHero();
		try {
			p.useHeroPower(p);
		}catch (NotEnoughManaException e1) {
			Controller.playSound2("notenoughmana/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");
			e1.printStackTrace();
		} catch (HeroPowerAlreadyUsedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NotYourTurnException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FullHandException e1) {
			
			Controller.playSound2("fullhandexception/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

		} catch (FullFieldException e1) {
			Controller.playSound2("fullfieldexception/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

		} catch (CloneNotSupportedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	//invoke on one of ur minions
	else if (listenForCurrentHeroField.isCurrHeroFieldMinionClicked()) {
		Priest p=(Priest) Controller.getModel().getCurrentHero();
		try {
			p.useHeroPower(listenForCurrentHeroField.getCurrHeroFieldMinionChoosen());
		} catch (NotEnoughManaException e1) {
			Controller.playSound2("notenoughmana/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");
			e1.printStackTrace();
		} catch (HeroPowerAlreadyUsedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NotYourTurnException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FullHandException e1) {
			
			Controller.playSound2("fullhandexception/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

		} catch (FullFieldException e1) {
			Controller.playSound2("fullfieldexception/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

		} catch (CloneNotSupportedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
		//warlock		
		else if(i==5) {
			
			
				Warlock w=(Warlock) Controller.getModel().getCurrentHero();
				try {
					w.useHeroPower();
				} catch (NotEnoughManaException e1) {
					Controller.playSound2("notenoughmana/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");
					e1.printStackTrace();
				} catch (HeroPowerAlreadyUsedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotYourTurnException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FullHandException e1) {
					
					Controller.playSound2("fullhandexception/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

				} catch (FullFieldException e1) {
					Controller.playSound2("fullfieldexception/"+(String)Controller.getModel().getCurrentHero().getName()+".wav");

				} catch (CloneNotSupportedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public static int identifyHero() {
		int i=0;
		if(Controller.getModel().getCurrentHero().getName().equals("Rexxar")) {
			i=1;			
		}
		else if(Controller.getModel().getCurrentHero().getName().equals("Jaina Proudmoore")) {
			i=2;			
		}
		else if(Controller.getModel().getCurrentHero().getName().equals("Uther Lightbringer")) {
			i=3;			
		}
		else if(Controller.getModel().getCurrentHero().getName().equals("Anduin Wrynn")) {
			i=4;			
		}
		else {
			i=5;
		}
		return i;
	}

}

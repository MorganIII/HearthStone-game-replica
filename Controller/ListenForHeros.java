package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//check which hero is clicked
public class ListenForHeros implements MouseListener{
private static boolean isCurHeroClicked;
private static boolean isOppHeroClicked;
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(55);

if(e.getSource()==Controller.getView().getCurHeroShowlbl()) {
	isCurHeroClicked=true;
}
else if (e.getSource()==Controller.getView().getOppheroShowlbl()) {
	isOppHeroClicked=true;
}
		
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
		if(e.getSource()==Controller.getView().getCurHeroShowlbl()) {

		Controller.playSound2("herossounds/"+Controller.getModel().getCurrentHero().getName()+".wav");
	}
		else if (e.getSource()==Controller.getView().getOppheroShowlbl()) {
			Controller.playSound2("herossounds/"+Controller.getModel().getOpponent().getName()+".wav");

		
		
		}
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==Controller.getView().getCurHeroShowlbl()) {

			Controller.playSound3("herossounds/"+Controller.getModel().getCurrentHero().getName()+".wav");
		}
			else if (e.getSource()==Controller.getView().getOppheroShowlbl()) {
				Controller.playSound3("herossounds/"+Controller.getModel().getOpponent().getName()+".wav");

			
			
			}		
	}

	public static boolean isCurHeroClicked() {
		return isCurHeroClicked;
	}

	public static void setCurHeroClicked(boolean isCurHeroClicked) {
		ListenForHeros.isCurHeroClicked = isCurHeroClicked;
	}

	public static boolean isOppHeroClicked() {
		return isOppHeroClicked;
	}

	public static void setOppHeroClicked(boolean isOppHeroClicked) {
		ListenForHeros.isOppHeroClicked = isOppHeroClicked;
	}

}

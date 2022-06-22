package view;


import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.cards.Card;

public class JLBLwithCard extends JLabel {
private Card c;
private String image;
private boolean isClicked;
public JLBLwithCard(ImageIcon i) {
	this.setIcon(i);
}
public Card getC() {
	return c;
}
public void setC(Card c) {
	this.c = c;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public boolean isClicked() {
	return isClicked;
}
public void setClicked(boolean isClicked) {
	this.isClicked = isClicked;
}

}

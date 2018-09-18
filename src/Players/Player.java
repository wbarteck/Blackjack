package Players;

import CardDeck.*;

public class Player {
	public Hand hand;
	public String name;
	public boolean stay = false;
	
	public Player(String playerName) {
		name = playerName;
	}
	
	public boolean hit(Card c) {
		hand.addCard(c);
		return !this.isBust();
	}
	
	public boolean isBust() {
		return hand.handSum()>21;
	}
	
	public int score() {
		return hand.handSum();
	}
	
}

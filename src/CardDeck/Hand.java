package CardDeck;

import java.util.*;

public class Hand {
	private List<Card> hand;
	
	public Hand() {
		hand = new ArrayList<Card>();
	}
	public Hand(Card c1, Card c2) {
		hand = new ArrayList<Card>();
		this.hand.add(c1);
		this.hand.add(c2);
	}
	
	public int handSum() {
		int sum = 0;
		int aceCount = 0;
		for (Card c : hand) {
			int cardVal = c.getValue().ordinal();
			if (cardVal < 9) {
				cardVal += 2;
				sum += cardVal;
			}
			else if (cardVal < 12) {
				cardVal = 10;
				sum += cardVal;
			}
			else {
				// Ace special case 1 or 11
				aceCount++;
			}
		}
		// handle ace sum
		if (sum <= 10 - (aceCount-1))
			sum += 11 + aceCount -1;
		else
			sum += aceCount;
		
		return sum;
	}
	
	public void addCard(Card c) {
		hand.add(c);
	}
	
	public String toString() {
		String str = "Hand: ";
		for (Card c : hand) {
			str += c + " | ";
		}
		str = str.substring(0,str.length()-2)+"\n";
		str += "Total points: " + this.handSum();
		return str;
	}
}

package CardDeck;

import java.util.*;

public class Deck {
	private List<Card> cards;
	
	public Deck() {
		cards = new ArrayList<Card>();
		// Initialize Deck
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 4; j++) {
				Card c = new Card(Card.Suit.values()[j], Card.Value.values()[i]);
				cards.add(c);
			}
		}
		Shuffle();
	}
	
	public void Shuffle() {
		// Is this cheating? If I had to do it I would take a rand int from cards.size and pop that sucker in a new arraylist
		Collections.shuffle(cards);
	}
	
	public String toString() {
		String s = "";
		for (Card c : cards)
			s += c.toString() + ", ";
		return s.substring(0, s.length()-2);
	}
	
	public Card dealCard() {
		Card c = cards.get(0);
		cards.remove(0);
		return c;
	}
}

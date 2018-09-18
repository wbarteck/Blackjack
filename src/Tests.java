import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CardDeck.*;
import Players.*;

class Tests {

	@Test
	void cardTests() {
		Card h7 = new Card(Card.Suit.Heart, Card.Value.Seven);
		Card sK = new Card(Card.Suit.Spade, Card.Value.King);
		Hand hand1 = new Hand(h7, sK);
		assertTrue(hand1.handSum()==17);
		
		Card cA = new Card(Card.Suit.Club, Card.Value.Ace);
		Card sA = new Card(Card.Suit.Spade, Card.Value.Ace);
		Card hA = new Card(Card.Suit.Heart, Card.Value.Ace);
		Card h8 = new Card(Card.Suit.Heart, Card.Value.Eight);
		Hand hand2 = new Hand(cA, sA);
		hand2.addCard(hA);
		hand2.addCard(h8);
		assertTrue(hand2.handSum()==21);
	}
	
	@Test
	void playerTests() {
		Card c1 = new Card(Card.Suit.Club, Card.Value.Ace);
		Card c2 = new Card(Card.Suit.Club, Card.Value.King);
		Player p = new Player("test");
		p.hand = new Hand(c1,c2);
		assertTrue(p.score()==21);
		assertFalse(p.isBust());
		c2 = new Card(Card.Suit.Club, Card.Value.Three);
		p.hand = new Hand(c1, c2);
		assertTrue(p.score()==14);
		p.hand.addCard(new Card(Card.Suit.Heart, Card.Value.Nine));
		assertTrue(p.score()==13);
		assertFalse(p.isBust());
		assertFalse(p.hit(new Card(Card.Suit.Spade, Card.Value.Nine))); // return false when bust on a hit
	}

}

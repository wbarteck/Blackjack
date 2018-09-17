import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CardDeck.*;

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

}

package CardDeck;

public class Card {
	public enum Suit {
		Spade,
		Diamond,
		Club,
		Heart
	}
	public enum Value {
		One,
		Two,
		Three,
		Four,
		Five,
		Six,
		Seven,
		Eight,
		Nine,
		Ten,
		Jack,
		Queen,
		King,
		Ace
	}
	
	private Suit suit;
	private Value value;
	
	public Card(Suit s, Value v) {
		this.suit = s;
		this.value = v;
	}
	
	public Suit getSuit() {
		return this.suit;
	}
	public Value getValue() {
		return this.value;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Card))
			return false;
		Card c = (Card)o;
		return c.getSuit() == this.suit && c.getValue() == this.value;
	}
	
	public String toString() {
		return this.getValue() + " of " + this.getSuit() + "s";
	}
}

import Players.*;
import CardDeck.*;

import java.util.*;

public class GameManager {
	private Player human;
	private Player computer;
	private Deck deck;
	private boolean game;	// game is in progress
	
	Scanner scanner = new Scanner(System.in);
	
	public GameManager() {
		game = true;
		deck = new Deck();
		
		human = new Player("Human");
		computer = new Player("Computer");
	}
	
	public void newGame() {
		deck = new Deck();
		// give each player two cards
		human.hand = new Hand(deck.dealCard(), deck.dealCard());
		computer.hand = new Hand(deck.dealCard(), deck.dealCard());
		human.stay=false;
		computer.stay=false;
		
		handleRound();
	}
	
	private void handleRound() {
		// check if there is a winner
		checkWin();
		
		human.stay=false;
		computer.stay=false;
		
		if (game) {
			// player turn first
			handleHumanTurn();
			
			handleComputerTurn();
			
			handleRound();
		}
	}
	
	private void handleHumanTurn() {
		System.out.println("---------HAND--------");
		System.out.println(human.hand);
		System.out.println("---------------------");
		System.out.println("would you like to Hit(H) or Stay(S)");
		String answer = scanner.nextLine();
		switch(answer.toUpperCase()) {
		case "H":
			human.hit(deck.dealCard());
			System.out.println("");
			break;
		case "S":
			human.stay = true;
			System.out.println("");
			break;
		default:
			System.out.println("Please enter a valid answer\n");
			handleHumanTurn();
		}
	}
	
	private void handleComputerTurn() {
		if (computer.hand.handSum() < 17) {
			// hit
			computer.hit(deck.dealCard());
		} else 
			computer.stay = true;
	}
	
	private void checkWin() {
		game = false;
		if (human.stay && computer.stay) {
			if (human.score() > computer.score())
				playerWin(human);
			else if (human.score() < computer.score())
				playerWin(computer);
			else
				playerWin(null);
		}
		else if (human.isBust() && !computer.isBust())
			playerWin(computer);
		else if (computer.isBust() && !human.isBust())
			playerWin(human);
		else if (computer.isBust() && human.isBust())
			playerWin(computer); // human bust first
		else if (human.score()==21 && computer.score()==21)
			playerWin(null);
		else if (human.score() == 21)
			playerWin(human);
		else if (computer.score() == 21)
			playerWin(computer);
		else { 
			// nobody won yet
			game = true;
		}
	}
	
	private void playerWin(Player player) {
		game = false;
		if (player==null) {
			// tie
			System.out.println("***It's a Tie!***");
		} else if (player == human) {
			System.out.println("***Human player Won***");
		} else if (player == computer) {
			System.out.println("***Computer Won***");
		}
		System.out.println("Human score: " + human.score() + " | Computer Score: " + computer.score());
		// play again
		System.out.println("Would you like to player again? Y/N\n");
		String answer = scanner.nextLine();
		switch(answer.toUpperCase()) {
		case "Y":
			System.out.println("");
			newGame();
			break;
		default:
			System.out.println("Thanks For Playing");
		}
	}
}

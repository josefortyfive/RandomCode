package ch15.collection.example1;

import java.util.List;
public class Main {

	public static void main(String args[]) {
		List<Card> deck = Card.getStandardDeck();
		Card.printDeck(deck);
	}
}

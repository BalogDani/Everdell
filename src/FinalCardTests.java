import org.junit.Test;

import CardTypes.*;
import GreenConstructions.*;
import GreenCritters.Husband;
import Main.Card;
import Main.Deck;
import Main.Players;
import Main.Town;
import PurpleCritters.Wife;
import TanCritters.Fool;

public class FinalCardTests {
		
	@Test
	public void cardTest() {
		TanCard tanCard = new TanCard();
		tanCard.printCardDetails();
	}
	
	
	@Test
	public void sendWorkerTest() {
		Players players = new Players();
		Town newTown = new Town("Dani",players);
		newTown.sendWorkerForRequirements(3, 0, 0, 0);
		newTown.sendWorkerForRequirements(0, 0, 1, 0);
		newTown.sendWorkerForRequirements(0, 2, 0, 0);
	}

	@Test
	public void sameUniqueCardPlayTest() throws Exception {
		Players players = new Players();
		Deck deck = new Deck("deck");
		Town newTown = new Town("Dani",players);
		newTown.addRequirementsToTown(20, 20, 20, 20);
		TanCard tanCard = new TanCard();
		newTown.playACard(tanCard, players, deck);
		GreenCard greenCard = new GreenCard();
		newTown.playACard(greenCard, players, deck);
		newTown.playACard(tanCard, players, deck);
	}
	
	@Test
	public void deckTest() {
		Deck makeIt = new Deck("makeIt");
		Deck deck = new Deck("deck");
		Deck discard = new Deck("discard");
		deck.printDeckDetails(deck);
		discard.printDeckDetails(discard);
		System.out.println("After creating meadow:");
		Deck meadow = new Deck("meadow", deck);
		meadow.printDeckDetails(meadow);
		deck.printDeckDetails(deck);
		System.out.println("Random card from deck: " + deck.chooseRandomCard());
	}
}

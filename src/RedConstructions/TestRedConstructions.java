package RedConstructions;

import org.junit.Test;

import Main.*;

public class TestRedConstructions {

	@Test
	public void innTest() throws Exception {
		Players players = new Players();
		Deck deck = new Deck("deck");
		Deck meadow = new Deck("meadow", deck);
		Town dani = new Town("Dani",players);
		Town friendless = new Town("Friendless",players);
		dani.addRequirementsToTown(20, 20, 20, 20);
		dani.printTownDetails();
		System.out.println("Let's begin with 20 resource from everything!\n");
		deck.printDeckDetails(deck);
		Inn inn = new Inn();
		Inn innTwo = new Inn();	
		dani.playACard(inn, players, deck);
		dani.printTownDetails();
		inn.activateRedDestination(dani, deck, meadow, players);
		dani.printTownDetails();
		System.out.println(dani.playersName + "'s special points: " + dani.specialPoints + "\n");
		meadow.printDeckDetails(meadow);
		dani.playACard(innTwo, players, deck);
		dani.printTownDetails();
		innTwo.activateRedDestination(friendless, deck, meadow, players);
		System.out.println(dani.playersName + "'s special points: " + dani.specialPoints + "\n");
		dani.printTownDetails();
		innTwo.activateRedDestination(friendless, deck, meadow, players);
		System.out.println(dani.playersName + "'s special points: " + dani.specialPoints + "\n");
		dani.printTownDetails();
		friendless.printTownDetails();
		deck.printDeckDetails(deck);
		meadow.printDeckDetails(meadow);
	}
}

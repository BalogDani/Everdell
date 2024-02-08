package RedConstructions;

import org.junit.Test;

import BlueConstructions.Crane;
import BlueCritters.Innkeeper;
import BlueCritters.Judge;
import GreenConstructions.Farm;
import GreenConstructions.GeneralStore;
import Main.*;
import PurpleConstructions.Palace;
import TanConstructions.Ruins;
import TanCritters.Wanderer;

public class TestRedConstructions {

	@Test
	public void innTest() throws Exception {
		Players players = new Players();
		Deck deck = new Deck("deck");
		Deck meadow = new Deck("meadow", deck);
		Town dani = new Town("Dani",players);
		dani.addRequirementsToTown(20, 20, 20, 20);
		dani.printTownDetails();
		System.out.println("Let's begin with 20 resource from everything!\n");
		deck.printDeckDetails(deck);
		Inn inn = new Inn();
		GeneralStore generalStore = new GeneralStore();
		Ruins ruins = new Ruins();
		Palace palace = new Palace();		
		dani.playACard(inn, players, deck);
		dani.printTownDetails();
		inn.activateRedDestination(dani, deck, meadow, players);
		dani.printTownDetails();
		meadow.printDeckDetails(meadow);
		deck.printDeckDetails(deck);
		inn.activateRedDestination(dani, deck, meadow, players);
		dani.printTownDetails();
		meadow.printDeckDetails(meadow);
	}
}

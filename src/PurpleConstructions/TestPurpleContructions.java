package PurpleConstructions;

import org.junit.Test;

import GreenConstructions.Fairgrounds;
import Main.Deck;
import Main.Players;
import Main.Town;
import PurpleCritters.Architect;

public class TestPurpleContructions {
	
	@Test
	public void architectTheaterTest() {
		Players players = new Players();
		Deck deck = new Deck("deck");
		Town dani = new Town("Dani",players);
		dani.addRequirementsToTown(20, 20, 20, 20);
		dani.printTownDetails();
		System.out.println("Let's begin with 20 resource from everything!\n");
		Architect architect = new Architect();
		Fairgrounds fairgrounds = new Fairgrounds();
		Theater theater = new Theater();
		dani.playACard(architect, players, deck);
		dani.playACard(theater, players, deck);
		dani.playACard(fairgrounds, players, deck);
		dani.printTownDetails();
	}
}

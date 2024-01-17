package TanConstructions;

import org.junit.Test;

import GreenConstructions.Farm;
import Main.Deck;
import Main.Players;
import Main.Town;
import TanCritters.Fool;
import TanCritters.Wanderer;

public class TestTanConstructions {

	@Test
	public void foolTest() {
		Players players = new Players();
		Deck deck = new Deck("deck");
		Town dani = new Town("Dani",players);
		dani.addRequirementsToTown(20, 20, 20, 20);
		Town friendless = new Town("Friendless",players);
		friendless.addRequirementsToTown(20, 20, 20, 20);
		Town henike = new Town("Henike",players);
		henike.addRequirementsToTown(20, 20, 20, 20);
		Fool fool = new Fool();
		Farm farm = new Farm();
		Wanderer wanderer = new Wanderer();
		dani.playACard(fool,players,deck);		// play it to friendless
		friendless.playACard(farm,players,deck);
		henike.playACard(wanderer, players, deck);
		dani.playACard(fool,players,deck);		// play it to friendless
		dani.playACard(fool,players,deck);		// play it to henike
		dani.printTownDetails();
		friendless.printTownDetails();
		henike.printTownDetails();
		henike.printHand();
		players.pointsOfPlayers();
	}
}

package TanConstructions;

import org.junit.Test;


import GreenConstructions.Farm;
import Main.Deck;
import Main.Players;
import Main.Player;
import TanCritters.*;

public class TestTanConstructions {

	@Test
	public void foolTest() {
		Players players = new Players();
		Deck deck = new Deck("deck");
		Player dani = new Player("Dani",players);
		dani.requirements.addRequirementsToTown(dani, 20, 20, 20, 20);
		Player friendless = new Player("Friendless",players);
		friendless.requirements.addRequirementsToTown(friendless, 20, 20, 20, 20);
		Player henike = new Player("Henike",players);
		henike.requirements.addRequirementsToTown(henike, 20, 20, 20, 20);
		Fool fool = new Fool();
		Farm farm = new Farm();
		Wanderer wanderer = new Wanderer();
		dani.playACard(fool,players,dani,deck);		// play it to friendless
		friendless.playACard(farm,players,friendless,deck);
		henike.playACard(wanderer, players, henike, deck);
		dani.playACard(fool,players,dani,deck);		// play it to friendless
		dani.playACard(fool,players,dani,deck);		// play it to henike
		dani.printTownDetails();
		friendless.printTownDetails();
		henike.printTownDetails();
		henike.printHand();
		players.pointsOfPlayers();
	}
	
	@Test
	public void bardTest() {
		Players players = new Players();
		Deck deck = new Deck("deck");
		Player dani = new Player("Dani",players);
		dani.requirements.addRequirementsToTown(dani, 20, 20, 20, 20);
		deck.printDeckDetails(deck);
		dani.addRandomCardFromDeckToHand(deck);
		dani.addRandomCardFromDeckToHand(deck);
		dani.addRandomCardFromDeckToHand(deck);
		dani.addRandomCardFromDeckToHand(deck);
		dani.addRandomCardFromDeckToHand(deck);
		dani.addRandomCardFromDeckToHand(deck);
		dani.addRandomCardFromDeckToHand(deck);
		dani.addRandomCardFromDeckToHand(deck);
		dani.addRandomCardFromDeckToHand(deck);
		dani.printHand();
		deck.printDeckDetails(deck);
		Bard bard = new Bard();
		dani.playACard(bard, players, dani, deck);
		dani.printTownDetails();
		dani.printHand();
		deck.printDeckDetails(deck);
	}
	
	@Test
	public void ruinsTest() {
		Players players = new Players();
		Deck deck = new Deck("deck");
		Player dani = new Player("Dani",players);
		dani.requirements.addRequirementsToTown(dani, 20, 20, 20, 20);
		dani.printTownDetails();
		Ruins ruins = new Ruins();
		Farm farmOne = new Farm();
		Farm farmTwo = new Farm();
		Wanderer wanderer = new Wanderer();
		dani.playACard(ruins, players, dani, deck);
		dani.printTownDetails();
		dani.playACard(wanderer, players, dani, deck);
		dani.playACard(ruins, players, dani, deck);
		dani.printTownDetails();
		dani.playACard(farmOne, players, dani, deck);
		dani.playACard(farmTwo, players, dani, deck);
		dani.playACard(ruins, players, dani, deck);
		dani.playACard(ruins, players, dani, deck);
		dani.printTownDetails();
		dani.printHand();
	}
	
	@Test
	public void postalPigeonTest() {
		Players players = new Players();
		Deck deck = new Deck("deck");
		deck.printDeckDetails(deck);
		Player dani = new Player("Dani",players);
		dani.requirements.addRequirementsToTown(dani, 20, 20, 20, 20);
		Player friendless = new Player("Friendless",players);
		friendless.requirements.addRequirementsToTown(friendless, 20, 20, 20, 20);
		dani.printTownDetails();
		PostalPigeon postalPigeon = new PostalPigeon();
		dani.playACard(postalPigeon, players, dani, deck);
		dani.printTownDetails();
		friendless.printTownDetails();
		deck.printDeckDetails(deck);
	}
}

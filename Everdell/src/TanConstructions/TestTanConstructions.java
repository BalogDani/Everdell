package TanConstructions;

import org.junit.Test;


import GreenConstructions.Farm;
import Main.Deck;
import Main.Players;
import Main.Town;
import TanCritters.*;

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
	
	@Test
	public void bardTest() {
		Players players = new Players();
		Deck deck = new Deck("deck");
		Town dani = new Town("Dani",players);
		dani.addRequirementsToTown(20, 20, 20, 20);
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
		dani.playACard(bard, players, deck);
		dani.printTownDetails();
		dani.printHand();
		deck.printDeckDetails(deck);
	}
	
	@Test
	public void ruinsTest() {
		Players players = new Players();
		Deck deck = new Deck("deck");
		Town dani = new Town("Dani",players);
		dani.addRequirementsToTown(20, 20, 20, 20);
		dani.printTownDetails();
		Ruins ruins = new Ruins();
		Farm farmOne = new Farm();
		Farm farmTwo = new Farm();
		Wanderer wanderer = new Wanderer();
		dani.playACard(ruins, players, deck);
		dani.printTownDetails();
		dani.playACard(wanderer, players, deck);
		dani.playACard(ruins, players, deck);
		dani.printTownDetails();
		dani.playACard(farmOne, players, deck);
		dani.playACard(farmTwo, players, deck);
		dani.playACard(ruins, players, deck);
		dani.printTownDetails();
	}
}

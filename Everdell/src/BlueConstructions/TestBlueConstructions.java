package BlueConstructions;

import org.junit.Test;

import BlueCritters.Historian;
import BlueCritters.Shopkeeper;
import GreenConstructions.Farm;
import GreenConstructions.GeneralStore;
import GreenConstructions.Mine;
import Main.*;
import PurpleCritters.Wife;
import TanCritters.Wanderer;

public class TestBlueConstructions {

	@Test
	public void shopkeeperHistorianTest() throws Exception {
		Players players = new Players();
		Deck deck = new Deck("deck");
		Town dani = new Town("Dani",players);
		dani.addRequirementsToTown(20, 20, 20, 20);
		dani.printTownDetails();
		System.out.println("Let's begin with 20 resource from everything!\n");
		Wanderer wanderer = new Wanderer();
		GeneralStore generalStore = new GeneralStore();
		Shopkeeper shopkeeper = new Shopkeeper();
		Wife wife = new Wife();
		Historian historian = new Historian();
		Wanderer wandererTwo = new Wanderer();
		Mine mine = new Mine();
		dani.playACard(wanderer, players, deck);
		dani.playACard(generalStore, players, deck);
		dani.printTownDetails();
		dani.playACard(shopkeeper, players, deck);
		dani.printTownDetails();
		dani.printHand();
		dani.playACard(historian, players, deck);
		dani.printTownDetails();
		dani.printHand();
		dani.playACard(wife, players, deck);
		dani.printTownDetails();
		dani.printHand();
		dani.playACard(wandererTwo, players, deck);
		dani.printTownDetails();
		dani.printHand();
		dani.playACard(mine, players, deck);
		dani.printTownDetails();
		dani.printHand();
	}
	
	@Test
	public void courthouseTest() throws Exception {
		Players players = new Players();
		Deck deck = new Deck("deck");
		Town dani = new Town("Dani",players);
		dani.addRequirementsToTown(20, 20, 20, 20);
		dani.printTownDetails();
		System.out.println("Let's begin with 20 resource from everything!\n");
		GeneralStore generalStore = new GeneralStore();
		Courthouse courthouse = new Courthouse();
		Farm farm = new Farm();
		Wanderer wanderer = new Wanderer();
		dani.playACard(generalStore, players, deck);
		dani.printTownDetails();
		dani.playACard(courthouse, players, deck);
		dani.printTownDetails();
		dani.playACard(farm, players, deck);
		dani.printTownDetails();
		dani.playACard(wanderer, players, deck);
		dani.printTownDetails();
	}
}

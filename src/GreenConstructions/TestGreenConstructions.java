package GreenConstructions;

import org.junit.Test;


import GreenCritters.*;
import Main.*;
import PurpleConstructions.EverTree;
import PurpleCritters.Wife;
import TanCritters.Fool;

public class TestGreenConstructions {
	
	@Test
	public void farmTest() throws Exception {
		Players players = new Players();
		Deck deck = new Deck("deck");
		Town dani = new Town("Dani",players);
		dani.addRequirementsToTown(20, 20, 20, 20);
		dani.printTownDetails();
		System.out.println("Let's begin with 20 resource from everything!\n");
		Farm farm = new Farm();
		Husband husbandOne = new Husband();
		Husband husbandTwo = new Husband();
		Wife wife = new Wife();
		dani.playACard(farm, players, deck);
		dani.printTownDetails();
		dani.playACard(wife, players, deck);
		dani.printTownDetails();
		dani.playACard(husbandOne, players, deck);
		dani.printTownDetails();
		dani.playACard(husbandTwo, players, deck);
		dani.printTownDetails();
	}

	@Test
	public void fairgroundsTest() throws Exception {
		Deck deck = new Deck("deck");
		Players players = new Players();
		Town dani = new Town("Dani",players);
		dani.addRequirementsToTown(20, 20, 20, 20);
		Town friendless = new Town("Friendless",players);
		friendless.addRequirementsToTown(20, 20, 20, 20);
		Town henike = new Town("Henike",players);
		henike.addRequirementsToTown(20, 20, 20, 20);
		Fool fool = new Fool();
		System.out.println("Let's begin with 20 resource from everything!\n");
		Fairgrounds fairgrounds = new Fairgrounds();
		dani.playACard(fairgrounds, players, deck);
		dani.playACard(fairgrounds, players, deck);
		dani.playACard(fool,players,deck);
		friendless.playACard(fairgrounds, players, deck);
		dani.playACard(fool,players,deck);
		Card foundCard = dani.findCardInTown("Fairgrounds");
		Fairgrounds fgInTown = (Fairgrounds) foundCard;
		System.out.println("Fairgrounds in " + dani.playersName + "'s town is occupied: " + fgInTown.occupied);
		dani.printTownDetails();
		dani.printHand();
		System.out.println("");
		friendless.printTownDetails();
		henike.printTownDetails();
		deck.printDeckDetails(deck);
	}
	
	@Test
	public void doctorTest() throws Exception {
		Deck deck = new Deck("deck");
		Players players = new Players();
		Town dani = new Town("Dani",players);
		dani.addRequirementsToTown(20, 20, 20, 20);
		Doctor doctor = new Doctor();
		dani.playACard(doctor, players, deck);
		dani.printTownDetails();
	}
	
	@Test
	public void bargeToadGeneralStoreTest() throws Exception {
		Deck deck = new Deck("deck");
		Players players = new Players();
		Town dani = new Town("Dani",players);
		dani.addRequirementsToTown(20, 20, 20, 20);
		BargeToad bargeToad = new BargeToad();
		Farm farmOne = new Farm();
		Farm farmTwo = new Farm();
		GeneralStore generalStore = new GeneralStore();
		EverTree everTree = new EverTree();
		dani.playACard(everTree, players, deck);
		dani.playACard(bargeToad, players, deck);		// Choose 'No' for Ever Tree
		dani.playACard(farmOne, players, deck);
		dani.playACard(farmTwo, players, deck);
		dani.playACard(bargeToad, players, deck);		// Choose 'Yes' for Ever Tree
		dani.playACard(generalStore, players, deck);
		dani.printTownDetails();
	}
	
	@Test
	public void peddlerTest() throws Exception {
		Deck deck = new Deck("deck");
		Players players = new Players();
		Town dani = new Town("Dani",players);
		dani.addRequirementsToTown(20, 0, 0, 20);
		dani.printTownDetails();
		Peddler peddler = new Peddler();
		dani.playACard(peddler, players, deck);
		dani.printTownDetails();
	}
	
	@Test
	public void storehouseTest() throws Exception {
		Deck deck = new Deck("deck");
		Players players = new Players();
		Town dani = new Town("Dani",players);
		Town tamas = new Town("Tamas", players);
		dani.addRequirementsToTown(20, 20, 20, 20);
		tamas.addRequirementsToTown(20, 20, 20, 20);
		dani.printTownDetails();
		tamas.printTownDetails();
		Storehouse storehouse = new Storehouse();
		dani.playACard(storehouse, players, deck);
		dani.printTownDetails();
		dani.activateGreenCards(deck, players);
		storehouse.emptyingStorehouse("Dani", tamas, players);
		storehouse.emptyingStorehouse("Dani", dani, players);
		storehouse.emptyingStorehouse("Dani", dani, players);
		storehouse.emptyingStorehouse("Dani", dani, players);
		dani.printTownDetails();
	}
	
	@Test
	public void teacherTest() {
		Players players = new Players();
		Deck deck = new Deck("deck");
		Town dani = new Town("Dani",players);
		dani.addRequirementsToTown(20, 20, 20, 20);
		Town friendless = new Town("Friendless",players);
		friendless.addRequirementsToTown(20, 20, 20, 20);
		Town henike = new Town("Henike",players);
		henike.addRequirementsToTown(20, 20, 20, 20);
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
		henike.printHand();
		deck.printDeckDetails(deck);
		Teacher teacherOne = new Teacher();
		Teacher teacherTwo = new Teacher();
		friendless.playACard(teacherOne, players, deck);	//give card to dani
		friendless.playACard(teacherTwo, players, deck);	//give card to henike
		friendless.printTownDetails();
		friendless.printHand();
		dani.printHand();
		henike.printHand();
		deck.printDeckDetails(deck);
	}
}

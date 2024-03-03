package GreenConstructions;

import org.junit.Test;


import GreenCritters.*;
import Main.*;
import PurpleConstructions.EverTree;
import PurpleCritters.Wife;
import TanCritters.*;

public class TestGreenConstructions {
	
	@Test
	public void farmTest() throws Exception {
		Players players = new Players();
		Deck deck = new Deck("deck");
		Player dani = new Player("Dani",players);
		dani.requirements.addRequirementsToTown(dani, 20, 20, 20, 20);
		dani.printTownDetails();
		System.out.println("Let's begin with 20 resource from everything!\n");
		Farm farmOne = new Farm();
		Farm farmTwo = new Farm();
		Husband husbandOne = new Husband();
		Husband husbandTwo = new Husband();
		System.out.println("husband1 equals husbandtwo: " + husbandOne.equals(husbandTwo));
		Wife wifeOne = new Wife();
		Wife wifeTwo = new Wife();
		dani.playACard(farmOne, players, dani, deck);
		dani.printTownDetails();
		dani.playACard(farmTwo, players, dani, deck);
		dani.printTownDetails();
		dani.playACard(wifeOne, players, dani, deck);
		dani.printTownDetails();
		dani.playACard(husbandOne, players, dani, deck);
		dani.printTownDetails();
		dani.playACard(wifeTwo, players, dani, deck);
		dani.printTownDetails();
		dani.playACard(husbandTwo, players, dani, deck);
		dani.printTownDetails();
	}

	@Test
	public void fairgroundsTest() throws Exception {
		Deck deck = new Deck("deck");
		Players players = new Players();
		Player dani = new Player("Dani",players);
		dani.requirements.addRequirementsToTown(dani, 20, 20, 20, 20);
		Player friendless = new Player("Friendless",players);
		friendless.requirements.addRequirementsToTown(friendless, 20, 20, 20, 20);
		Player henike = new Player("Henike",players);
		henike.requirements.addRequirementsToTown(henike, 20, 20, 20, 20);
		Fool fool = new Fool();
		System.out.println("Let's begin with 20 resource from everything!\n");
		Fairgrounds fairgrounds = new Fairgrounds();
		dani.playACard(fairgrounds, players, dani, deck);
		dani.playACard(fairgrounds, players, dani, deck);
		dani.playACard(fool,players,dani, deck);
		friendless.playACard(fairgrounds, players, friendless, deck);
		dani.playACard(fool,players,dani, deck);
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
		Player dani = new Player("Dani",players);
		dani.requirements.addRequirementsToTown(dani, 20, 20, 20, 20);
		Doctor doctor = new Doctor();
		dani.playACard(doctor, players, dani, deck);
		dani.printTownDetails();
	}
	
	@Test
	public void bargeToadGeneralStoreTest() throws Exception {
		Deck deck = new Deck("deck");
		Players players = new Players();
		Player dani = new Player("Dani",players);
		dani.requirements.addRequirementsToTown(dani, 20, 20, 20, 20);
		BargeToad bargeToad = new BargeToad();
		Farm farmOne = new Farm();
		Farm farmTwo = new Farm();
		GeneralStore generalStore = new GeneralStore();
		EverTree everTree = new EverTree();
		dani.playACard(everTree, players, dani, deck);
		dani.playACard(bargeToad, players, dani, deck);		// Choose 'No' for Ever Tree
		dani.playACard(farmOne, players, dani, deck);
		dani.playACard(farmTwo, players, dani, deck);
		dani.playACard(bargeToad, players, dani, deck);		// Choose 'Yes' for Ever Tree
		dani.playACard(generalStore, players, dani, deck);
		dani.printTownDetails();
	}
	
	@Test
	public void peddlerTest() throws Exception {
		Deck deck = new Deck("deck");
		Players players = new Players();
		Player dani = new Player("Dani",players);
		dani.requirements.addRequirementsToTown(dani, 20, 0, 0, 20);
		dani.printTownDetails();
		Peddler peddler = new Peddler();
		dani.playACard(peddler, players, dani, deck);
		dani.printTownDetails();
	}
	
	@Test
	public void storehouseTest() throws Exception {
		Deck deck = new Deck("deck");
		Players players = new Players();
		Player dani = new Player("Dani",players);
		Player tamas = new Player("Tamas", players);
		dani.requirements.addRequirementsToTown(dani, 20, 20, 20, 20);
		tamas.requirements.addRequirementsToTown(tamas, 20, 20, 20, 20);
		dani.printTownDetails();
		tamas.printTownDetails();
		Storehouse storehouse = new Storehouse();
		dani.playACard(storehouse, players, dani, deck);
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
		Player dani = new Player("Dani",players);
		dani.requirements.addRequirementsToTown(dani, 20, 20, 20, 20);
		Player friendless = new Player("Friendless",players);
		friendless.requirements.addRequirementsToTown(friendless, 20, 20, 20, 20);
		Player henike = new Player("Henike",players);
		henike.requirements.addRequirementsToTown(henike, 20, 20, 20, 20);
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
		friendless.playACard(teacherOne, players, friendless, deck);	//give card to dani
		friendless.playACard(teacherTwo, players, friendless, deck);	//give card to henike
		friendless.printTownDetails();
		friendless.printHand();
		dani.printHand();
		henike.printHand();
		deck.printDeckDetails(deck);
	}
	
	@Test
	public void chipeSweepMinerMoleTest() {
		Players players = new Players();
		Deck deck = new Deck("deck");
		Player dani = new Player("Dani",players);
		dani.requirements.addRequirementsToTown(dani, 20, 20, 20, 20);
		Player friendless = new Player("Friendless",players);
		friendless.requirements.addRequirementsToTown(friendless, 20, 20, 20, 20);
		Wanderer wanderer = new Wanderer();
		Farm farm = new Farm();
		Doctor doctor = new Doctor();
		GeneralStore generalStore = new GeneralStore();
		Storehouse storehouse = new Storehouse();
		EverTree everTree = new EverTree();
		ChipSweep chipSweep = new ChipSweep();
		dani.playACard(wanderer, players, dani, deck);
		dani.playACard(farm, players, dani, deck);
		dani.playACard(generalStore, players, dani, deck);
		dani.playACard(doctor, players, dani, deck);
		dani.playACard(storehouse, players, dani, deck);
		dani.playACard(everTree, players, dani, deck);
		dani.printTownDetails();
		dani.playACard(chipSweep, players, dani, deck);
		dani.printTownDetails();
		MinerMole minerMole = new MinerMole();
		friendless.playACard(minerMole, players, friendless, deck);
		dani.printTownDetails();
		friendless.printTownDetails();
	}
}

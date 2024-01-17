package GreenConstructions;

import org.junit.Test;

import GreenCritters.BargeToad;
import GreenCritters.Doctor;
import GreenCritters.Husband;
import Main.Card;
import Main.Deck;
import Main.Players;
import Main.Town;
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
		dani.playACard(bargeToad, players, deck);
		dani.playACard(farmOne, players, deck);
		dani.playACard(farmTwo, players, deck);
		dani.playACard(bargeToad, players, deck);
		dani.playACard(generalStore, players, deck);
		dani.printTownDetails();
	}
}

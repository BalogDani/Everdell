import org.junit.Test;

import CardTypes.*;
import GreenConstructions.*;
import GreenCritters.Husband;
import Main.Town;
import PurpleCritters.Wife;

public class FinalCardTests {
		
	@Test
	public void cardTest() {
		TanCard tanCard = new TanCard();
		tanCard.printCardDetails();
	}
	
	
	@Test
	public void sendWorkerTest() {
		Town newTown = new Town("Dani");
		newTown.sendWorkerForRequirements(3, 0, 0, 0);
		newTown.sendWorkerForRequirements(0, 0, 1, 0);
		newTown.sendWorkerForRequirements(0, 2, 0, 0);
	}

	@Test
	public void sameUniqueCardPlayTest() {
		Town newTown = new Town("Dani");
		newTown.addRequirementsToTown(20, 20, 20, 20);
		TanCard tanCard = new TanCard();
		newTown.playACard(tanCard);
		GreenCard greenCard = new GreenCard();
		newTown.playACard(greenCard);
		newTown.playACard(tanCard);
	}
	
	@Test
	public void farmTest() {
		Town newTown = new Town("Dani");
		newTown.addRequirementsToTown(20, 20, 20, 20);
		newTown.printTownDetails(newTown);
		System.out.println("Let's begin with 20 resource from everything!\n");
		Farm Farm = new Farm();
		Husband HusbandOne = new Husband();
		Husband HusbandTwo = new Husband();
		Wife Wife = new Wife();
		newTown.playACard(Farm);
		newTown.printTownDetails(newTown);
		System.out.println("");
		newTown.playACard(Wife);
		newTown.printTownDetails(newTown);
		System.out.println("");
		newTown.playACard(HusbandOne);
		newTown.printTownDetails(newTown);
		System.out.println("");
		newTown.playACard(HusbandTwo);
		newTown.printTownDetails(newTown);
	}
}

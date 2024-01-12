import org.junit.Test;

import CardTypes.*;
import GreenConstructions.*;
import Main.Requirements;
import Main.Town;

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
		Farm Farm = new Farm();
		newTown.playACard(Farm);
		System.out.println("Is it occupied? " + Farm.occupied);
		Farm.occupie();
		Farm.printCardDetails();
	}
	
	@Test
	public void relatedCardPlayTest() {
		Town newTown = new Town("Dani");
		newTown.addRequirementsToTown(20, 20, 20, 20);
		GreenCard Farm = new GreenCard();
		newTown.playACard(Farm);
		GreenCard Husband = new GreenCard("Husband", new Requirements(0,0,0,3),false,2,"Farm");
		newTown.playACard(Husband);
		newTown.playACard(Husband);
	}
}

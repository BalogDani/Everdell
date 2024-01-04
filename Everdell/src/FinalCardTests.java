import org.junit.Test;

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
}

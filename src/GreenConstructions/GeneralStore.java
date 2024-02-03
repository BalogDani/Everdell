package GreenConstructions;

import Main.Deck;
import Main.Requirements;
import Main.Town;

public class GeneralStore extends GreenConstruction{

	public GeneralStore() {
		super("General Store", new Requirements(0, 1, 1, 0), false, 1, "Shopkeeper");
	}
	
	public void playCard(Town town, Deck deck){
		activateGreenCard(town);
		super.playCard(town, deck);
	}
	
	public void activateGreenCard(Town town){
		town.addSpecificRequirementsToTown("berry", 1);
		boolean isFarmInTown = town.isTheCardInArrayList("Farm", town.cards);
		if (isFarmInTown) {
			town.addSpecificRequirementsToTown("berry", 1);
		}
	}
}

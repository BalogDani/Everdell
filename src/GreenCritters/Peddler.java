package GreenCritters;

import CardTypes.GreenCard;
import Main.Deck;
import Main.Requirements;
import Main.Town;

public class Peddler extends GreenCard{

	public Peddler() {
		super("Peddler", new Requirements(0, 0, 0, 2), false, 1, "Ruins");
	}
	
	public void playCard(Town town, Deck deck){
		super.playCard(town, deck);
		activateGreenCard(town);
	}
	
	public void activateGreenCard(Town town){
		int ammount = this.readResourceAmmount();
		if(ammount > 2) {
			ammount = 2;
		}
		
		int sumOfRequirementsInTown = town.requirements.twig + town.requirements.resin + town.requirements.pebble + town.requirements.berry;
		if(sumOfRequirementsInTown!=0) {
			for(int i = 0; i < ammount; i++) {
				this.changeResources(town);
				System.out.println(i+1 + ". resource exchanged.\n");
			}			
		}
		else {
			System.out.println("Not enough resources in town to change them.");
		}
	}
}

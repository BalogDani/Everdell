package GreenCritters;

import CardTypes.GreenCard;
import Main.Deck;
import Main.Requirements;
import Main.Town;

public class Husband extends GreenCard{
	
	public boolean pairedWithWife = false;
	
	public Husband() {
		super("Husband", new Requirements(0, 0, 0, 3), false, 2, "Farm");
	}
	
	public void playCard(Town town, Deck deck){
		if(town.isTheCardInArrayList("Farm", town.cards) && pairedWithWife) {
			String resource = this.readResourceInput("add");
			if(resource.equals("twig") || resource.equals("resin") || resource.equals("pebble") || resource.equals("berry")) {
				town.addSpecificRequirementsToTown(resource,1);
				System.out.println("A " + this.name + " card is played by " + town.playersName + ".");
			}
			else {
				this.playCard(town, deck);
			}
		}
	}
	
	public void activateGreenCard(Town town, Deck deck){
		playCard(town, deck);
	}
}

package GreenConstructions;

import Main.Deck;
import Main.Requirements;
import Main.Town;

public class ResinRefinery extends GreenConstruction {
	
	public ResinRefinery() {
		super("Resin Refinery", new Requirements(0,1,1,0),false,1,"Chip Sweep");
		notACritter();
	}
	
	public void playCard(Town town, Deck deck){
		town.addSpecificRequirementsToTown("resin",1);
		System.out.println("A " + this.name + " card is played by " + town.playersName + ".");
		super.playCard(town, deck);
	}
	
	public void activateGreenCard(Town town, Deck deck){
		playCard(town, deck);
	}
}

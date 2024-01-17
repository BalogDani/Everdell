package GreenConstructions;

import Main.Deck;
import Main.Requirements;
import Main.Town;

public class Mine extends GreenConstruction{
	
	public Mine() {
		super("Mine", new Requirements(1,1,1,0),false,2,"Miner Mole");
		notACritter();
	}
	
	public void playCard(Town town, Deck deck){
		town.addSpecificRequirementsToTown("pebble",1);
		System.out.println("A " + this.name + " card is played by " + town.playersName + ".");
		super.playCard(town, deck);
	}
	
	public void activateGreenCard(Town town, Deck deck){
		playCard(town, deck);
	}
}

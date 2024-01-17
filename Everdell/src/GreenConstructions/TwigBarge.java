package GreenConstructions;

import Main.Deck;
import Main.Requirements;
import Main.Town;

public class TwigBarge extends GreenConstruction{

	public boolean occupied = false;
	
	public TwigBarge() {
		super("Twig Barge", new Requirements(1,0,1,0),false,1,"Barge Toad");
		notACritter();
	}
	
	public void playCard(Town town, Deck deck){
		town.addSpecificRequirementsToTown("twig",1);
		System.out.println("A " + this.name + " card is played by " + town.playersName + ".");
		super.playCard(town, deck);
	}
	
	public void activateGreenCard(Town town, Deck deck){
		playCard(town, deck);
	}
}

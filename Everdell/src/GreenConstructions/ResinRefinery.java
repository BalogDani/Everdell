package GreenConstructions;

import Main.Requirements;
import Main.Town;

public class ResinRefinery extends GreenConstruction {
	
	public ResinRefinery() {
		super("Resin Refinery", new Requirements(0,1,1,0),false,1,"Chip Sweep");
		notACritter();
	}
	
	public void playCard(Town town){
		town.addRequirementsToTown(0, 1, 0, 0);
		System.out.println("A " + this.name + " card is played by " + town.playersName + ".");
	}
	
	public void activateGreenCard(Town town){
		playCard(town);
	}
}

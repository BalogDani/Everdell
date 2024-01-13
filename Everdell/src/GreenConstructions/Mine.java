package GreenConstructions;

import Main.Requirements;
import Main.Town;

public class Mine extends GreenConstruction{
	
	public Mine() {
		super("Mine", new Requirements(1,1,1,0),false,2,"Miner Mole");
		notACritter();
	}
	
	public void playCard(Town town){
		town.addRequirementsToTown(0, 0, 1, 0);
		System.out.println("A " + this.name + " card is played by " + town.playersName + ".");
	}
	
	public void activateGreenCard(Town town){
		playCard(town);
	}
}

package BlueConstructions;

import Main.*;

public class Courthouse extends BlueConstruction{

	public Courthouse() {
		super("Courthouse",new Requirements(1,1,2,0),true,2,"Judge");
	}
	
	public void blueCardEffect(Card cardToPlay, Town town, Deck deck){
		if(!cardToPlay.critter && !cardToPlay.name.equals(this.name)) {
			String resource = this.readResourceInput("add");
			if(resource.equals("twig") || resource.equals("resin") || resource.equals("pebble")) {
				town.addSpecificRequirementsToTown(resource,1);
				System.out.println("A " + this.name + " card is played by " + town.playersName + ".");
			}
			else {
				System.out.println("Resource " + resource + " can't be added to town.");
				this.blueCardEffect(cardToPlay, town, deck);
			}
		}
	}
}

package GreenConstructions;

import Main.Deck;
import Main.Requirements;
import Main.Player;
import Main.Players;

public class Mine extends GreenConstruction{
	
	public Mine() {
		super("Mine", new Requirements(1,1,1,0),false,2,"Miner Mole");
		notACritter();
	}
	
	public void playCard(Player player, Deck deck, Players players){
		activateGreenCard(player);
	}
	
	public void activateGreenCard(Player player){
		player.requirements.addSpecificRequirementsToTown(player, "pebble", 1);
	}
}
